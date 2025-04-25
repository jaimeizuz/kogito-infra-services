package org.kie.kogito.handlers;

import org.kie.kogito.internal.process.workitem.WorkItemExecutionException;

@jakarta.enterprise.context.ApplicationScoped()
public class DummyServiceTask_callDummy__A10FCA8A_D387_49BF_B675_596B9B78ABE6_Handler extends org.kie.kogito.process.workitems.impl.DefaultKogitoWorkItemHandler {

    org.kie.kogito.hr.servicetasks.DummyServiceTask service;

    public DummyServiceTask_callDummy__A10FCA8A_D387_49BF_B675_596B9B78ABE6_Handler() {
        this(new org.kie.kogito.hr.servicetasks.DummyServiceTask());
    }

    @jakarta.inject.Inject()
    public DummyServiceTask_callDummy__A10FCA8A_D387_49BF_B675_596B9B78ABE6_Handler(org.kie.kogito.hr.servicetasks.DummyServiceTask service) {
        this.service = service;
    }

    public java.util.Optional<org.kie.kogito.internal.process.workitem.WorkItemTransition> activateWorkItemHandler(org.kie.kogito.internal.process.workitem.KogitoWorkItemManager workItemManager, org.kie.kogito.internal.process.workitem.KogitoWorkItemHandler workItemHandler, org.kie.kogito.internal.process.workitem.KogitoWorkItem workItem, org.kie.kogito.internal.process.workitem.WorkItemTransition transition) {
        java.util.Map<java.lang.String, java.lang.Object> result;
        service.callDummy((org.kie.kogito.hr.CandidateDataRestDTO) workItem.getParameter("candidateData"));
        result = java.util.Collections.emptyMap();
        return java.util.Optional.of(this.workItemLifeCycle.newTransition("complete", workItem.getPhaseStatus(), result));
    }

    public java.util.Optional<org.kie.kogito.internal.process.workitem.WorkItemTransition> abortWorkItemHandler(org.kie.kogito.internal.process.workitem.KogitoWorkItemManager workItemManager, org.kie.kogito.internal.process.workitem.KogitoWorkItemHandler workItemHandler, org.kie.kogito.internal.process.workitem.KogitoWorkItem workItem, org.kie.kogito.internal.process.workitem.WorkItemTransition transition) {
        return java.util.Optional.empty();
    }

    public String getName() {
        return "org.kie.kogito.hr.servicetasks.DummyServiceTask_callDummy__A10FCA8A_D387_49BF_B675_596B9B78ABE6_Handler";
    }
}
