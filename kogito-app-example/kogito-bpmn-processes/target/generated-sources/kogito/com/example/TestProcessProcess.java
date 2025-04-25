package com.example;

import com.example.TestProcessModel;
import org.kie.api.definition.process.Process;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.drools.core.util.KieFunctions;
import org.jbpm.process.core.datatype.impl.type.BooleanDataType;
import org.jbpm.process.core.datatype.impl.type.StringDataType;

@jakarta.enterprise.context.ApplicationScoped()
@jakarta.inject.Named("TestProcess")
@io.quarkus.runtime.Startup()
public class TestProcessProcess extends org.kie.kogito.process.impl.AbstractProcess<com.example.TestProcessModel> {

    @jakarta.inject.Inject()
    public TestProcessProcess(org.kie.kogito.app.Application app, org.kie.kogito.correlation.CorrelationService correlations, org.kie.kogito.process.ProcessInstancesFactory factory) {
        super(app, java.util.Arrays.asList(), correlations, factory);
        activate();
    }

    public TestProcessProcess() {
    }

    @Override()
    public com.example.TestProcessProcessInstance createInstance(com.example.TestProcessModel value) {
        return new com.example.TestProcessProcessInstance(this, value, this.createProcessRuntime());
    }

    public com.example.TestProcessProcessInstance createInstance(java.lang.String businessKey, com.example.TestProcessModel value) {
        return new com.example.TestProcessProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public com.example.TestProcessProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.correlation.CompositeCorrelation correlation, com.example.TestProcessModel value) {
        return new com.example.TestProcessProcessInstance(this, value, businessKey, this.createProcessRuntime(), correlation);
    }

    @Override()
    public com.example.TestProcessModel createModel() {
        return new com.example.TestProcessModel();
    }

