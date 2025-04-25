package org.acme.travels;

import org.drools.modelcompiler.dsl.pattern.D;
import org.drools.model.Index.ConstraintType;

public class Rulesd6873a39ab144ce38651c810eeb54a7b implements org.drools.model.Model {

    public final static java.time.format.DateTimeFormatter DATE_TIME_FORMATTER = new java.time.format.DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern(org.drools.util.DateUtils.getDateFormatMask()).toFormatter(java.util.Locale.ENGLISH);

    @Override
    public String getName() {
        return "org.acme.travels";
    }

    @Override
    public java.util.List<org.drools.model.Global> getGlobals() {
        return globals;
    }

    @Override
    public java.util.List<org.drools.model.TypeMetaData> getTypeMetaDatas() {
        return typeMetaDatas;
    }

    protected java.util.List<org.drools.model.Global> globals = java.util.Collections.emptyList();

    java.util.List<org.drools.model.TypeMetaData> typeMetaDatas = java.util.Collections.emptyList();

    @Override
    public java.util.List<org.drools.model.Rule> getRules() {
        return rules;
    }

    public java.util.List<org.drools.model.Rule> getRulesList() {
        return java.util.Arrays.asList(Rulesd6873a39ab144ce38651c810eeb54a7b_rule_Polish_32citizens_32require_32visa_32to_32US.rule_Polish_32citizens_32require_32visa_32to_32US(),
                                       Rulesd6873a39ab144ce38651c810eeb54a7b_rule_Polish_32citizens_32do_32not_32require_32visa_32to_32UK.rule_Polish_32citizens_32do_32not_32require_32visa_32to_32UK(),
                                       Rulesd6873a39ab144ce38651c810eeb54a7b_rule_Polish_32citizens_32require_32visa_32to_32Australia.rule_Polish_32citizens_32require_32visa_32to_32Australia(),
                                       Rulesd6873a39ab144ce38651c810eeb54a7b_rule_Brazilian_32citizens_32require_32visa_32to_32Australia.rule_Brazilian_32citizens_32require_32visa_32to_32Australia());
    }

    java.util.List<org.drools.model.Rule> rules = getRulesList();

    @Override
    public java.util.List<org.drools.model.Query> getQueries() {
        return java.util.Collections.emptyList();
    }

    @Override
    public java.util.List<org.drools.model.EntryPoint> getEntryPoints() {
        return java.util.Collections.emptyList();
    }
}
