package org.acme.travels.P72;


import static org.acme.travels.Rulesd6873a39ab144ce38651c810eeb54a7b.*;
import org.acme.travels.*;
import org.drools.modelcompiler.dsl.pattern.D;

@org.drools.compiler.kie.builder.MaterializedLambda()
public enum LambdaExtractor72A9A4ED8C34199AB237F61E49FFE2CE implements org.drools.model.functions.Function1<org.acme.travels.Traveller, java.lang.String>, org.drools.model.functions.HashedExpression {

    INSTANCE;

    public static final String EXPRESSION_HASH = "41EF90148DBEC62D76CCDFB69BF38C59";

    public java.lang.String getExpressionHash() {
        return EXPRESSION_HASH;
    }

    @Override()
    public java.lang.String apply(org.acme.travels.Traveller _this) {
        return _this.getNationality();
    }
}
