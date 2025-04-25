package org.acme.travels.PD9;


import static org.acme.travels.Rulesd6873a39ab144ce38651c810eeb54a7b.*;
import org.acme.travels.*;
import org.drools.modelcompiler.dsl.pattern.D;

@org.drools.compiler.kie.builder.MaterializedLambda()
public enum LambdaPredicateD97F291425C6F8C413B79FD32E447B03 implements org.drools.model.functions.Predicate1<org.acme.travels.Traveller>, org.drools.model.functions.HashedExpression {

    INSTANCE;

    public static final String EXPRESSION_HASH = "8F377BD7B0C0078790858ECA9AE575D7";

    public java.lang.String getExpressionHash() {
        return EXPRESSION_HASH;
    }

    @Override()
    public boolean test(org.acme.travels.Traveller _this) throws java.lang.Exception {
        return org.drools.modelcompiler.util.EvaluationUtil.areNullSafeEquals(_this.getNationality(), "Brazilian");
    }

    @Override()
    public org.drools.model.functions.PredicateInformation predicateInformation() {
        org.drools.model.functions.PredicateInformation info = new org.drools.model.functions.PredicateInformation("$traveller.nationality == \"Brazilian\"");
        info.addRuleNames("Brazilian citizens require visa to Australia", "org/acme/travels/visa-rules.drl.xls");
        return info;
    }
}
