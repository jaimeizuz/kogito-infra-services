/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.example;

import java.util.Set;
import org.kie.kogito.Application;
import org.kie.kogito.usertask.UserTask;
import org.kie.kogito.usertask.UserTaskAssignmentStrategy;
import org.kie.kogito.usertask.UserTaskConfig;
import org.kie.kogito.usertask.UserTaskInstances;
import org.kie.kogito.usertask.impl.DefaultUserTask;

@jakarta.enterprise.context.ApplicationScoped()
@jakarta.inject.Named("TestProcess__396AA527_1060_4069_8DAC_95A8A9F0513F")
public class TestProcess__396AA527_1060_4069_8DAC_95A8A9F0513F extends DefaultUserTask {

    @jakarta.inject.Inject
    Application application;

    public TestProcess__396AA527_1060_4069_8DAC_95A8A9F0513F() {
        super("_396AA527-1060-4069-8DAC-95A8A9F0513F", "userTask2");
        this.setPotentialUsers("jdoe");
        this.setPotentialGroups((java.lang.String) null);
        this.setAdminUsers((java.lang.String) null);
        this.setAdminGroups((java.lang.String) null);
        this.setExcludedUsers((java.lang.String) null);
        this.setTaskDescription((java.lang.String) null);
        this.setTaskPriority((java.lang.String) null);
        this.setReferenceName("User Task 2");
        this.setSkippable("false");
        this.setNotStartedDeadLines((java.lang.String) null);
        this.setNotCompletedDeadlines((java.lang.String) null);
        this.setNotStartedReassignments((java.lang.String) null);
        this.setNotCompletedReassignments((java.lang.String) null);
    }

    @Override
    public UserTaskAssignmentStrategy getAssignmentStrategy() {
        UserTaskConfig userTaskConfig = application.config().get(UserTaskConfig.class);
        return userTaskConfig.userTaskAssignmentStrategies().defaultUserTaskAssignmentStrategy();
    }

    @Override
    public UserTaskInstances instances() {
        UserTaskConfig userTaskConfig = application.config().get(UserTaskConfig.class);
        return userTaskConfig.userTaskInstances();
    }
}
