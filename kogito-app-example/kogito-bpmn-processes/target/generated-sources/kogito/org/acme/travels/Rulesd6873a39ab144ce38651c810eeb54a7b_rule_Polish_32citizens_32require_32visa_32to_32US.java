package org.acme.travels;

import org.drools.modelcompiler.dsl.pattern.D;
import org.drools.model.Index.ConstraintType;
import static org.acme.travels.Rulesd6873a39ab144ce38651c810eeb54a7b.*;
import static org.acme.travels.Rulesd6873a39ab144ce38651c810eeb54a7b.*;

public class Rulesd6873a39ab144ce38651c810eeb54a7b_rule_Polish_32citizens_32require_32visa_32to_32US {

    /**
     * Rule name: Polish citizens require visa to US
     */
    public static org.drools.model.Rule rule_Polish_32citizens_32require_32visa_32to_32US() {
        final org.drools.model.Variable<org.acme.travels.Trip> var_$trip = D.declarationOf(org.acme.travels.Trip.class,
                                                                                           DomainClassesMetadatad6873a39ab144ce38651c810eeb54a7b.org_acme_travels_Trip_Metadata_INSTANCE,
                                                                                           "$trip");
        final org.drools.model.Variable<org.acme.travels.Traveller> var_$traveller = D.declarationOf(org.acme.travels.Traveller.class,
                                                                                                     DomainClassesMetadatad6873a39ab144ce38651c810eeb54a7b.org_acme_travels_Traveller_Metadata_INSTANCE,
                                                                                                     "$traveller");
        org.drools.model.Rule rule = D.rule("org.acme.travels",
                                            "Polish citizens require visa to US")
                                      .attribute(org.drools.model.Rule.Attribute.RULEFLOW_GROUP,
                                                 "visas")
                                      .build(D.pattern(var_$trip).expr("GENERATED_A7B76908B81A3DA78E57328A257F3950",
                                                                       org.acme.travels.P37.LambdaPredicate37080BCD0F9C3ED3366617805A831382.INSTANCE,
                                                                       D.alphaIndexedBy(java.lang.String.class,
                                                                                        org.drools.model.Index.ConstraintType.EQUAL,
                                                                                        -1,
                                                                                        org.acme.travels.P22.LambdaExtractor2284DD6F592D3F43EA1A5B1FE32A26FB.INSTANCE,
                                                                                        "US"),
                                                                       D.reactOn("country")),
                                             D.pattern(var_$traveller).expr("GENERATED_35B94D5F500233D6B8577C6DCDD7CCB1",
                                                                            org.acme.travels.P05.LambdaPredicate0599F4979C155AB0177885C1A53E55C3.INSTANCE,
                                                                            D.alphaIndexedBy(java.lang.String.class,
                                                                                             org.drools.model.Index.ConstraintType.EQUAL,
                                                                                             -1,
                                                                                             org.acme.travels.P72.LambdaExtractor72A9A4ED8C34199AB237F61E49FFE2CE.INSTANCE,
                                                                                             "Polish"),
                                                                            D.reactOn("nationality")),
                                             D.on(var_$trip).execute(org.acme.travels.P28.LambdaConsequence28AEA0EF6DE4B93067D57F7B16285523.INSTANCE));
        return rule;
    }
}
