package org.acme.travels.P3E;


import static org.acme.travels.Rulesd6873a39ab144ce38651c810eeb54a7b.*;
import org.acme.travels.*;
import org.drools.modelcompiler.dsl.pattern.D;

@org.drools.compiler.kie.builder.MaterializedLambda()
public enum LambdaConsequence3E06866B0CC8B0FB2B8BA18C6C533FAB implements org.drools.model.functions.Block1<org.acme.travels.Trip>, org.drools.model.functions.HashedExpression {

    INSTANCE;

    public static final String EXPRESSION_HASH = "003B4F1F54C15773BB8120D11EE9F2D4";

    public java.lang.String getExpressionHash() {
        return EXPRESSION_HASH;
    }

    @Override()
    public void execute(org.acme.travels.Trip $trip) throws java.lang.Exception {
        $trip.setVisaRequired(false);
    }
}
