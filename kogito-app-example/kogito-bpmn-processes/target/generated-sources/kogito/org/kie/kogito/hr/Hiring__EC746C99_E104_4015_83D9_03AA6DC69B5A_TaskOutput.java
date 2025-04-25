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
package org.kie.kogito.hr;

import java.util.HashMap;
import java.util.Map;
import org.kie.kogito.MapOutput;
import org.kie.kogito.UserTask;

@UserTask(taskName = "Store Candidate Data", processName = "hiring")
public class Hiring__EC746C99_E104_4015_83D9_03AA6DC69B5A_TaskOutput implements MapOutput {

    @Override
    public Map<String, Object> toMap() {
        Map<String, Object> params = new HashMap<>();
        return params;
    }

    public static Hiring__EC746C99_E104_4015_83D9_03AA6DC69B5A_TaskOutput fromMap(Map<String, Object> params) {
        org.kie.kogito.hr.Hiring__EC746C99_E104_4015_83D9_03AA6DC69B5A_TaskOutput result = new Hiring__EC746C99_E104_4015_83D9_03AA6DC69B5A_TaskOutput();
        return result;
    }
}
//Task output for user task 'Store Candidate Data' in process 'hiring'
