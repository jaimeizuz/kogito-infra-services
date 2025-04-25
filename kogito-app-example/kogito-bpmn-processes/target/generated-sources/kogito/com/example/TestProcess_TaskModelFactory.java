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

import org.kie.kogito.usertask.model.Attachment;
import org.kie.kogito.usertask.model.AttachmentInfo;
import org.kie.kogito.usertask.model.Comment;
import org.kie.kogito.process.workitem.TaskModel;

public class TestProcess_TaskModelFactory {

    public static TaskModel from(org.kie.kogito.process.WorkItem workItem) {
        switch(workItem.getNodeId().toExternalFormat()) {
            case "_5A1C97E5-A188-4C80-899E-0702BC278AD6":
                return TestProcess__5A1C97E5_A188_4C80_899E_0702BC278AD6_TaskModel.from(workItem);
            case "_396AA527-1060-4069-8DAC-95A8A9F0513F":
                return TestProcess__396AA527_1060_4069_8DAC_95A8A9F0513F_TaskModel.from(workItem);
            default:
                throw new IllegalArgumentException("Invalid task name for work item " + workItem);
        }
    }
}
