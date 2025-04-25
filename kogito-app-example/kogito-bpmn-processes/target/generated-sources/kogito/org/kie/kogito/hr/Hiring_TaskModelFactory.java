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

import org.kie.kogito.usertask.model.Attachment;
import org.kie.kogito.usertask.model.AttachmentInfo;
import org.kie.kogito.usertask.model.Comment;
import org.kie.kogito.process.workitem.TaskModel;

public class Hiring_TaskModelFactory {

    public static TaskModel from(org.kie.kogito.process.WorkItem workItem) {
        switch(workItem.getNodeId().toExternalFormat()) {
            case "_B8C4F63C-81AD-4291-9C1B-84967277EEF6":
                return Hiring__B8C4F63C_81AD_4291_9C1B_84967277EEF6_TaskModel.from(workItem);
            case "_8962C15F-55EC-46F7-B926-5D5A1FD8D35E":
                return Hiring__8962C15F_55EC_46F7_B926_5D5A1FD8D35E_TaskModel.from(workItem);
            case "_EC746C99-E104-4015-83D9-03AA6DC69B5A":
                return Hiring__EC746C99_E104_4015_83D9_03AA6DC69B5A_TaskModel.from(workItem);
            case "_B1659D20-D231-4FF0-98BA-7A177E2188A5":
                return Hiring__B1659D20_D231_4FF0_98BA_7A177E2188A5_TaskModel.from(workItem);
            case "_D07EB7C0-8D6C-4ABC-AC31-E8D2DF05301C":
                return Hiring__D07EB7C0_8D6C_4ABC_AC31_E8D2DF05301C_TaskModel.from(workItem);
            case "_A10FCA8A-D387-49BF-B675-596B9B78ABE6":
                return Hiring__A10FCA8A_D387_49BF_B675_596B9B78ABE6_TaskModel.from(workItem);
            case "_3DE5198B-404A-4EDE-9489-419CD8DA550E":
                return Hiring__3DE5198B_404A_4EDE_9489_419CD8DA550E_TaskModel.from(workItem);
            default:
                throw new IllegalArgumentException("Invalid task name for work item " + workItem);
        }
    }
}
