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

import java.util.HashMap;
import java.util.Map;
import org.kie.kogito.MapOutput;
import org.kie.kogito.UserTask;
import org.kie.kogito.UserTaskParam.ParamType;
import org.kie.kogito.UserTaskParam;

@UserTask(taskName = "userTask1", processName = "TestProcess")
public class TestProcess__5A1C97E5_A188_4C80_899E_0702BC278AD6_TaskOutput implements MapOutput {

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> params = new HashMap<>();
        params.put("repeatTask", this.repeatTask);
        return params;
    }

    public static TestProcess__5A1C97E5_A188_4C80_899E_0702BC278AD6_TaskOutput fromMap(Map<String, Object> params) {
        com.example.TestProcess__5A1C97E5_A188_4C80_899E_0702BC278AD6_TaskOutput result = new TestProcess__5A1C97E5_A188_4C80_899E_0702BC278AD6_TaskOutput();
        result.repeatTask = (java.lang.Boolean) params.get("repeatTask");
        return result;
    }

    @UserTaskParam(value = ParamType.OUTPUT)
    private java.lang.Boolean repeatTask;

    public java.lang.Boolean getRepeatTask() {
        return repeatTask;
    }

    public void setRepeatTask(java.lang.Boolean repeatTask) {
        this.repeatTask = repeatTask;
    }
}
//Task output for user task 'User Task 1' in process 'TestProcess'
