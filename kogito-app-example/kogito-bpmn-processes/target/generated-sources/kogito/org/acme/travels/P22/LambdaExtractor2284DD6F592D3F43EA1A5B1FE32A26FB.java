package org.acme.travels.P22;


import static org.acme.travels.Rulesd6873a39ab144ce38651c810eeb54a7b.*;
import org.acme.travels.*;
import org.drools.modelcompiler.dsl.pattern.D;

@org.drools.compiler.kie.builder.MaterializedLambda()
public enum LambdaExtractor2284DD6F592D3F43EA1A5B1FE32A26FB implements org.drools.model.functions.Function1<org.acme.travels.Trip, java.lang.String>, org.drools.model.functions.HashedExpression {

    INSTANCE;

    public static final String EXPRESSION_HASH = "E1921335BDAA114A0008B3D9577B37E6";

    public java.lang.String getExpressionHash() {
        return EXPRESSION_HASH;
    }

    @Override()
    public java.lang.String apply(org.acme.travels.Trip _this) {
        return _this.getCountry();
    }
}
