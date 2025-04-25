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

import org.kie.kogito.MapInput;
import org.kie.kogito.MapInputId;
import org.kie.kogito.MapOutput;
import java.util.Map;
import java.util.HashMap;
import org.kie.kogito.MappableToModel;
import org.kie.kogito.Model;
import org.kie.kogito.ProcessInput;

@org.kie.kogito.codegen.Generated(value = "kogito-codegen", reference = "TestProcess", name = "TestProcess", hidden = true)
@ProcessInput(processName = "TestProcess")
public class TestProcessModelInput implements Model, MapInput, MapInputId, MapOutput, MappableToModel<TestProcessModel> {

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "variable1")
    @jakarta.validation.Valid()
    private java.lang.String variable1;

    public java.lang.String getVariable1() {
        return variable1;
    }

    public void setVariable1(java.lang.String variable1) {
        this.variable1 = variable1;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "variable3")
    @jakarta.validation.Valid()
    private java.lang.String variable3;

    public java.lang.String getVariable3() {
        return variable3;
    }

    public void setVariable3(java.lang.String variable3) {
        this.variable3 = variable3;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "variable2")
    @jakarta.validation.Valid()
    private java.lang.String variable2;

    public java.lang.String getVariable2() {
        return variable2;
    }

    public void setVariable2(java.lang.String variable2) {
        this.variable2 = variable2;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "variable4")
    @jakarta.validation.Valid()
    private java.lang.String variable4;

    public java.lang.String getVariable4() {
        return variable4;
    }

    public void setVariable4(java.lang.String variable4) {
        this.variable4 = variable4;
    }

    @Override()
    public TestProcessModel toModel() {
        TestProcessModel result = new TestProcessModel();
        result.setVariable1(getVariable1());
        result.setVariable3(getVariable3());
        result.setVariable2(getVariable2());
        result.setVariable4(getVariable4());
        return result;
    }
}
