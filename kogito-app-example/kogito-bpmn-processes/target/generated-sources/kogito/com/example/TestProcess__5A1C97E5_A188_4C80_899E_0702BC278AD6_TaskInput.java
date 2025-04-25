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

import java.util.Map;
import org.kie.kogito.UserTask;
import org.kie.kogito.UserTaskParam.ParamType;
import org.kie.kogito.UserTaskParam;

@UserTask(taskName = "userTask1", processName = "TestProcess")
public class TestProcess__5A1C97E5_A188_4C80_899E_0702BC278AD6_TaskInput {

    public static TestProcess__5A1C97E5_A188_4C80_899E_0702BC278AD6_TaskInput fromMap(Map<String, Object> params) {
        TestProcess__5A1C97E5_A188_4C80_899E_0702BC278AD6_TaskInput item = new TestProcess__5A1C97E5_A188_4C80_899E_0702BC278AD6_TaskInput();
        item.variable1 = (java.lang.String) params.get("variable1");
        item.variable3 = (java.lang.String) params.get("variable3");
        item.variable2 = (java.lang.String) params.get("variable2");
        item.variable4 = (java.lang.String) params.get("variable4");
        return item;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String variable1;

    public java.lang.String getVariable1() {
        return variable1;
    }

    public void setVariable1(java.lang.String variable1) {
        this.variable1 = variable1;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String variable3;

    public java.lang.String getVariable3() {
        return variable3;
    }

    public void setVariable3(java.lang.String variable3) {
        this.variable3 = variable3;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String variable2;

    public java.lang.String getVariable2() {
        return variable2;
    }

    public void setVariable2(java.lang.String variable2) {
        this.variable2 = variable2;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String variable4;

    public java.lang.String getVariable4() {
        return variable4;
    }

    public void setVariable4(java.lang.String variable4) {
        this.variable4 = variable4;
    }
}
//Task input for user task 'User Task 1' in process 'TestProcess'
