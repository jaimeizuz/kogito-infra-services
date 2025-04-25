package com.example;

import com.example.TestProcessModel;

public class TestProcessProcessInstance extends org.kie.kogito.process.impl.AbstractProcessInstance<TestProcessModel> {

    public TestProcessProcessInstance(com.example.TestProcessProcess process, TestProcessModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, processRuntime);
    }

    public TestProcessProcessInstance(com.example.TestProcessProcess process, TestProcessModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime) {
        super(process, value, businessKey, processRuntime);
    }

    public TestProcessProcessInstance(com.example.TestProcessProcess process, TestProcessModel value, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, processRuntime, wpi);
    }

    public TestProcessProcessInstance(com.example.TestProcessProcess process, TestProcessModel value, org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        super(process, value, wpi);
    }

    public TestProcessProcessInstance(com.example.TestProcessProcess process, TestProcessModel value, java.lang.String businessKey, org.kie.api.runtime.process.ProcessRuntime processRuntime, org.kie.kogito.correlation.CompositeCorrelation correlation) {
        super(process, value, businessKey, processRuntime, correlation);
    }

    protected java.util.Map<String, Object> bind(TestProcessModel variables) {
        if (null != variables)
            return variables.toMap();
        else
            return new java.util.HashMap();
    }

    protected void unbind(TestProcessModel variables, java.util.Map<String, Object> vmap) {
        variables.fromMap(this.id(), vmap);
    }
}
