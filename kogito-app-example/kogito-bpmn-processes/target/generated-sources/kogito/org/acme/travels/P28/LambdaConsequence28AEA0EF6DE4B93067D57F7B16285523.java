package org.acme.travels.P28;


import static org.acme.travels.Rulesd6873a39ab144ce38651c810eeb54a7b.*;
import org.acme.travels.*;
import org.drools.modelcompiler.dsl.pattern.D;

@org.drools.compiler.kie.builder.MaterializedLambda()
public enum LambdaConsequence28AEA0EF6DE4B93067D57F7B16285523 implements org.drools.model.functions.Block1<org.acme.travels.Trip>, org.drools.model.functions.HashedExpression {

    INSTANCE;

    public static final String EXPRESSION_HASH = "DCFBC4906F5F537E67F6A7CB41F890F4";

    public java.lang.String getExpressionHash() {
        return EXPRESSION_HASH;
    }

    @Override()
    public void execute(org.acme.travels.Trip $trip) throws java.lang.Exception {
        $trip.setVisaRequired(true);
    }
}
