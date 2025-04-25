package org.kie.kogito.hr;

import org.kie.kogito.hr.HiringModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.BooleanDataType;
import org.jbpm.process.core.datatype.impl.type.StringDataType;

@jakarta.enterprise.context.ApplicationScoped()
@jakarta.inject.Named("hiring")
@io.quarkus.runtime.Startup()
public class HiringProcess extends org.kie.kogito.process.impl.AbstractProcess<org.kie.kogito.hr.HiringModel> {

    public HiringProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.process.ProcessInstancesFactory factory) {
        this(app, correlations, factory, new org.kie.kogito.handlers.DummyServiceTask_callDummy__A10FCA8A_D387_49BF_B675_596B9B78ABE6_Handler(), new org.kie.kogito.handlers.DummyServiceTask_callDummy__EC746C99_E104_4015_83D9_03AA6DC69B5A_Handler(), new org.kie.kogito.handlers.DummyServiceTask_callDummy__3DE5198B_404A_4EDE_9489_419CD8DA550E_Handler());
    }

    @jakarta.inject.Inject()
    public HiringProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.process.ProcessInstancesFactory factory, org.kie.kogito.handlers.DummyServiceTask_callDummy__A10FCA8A_D387_49BF_B675_596B9B78ABE6_Handler dummyServiceTask_callDummy__A10FCA8A_D387_49BF_B675_596B9B78ABE6_Handler, org.kie.kogito.handlers.DummyServiceTask_callDummy__EC746C99_E104_4015_83D9_03AA6DC69B5A_Handler dummyServiceTask_callDummy__EC746C99_E104_4015_83D9_03AA6DC69B5A_Handler, org.kie.kogito.handlers.DummyServiceTask_callDummy__3DE5198B_404A_4EDE_9489_419CD8DA550E_Handler dummyServiceTask_callDummy__3DE5198B_404A_4EDE_9489_419CD8DA550E_Handler) {
        super(app, java.util.Arrays.asList(dummyServiceTask_callDummy__A10FCA8A_D387_49BF_B675_596B9B78ABE6_Handler, dummyServiceTask_callDummy__EC746C99_E104_4015_83D9_03AA6DC69B5A_Handler, dummyServiceTask_callDummy__3DE5198B_404A_4EDE_9489_419CD8DA550E_Handler), correlations, factory);
        activate();
    }

    public HiringProcess() {
    }

    @Override()
    public org.kie.kogito.hr.HiringProcessInstance createInstance(org.kie.kogito.hr.HiringModel value) {
        return new org.kie.kogito.hr.HiringProcessInstance(this, value, this.createProcessRuntime());
    }

    public org.kie.kogito.hr.HiringProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.hr.HiringModel value) {
        return new org.kie.kogito.hr.HiringProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public org.kie.kogito.hr.HiringProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, org.kie.kogito.hr.HiringModel value) {
        return new org.kie.kogito.hr.HiringProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public org.kie.kogito.hr.HiringModel createModel() {
        return new org.kie.kogito.hr.HiringModel();
    }

    public org.kie.kogito.hr.HiringProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((org.kie.kogito.hr.HiringModel) value);
    }

    public org.kie.kogito.hr.HiringProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (org.kie.kogito.hr.HiringModel) value);
    }

    public org.kie.kogito.hr.HiringProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.kie.kogito.hr.HiringProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public org.kie.kogito.hr.HiringProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.kie.kogito.hr.HiringProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("hiring", true);
        factory.variable("hr_approval", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Boolean.class), java.util.Map.of("customTags", "internal", "ItemSubjectRef", "_hr_approvalItem", "hr_approval", "hr_approval"));
        factory.variable("it_approval", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Boolean.class), java.util.Map.of("customTags", "internal", "it_approval", "it_approval", "ItemSubjectRef", "_it_approvalItem"));
        factory.variable("candidateData", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(org.kie.kogito.hr.CandidateData.class), java.util.Map.of("customTags", "input", "candidateData", "candidateData", "ItemSubjectRef", "_candidateDataItem"));
        factory.variable("offer", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(org.kie.kogito.hr.Offer.class), java.util.Map.of("offer", "offer", "customTags", "output", "ItemSubjectRef", "_offerItem"));
        factory.variable("expirationTime", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("customTags", "input,required", "expirationTime", "expirationTime", "ItemSubjectRef", "_expirationTimeItem"));
        factory.variable("throwException", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Boolean.class), java.util.Map.of("customTags", "input,required", "throwException", "throwException", "ItemSubjectRef", "_throwExceptionItem"));
        factory.variable("workitemType", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("customTags", "input", "workitemType", "workitemType", "ItemSubjectRef", "_workitemTypeItem"));
        factory.variable("errorStrategy", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("customTags", "input", "errorStrategy", "errorStrategy", "ItemSubjectRef", "_errorStrategyItem"));
        factory.variable("needMgmtApproval", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Boolean.class), java.util.Map.of("customTags", "input,required", "needMgmtApproval", "needMgmtApproval", "ItemSubjectRef", "_needMgmtApprovalItem"));
        factory.name("hiring");
        factory.packageName("org.kie.kogito.hr");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("jbpm.enable.multi.con", null);
        factory.metaData("jbpm.transactions.enable", "true");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        factory.imports("org.kie.kogito.hr.HiringProcessDtoUtils");
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E = factory.workItemNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_3DE5198B-404A-4EDE-9489-419CD8DA550E"));
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.name("Call REST dummy using Service Task");
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.workName("org.kie.kogito.hr.servicetasks.DummyServiceTask_callDummy__3DE5198B_404A_4EDE_9489_419CD8DA550E_Handler");
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.workParameter("Interface", "org.kie.kogito.hr.servicetasks.DummyServiceTask");
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.workParameter("NodeName", "Call REST dummy using Service Task");
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.workParameter("Operation", "callDummy");
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.workParameter("UNIQUE_TASK_ID", "_3DE5198B-404A-4EDE-9489-419CD8DA550E");
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.workParameter("implementation", "Java");
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.workParameter("interfaceImplementationRef", "org.kie.kogito.hr.servicetasks.DummyServiceTask");
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.workParameter("operationImplementationRef", "callDummy");
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_3DE5198B-404A-4EDE-9489-419CD8DA550E_candidateDataInputX", "candidateData", "org.kie.kogito.hr.CandidateDataRestDTO", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("5f471454-8a71-46f3-a9a9-77bef9cc3223", "EXPRESSION (#{org.kie.kogito.hr.HiringProcessDtoUtils.fromCandidateDataVariable(#{candidateData})})", "java.lang.Object", "#{org.kie.kogito.hr.HiringProcessDtoUtils.fromCandidateDataVariable(#{candidateData})}"), new org.jbpm.workflow.core.impl.DataDefinition("_3DE5198B-404A-4EDE-9489-419CD8DA550E_candidateDataInputX", "candidateData", "org.kie.kogito.hr.CandidateDataRestDTO", null))), null));
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.done();
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.metaData("UniqueId", "_3DE5198B-404A-4EDE-9489-419CD8DA550E");
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.metaData("customAsync", "true");
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.metaData("Implementation", "Java");
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.metaData("elementname", "Call REST dummy using Service Task");
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.metaData("Type", "Service Task");
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.metaData("OperationRef", "_3DE5198B-404A-4EDE-9489-419CD8DA550E_ServiceOperation");
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.metaData("x", 2175);
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.metaData("width", 154);
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.metaData("y", 326);
        workItemNode_3DE5198B_404A_4EDE_9489_419CD8DA550E.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6 = factory.workItemNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_A10FCA8A-D387-49BF-B675-596B9B78ABE6"));
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.name("Call REST dummy using Service Task");
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.workName("org.kie.kogito.hr.servicetasks.DummyServiceTask_callDummy__A10FCA8A_D387_49BF_B675_596B9B78ABE6_Handler");
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.workParameter("Interface", "org.kie.kogito.hr.servicetasks.DummyServiceTask");
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.workParameter("NodeName", "Call REST dummy using Service Task");
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.workParameter("Operation", "callDummy");
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.workParameter("UNIQUE_TASK_ID", "_A10FCA8A-D387-49BF-B675-596B9B78ABE6");
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.workParameter("implementation", "Java");
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.workParameter("interfaceImplementationRef", "org.kie.kogito.hr.servicetasks.DummyServiceTask");
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.workParameter("operationImplementationRef", "callDummy");
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_A10FCA8A-D387-49BF-B675-596B9B78ABE6_candidateDataInputX", "candidateData", "org.kie.kogito.hr.CandidateDataRestDTO", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("40968669-2332-417e-8eca-36ac2cff0e42", "EXPRESSION (#{org.kie.kogito.hr.HiringProcessDtoUtils.fromCandidateDataVariable(#{candidateData})})", "java.lang.Object", "#{org.kie.kogito.hr.HiringProcessDtoUtils.fromCandidateDataVariable(#{candidateData})}"), new org.jbpm.workflow.core.impl.DataDefinition("_A10FCA8A-D387-49BF-B675-596B9B78ABE6_candidateDataInputX", "candidateData", "org.kie.kogito.hr.CandidateDataRestDTO", null))), null));
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.done();
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.metaData("UniqueId", "_A10FCA8A-D387-49BF-B675-596B9B78ABE6");
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.metaData("customAsync", "true");
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.metaData("Implementation", "Java");
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.metaData("elementname", "Call REST dummy using Service Task");
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.metaData("Type", "Service Task");
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.metaData("OperationRef", "_A10FCA8A-D387-49BF-B675-596B9B78ABE6_ServiceOperation");
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.metaData("x", 2175);
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.metaData("width", 154);
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.metaData("y", 140);
        workItemNode_A10FCA8A_D387_49BF_B675_596B9B78ABE6.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode_D07EB7C0_8D6C_4ABC_AC31_E8D2DF05301C = factory.humanTaskNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_D07EB7C0-8D6C-4ABC-AC31-E8D2DF05301C"));
        humanTaskNode_D07EB7C0_8D6C_4ABC_AC31_E8D2DF05301C.name("Management Interview");
        humanTaskNode_D07EB7C0_8D6C_4ABC_AC31_E8D2DF05301C.workParameter("ActorId", "jdoe");
        humanTaskNode_D07EB7C0_8D6C_4ABC_AC31_E8D2DF05301C.workParameter("NodeName", "Management Interview");
        humanTaskNode_D07EB7C0_8D6C_4ABC_AC31_E8D2DF05301C.workParameter("Skippable", "false");
        humanTaskNode_D07EB7C0_8D6C_4ABC_AC31_E8D2DF05301C.workParameter("TaskName", "MgmtInterview");
        humanTaskNode_D07EB7C0_8D6C_4ABC_AC31_E8D2DF05301C.workParameter("UNIQUE_TASK_ID", "_D07EB7C0-8D6C-4ABC-AC31-E8D2DF05301C");
        humanTaskNode_D07EB7C0_8D6C_4ABC_AC31_E8D2DF05301C.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_D07EB7C0-8D6C-4ABC-AC31-E8D2DF05301C_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("d200a22d-c572-485c-81dd-04baf736b932", "EXPRESSION (MgmtInterview)", "java.lang.Object", "MgmtInterview"), new org.jbpm.workflow.core.impl.DataDefinition("_D07EB7C0-8D6C-4ABC-AC31-E8D2DF05301C_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode_D07EB7C0_8D6C_4ABC_AC31_E8D2DF05301C.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_D07EB7C0-8D6C-4ABC-AC31-E8D2DF05301C_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("446b8c47-231d-4eab-8ff9-3c0598bc0841", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_D07EB7C0-8D6C-4ABC-AC31-E8D2DF05301C_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode_D07EB7C0_8D6C_4ABC_AC31_E8D2DF05301C.done();
        humanTaskNode_D07EB7C0_8D6C_4ABC_AC31_E8D2DF05301C.metaData("UniqueId", "_D07EB7C0-8D6C-4ABC-AC31-E8D2DF05301C");
        humanTaskNode_D07EB7C0_8D6C_4ABC_AC31_E8D2DF05301C.metaData("elementname", "Management Interview");
        humanTaskNode_D07EB7C0_8D6C_4ABC_AC31_E8D2DF05301C.metaData("x", 1967);
        humanTaskNode_D07EB7C0_8D6C_4ABC_AC31_E8D2DF05301C.metaData("width", 154);
        humanTaskNode_D07EB7C0_8D6C_4ABC_AC31_E8D2DF05301C.metaData("y", 326);
        humanTaskNode_D07EB7C0_8D6C_4ABC_AC31_E8D2DF05301C.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.JoinFactory<?> joinNode_F761355E_F248_46A4_9CAD_9DDFD7F47380 = factory.joinNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_F761355E-F248-46A4-9CAD-9DDFD7F47380"));
        joinNode_F761355E_F248_46A4_9CAD_9DDFD7F47380.name("Join");
        joinNode_F761355E_F248_46A4_9CAD_9DDFD7F47380.type(5);
        joinNode_F761355E_F248_46A4_9CAD_9DDFD7F47380.metaData("UniqueId", "_F761355E-F248-46A4-9CAD-9DDFD7F47380");
        joinNode_F761355E_F248_46A4_9CAD_9DDFD7F47380.metaData("x", 2414);
        joinNode_F761355E_F248_46A4_9CAD_9DDFD7F47380.metaData("width", 56);
        joinNode_F761355E_F248_46A4_9CAD_9DDFD7F47380.metaData("y", 249);
        joinNode_F761355E_F248_46A4_9CAD_9DDFD7F47380.metaData("height", 56);
        joinNode_F761355E_F248_46A4_9CAD_9DDFD7F47380.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode_92DE8566_6BCB_4156_8501_B89B6E3720D8 = factory.splitNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_92DE8566-6BCB-4156-8501-B89B6E3720D8"));
        splitNode_92DE8566_6BCB_4156_8501_B89B6E3720D8.name("Required interviews?");
        splitNode_92DE8566_6BCB_4156_8501_B89B6E3720D8.type(3);
        splitNode_92DE8566_6BCB_4156_8501_B89B6E3720D8.metaData("UniqueId", "_92DE8566-6BCB-4156-8501-B89B6E3720D8");
        splitNode_92DE8566_6BCB_4156_8501_B89B6E3720D8.metaData("elementname", "Required interviews?");
        splitNode_92DE8566_6BCB_4156_8501_B89B6E3720D8.metaData("x", 1852);
        splitNode_92DE8566_6BCB_4156_8501_B89B6E3720D8.metaData("width", 56);
        splitNode_92DE8566_6BCB_4156_8501_B89B6E3720D8.metaData("y", 248);
        splitNode_92DE8566_6BCB_4156_8501_B89B6E3720D8.metaData("Default", null);
        splitNode_92DE8566_6BCB_4156_8501_B89B6E3720D8.metaData("height", 56);
        splitNode_92DE8566_6BCB_4156_8501_B89B6E3720D8.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_8962C15F-55EC-46F7-B926-5D5A1FD8D35E"), "_5B767618-0FC5-4D45-899F-59A4F26D1EE1", "DROOLS_DEFAULT", "java", kcontext -> {
            return true;
        }, 0, false);
        splitNode_92DE8566_6BCB_4156_8501_B89B6E3720D8.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_D07EB7C0-8D6C-4ABC-AC31-E8D2DF05301C"), "_9FE6C251-1785-4EF8-B652-797F4AB949A3", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.Boolean needMgmtApproval = (java.lang.Boolean) kcontext.getVariable("needMgmtApproval");
            return needMgmtApproval;
        }, 0, false);
        splitNode_92DE8566_6BCB_4156_8501_B89B6E3720D8.done();
        splitNode_92DE8566_6BCB_4156_8501_B89B6E3720D8.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_8962C15F-55EC-46F7-B926-5D5A1FD8D35E"), "_5B767618-0FC5-4D45-899F-59A4F26D1EE1", "DROOLS_DEFAULT", "java", kcontext -> {
            return true;
        }, 0, false);
        splitNode_92DE8566_6BCB_4156_8501_B89B6E3720D8.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_D07EB7C0-8D6C-4ABC-AC31-E8D2DF05301C"), "_9FE6C251-1785-4EF8-B652-797F4AB949A3", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.Boolean needMgmtApproval = (java.lang.Boolean) kcontext.getVariable("needMgmtApproval");
            return needMgmtApproval;
        }, 0, false);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_4A187456_FA5A_4504_9F36_62B48338F7EB = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_4A187456-FA5A-4504-9F36-62B48338F7EB"));
        endNode_4A187456_FA5A_4504_9F36_62B48338F7EB.name("Application rejected");
        endNode_4A187456_FA5A_4504_9F36_62B48338F7EB.terminate(false);
        endNode_4A187456_FA5A_4504_9F36_62B48338F7EB.metaData("UniqueId", "_4A187456-FA5A-4504-9F36-62B48338F7EB");
        endNode_4A187456_FA5A_4504_9F36_62B48338F7EB.metaData("elementname", "Application rejected");
        endNode_4A187456_FA5A_4504_9F36_62B48338F7EB.metaData("x", 2895);
        endNode_4A187456_FA5A_4504_9F36_62B48338F7EB.metaData("width", 56);
        endNode_4A187456_FA5A_4504_9F36_62B48338F7EB.metaData("y", 620);
        endNode_4A187456_FA5A_4504_9F36_62B48338F7EB.metaData("height", 56);
        endNode_4A187456_FA5A_4504_9F36_62B48338F7EB.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode_B1659D20_D231_4FF0_98BA_7A177E2188A5 = factory.workItemNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B1659D20-D231-4FF0-98BA-7A177E2188A5"));
        workItemNode_B1659D20_D231_4FF0_98BA_7A177E2188A5.name("Call REST dummy using WIH");
        workItemNode_B1659D20_D231_4FF0_98BA_7A177E2188A5.workName("CustomTask");
        workItemNode_B1659D20_D231_4FF0_98BA_7A177E2188A5.workParameter("NodeName", "Call REST dummy using WIH");
        workItemNode_B1659D20_D231_4FF0_98BA_7A177E2188A5.workParameter("TaskName", "CustomTask");
        workItemNode_B1659D20_D231_4FF0_98BA_7A177E2188A5.workParameter("UNIQUE_TASK_ID", "_B1659D20-D231-4FF0-98BA-7A177E2188A5");
        workItemNode_B1659D20_D231_4FF0_98BA_7A177E2188A5.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("errorStrategy", "errorStrategy", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("_B1659D20-D231-4FF0-98BA-7A177E2188A5_errorStrategyInputX", "errorStrategy", "String", null), null, null));
        workItemNode_B1659D20_D231_4FF0_98BA_7A177E2188A5.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("throwException", "throwException", "java.lang.Boolean", null)), new org.jbpm.workflow.core.impl.DataDefinition("_B1659D20-D231-4FF0-98BA-7A177E2188A5_throwExceptionInputX", "throwException", "Boolean", null), null, null));
        workItemNode_B1659D20_D231_4FF0_98BA_7A177E2188A5.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_B1659D20-D231-4FF0-98BA-7A177E2188A5_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("0c3e095f-d728-4310-be72-8c98ab62716c", "EXPRESSION (CustomTask)", "java.lang.Object", "CustomTask"), new org.jbpm.workflow.core.impl.DataDefinition("_B1659D20-D231-4FF0-98BA-7A177E2188A5_TaskNameInputX", "TaskName", "Object", null))), null));
        workItemNode_B1659D20_D231_4FF0_98BA_7A177E2188A5.done();
        workItemNode_B1659D20_D231_4FF0_98BA_7A177E2188A5.metaData("UniqueId", "_B1659D20-D231-4FF0-98BA-7A177E2188A5");
        workItemNode_B1659D20_D231_4FF0_98BA_7A177E2188A5.metaData("elementname", "Call REST dummy using WIH");
        workItemNode_B1659D20_D231_4FF0_98BA_7A177E2188A5.metaData("Documentation", "Basic minimal custom task.");
        workItemNode_B1659D20_D231_4FF0_98BA_7A177E2188A5.metaData("x", 923);
        workItemNode_B1659D20_D231_4FF0_98BA_7A177E2188A5.metaData("width", 154);
        workItemNode_B1659D20_D231_4FF0_98BA_7A177E2188A5.metaData("y", 380);
        workItemNode_B1659D20_D231_4FF0_98BA_7A177E2188A5.metaData("customAsync", "true");
        workItemNode_B1659D20_D231_4FF0_98BA_7A177E2188A5.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.JoinFactory<?> joinNode_0462D6E9_7099_4F55_B570_4878505FF34D = factory.joinNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0462D6E9-7099-4F55-B570-4878505FF34D"));
        joinNode_0462D6E9_7099_4F55_B570_4878505FF34D.name("Join");
        joinNode_0462D6E9_7099_4F55_B570_4878505FF34D.type(2);
        joinNode_0462D6E9_7099_4F55_B570_4878505FF34D.metaData("UniqueId", "_0462D6E9-7099-4F55-B570-4878505FF34D");
        joinNode_0462D6E9_7099_4F55_B570_4878505FF34D.metaData("x", 1196);
        joinNode_0462D6E9_7099_4F55_B570_4878505FF34D.metaData("width", 56);
        joinNode_0462D6E9_7099_4F55_B570_4878505FF34D.metaData("y", 249);
        joinNode_0462D6E9_7099_4F55_B570_4878505FF34D.metaData("height", 56);
        joinNode_0462D6E9_7099_4F55_B570_4878505FF34D.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode_B96B65A3_8142_4FBF_B503_610F965AD5D6 = factory.splitNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B96B65A3-8142-4FBF-B503-610F965AD5D6"));
        splitNode_B96B65A3_8142_4FBF_B503_610F965AD5D6.name("Workitem type?");
        splitNode_B96B65A3_8142_4FBF_B503_610F965AD5D6.type(2);
        splitNode_B96B65A3_8142_4FBF_B503_610F965AD5D6.metaData("UniqueId", "_B96B65A3-8142-4FBF-B503-610F965AD5D6");
        splitNode_B96B65A3_8142_4FBF_B503_610F965AD5D6.metaData("elementname", "Workitem type?");
        splitNode_B96B65A3_8142_4FBF_B503_610F965AD5D6.metaData("x", 767);
        splitNode_B96B65A3_8142_4FBF_B503_610F965AD5D6.metaData("width", 56);
        splitNode_B96B65A3_8142_4FBF_B503_610F965AD5D6.metaData("y", 248);
        splitNode_B96B65A3_8142_4FBF_B503_610F965AD5D6.metaData("Default", "_15EDBFA5-29BC-4073-AB13-229381937C69");
        splitNode_B96B65A3_8142_4FBF_B503_610F965AD5D6.metaData("height", 56);
        splitNode_B96B65A3_8142_4FBF_B503_610F965AD5D6.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_EC746C99-E104-4015-83D9-03AA6DC69B5A"), "_15EDBFA5-29BC-4073-AB13-229381937C69", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String workitemType = (java.lang.String) kcontext.getVariable("workitemType");
            return workitemType.equals("ST");
        }, 0, true);
        splitNode_B96B65A3_8142_4FBF_B503_610F965AD5D6.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B1659D20-D231-4FF0-98BA-7A177E2188A5"), "_D2BCD4A8-0BCF-4DA3-9DB8-EA18F11DB5AD", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String workitemType = (java.lang.String) kcontext.getVariable("workitemType");
            return workitemType.equals("WIH");
        }, 0, false);
        splitNode_B96B65A3_8142_4FBF_B503_610F965AD5D6.done();
        splitNode_B96B65A3_8142_4FBF_B503_610F965AD5D6.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_EC746C99-E104-4015-83D9-03AA6DC69B5A"), "_15EDBFA5-29BC-4073-AB13-229381937C69", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String workitemType = (java.lang.String) kcontext.getVariable("workitemType");
            return workitemType.equals("ST");
        }, 0, true);
        splitNode_B96B65A3_8142_4FBF_B503_610F965AD5D6.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B1659D20-D231-4FF0-98BA-7A177E2188A5"), "_D2BCD4A8-0BCF-4DA3-9DB8-EA18F11DB5AD", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.String workitemType = (java.lang.String) kcontext.getVariable("workitemType");
            return workitemType.equals("WIH");
        }, 0, false);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_A51348E2_06CA_496F_B275_FE665DFD03DE = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_A51348E2-06CA-496F-B275-FE665DFD03DE"));
        endNode_A51348E2_06CA_496F_B275_FE665DFD03DE.name("Hiring failed");
        endNode_A51348E2_06CA_496F_B275_FE665DFD03DE.terminate(false);
        endNode_A51348E2_06CA_496F_B275_FE665DFD03DE.metaData("UniqueId", "_A51348E2-06CA-496F-B275-FE665DFD03DE");
        endNode_A51348E2_06CA_496F_B275_FE665DFD03DE.metaData("elementname", "Hiring failed");
        endNode_A51348E2_06CA_496F_B275_FE665DFD03DE.metaData("x", 1094);
        endNode_A51348E2_06CA_496F_B275_FE665DFD03DE.metaData("width", 56);
        endNode_A51348E2_06CA_496F_B275_FE665DFD03DE.metaData("y", 248);
        endNode_A51348E2_06CA_496F_B275_FE665DFD03DE.metaData("height", 56);
        endNode_A51348E2_06CA_496F_B275_FE665DFD03DE.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_3D3240D6_1A0B_41AF_8122_29DA62B6F0AE = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_3D3240D6-1A0B-41AF-8122-29DA62B6F0AE"));
        endNode_3D3240D6_1A0B_41AF_8122_29DA62B6F0AE.name("Interview Cancelled");
        endNode_3D3240D6_1A0B_41AF_8122_29DA62B6F0AE.terminate(false);
        endNode_3D3240D6_1A0B_41AF_8122_29DA62B6F0AE.metaData("UniqueId", "_3D3240D6-1A0B-41AF-8122-29DA62B6F0AE");
        endNode_3D3240D6_1A0B_41AF_8122_29DA62B6F0AE.metaData("elementname", "Interview Cancelled");
        endNode_3D3240D6_1A0B_41AF_8122_29DA62B6F0AE.metaData("x", 1920);
        endNode_3D3240D6_1A0B_41AF_8122_29DA62B6F0AE.metaData("width", 56);
        endNode_3D3240D6_1A0B_41AF_8122_29DA62B6F0AE.metaData("y", 26);
        endNode_3D3240D6_1A0B_41AF_8122_29DA62B6F0AE.metaData("height", 56);
        endNode_3D3240D6_1A0B_41AF_8122_29DA62B6F0AE.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_5B5C8F18_B18E_4F38_BEB2_BA1AF8025836 = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_5B5C8F18-B18E-4F38-BEB2-BA1AF8025836"));
        actionNode_5B5C8F18_B18E_4F38_BEB2_BA1AF8025836.name("Interview cancelled");
        actionNode_5B5C8F18_B18E_4F38_BEB2_BA1AF8025836.metaData("UniqueId", "_5B5C8F18-B18E-4F38-BEB2-BA1AF8025836");
        actionNode_5B5C8F18_B18E_4F38_BEB2_BA1AF8025836.metaData("elementname", "Interview cancelled");
        actionNode_5B5C8F18_B18E_4F38_BEB2_BA1AF8025836.metaData("NodeType", "ScriptTask");
        actionNode_5B5C8F18_B18E_4F38_BEB2_BA1AF8025836.metaData("x", 1686);
        actionNode_5B5C8F18_B18E_4F38_BEB2_BA1AF8025836.metaData("width", 154);
        actionNode_5B5C8F18_B18E_4F38_BEB2_BA1AF8025836.metaData("y", 3);
        actionNode_5B5C8F18_B18E_4F38_BEB2_BA1AF8025836.metaData("height", 102);
        actionNode_5B5C8F18_B18E_4F38_BEB2_BA1AF8025836.action(kcontext -> {
            System.out.println();
        });
        actionNode_5B5C8F18_B18E_4F38_BEB2_BA1AF8025836.done();
        org.jbpm.ruleflow.core.factory.WorkItemNodeFactory<?> workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A = factory.workItemNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_EC746C99-E104-4015-83D9-03AA6DC69B5A"));
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.name("Store Candidate Data");
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.workName("org.kie.kogito.hr.servicetasks.DummyServiceTask_callDummy__EC746C99_E104_4015_83D9_03AA6DC69B5A_Handler");
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.workParameter("Interface", "org.kie.kogito.hr.servicetasks.DummyServiceTask");
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.workParameter("NodeName", "Store Candidate Data");
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.workParameter("Operation", "callDummy");
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.workParameter("UNIQUE_TASK_ID", "_EC746C99-E104-4015-83D9-03AA6DC69B5A");
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.workParameter("implementation", "Java");
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.workParameter("interfaceImplementationRef", "org.kie.kogito.hr.servicetasks.DummyServiceTask");
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.workParameter("operationImplementationRef", "callDummy");
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_EC746C99-E104-4015-83D9-03AA6DC69B5A_candidateDataRestDTOInputX", "candidateDataRestDTO", "org.kie.kogito.hr.CandidateDataRestDTO", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("01099201-747e-417b-9bd9-9351a9620e02", "EXPRESSION (#{org.kie.kogito.hr.HiringProcessDtoUtils.fromCandidateDataVariable(candidateData)})", "java.lang.Object", "#{org.kie.kogito.hr.HiringProcessDtoUtils.fromCandidateDataVariable(candidateData)}"), new org.jbpm.workflow.core.impl.DataDefinition("_EC746C99-E104-4015-83D9-03AA6DC69B5A_candidateDataRestDTOInputX", "candidateDataRestDTO", "org.kie.kogito.hr.CandidateDataRestDTO", null))), null));
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.done();
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.metaData("UniqueId", "_EC746C99-E104-4015-83D9-03AA6DC69B5A");
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.metaData("customAsync", "true");
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.metaData("Implementation", "Java");
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.metaData("elementname", "Store Candidate Data");
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.metaData("Type", "Service Task");
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.metaData("OperationRef", "_EC746C99-E104-4015-83D9-03AA6DC69B5A_ServiceOperation");
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.metaData("x", 923);
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.metaData("width", 154);
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.metaData("y", 90);
        workItemNode_EC746C99_E104_4015_83D9_03AA6DC69B5A.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_940F2A0C_8CC6_4ECA_B504_49363AF68B67 = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_940F2A0C-8CC6-4ECA-B504-49363AF68B67"));
        actionNode_940F2A0C_8CC6_4ECA_B504_49363AF68B67.name("Send Offer to Candidate");
        actionNode_940F2A0C_8CC6_4ECA_B504_49363AF68B67.metaData("UniqueId", "_940F2A0C-8CC6-4ECA-B504-49363AF68B67");
        actionNode_940F2A0C_8CC6_4ECA_B504_49363AF68B67.metaData("elementname", "Send Offer to Candidate");
        actionNode_940F2A0C_8CC6_4ECA_B504_49363AF68B67.metaData("NodeType", "ScriptTask");
        actionNode_940F2A0C_8CC6_4ECA_B504_49363AF68B67.metaData("x", 2702);
        actionNode_940F2A0C_8CC6_4ECA_B504_49363AF68B67.metaData("width", 154);
        actionNode_940F2A0C_8CC6_4ECA_B504_49363AF68B67.metaData("y", 226);
        actionNode_940F2A0C_8CC6_4ECA_B504_49363AF68B67.metaData("height", 102);
        actionNode_940F2A0C_8CC6_4ECA_B504_49363AF68B67.action(kcontext -> {
            org.kie.kogito.hr.CandidateData candidateData = (org.kie.kogito.hr.CandidateData) kcontext.getVariable("candidateData");
            org.kie.kogito.hr.Offer offer = (org.kie.kogito.hr.Offer) kcontext.getVariable("offer");
            System.out.println("###################################");
            System.out.println("To: " + candidateData.getEmail());
            System.out.println("Subject: Congratulations you made it!");
            System.out.println("Dear " + candidateData.getFullName() + ", we are happy to tell you that you've successfully went through the hiring process. You'll find the final Offer details in attached.");
            System.out.println("Job Category: " + offer.getCategory());
            System.out.println("Base salary: " + offer.getSalary());
            System.out.println("###################################");
        });
        actionNode_940F2A0C_8CC6_4ECA_B504_49363AF68B67.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_57DBE42C_6850_4A08_AC73_2BB0FFDFCC8C = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_57DBE42C-6850-4A08-AC73-2BB0FFDFCC8C"));
        actionNode_57DBE42C_6850_4A08_AC73_2BB0FFDFCC8C.name("Log Offer");
        actionNode_57DBE42C_6850_4A08_AC73_2BB0FFDFCC8C.metaData("UniqueId", "_57DBE42C-6850-4A08-AC73-2BB0FFDFCC8C");
        actionNode_57DBE42C_6850_4A08_AC73_2BB0FFDFCC8C.metaData("elementname", "Log Offer");
        actionNode_57DBE42C_6850_4A08_AC73_2BB0FFDFCC8C.metaData("NodeType", "ScriptTask");
        actionNode_57DBE42C_6850_4A08_AC73_2BB0FFDFCC8C.metaData("x", 1295);
        actionNode_57DBE42C_6850_4A08_AC73_2BB0FFDFCC8C.metaData("width", 154);
        actionNode_57DBE42C_6850_4A08_AC73_2BB0FFDFCC8C.metaData("y", 225);
        actionNode_57DBE42C_6850_4A08_AC73_2BB0FFDFCC8C.metaData("height", 102);
        actionNode_57DBE42C_6850_4A08_AC73_2BB0FFDFCC8C.action(kcontext -> {
            org.kie.kogito.hr.CandidateData candidateData = (org.kie.kogito.hr.CandidateData) kcontext.getVariable("candidateData");
            org.kie.kogito.hr.Offer offer = (org.kie.kogito.hr.Offer) kcontext.getVariable("offer");
            System.out.println("###################################");
            System.out.println("Generated offer for candidate: " + candidateData.getFullName());
            System.out.println("Job Category: " + offer.getCategory());
            System.out.println("Base salary: " + offer.getSalary());
            System.out.println("###################################");
        });
        actionNode_57DBE42C_6850_4A08_AC73_2BB0FFDFCC8C.done();
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_6CE52250_BCEE_485C_8AE4_F6CACF2EF5A1 = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_6CE52250-BCEE-485C-8AE4-F6CACF2EF5A1"));
        endNode_6CE52250_BCEE_485C_8AE4_F6CACF2EF5A1.name("Offer sent");
        endNode_6CE52250_BCEE_485C_8AE4_F6CACF2EF5A1.terminate(false);
        endNode_6CE52250_BCEE_485C_8AE4_F6CACF2EF5A1.metaData("UniqueId", "_6CE52250-BCEE-485C-8AE4-F6CACF2EF5A1");
        endNode_6CE52250_BCEE_485C_8AE4_F6CACF2EF5A1.metaData("elementname", "Offer sent");
        endNode_6CE52250_BCEE_485C_8AE4_F6CACF2EF5A1.metaData("x", 2895);
        endNode_6CE52250_BCEE_485C_8AE4_F6CACF2EF5A1.metaData("width", 56);
        endNode_6CE52250_BCEE_485C_8AE4_F6CACF2EF5A1.metaData("y", 249);
        endNode_6CE52250_BCEE_485C_8AE4_F6CACF2EF5A1.metaData("height", 56);
        endNode_6CE52250_BCEE_485C_8AE4_F6CACF2EF5A1.done();
        org.jbpm.ruleflow.core.factory.RuleSetNodeFactory<?> ruleSetNode_F4D56F6C_4CFE_4D5C_BF5E_67261F68EF1A = factory.ruleSetNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_F4D56F6C-4CFE-4D5C-BF5E-67261F68EF1A"));
        ruleSetNode_F4D56F6C_4CFE_4D5C_BF5E_67261F68EF1A.name("Generate base offer");
        ruleSetNode_F4D56F6C_4CFE_4D5C_BF5E_67261F68EF1A.decision("https://kiegroup.org/dmn/_0DCC505E-71B4-4C29-8848-4006623FE51A", "New Hiring Offer", null, () -> {
            return app.get(org.kie.kogito.decision.DecisionModels.class).getDecisionModel("https://kiegroup.org/dmn/_0DCC505E-71B4-4C29-8848-4006623FE51A", "New Hiring Offer");
        });
        ruleSetNode_F4D56F6C_4CFE_4D5C_BF5E_67261F68EF1A.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_F4D56F6C-4CFE-4D5C-BF5E-67261F68EF1A_fileNameInputX", "fileName", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("14983970-5af5-4692-a865-d4bcd16735d3", "EXPRESSION (NewHiringOffer.dmn)", "java.lang.Object", "NewHiringOffer.dmn"), new org.jbpm.workflow.core.impl.DataDefinition("_F4D56F6C-4CFE-4D5C-BF5E-67261F68EF1A_fileNameInputX", "fileName", "java.lang.String", null))), null));
        ruleSetNode_F4D56F6C_4CFE_4D5C_BF5E_67261F68EF1A.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_F4D56F6C-4CFE-4D5C-BF5E-67261F68EF1A_namespaceInputX", "namespace", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("ed6a76e2-48df-44f4-baa5-692642bc70e5", "EXPRESSION (https://kiegroup.org/dmn/_0DCC505E-71B4-4C29-8848-4006623FE51A)", "java.lang.Object", "https://kiegroup.org/dmn/_0DCC505E-71B4-4C29-8848-4006623FE51A"), new org.jbpm.workflow.core.impl.DataDefinition("_F4D56F6C-4CFE-4D5C-BF5E-67261F68EF1A_namespaceInputX", "namespace", "java.lang.String", null))), null));
        ruleSetNode_F4D56F6C_4CFE_4D5C_BF5E_67261F68EF1A.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_F4D56F6C-4CFE-4D5C-BF5E-67261F68EF1A_modelInputX", "model", "java.lang.String", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("a69c4604-c09e-401c-8919-220caf02a46f", "EXPRESSION (New Hiring Offer)", "java.lang.Object", "New Hiring Offer"), new org.jbpm.workflow.core.impl.DataDefinition("_F4D56F6C-4CFE-4D5C-BF5E-67261F68EF1A_modelInputX", "model", "java.lang.String", null))), null));
        ruleSetNode_F4D56F6C_4CFE_4D5C_BF5E_67261F68EF1A.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("candidateData", "candidateData", "org.kie.kogito.hr.CandidateData", null)), new org.jbpm.workflow.core.impl.DataDefinition("_F4D56F6C-4CFE-4D5C-BF5E-67261F68EF1A_CandidateDataInputX", "CandidateData", "org.kie.kogito.hr.CandidateData", null), null, null));
        ruleSetNode_F4D56F6C_4CFE_4D5C_BF5E_67261F68EF1A.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_F4D56F6C-4CFE-4D5C-BF5E-67261F68EF1A_OfferOutputX", "Offer", "org.kie.kogito.hr.Offer", null)), new org.jbpm.workflow.core.impl.DataDefinition("offer", "offer", "org.kie.kogito.hr.Offer", null), null, null));
        ruleSetNode_F4D56F6C_4CFE_4D5C_BF5E_67261F68EF1A.metaData("UniqueId", "_F4D56F6C-4CFE-4D5C-BF5E-67261F68EF1A");
        ruleSetNode_F4D56F6C_4CFE_4D5C_BF5E_67261F68EF1A.metaData("elementname", "Generate base offer");
        ruleSetNode_F4D56F6C_4CFE_4D5C_BF5E_67261F68EF1A.metaData("x", 533);
        ruleSetNode_F4D56F6C_4CFE_4D5C_BF5E_67261F68EF1A.metaData("width", 154);
        ruleSetNode_F4D56F6C_4CFE_4D5C_BF5E_67261F68EF1A.metaData("y", 225);
        ruleSetNode_F4D56F6C_4CFE_4D5C_BF5E_67261F68EF1A.metaData("height", 102);
        ruleSetNode_F4D56F6C_4CFE_4D5C_BF5E_67261F68EF1A.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_4B7FF147_F096_435B_8CAF_48318EF786B0 = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_4B7FF147-F096-435B-8CAF-48318EF786B0"));
        actionNode_4B7FF147_F096_435B_8CAF_48318EF786B0.name("Application denied");
        actionNode_4B7FF147_F096_435B_8CAF_48318EF786B0.metaData("UniqueId", "_4B7FF147-F096-435B-8CAF-48318EF786B0");
        actionNode_4B7FF147_F096_435B_8CAF_48318EF786B0.metaData("elementname", "Application denied");
        actionNode_4B7FF147_F096_435B_8CAF_48318EF786B0.metaData("NodeType", "ScriptTask");
        actionNode_4B7FF147_F096_435B_8CAF_48318EF786B0.metaData("x", 2693);
        actionNode_4B7FF147_F096_435B_8CAF_48318EF786B0.metaData("width", 154);
        actionNode_4B7FF147_F096_435B_8CAF_48318EF786B0.metaData("y", 595);
        actionNode_4B7FF147_F096_435B_8CAF_48318EF786B0.metaData("height", 102);
        actionNode_4B7FF147_F096_435B_8CAF_48318EF786B0.action(kcontext -> {
            org.kie.kogito.hr.CandidateData candidateData = (org.kie.kogito.hr.CandidateData) kcontext.getVariable("candidateData");
            System.out.println("###################################");
            System.out.println("Candidate " + candidateData.getFullName() + " don't meet the requirements for the position but we'll keep it on records for the future!");
            System.out.println("###################################");
        });
        actionNode_4B7FF147_F096_435B_8CAF_48318EF786B0.done();
        org.jbpm.ruleflow.core.factory.JoinFactory<?> joinNode_30C8C01B_4149_4AE5_8D86_D27D57BCA8E7 = factory.joinNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_30C8C01B-4149-4AE5-8D86-D27D57BCA8E7"));
        joinNode_30C8C01B_4149_4AE5_8D86_D27D57BCA8E7.name("Join");
        joinNode_30C8C01B_4149_4AE5_8D86_D27D57BCA8E7.type(2);
        joinNode_30C8C01B_4149_4AE5_8D86_D27D57BCA8E7.metaData("UniqueId", "_30C8C01B-4149-4AE5-8D86-D27D57BCA8E7");
        joinNode_30C8C01B_4149_4AE5_8D86_D27D57BCA8E7.metaData("x", 2528);
        joinNode_30C8C01B_4149_4AE5_8D86_D27D57BCA8E7.metaData("width", 56);
        joinNode_30C8C01B_4149_4AE5_8D86_D27D57BCA8E7.metaData("y", 620);
        joinNode_30C8C01B_4149_4AE5_8D86_D27D57BCA8E7.metaData("height", 56);
        joinNode_30C8C01B_4149_4AE5_8D86_D27D57BCA8E7.done();
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode_A51A809E_03C0_4EA7_91F1_7B3C5E29AD04 = factory.splitNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_A51A809E-03C0-4EA7-91F1-7B3C5E29AD04"));
        splitNode_A51A809E_03C0_4EA7_91F1_7B3C5E29AD04.name("Split");
        splitNode_A51A809E_03C0_4EA7_91F1_7B3C5E29AD04.type(2);
        splitNode_A51A809E_03C0_4EA7_91F1_7B3C5E29AD04.metaData("UniqueId", "_A51A809E-03C0-4EA7-91F1-7B3C5E29AD04");
        splitNode_A51A809E_03C0_4EA7_91F1_7B3C5E29AD04.metaData("x", 436);
        splitNode_A51A809E_03C0_4EA7_91F1_7B3C5E29AD04.metaData("width", 56);
        splitNode_A51A809E_03C0_4EA7_91F1_7B3C5E29AD04.metaData("y", 249);
        splitNode_A51A809E_03C0_4EA7_91F1_7B3C5E29AD04.metaData("Default", "_59F9A0E6-7F9C-43A9-8920-5B40A91169E6");
        splitNode_A51A809E_03C0_4EA7_91F1_7B3C5E29AD04.metaData("height", 56);
        splitNode_A51A809E_03C0_4EA7_91F1_7B3C5E29AD04.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_30C8C01B-4149-4AE5-8D86-D27D57BCA8E7"), "_C6E61C53-FD35-4347-B69E-30AA93AE4404", "DROOLS_DEFAULT", "java", kcontext -> {
            org.kie.kogito.hr.CandidateData candidateData = (org.kie.kogito.hr.CandidateData) kcontext.getVariable("candidateData");
            return candidateData.getExperience() < 1 || candidateData.getSkills().size() == 0;
        }, 0, false);
        splitNode_A51A809E_03C0_4EA7_91F1_7B3C5E29AD04.done();
        splitNode_A51A809E_03C0_4EA7_91F1_7B3C5E29AD04.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_30C8C01B-4149-4AE5-8D86-D27D57BCA8E7"), "_C6E61C53-FD35-4347-B69E-30AA93AE4404", "DROOLS_DEFAULT", "java", kcontext -> {
            org.kie.kogito.hr.CandidateData candidateData = (org.kie.kogito.hr.CandidateData) kcontext.getVariable("candidateData");
            return candidateData.getExperience() < 1 || candidateData.getSkills().size() == 0;
        }, 0, false);
        org.jbpm.ruleflow.core.factory.SplitFactory<?> splitNode_B9662806_84F3_4444_AD62_4790CDA7C85D = factory.splitNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B9662806-84F3-4444-AD62-4790CDA7C85D"));
        splitNode_B9662806_84F3_4444_AD62_4790CDA7C85D.name("Split");
        splitNode_B9662806_84F3_4444_AD62_4790CDA7C85D.type(2);
        splitNode_B9662806_84F3_4444_AD62_4790CDA7C85D.metaData("UniqueId", "_B9662806-84F3-4444-AD62-4790CDA7C85D");
        splitNode_B9662806_84F3_4444_AD62_4790CDA7C85D.metaData("x", 2528);
        splitNode_B9662806_84F3_4444_AD62_4790CDA7C85D.metaData("width", 56);
        splitNode_B9662806_84F3_4444_AD62_4790CDA7C85D.metaData("y", 249);
        splitNode_B9662806_84F3_4444_AD62_4790CDA7C85D.metaData("Default", "_B7FC63DD-C08F-4CB3-A51A-79C1B8B18E6E");
        splitNode_B9662806_84F3_4444_AD62_4790CDA7C85D.metaData("height", 56);
        splitNode_B9662806_84F3_4444_AD62_4790CDA7C85D.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_940F2A0C-8CC6-4ECA-B504-49363AF68B67"), "_B11455DE-F77A-4251-A85B-4C66636E3CD9", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.Boolean it_approval = (java.lang.Boolean) kcontext.getVariable("it_approval");
            java.lang.Boolean hr_approval = (java.lang.Boolean) kcontext.getVariable("hr_approval");
            return hr_approval && it_approval;
        }, 0, false);
        splitNode_B9662806_84F3_4444_AD62_4790CDA7C85D.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_30C8C01B-4149-4AE5-8D86-D27D57BCA8E7"), "_B7FC63DD-C08F-4CB3-A51A-79C1B8B18E6E", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.Boolean it_approval = (java.lang.Boolean) kcontext.getVariable("it_approval");
            java.lang.Boolean hr_approval = (java.lang.Boolean) kcontext.getVariable("hr_approval");
            return (!hr_approval || !it_approval);
        }, 0, true);
        splitNode_B9662806_84F3_4444_AD62_4790CDA7C85D.done();
        splitNode_B9662806_84F3_4444_AD62_4790CDA7C85D.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_940F2A0C-8CC6-4ECA-B504-49363AF68B67"), "_B11455DE-F77A-4251-A85B-4C66636E3CD9", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.Boolean it_approval = (java.lang.Boolean) kcontext.getVariable("it_approval");
            java.lang.Boolean hr_approval = (java.lang.Boolean) kcontext.getVariable("hr_approval");
            return hr_approval && it_approval;
        }, 0, false);
        splitNode_B9662806_84F3_4444_AD62_4790CDA7C85D.constraint(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_30C8C01B-4149-4AE5-8D86-D27D57BCA8E7"), "_B7FC63DD-C08F-4CB3-A51A-79C1B8B18E6E", "DROOLS_DEFAULT", "java", kcontext -> {
            java.lang.Boolean it_approval = (java.lang.Boolean) kcontext.getVariable("it_approval");
            java.lang.Boolean hr_approval = (java.lang.Boolean) kcontext.getVariable("hr_approval");
            return (!hr_approval || !it_approval);
        }, 0, true);
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_834B21EF_9229_44F8_A5DB_D96EBB39A347 = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_834B21EF-9229-44F8-A5DB-D96EBB39A347"));
        actionNode_834B21EF_9229_44F8_A5DB_D96EBB39A347.name("Send notification HR Interview avoided");
        actionNode_834B21EF_9229_44F8_A5DB_D96EBB39A347.metaData("UniqueId", "_834B21EF-9229-44F8-A5DB-D96EBB39A347");
        actionNode_834B21EF_9229_44F8_A5DB_D96EBB39A347.metaData("elementname", "Send notification HR Interview avoided");
        actionNode_834B21EF_9229_44F8_A5DB_D96EBB39A347.metaData("NodeType", "ScriptTask");
        actionNode_834B21EF_9229_44F8_A5DB_D96EBB39A347.metaData("x", 1508);
        actionNode_834B21EF_9229_44F8_A5DB_D96EBB39A347.metaData("width", 154);
        actionNode_834B21EF_9229_44F8_A5DB_D96EBB39A347.metaData("y", 410);
        actionNode_834B21EF_9229_44F8_A5DB_D96EBB39A347.metaData("height", 102);
        actionNode_834B21EF_9229_44F8_A5DB_D96EBB39A347.action(kcontext -> {
            System.out.println("###################################");
            System.out.println("HR Interview have been avoided after reasonable time");
            System.out.println("###################################");
        });
        actionNode_834B21EF_9229_44F8_A5DB_D96EBB39A347.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_5BDBE48C_CC83_46A9_9D56_F846F8FC1045 = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_5BDBE48C-CC83-46A9-9D56-F846F8FC1045"));
        actionNode_5BDBE48C_CC83_46A9_9D56_F846F8FC1045.name("New Hiring");
        actionNode_5BDBE48C_CC83_46A9_9D56_F846F8FC1045.metaData("UniqueId", "_5BDBE48C-CC83-46A9-9D56-F846F8FC1045");
        actionNode_5BDBE48C_CC83_46A9_9D56_F846F8FC1045.metaData("elementname", "New Hiring");
        actionNode_5BDBE48C_CC83_46A9_9D56_F846F8FC1045.metaData("NodeType", "ScriptTask");
        actionNode_5BDBE48C_CC83_46A9_9D56_F846F8FC1045.metaData("x", 226);
        actionNode_5BDBE48C_CC83_46A9_9D56_F846F8FC1045.metaData("width", 154);
        actionNode_5BDBE48C_CC83_46A9_9D56_F846F8FC1045.metaData("y", 226);
        actionNode_5BDBE48C_CC83_46A9_9D56_F846F8FC1045.metaData("height", 102);
        actionNode_5BDBE48C_CC83_46A9_9D56_F846F8FC1045.action(kcontext -> {
            java.lang.Boolean hr_approval = (java.lang.Boolean) kcontext.getVariable("hr_approval");
            java.lang.Boolean it_approval = (java.lang.Boolean) kcontext.getVariable("it_approval");
            org.kie.kogito.hr.CandidateData candidateData = (org.kie.kogito.hr.CandidateData) kcontext.getVariable("candidateData");
            org.jboss.logging.Logger logger = org.jboss.logging.Logger.getLogger(kcontext.getProcessInstance().getProcessName() + "|" + kcontext.getNodeInstance().getNodeName() + "|" + kcontext.getProcessInstance().getId());
            logger.info("New Hiring has been created for candidate: " + candidateData.getFullName());
            kcontext.setVariable("hr_approval", false);
            kcontext.setVariable("it_approval", false);
        });
        actionNode_5BDBE48C_CC83_46A9_9D56_F846F8FC1045.done();
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode_8962C15F_55EC_46F7_B926_5D5A1FD8D35E = factory.humanTaskNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_8962C15F-55EC-46F7-B926-5D5A1FD8D35E"));
        humanTaskNode_8962C15F_55EC_46F7_B926_5D5A1FD8D35E.name("IT Interview");
        humanTaskNode_8962C15F_55EC_46F7_B926_5D5A1FD8D35E.workParameter("ActorId", "jdoe");
        humanTaskNode_8962C15F_55EC_46F7_B926_5D5A1FD8D35E.workParameter("NodeName", "IT Interview");
        humanTaskNode_8962C15F_55EC_46F7_B926_5D5A1FD8D35E.workParameter("Skippable", "false");
        humanTaskNode_8962C15F_55EC_46F7_B926_5D5A1FD8D35E.workParameter("TaskName", "ITInterview");
        humanTaskNode_8962C15F_55EC_46F7_B926_5D5A1FD8D35E.workParameter("UNIQUE_TASK_ID", "_8962C15F-55EC-46F7-B926-5D5A1FD8D35E");
        humanTaskNode_8962C15F_55EC_46F7_B926_5D5A1FD8D35E.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_8962C15F-55EC-46F7-B926-5D5A1FD8D35E_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("f4daef4e-6122-41b7-991f-8952f4273361", "EXPRESSION (ITInterview)", "java.lang.Object", "ITInterview"), new org.jbpm.workflow.core.impl.DataDefinition("_8962C15F-55EC-46F7-B926-5D5A1FD8D35E_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode_8962C15F_55EC_46F7_B926_5D5A1FD8D35E.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("candidateData", "candidateData", "org.kie.kogito.hr.CandidateData", null)), new org.jbpm.workflow.core.impl.DataDefinition("_8962C15F-55EC-46F7-B926-5D5A1FD8D35E_candidateInputX", "candidate", "org.kie.kogito.hr.CandidateData", null), null, null));
        humanTaskNode_8962C15F_55EC_46F7_B926_5D5A1FD8D35E.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("offer", "offer", "org.kie.kogito.hr.Offer", null)), new org.jbpm.workflow.core.impl.DataDefinition("_8962C15F-55EC-46F7-B926-5D5A1FD8D35E_offerInputX", "offer", "org.kie.kogito.hr.Offer", null), null, null));
        humanTaskNode_8962C15F_55EC_46F7_B926_5D5A1FD8D35E.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("it_approval", "it_approval", "java.lang.Boolean", null)), new org.jbpm.workflow.core.impl.DataDefinition("_8962C15F-55EC-46F7-B926-5D5A1FD8D35E_approveInputX", "approve", "Boolean", null), null, null));
        humanTaskNode_8962C15F_55EC_46F7_B926_5D5A1FD8D35E.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_8962C15F-55EC-46F7-B926-5D5A1FD8D35E_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("28476d80-5acd-4da0-bc1c-3b64a2ef12b2", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_8962C15F-55EC-46F7-B926-5D5A1FD8D35E_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode_8962C15F_55EC_46F7_B926_5D5A1FD8D35E.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_8962C15F-55EC-46F7-B926-5D5A1FD8D35E_approveOutputX", "approve", "Boolean", null)), new org.jbpm.workflow.core.impl.DataDefinition("it_approval", "it_approval", "java.lang.Boolean", null), null, null));
        humanTaskNode_8962C15F_55EC_46F7_B926_5D5A1FD8D35E.done();
        humanTaskNode_8962C15F_55EC_46F7_B926_5D5A1FD8D35E.metaData("UniqueId", "_8962C15F-55EC-46F7-B926-5D5A1FD8D35E");
        humanTaskNode_8962C15F_55EC_46F7_B926_5D5A1FD8D35E.metaData("elementname", "IT Interview");
        humanTaskNode_8962C15F_55EC_46F7_B926_5D5A1FD8D35E.metaData("x", 1967);
        humanTaskNode_8962C15F_55EC_46F7_B926_5D5A1FD8D35E.metaData("width", 154);
        humanTaskNode_8962C15F_55EC_46F7_B926_5D5A1FD8D35E.metaData("y", 140);
        humanTaskNode_8962C15F_55EC_46F7_B926_5D5A1FD8D35E.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6 = factory.humanTaskNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B8C4F63C-81AD-4291-9C1B-84967277EEF6"));
        humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6.name("HR Interview");
        humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6.workParameter("ActorId", "jdoe");
        humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6.workParameter("NodeName", "HR Interview");
        humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6.workParameter("Skippable", "false");
        humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6.workParameter("TaskName", "HRInterview");
        humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6.workParameter("UNIQUE_TASK_ID", "_B8C4F63C-81AD-4291-9C1B-84967277EEF6");
        humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_B8C4F63C-81AD-4291-9C1B-84967277EEF6_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("26368b1f-ccf8-4c13-a699-e7b4fbe911f9", "EXPRESSION (HRInterview)", "java.lang.Object", "HRInterview"), new org.jbpm.workflow.core.impl.DataDefinition("_B8C4F63C-81AD-4291-9C1B-84967277EEF6_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("candidateData", "candidateData", "org.kie.kogito.hr.CandidateData", null)), new org.jbpm.workflow.core.impl.DataDefinition("_B8C4F63C-81AD-4291-9C1B-84967277EEF6_candidateInputX", "candidate", "org.kie.kogito.hr.CandidateData", null), null, null));
        humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("offer", "offer", "org.kie.kogito.hr.Offer", null)), new org.jbpm.workflow.core.impl.DataDefinition("_B8C4F63C-81AD-4291-9C1B-84967277EEF6_offerInputX", "offer", "org.kie.kogito.hr.Offer", null), null, null));
        humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("hr_approval", "hr_approval", "java.lang.Boolean", null)), new org.jbpm.workflow.core.impl.DataDefinition("_B8C4F63C-81AD-4291-9C1B-84967277EEF6_approveInputX", "approve", "Boolean", null), null, null));
        humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_B8C4F63C-81AD-4291-9C1B-84967277EEF6_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("938e65df-6ce7-482a-8db1-c3a11c5fd7d9", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_B8C4F63C-81AD-4291-9C1B-84967277EEF6_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_B8C4F63C-81AD-4291-9C1B-84967277EEF6_approveOutputX", "approve", "Boolean", null)), new org.jbpm.workflow.core.impl.DataDefinition("hr_approval", "hr_approval", "java.lang.Boolean", null), null, null));
        humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_B8C4F63C-81AD-4291-9C1B-84967277EEF6_offerOutputX", "offer", "org.kie.kogito.hr.Offer", null)), new org.jbpm.workflow.core.impl.DataDefinition("offer", "offer", "org.kie.kogito.hr.Offer", null), null, null));
        humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6.done();
        humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6.metaData("UniqueId", "_B8C4F63C-81AD-4291-9C1B-84967277EEF6");
        humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6.metaData("elementname", "HR Interview");
        humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6.metaData("x", 1498);
        humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6.metaData("width", 154);
        humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6.metaData("y", 224);
        humanTaskNode_B8C4F63C_81AD_4291_9C1B_84967277EEF6.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode_1639F738_45F3_4CD6_A80E_CCEBAA605D56 = factory.startNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_1639F738-45F3-4CD6-A80E-CCEBAA605D56"));
        startNode_1639F738_45F3_4CD6_A80E_CCEBAA605D56.name("Start");
        startNode_1639F738_45F3_4CD6_A80E_CCEBAA605D56.interrupting(true);
        startNode_1639F738_45F3_4CD6_A80E_CCEBAA605D56.metaData("UniqueId", "_1639F738-45F3-4CD6-A80E-CCEBAA605D56");
        startNode_1639F738_45F3_4CD6_A80E_CCEBAA605D56.metaData("EventType", "none");
        startNode_1639F738_45F3_4CD6_A80E_CCEBAA605D56.metaData("x", 109);
        startNode_1639F738_45F3_4CD6_A80E_CCEBAA605D56.metaData("width", 56);
        startNode_1639F738_45F3_4CD6_A80E_CCEBAA605D56.metaData("y", 249);
        startNode_1639F738_45F3_4CD6_A80E_CCEBAA605D56.metaData("height", 56);
        startNode_1639F738_45F3_4CD6_A80E_CCEBAA605D56.done();
        org.jbpm.ruleflow.core.factory.BoundaryEventNodeFactory<?> boundaryEventNode_116F3C54_A10E_4952_9E08_1CACE74CED0B = factory.boundaryEventNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_116F3C54-A10E-4952-9E08-1CACE74CED0B"));
        boundaryEventNode_116F3C54_A10E_4952_9E08_1CACE74CED0B.metaData("UniqueId", "_116F3C54-A10E-4952-9E08-1CACE74CED0B");
        boundaryEventNode_116F3C54_A10E_4952_9E08_1CACE74CED0B.metaData("EventType", "timer");
        boundaryEventNode_116F3C54_A10E_4952_9E08_1CACE74CED0B.metaData("x", 1558);
        boundaryEventNode_116F3C54_A10E_4952_9E08_1CACE74CED0B.metaData("width", 56);
        boundaryEventNode_116F3C54_A10E_4952_9E08_1CACE74CED0B.metaData("y", 298);
        boundaryEventNode_116F3C54_A10E_4952_9E08_1CACE74CED0B.metaData("AttachedTo", "_B8C4F63C-81AD-4291-9C1B-84967277EEF6");
        boundaryEventNode_116F3C54_A10E_4952_9E08_1CACE74CED0B.metaData("TimeDuration", "#{expirationTime}");
        boundaryEventNode_116F3C54_A10E_4952_9E08_1CACE74CED0B.metaData("CancelActivity", true);
        boundaryEventNode_116F3C54_A10E_4952_9E08_1CACE74CED0B.metaData("height", 56);
        boundaryEventNode_116F3C54_A10E_4952_9E08_1CACE74CED0B.name("BoundaryEvent");
        boundaryEventNode_116F3C54_A10E_4952_9E08_1CACE74CED0B.eventType("Timer-_B8C4F63C-81AD-4291-9C1B-84967277EEF6-#{expirationTime}-_116F3C54-A10E-4952-9E08-1CACE74CED0B");
        boundaryEventNode_116F3C54_A10E_4952_9E08_1CACE74CED0B.attachedTo("_B8C4F63C-81AD-4291-9C1B-84967277EEF6");
        boundaryEventNode_116F3C54_A10E_4952_9E08_1CACE74CED0B.scope(null);
        boundaryEventNode_116F3C54_A10E_4952_9E08_1CACE74CED0B.done();
        org.jbpm.ruleflow.core.factory.BoundaryEventNodeFactory<?> boundaryEventNode_357AB6EA_99F6_4474_9328_449C86EF5176 = factory.boundaryEventNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_357AB6EA-99F6-4474-9328-449C86EF5176"));
        boundaryEventNode_357AB6EA_99F6_4474_9328_449C86EF5176.metaData("UniqueId", "_357AB6EA-99F6-4474-9328-449C86EF5176");
        boundaryEventNode_357AB6EA_99F6_4474_9328_449C86EF5176.metaData("EventType", "signal");
        boundaryEventNode_357AB6EA_99F6_4474_9328_449C86EF5176.metaData("SignalName", "cancelHrInterview");
        boundaryEventNode_357AB6EA_99F6_4474_9328_449C86EF5176.metaData("x", 1580);
        boundaryEventNode_357AB6EA_99F6_4474_9328_449C86EF5176.metaData("width", 56);
        boundaryEventNode_357AB6EA_99F6_4474_9328_449C86EF5176.metaData("y", 196);
        boundaryEventNode_357AB6EA_99F6_4474_9328_449C86EF5176.metaData("AttachedTo", "_B8C4F63C-81AD-4291-9C1B-84967277EEF6");
        boundaryEventNode_357AB6EA_99F6_4474_9328_449C86EF5176.metaData("CancelActivity", true);
        boundaryEventNode_357AB6EA_99F6_4474_9328_449C86EF5176.metaData("height", 56);
        boundaryEventNode_357AB6EA_99F6_4474_9328_449C86EF5176.name("BoundaryEvent");
        boundaryEventNode_357AB6EA_99F6_4474_9328_449C86EF5176.eventType("cancelHrInterview");
        boundaryEventNode_357AB6EA_99F6_4474_9328_449C86EF5176.attachedTo("_B8C4F63C-81AD-4291-9C1B-84967277EEF6");
        boundaryEventNode_357AB6EA_99F6_4474_9328_449C86EF5176.scope("external");
        boundaryEventNode_357AB6EA_99F6_4474_9328_449C86EF5176.done();
        org.jbpm.ruleflow.core.factory.BoundaryEventNodeFactory<?> boundaryEventNode_F5C4E6BF_96CA_4F84_92E7_4CC7E6CB2CC2 = factory.boundaryEventNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_F5C4E6BF-96CA-4F84-92E7-4CC7E6CB2CC2"));
        boundaryEventNode_F5C4E6BF_96CA_4F84_92E7_4CC7E6CB2CC2.metaData("UniqueId", "_F5C4E6BF-96CA-4F84-92E7-4CC7E6CB2CC2");
        boundaryEventNode_F5C4E6BF_96CA_4F84_92E7_4CC7E6CB2CC2.metaData("EventType", "error");
        boundaryEventNode_F5C4E6BF_96CA_4F84_92E7_4CC7E6CB2CC2.metaData("ErrorStructureRef", null);
        boundaryEventNode_F5C4E6BF_96CA_4F84_92E7_4CC7E6CB2CC2.metaData("elementname", "Call failed");
        boundaryEventNode_F5C4E6BF_96CA_4F84_92E7_4CC7E6CB2CC2.metaData("ErrorEvent", "restDummyException");
        boundaryEventNode_F5C4E6BF_96CA_4F84_92E7_4CC7E6CB2CC2.metaData("x", 958);
        boundaryEventNode_F5C4E6BF_96CA_4F84_92E7_4CC7E6CB2CC2.metaData("width", 56);
        boundaryEventNode_F5C4E6BF_96CA_4F84_92E7_4CC7E6CB2CC2.metaData("y", 164);
        boundaryEventNode_F5C4E6BF_96CA_4F84_92E7_4CC7E6CB2CC2.metaData("AttachedTo", "_EC746C99-E104-4015-83D9-03AA6DC69B5A");
        boundaryEventNode_F5C4E6BF_96CA_4F84_92E7_4CC7E6CB2CC2.metaData("HasErrorEvent", true);
        boundaryEventNode_F5C4E6BF_96CA_4F84_92E7_4CC7E6CB2CC2.metaData("height", 56);
        boundaryEventNode_F5C4E6BF_96CA_4F84_92E7_4CC7E6CB2CC2.name("Call failed");
        boundaryEventNode_F5C4E6BF_96CA_4F84_92E7_4CC7E6CB2CC2.eventType("Error-_EC746C99-E104-4015-83D9-03AA6DC69B5A-restDummyException");
        boundaryEventNode_F5C4E6BF_96CA_4F84_92E7_4CC7E6CB2CC2.attachedTo("_EC746C99-E104-4015-83D9-03AA6DC69B5A");
        boundaryEventNode_F5C4E6BF_96CA_4F84_92E7_4CC7E6CB2CC2.scope(null);
        boundaryEventNode_F5C4E6BF_96CA_4F84_92E7_4CC7E6CB2CC2.done();
        factory.errorExceptionHandler("Error-_EC746C99-E104-4015-83D9-03AA6DC69B5A-restDummyException", "restDummyException", null);
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_D07EB7C0-8D6C-4ABC-AC31-E8D2DF05301C"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_3DE5198B-404A-4EDE-9489-419CD8DA550E"), "_DCA152A6-44CB-409D-8553-7D2A05E565B4");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_8962C15F-55EC-46F7-B926-5D5A1FD8D35E"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_A10FCA8A-D387-49BF-B675-596B9B78ABE6"), "_5B44E9B7-A751-47D2-9110-1FA9556BC714");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_92DE8566-6BCB-4156-8501-B89B6E3720D8"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_D07EB7C0-8D6C-4ABC-AC31-E8D2DF05301C"), "_9FE6C251-1785-4EF8-B652-797F4AB949A3");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_A10FCA8A-D387-49BF-B675-596B9B78ABE6"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_F761355E-F248-46A4-9CAD-9DDFD7F47380"), "_B45E2782-2C82-49A2-9A94-C2270CB637CC");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_3DE5198B-404A-4EDE-9489-419CD8DA550E"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_F761355E-F248-46A4-9CAD-9DDFD7F47380"), "_4770C289-95BB-40FC-BB43-A5E61532F6E8");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B8C4F63C-81AD-4291-9C1B-84967277EEF6"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_92DE8566-6BCB-4156-8501-B89B6E3720D8"), "_8E44DA55-5182-468D-BFFC-060104A32115");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_4B7FF147-F096-435B-8CAF-48318EF786B0"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_4A187456-FA5A-4504-9F36-62B48338F7EB"), "_D494F40B-F72D-45FB-9F49-4F1495112445");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B96B65A3-8142-4FBF-B503-610F965AD5D6"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B1659D20-D231-4FF0-98BA-7A177E2188A5"), "_D2BCD4A8-0BCF-4DA3-9DB8-EA18F11DB5AD");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B1659D20-D231-4FF0-98BA-7A177E2188A5"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0462D6E9-7099-4F55-B570-4878505FF34D"), "_45B91D90-CEBD-4424-B2E6-1CE245D1BB73");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_EC746C99-E104-4015-83D9-03AA6DC69B5A"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0462D6E9-7099-4F55-B570-4878505FF34D"), "_62DEE29C-CB7E-4532-A2A5-770BE5B4CDBC");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_F4D56F6C-4CFE-4D5C-BF5E-67261F68EF1A"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B96B65A3-8142-4FBF-B503-610F965AD5D6"), "_8783F744-5AF8-4550-AE7A-AA82DE8075B3");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_F5C4E6BF-96CA-4F84-92E7-4CC7E6CB2CC2"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_A51348E2-06CA-496F-B275-FE665DFD03DE"), "_689FCAD1-85A6-4A28-B296-CAD32ABD34DE");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_5B5C8F18-B18E-4F38-BEB2-BA1AF8025836"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_3D3240D6-1A0B-41AF-8122-29DA62B6F0AE"), "_6A731794-34D3-4CCA-9607-D469D612595F");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_357AB6EA-99F6-4474-9328-449C86EF5176"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_5B5C8F18-B18E-4F38-BEB2-BA1AF8025836"), "_78B6783F-A4AC-4CF6-8B12-E22796C92214");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B96B65A3-8142-4FBF-B503-610F965AD5D6"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_EC746C99-E104-4015-83D9-03AA6DC69B5A"), "_15EDBFA5-29BC-4073-AB13-229381937C69");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B9662806-84F3-4444-AD62-4790CDA7C85D"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_940F2A0C-8CC6-4ECA-B504-49363AF68B67"), "_B11455DE-F77A-4251-A85B-4C66636E3CD9");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0462D6E9-7099-4F55-B570-4878505FF34D"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_57DBE42C-6850-4A08-AC73-2BB0FFDFCC8C"), "_9653B0EA-4385-42E2-BA75-9B0785F3144D");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_940F2A0C-8CC6-4ECA-B504-49363AF68B67"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_6CE52250-BCEE-485C-8AE4-F6CACF2EF5A1"), "_7DDA574A-C220-4FEF-9784-22EF8052EDEC");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_A51A809E-03C0-4EA7-91F1-7B3C5E29AD04"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_F4D56F6C-4CFE-4D5C-BF5E-67261F68EF1A"), "_59F9A0E6-7F9C-43A9-8920-5B40A91169E6");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_30C8C01B-4149-4AE5-8D86-D27D57BCA8E7"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_4B7FF147-F096-435B-8CAF-48318EF786B0"), "_94172225-E124-4F14-98DA-C3D62C11254A");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_A51A809E-03C0-4EA7-91F1-7B3C5E29AD04"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_30C8C01B-4149-4AE5-8D86-D27D57BCA8E7"), "_C6E61C53-FD35-4347-B69E-30AA93AE4404");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B9662806-84F3-4444-AD62-4790CDA7C85D"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_30C8C01B-4149-4AE5-8D86-D27D57BCA8E7"), "_B7FC63DD-C08F-4CB3-A51A-79C1B8B18E6E");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_834B21EF-9229-44F8-A5DB-D96EBB39A347"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_30C8C01B-4149-4AE5-8D86-D27D57BCA8E7"), "_5334FFDC-1FCB-47E6-8085-36DC9A3D17B9");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_5BDBE48C-CC83-46A9-9D56-F846F8FC1045"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_A51A809E-03C0-4EA7-91F1-7B3C5E29AD04"), "_5162ABF0-DD2E-4BDC-9A46-DDCFCB010287");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_F761355E-F248-46A4-9CAD-9DDFD7F47380"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B9662806-84F3-4444-AD62-4790CDA7C85D"), "_066825BF-D6A7-46FC-8633-BA0DA4242F4E");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_116F3C54-A10E-4952-9E08-1CACE74CED0B"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_834B21EF-9229-44F8-A5DB-D96EBB39A347"), "_7B41F971-C74D-4036-8A5E-EFF81C37986A");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_1639F738-45F3-4CD6-A80E-CCEBAA605D56"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_5BDBE48C-CC83-46A9-9D56-F846F8FC1045"), "_8863B46B-9B0F-40B9-AAB1-A7503CF9AA0A");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_92DE8566-6BCB-4156-8501-B89B6E3720D8"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_8962C15F-55EC-46F7-B926-5D5A1FD8D35E"), "_5B767618-0FC5-4D45-899F-59A4F26D1EE1");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_57DBE42C-6850-4A08-AC73-2BB0FFDFCC8C"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_B8C4F63C-81AD-4291-9C1B-84967277EEF6"), "_BDA80CAE-7356-4FEA-89B8-2D71341C07C7");
        factory.validate();
        return factory.getProcess();
    }
}
