package org.acme.travels;
public class DomainClassesMetadatad6873a39ab144ce38651c810eeb54a7b {

    public static final org.drools.model.DomainClassMetadata org_acme_travels_Trip_Metadata_INSTANCE = new org_acme_travels_Trip_Metadata();
    private static class org_acme_travels_Trip_Metadata implements org.drools.model.DomainClassMetadata {

        @Override
        public Class<?> getDomainClass() {
            return org.acme.travels.Trip.class;
        }

        @Override
        public int getPropertiesSize() {
            return 6;
        }

        @Override
        public int getPropertyIndex( String name ) {
            switch(name) {
                case "this": return 0;
                case "begin": return 1;
                case "city": return 2;
                case "country": return 3;
                case "end": return 4;
                case "visaRequired": return 5;
             }
             throw new RuntimeException("Unknown property '" + name + "' for class class class org.acme.travels.Trip");
        }
    }
    public static final org.drools.model.DomainClassMetadata org_acme_travels_Traveller_Metadata_INSTANCE = new org_acme_travels_Traveller_Metadata();
    private static class org_acme_travels_Traveller_Metadata implements org.drools.model.DomainClassMetadata {

        @Override
        public Class<?> getDomainClass() {
            return org.acme.travels.Traveller.class;
        }

        @Override
        public int getPropertiesSize() {
            return 7;
        }

        @Override
        public int getPropertyIndex( String name ) {
            switch(name) {
                case "this": return 0;
                case "address": return 1;
                case "email": return 2;
                case "firstName": return 3;
                case "lastName": return 4;
                case "nationality": return 5;
                case "passportNumber": return 6;
             }
             throw new RuntimeException("Unknown property '" + name + "' for class class class org.acme.travels.Traveller");
        }
    }
}