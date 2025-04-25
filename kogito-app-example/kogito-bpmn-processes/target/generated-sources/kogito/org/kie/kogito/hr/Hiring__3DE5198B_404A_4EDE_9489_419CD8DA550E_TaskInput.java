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

import java.util.Map;
import org.kie.kogito.UserTask;
import org.kie.kogito.UserTaskParam.ParamType;
import org.kie.kogito.UserTaskParam;

@UserTask(taskName = "Call REST dummy using Service Task", processName = "hiring")
public class Hiring__3DE5198B_404A_4EDE_9489_419CD8DA550E_TaskInput {

    public static Hiring__3DE5198B_404A_4EDE_9489_419CD8DA550E_TaskInput fromMap(Map<String, Object> params) {
        Hiring__3DE5198B_404A_4EDE_9489_419CD8DA550E_TaskInput item = new Hiring__3DE5198B_404A_4EDE_9489_419CD8DA550E_TaskInput();
        item.candidateData = (org.kie.kogito.hr.CandidateDataRestDTO) params.get("candidateData");
        item.Interface = (java.lang.String) params.get("Interface");
        item.Operation = (java.lang.String) params.get("Operation");
        item.interfaceImplementationRef = (java.lang.String) params.get("interfaceImplementationRef");
        item.operationImplementationRef = (java.lang.String) params.get("operationImplementationRef");
        item.implementation = (java.lang.String) params.get("implementation");
        return item;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private org.kie.kogito.hr.CandidateDataRestDTO candidateData;

    public org.kie.kogito.hr.CandidateDataRestDTO getCandidateData() {
        return candidateData;
    }

    public void setCandidateData(org.kie.kogito.hr.CandidateDataRestDTO candidateData) {
        this.candidateData = candidateData;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String Interface;

    public java.lang.String getInterface() {
        return Interface;
    }

    public void setInterface(java.lang.String Interface) {
        this.Interface = Interface;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String Operation;

    public java.lang.String getOperation() {
        return Operation;
    }

    public void setOperation(java.lang.String Operation) {
        this.Operation = Operation;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String interfaceImplementationRef;

    public java.lang.String getInterfaceImplementationRef() {
        return interfaceImplementationRef;
    }

    public void setInterfaceImplementationRef(java.lang.String interfaceImplementationRef) {
        this.interfaceImplementationRef = interfaceImplementationRef;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String operationImplementationRef;

    public java.lang.String getOperationImplementationRef() {
        return operationImplementationRef;
    }

    public void setOperationImplementationRef(java.lang.String operationImplementationRef) {
        this.operationImplementationRef = operationImplementationRef;
    }

    @UserTaskParam(value = ParamType.INPUT)
    private java.lang.String implementation;

    public java.lang.String getImplementation() {
        return implementation;
    }

    public void setImplementation(java.lang.String implementation) {
        this.implementation = implementation;
    }
}
//Task input for user task 'Call REST dummy using Service Task' in process 'hiring'
