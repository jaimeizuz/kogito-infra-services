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

import org.kie.kogito.MapInput;
import org.kie.kogito.MapInputId;
import org.kie.kogito.MapOutput;
import java.util.Map;
import java.util.HashMap;
import org.kie.kogito.MappableToModel;
import org.kie.kogito.Model;
import org.kie.kogito.ProcessInput;

@org.kie.kogito.codegen.Generated(value = "kogito-codegen", reference = "hiring", name = "Hiring", hidden = true)
@ProcessInput(processName = "hiring")
public class HiringModelInput implements Model, MapInput, MapInputId, MapOutput, MappableToModel<HiringModel> {

    @org.kie.kogito.codegen.VariableInfo(tags = "input")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "workitemType")
    @jakarta.validation.Valid()
    private java.lang.String workitemType;

    public java.lang.String getWorkitemType() {
        return workitemType;
    }

    public void setWorkitemType(java.lang.String workitemType) {
        this.workitemType = workitemType;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "input,required")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "expirationTime")
    @jakarta.validation.Valid()
    @jakarta.validation.constraints.NotNull()
    private java.lang.String expirationTime;

    public java.lang.String getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(java.lang.String expirationTime) {
        this.expirationTime = expirationTime;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "input")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "candidateData")
    @jakarta.validation.Valid()
    private org.kie.kogito.hr.CandidateData candidateData;

    public org.kie.kogito.hr.CandidateData getCandidateData() {
        return candidateData;
    }

    public void setCandidateData(org.kie.kogito.hr.CandidateData candidateData) {
        this.candidateData = candidateData;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "input")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "errorStrategy")
    @jakarta.validation.Valid()
    private java.lang.String errorStrategy;

    public java.lang.String getErrorStrategy() {
        return errorStrategy;
    }

    public void setErrorStrategy(java.lang.String errorStrategy) {
        this.errorStrategy = errorStrategy;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "input,required")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "throwException")
    @jakarta.validation.Valid()
    @jakarta.validation.constraints.NotNull()
    private java.lang.Boolean throwException;

    public java.lang.Boolean getThrowException() {
        return throwException;
    }

    public void setThrowException(java.lang.Boolean throwException) {
        this.throwException = throwException;
    }

    @org.kie.kogito.codegen.VariableInfo(tags = "input,required")
    @com.fasterxml.jackson.annotation.JsonProperty(value = "needMgmtApproval")
    @jakarta.validation.Valid()
    @jakarta.validation.constraints.NotNull()
    private java.lang.Boolean needMgmtApproval;

    public java.lang.Boolean getNeedMgmtApproval() {
        return needMgmtApproval;
    }

    public void setNeedMgmtApproval(java.lang.Boolean needMgmtApproval) {
        this.needMgmtApproval = needMgmtApproval;
    }

    @Override()
    public HiringModel toModel() {
        HiringModel result = new HiringModel();
        result.setWorkitemType(getWorkitemType());
        result.setExpirationTime(getExpirationTime());
        result.setCandidateData(getCandidateData());
        result.setErrorStrategy(getErrorStrategy());
        result.setThrowException(getThrowException());
        result.setNeedMgmtApproval(getNeedMgmtApproval());
        return result;
    }
}
