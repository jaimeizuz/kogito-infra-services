package org.kie.kogito.usertask.lifecycle.impl;

import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.inject.Singleton;

import org.kie.kogito.auth.IdentityProvider;
import org.kie.kogito.usertask.UserTaskAssignmentStrategy;
import org.kie.kogito.usertask.UserTaskInstance;
import org.kie.kogito.usertask.impl.lifecycle.DefaultUserTaskLifeCycle;
import org.kie.kogito.usertask.lifecycle.UserTaskTransitionToken;

@Singleton
public class ReassignmentUserTaskLifecycle extends DefaultUserTaskLifeCycle {

    private static final Logger logger = LoggerFactory.getLogger(ReassignmentUserTaskLifecycle.class);

    public ReassignmentUserTaskLifecycle() {
        super();
    }

    @Override
    public Optional<UserTaskTransitionToken> reassign(UserTaskInstance userTaskInstance, UserTaskTransitionToken token,
            IdentityProvider identityProvider) {

        logger.info("Custom reassignment triggered");
                
        userTaskInstance.stopNotStartedDeadlines();
        userTaskInstance.stopNotStartedReassignments();
        userTaskInstance.stopNotCompletedDeadlines();
        userTaskInstance.stopNotCompletedReassignments();

        // restart the timers
        userTaskInstance.startNotCompletedDeadlines();
        userTaskInstance.startNotCompletedReassignments();

        String user = assignStrategy(userTaskInstance, identityProvider);
        
        if (user != null) {
            logger.info("Reassigning user task to user " + user);
            return Optional.of(newTransitionToken(CLAIM, RESERVED, Map.of(PARAMETER_USER, user)));
        }
        else {
            logger.info("User not computed, transitioning user task to ready state");
            userTaskInstance.setActualOwner((String)null);
        }

        userTaskInstance.startNotStartedDeadlines();
        userTaskInstance.startNotStartedReassignments();        
        return Optional.empty();
    }

    private String assignStrategy(UserTaskInstance userTaskInstance, IdentityProvider identityProvider) {
        UserTaskAssignmentStrategy assignmentStrategy = userTaskInstance.getUserTask().getAssignmentStrategy();
        return assignmentStrategy.computeAssignment(userTaskInstance, identityProvider).orElse(null);
    }    
}
