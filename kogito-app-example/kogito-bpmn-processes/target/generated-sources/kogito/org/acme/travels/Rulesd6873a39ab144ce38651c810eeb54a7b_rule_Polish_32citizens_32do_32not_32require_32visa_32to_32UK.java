package org.acme.travels;

import org.drools.modelcompiler.dsl.pattern.D;
import org.drools.model.Index.ConstraintType;
import static org.acme.travels.Rulesd6873a39ab144ce38651c810eeb54a7b.*;
import static org.acme.travels.Rulesd6873a39ab144ce38651c810eeb54a7b.*;

public class Rulesd6873a39ab144ce38651c810eeb54a7b_rule_Polish_32citizens_32do_32not_32require_32visa_32to_32UK {

    /**
     * Rule name: Polish citizens do not require visa to UK
     */
    public static org.drools.model.Rule rule_Polish_32citizens_32do_32not_32require_32visa_32to_32UK() {
        final org.drools.model.Variable<org.acme.travels.Trip> var_$trip = D.declarationOf(org.acme.travels.Trip.class,
                                                                                           DomainClassesMetadatad6873a39ab144ce38651c810eeb54a7b.org_acme_travels_Trip_Metadata_INSTANCE,
                                                                                           "$trip");
        final org.drools.model.Variable<org.acme.travels.Traveller> var_$traveller = D.declarationOf(org.acme.travels.Traveller.class,
                                                                                                     DomainClassesMetadatad6873a39ab144ce38651c810eeb54a7b.org_acme_travels_Traveller_Metadata_INSTANCE,
                                                                                                     "$traveller");
        org.drools.model.Rule rule = D.rule("org.acme.travels",
                                            "Polish citizens do not require visa to UK")
                                      .attribute(org.drools.model.Rule.Attribute.RULEFLOW_GROUP,
                                                 "visas")
                                      .build(D.pattern(var_$trip).expr("GENERATED_870FAA254DD7AE2732F6F23EA83A9634",
                                                                       org.acme.travels.P0A.LambdaPredicate0A8794C3C61C7469FA40A41E4839A400.INSTANCE,
                                                                       D.alphaIndexedBy(java.lang.String.class,
                                                                                        org.drools.model.Index.ConstraintType.EQUAL,
                                                                                        -1,
                                                                                        org.acme.travels.P22.LambdaExtractor2284DD6F592D3F43EA1A5B1FE32A26FB.INSTANCE,
                                                                                        "UK"),
                                                                       D.reactOn("country")),
                                             D.pattern(var_$traveller).expr("GENERATED_35B94D5F500233D6B8577C6DCDD7CCB1",
                                                                            org.acme.travels.P05.LambdaPredicate0599F4979C155AB0177885C1A53E55C3.INSTANCE,
                                                                            D.alphaIndexedBy(java.lang.String.class,
                                                                                             org.drools.model.Index.ConstraintType.EQUAL,
                                                                                             -1,
                                                                                             org.acme.travels.P72.LambdaExtractor72A9A4ED8C34199AB237F61E49FFE2CE.INSTANCE,
                                                                                             "Polish"),
                                                                            D.reactOn("nationality")),
                                             D.on(var_$trip).execute(org.acme.travels.P3E.LambdaConsequence3E06866B0CC8B0FB2B8BA18C6C533FAB.INSTANCE));
        return rule;
    }
}
