package org.acme.travels;

import org.drools.modelcompiler.dsl.pattern.D;
import org.drools.model.Index.ConstraintType;
import static org.acme.travels.Rulesd6873a39ab144ce38651c810eeb54a7b.*;
import static org.acme.travels.Rulesd6873a39ab144ce38651c810eeb54a7b.*;

public class Rulesd6873a39ab144ce38651c810eeb54a7b_rule_Brazilian_32citizens_32require_32visa_32to_32Australia {

    /**
     * Rule name: Brazilian citizens require visa to Australia
     */
    public static org.drools.model.Rule rule_Brazilian_32citizens_32require_32visa_32to_32Australia() {
        final org.drools.model.Variable<org.acme.travels.Trip> var_$trip = D.declarationOf(org.acme.travels.Trip.class,
                                                                                           DomainClassesMetadatad6873a39ab144ce38651c810eeb54a7b.org_acme_travels_Trip_Metadata_INSTANCE,
                                                                                           "$trip");
        final org.drools.model.Variable<org.acme.travels.Traveller> var_$traveller = D.declarationOf(org.acme.travels.Traveller.class,
                                                                                                     DomainClassesMetadatad6873a39ab144ce38651c810eeb54a7b.org_acme_travels_Traveller_Metadata_INSTANCE,
                                                                                                     "$traveller");
        org.drools.model.Rule rule = D.rule("org.acme.travels",
                                            "Brazilian citizens require visa to Australia")
                                      .attribute(org.drools.model.Rule.Attribute.RULEFLOW_GROUP,
                                                 "visas")
                                      .build(D.pattern(var_$trip).expr("GENERATED_9EACDF2377C5EC838B1F7D00D9C84657",
                                                                       org.acme.travels.PA5.LambdaPredicateA58AC89842189A4821B883013AD2D021.INSTANCE,
                                                                       D.alphaIndexedBy(java.lang.String.class,
                                                                                        org.drools.model.Index.ConstraintType.EQUAL,
                                                                                        -1,
                                                                                        org.acme.travels.P22.LambdaExtractor2284DD6F592D3F43EA1A5B1FE32A26FB.INSTANCE,
                                                                                        "Australia"),
                                                                       D.reactOn("country")),
                                             D.pattern(var_$traveller).expr("GENERATED_109676D3470D5976BA01B98AAAA672EC",
                                                                            org.acme.travels.PD9.LambdaPredicateD97F291425C6F8C413B79FD32E447B03.INSTANCE,
                                                                            D.alphaIndexedBy(java.lang.String.class,
                                                                                             org.drools.model.Index.ConstraintType.EQUAL,
                                                                                             -1,
                                                                                             org.acme.travels.P72.LambdaExtractor72A9A4ED8C34199AB237F61E49FFE2CE.INSTANCE,
                                                                                             "Brazilian"),
                                                                            D.reactOn("nationality")),
                                             D.on(var_$trip).execute(org.acme.travels.P28.LambdaConsequence28AEA0EF6DE4B93067D57F7B16285523.INSTANCE));
        return rule;
    }
}