    public com.example.TestProcessProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((com.example.TestProcessModel) value);
    }

    public com.example.TestProcessProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (com.example.TestProcessModel) value);
    }

    public com.example.TestProcessProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.example.TestProcessProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public com.example.TestProcessProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new com.example.TestProcessProcessInstance(this, this.createModel(), wpi);
    }

    protected org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("TestProcess", true);
        factory.variable("repeatTask", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.Boolean.class), java.util.Map.of("customTags", "internal", "repeatTask", "repeatTask", "ItemSubjectRef", "_repeatTaskItem"));
        factory.variable("variable1", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("variable1", "variable1", "ItemSubjectRef", "_variable1Item"));
        factory.variable("variable2", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("variable2", "variable2", "ItemSubjectRef", "_variable2Item"));
        factory.variable("variable3", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("variable3", "variable3", "ItemSubjectRef", "_variable3Item"));
        factory.variable("variable4", org.jbpm.process.core.datatype.DataTypeResolver.fromClass(java.lang.String.class), java.util.Map.of("variable4", "variable4", "ItemSubjectRef", "_variable4Item"));
        factory.name("TestProcess");
        factory.packageName("com.example");
        factory.dynamic(false);
        factory.version("1.0");
        factory.type("BPMN");
        factory.visibility("Public");
        factory.metaData("jbpm.enable.multi.con", null);
        factory.metaData("jbpm.transactions.enable", "true");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.ActionNodeFactory<?> actionNode_0192194F_8284_40D7_9E48_BD767C381B92 = factory.actionNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0192194F-8284-40D7-9E48-BD767C381B92"));
        actionNode_0192194F_8284_40D7_9E48_BD767C381B92.name("Script Task 1");
        actionNode_0192194F_8284_40D7_9E48_BD767C381B92.metaData("UniqueId", "_0192194F-8284-40D7-9E48-BD767C381B92");
        actionNode_0192194F_8284_40D7_9E48_BD767C381B92.metaData("elementname", "Script Task 1");
        actionNode_0192194F_8284_40D7_9E48_BD767C381B92.metaData("NodeType", "ScriptTask");
        actionNode_0192194F_8284_40D7_9E48_BD767C381B92.metaData("x", 352);
        actionNode_0192194F_8284_40D7_9E48_BD767C381B92.metaData("width", 154);
        actionNode_0192194F_8284_40D7_9E48_BD767C381B92.metaData("y", 221);
        actionNode_0192194F_8284_40D7_9E48_BD767C381B92.metaData("height", 102);
        actionNode_0192194F_8284_40D7_9E48_BD767C381B92.action(kcontext -> {
            java.lang.String variable1 = (java.lang.String) kcontext.getVariable("variable1");
            java.lang.String variable2 = (java.lang.String) kcontext.getVariable("variable2");
            java.lang.String variable3 = (java.lang.String) kcontext.getVariable("variable3");
            java.lang.String variable4 = (java.lang.String) kcontext.getVariable("variable4");
            System.out.println("Script Task Executed");
            kcontext.setVariable("variable1", "value1");
            kcontext.setVariable("variable2", "value2");
            kcontext.setVariable("variable3", "value3");
            kcontext.setVariable("variable4", "value4");
        });
        actionNode_0192194F_8284_40D7_9E48_BD767C381B92.done();
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode_396AA527_1060_4069_8DAC_95A8A9F0513F = factory.humanTaskNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_396AA527-1060-4069-8DAC-95A8A9F0513F"));
        humanTaskNode_396AA527_1060_4069_8DAC_95A8A9F0513F.name("User Task 2");
        humanTaskNode_396AA527_1060_4069_8DAC_95A8A9F0513F.workParameter("ActorId", "jdoe");
        humanTaskNode_396AA527_1060_4069_8DAC_95A8A9F0513F.workParameter("NodeName", "User Task 2");
        humanTaskNode_396AA527_1060_4069_8DAC_95A8A9F0513F.workParameter("Skippable", "false");
        humanTaskNode_396AA527_1060_4069_8DAC_95A8A9F0513F.workParameter("TaskName", "userTask2");
        humanTaskNode_396AA527_1060_4069_8DAC_95A8A9F0513F.workParameter("UNIQUE_TASK_ID", "_396AA527-1060-4069-8DAC-95A8A9F0513F");
        humanTaskNode_396AA527_1060_4069_8DAC_95A8A9F0513F.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_396AA527-1060-4069-8DAC-95A8A9F0513F_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("0a92ba21-b163-4f8d-96c2-793cb56f1aff", "EXPRESSION (userTask2)", "java.lang.Object", "userTask2"), new org.jbpm.workflow.core.impl.DataDefinition("_396AA527-1060-4069-8DAC-95A8A9F0513F_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode_396AA527_1060_4069_8DAC_95A8A9F0513F.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_396AA527-1060-4069-8DAC-95A8A9F0513F_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("2059328a-97f7-4a85-9529-09f9b154992d", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_396AA527-1060-4069-8DAC-95A8A9F0513F_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode_396AA527_1060_4069_8DAC_95A8A9F0513F.done();
        humanTaskNode_396AA527_1060_4069_8DAC_95A8A9F0513F.metaData("UniqueId", "_396AA527-1060-4069-8DAC-95A8A9F0513F");
        humanTaskNode_396AA527_1060_4069_8DAC_95A8A9F0513F.metaData("elementname", "User Task 2");
        humanTaskNode_396AA527_1060_4069_8DAC_95A8A9F0513F.metaData("x", 770);
        humanTaskNode_396AA527_1060_4069_8DAC_95A8A9F0513F.metaData("width", 154);
        humanTaskNode_396AA527_1060_4069_8DAC_95A8A9F0513F.metaData("y", 221);
        humanTaskNode_396AA527_1060_4069_8DAC_95A8A9F0513F.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.EndNodeFactory<?> endNode_7F5AE5BE_3189_47FD_AF7F_225F8CBA1599 = factory.endNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_7F5AE5BE-3189-47FD-AF7F-225F8CBA1599"));
        endNode_7F5AE5BE_3189_47FD_AF7F_225F8CBA1599.name("Process finished");
        endNode_7F5AE5BE_3189_47FD_AF7F_225F8CBA1599.terminate(false);
        endNode_7F5AE5BE_3189_47FD_AF7F_225F8CBA1599.metaData("UniqueId", "_7F5AE5BE-3189-47FD-AF7F-225F8CBA1599");
        endNode_7F5AE5BE_3189_47FD_AF7F_225F8CBA1599.metaData("elementname", "Process finished");
        endNode_7F5AE5BE_3189_47FD_AF7F_225F8CBA1599.metaData("x", 1042);
        endNode_7F5AE5BE_3189_47FD_AF7F_225F8CBA1599.metaData("width", 56);
        endNode_7F5AE5BE_3189_47FD_AF7F_225F8CBA1599.metaData("y", 244);
        endNode_7F5AE5BE_3189_47FD_AF7F_225F8CBA1599.metaData("height", 56);
        endNode_7F5AE5BE_3189_47FD_AF7F_225F8CBA1599.done();
        org.jbpm.ruleflow.core.factory.HumanTaskNodeFactory<?> humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6 = factory.humanTaskNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_5A1C97E5-A188-4C80-899E-0702BC278AD6"));
        humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6.name("User Task 1");
        humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6.workParameter("ActorId", "jdoe");
        humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6.workParameter("NodeName", "User Task 1");
        humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6.workParameter("Skippable", "false");
        humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6.workParameter("TaskName", "userTask1");
        humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6.workParameter("UNIQUE_TASK_ID", "_5A1C97E5-A188-4C80-899E-0702BC278AD6");
        humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_5A1C97E5-A188-4C80-899E-0702BC278AD6_TaskNameInputX", "TaskName", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("4081fec9-6405-4973-9e3d-ada216f9d280", "EXPRESSION (userTask1)", "java.lang.Object", "userTask1"), new org.jbpm.workflow.core.impl.DataDefinition("_5A1C97E5-A188-4C80-899E-0702BC278AD6_TaskNameInputX", "TaskName", "Object", null))), null));
        humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("variable1", "variable1", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("_5A1C97E5-A188-4C80-899E-0702BC278AD6_variable1InputX", "variable1", "String", null), null, null));
        humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("variable2", "variable2", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("_5A1C97E5-A188-4C80-899E-0702BC278AD6_variable2InputX", "variable2", "String", null), null, null));
        humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("variable3", "variable3", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("_5A1C97E5-A188-4C80-899E-0702BC278AD6_variable3InputX", "variable3", "String", null), null, null));
        humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("variable4", "variable4", "java.lang.String", null)), new org.jbpm.workflow.core.impl.DataDefinition("_5A1C97E5-A188-4C80-899E-0702BC278AD6_variable4InputX", "variable4", "String", null), null, null));
        humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6.mapDataInputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(), new org.jbpm.workflow.core.impl.DataDefinition("_5A1C97E5-A188-4C80-899E-0702BC278AD6_SkippableInputX", "Skippable", "Object", null), java.util.Arrays.asList(new org.jbpm.workflow.core.node.Assignment(null, new org.jbpm.workflow.core.impl.DataDefinition("2fbfa461-c0ca-4205-8593-0ddd575cdd88", "EXPRESSION (false)", "java.lang.Object", "false"), new org.jbpm.workflow.core.impl.DataDefinition("_5A1C97E5-A188-4C80-899E-0702BC278AD6_SkippableInputX", "Skippable", "Object", null))), null));
        humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6.mapDataOutputAssociation(new org.jbpm.workflow.core.impl.DataAssociation(java.util.Arrays.asList(new org.jbpm.workflow.core.impl.DataDefinition("_5A1C97E5-A188-4C80-899E-0702BC278AD6_repeatTaskOutputX", "repeatTask", "Boolean", null)), new org.jbpm.workflow.core.impl.DataDefinition("repeatTask", "repeatTask", "java.lang.Boolean", null), null, null));
        humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6.done();
        humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6.metaData("UniqueId", "_5A1C97E5-A188-4C80-899E-0702BC278AD6");
        humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6.metaData("elementname", "User Task 1");
        humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6.metaData("x", 567);
        humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6.metaData("width", 154);
        humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6.metaData("y", 221);
        humanTaskNode_5A1C97E5_A188_4C80_899E_0702BC278AD6.metaData("height", 102);
        org.jbpm.ruleflow.core.factory.StartNodeFactory<?> startNode_DDB19328_DDA1_42FF_AC60_0765E7C0947E = factory.startNode(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_DDB19328-DDA1-42FF-AC60-0765E7C0947E"));
        startNode_DDB19328_DDA1_42FF_AC60_0765E7C0947E.name("Process started");
        startNode_DDB19328_DDA1_42FF_AC60_0765E7C0947E.interrupting(true);
        startNode_DDB19328_DDA1_42FF_AC60_0765E7C0947E.metaData("UniqueId", "_DDB19328-DDA1-42FF-AC60-0765E7C0947E");
        startNode_DDB19328_DDA1_42FF_AC60_0765E7C0947E.metaData("elementname", "Process started");
        startNode_DDB19328_DDA1_42FF_AC60_0765E7C0947E.metaData("EventType", "none");
        startNode_DDB19328_DDA1_42FF_AC60_0765E7C0947E.metaData("x", 235);
        startNode_DDB19328_DDA1_42FF_AC60_0765E7C0947E.metaData("width", 56);
        startNode_DDB19328_DDA1_42FF_AC60_0765E7C0947E.metaData("y", 244);
        startNode_DDB19328_DDA1_42FF_AC60_0765E7C0947E.metaData("height", 56);
        startNode_DDB19328_DDA1_42FF_AC60_0765E7C0947E.done();
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_DDB19328-DDA1-42FF-AC60-0765E7C0947E"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0192194F-8284-40D7-9E48-BD767C381B92"), "_F4D664B9-F7B0-42C6-A3E2-81435CDF7CD2");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_5A1C97E5-A188-4C80-899E-0702BC278AD6"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_396AA527-1060-4069-8DAC-95A8A9F0513F"), "_3045C57A-3526-4B29-9D61-C0F3E9260C23");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_396AA527-1060-4069-8DAC-95A8A9F0513F"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_7F5AE5BE-3189-47FD-AF7F-225F8CBA1599"), "_69F21C9B-DC9F-48CB-BA59-7E1973E73816");
        factory.connection(org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_0192194F-8284-40D7-9E48-BD767C381B92"), org.jbpm.ruleflow.core.WorkflowElementIdentifierFactory.fromExternalFormat("_5A1C97E5-A188-4C80-899E-0702BC278AD6"), "_8541595C-152C-4CC6-A44A-A09F8A955241");
        factory.validate();
        return factory.getProcess();
    }
}
