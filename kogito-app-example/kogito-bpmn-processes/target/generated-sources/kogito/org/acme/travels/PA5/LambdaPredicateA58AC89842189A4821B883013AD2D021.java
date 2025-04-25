package org.acme.travels.PA5;


import static org.acme.travels.Rulesd6873a39ab144ce38651c810eeb54a7b.*;
import org.acme.travels.*;
import org.drools.modelcompiler.dsl.pattern.D;

@org.drools.compiler.kie.builder.MaterializedLambda()
public enum LambdaPredicateA58AC89842189A4821B883013AD2D021 implements org.drools.model.functions.Predicate1<org.acme.travels.Trip>, org.drools.model.functions.HashedExpression {

    INSTANCE;

    public static final String EXPRESSION_HASH = "78706A793AB28C949CE53B565F829FCF";

    public java.lang.String getExpressionHash() {
        return EXPRESSION_HASH;
    }

    @Override()
    public boolean test(org.acme.travels.Trip _this) throws java.lang.Exception {
        return org.drools.modelcompiler.util.EvaluationUtil.areNullSafeEquals(_this.getCountry(), "Australia");
    }

    @Override()
    public org.drools.model.functions.PredicateInformation predicateInformation() {
        org.drools.model.functions.PredicateInformation info = new org.drools.model.functions.PredicateInformation("$trip.country == \"Australia\"");
        info.addRuleNames("Brazilian citizens require visa to Australia", "org/acme/travels/visa-rules.drl.xls", "Polish citizens require visa to Australia", "org/acme/travels/visa-rules.drl.xls");
        return info;
    }
}
