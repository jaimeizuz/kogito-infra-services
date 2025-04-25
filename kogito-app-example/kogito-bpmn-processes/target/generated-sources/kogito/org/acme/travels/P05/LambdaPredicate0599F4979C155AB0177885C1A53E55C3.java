package org.acme.travels.P05;


import static org.acme.travels.Rulesd6873a39ab144ce38651c810eeb54a7b.*;
import org.acme.travels.*;
import org.drools.modelcompiler.dsl.pattern.D;

@org.drools.compiler.kie.builder.MaterializedLambda()
public enum LambdaPredicate0599F4979C155AB0177885C1A53E55C3 implements org.drools.model.functions.Predicate1<org.acme.travels.Traveller>, org.drools.model.functions.HashedExpression {

    INSTANCE;

    public static final String EXPRESSION_HASH = "C96177F6A6AD31C4CC687A192D4E10BE";

    public java.lang.String getExpressionHash() {
        return EXPRESSION_HASH;
    }

    @Override()
    public boolean test(org.acme.travels.Traveller _this) throws java.lang.Exception {
        return org.drools.modelcompiler.util.EvaluationUtil.areNullSafeEquals(_this.getNationality(), "Polish");
    }

    @Override()
    public org.drools.model.functions.PredicateInformation predicateInformation() {
        org.drools.model.functions.PredicateInformation info = new org.drools.model.functions.PredicateInformation("$traveller.nationality == \"Polish\"");
        info.addRuleNames("Polish citizens do not require visa to UK", "org/acme/travels/visa-rules.drl.xls", "Polish citizens require visa to Australia", "org/acme/travels/visa-rules.drl.xls", "Polish citizens require visa to US", "org/acme/travels/visa-rules.drl.xls");
        return info;
    }
}
