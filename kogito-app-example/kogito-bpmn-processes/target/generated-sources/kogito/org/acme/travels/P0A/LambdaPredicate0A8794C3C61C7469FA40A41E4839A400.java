package org.acme.travels.P0A;


import static org.acme.travels.Rulesd6873a39ab144ce38651c810eeb54a7b.*;
import org.acme.travels.*;
import org.drools.modelcompiler.dsl.pattern.D;

@org.drools.compiler.kie.builder.MaterializedLambda()
public enum LambdaPredicate0A8794C3C61C7469FA40A41E4839A400 implements org.drools.model.functions.Predicate1<org.acme.travels.Trip>, org.drools.model.functions.HashedExpression {

    INSTANCE;

    public static final String EXPRESSION_HASH = "1A1158053192D10FD74A3825B92D44D0";

    public java.lang.String getExpressionHash() {
        return EXPRESSION_HASH;
    }

    @Override()
    public boolean test(org.acme.travels.Trip _this) throws java.lang.Exception {
        return org.drools.modelcompiler.util.EvaluationUtil.areNullSafeEquals(_this.getCountry(), "UK");
    }

    @Override()
    public org.drools.model.functions.PredicateInformation predicateInformation() {
        org.drools.model.functions.PredicateInformation info = new org.drools.model.functions.PredicateInformation("$trip.country == \"UK\"");
        info.addRuleNames("Polish citizens do not require visa to UK", "org/acme/travels/visa-rules.drl.xls");
        return info;
    }
}
