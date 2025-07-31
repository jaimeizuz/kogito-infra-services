package org.kie.kogito.hr.servicetasks;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import java.util.List;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.kie.api.runtime.process.ProcessWorkItemHandlerException;
import org.kie.kogito.PersonDTO;
import org.kie.kogito.PersonsDTO;
import org.kie.kogito.internal.process.workitem.WorkItemHandlerRuntimeException;
import org.kie.kogito.rest.client.DummyRestClient;

@ApplicationScoped
public class DummyServiceTask {

    @Inject
    @RestClient
    DummyRestClient dummyRestClient;

    Logger logger = Logger.getLogger(DummyServiceTask.class);

    public String callDummy() {
        Response response = null;
        
        try {
            response = dummyRestClient.getDummy();

            logger.info("DUMMY RESPONSE: " + response.readEntity(String.class));
        }
        catch(Exception ex) {
            throw new WorkItemHandlerRuntimeException(ex);
        }   
        
        return "success";
    }

    public String callDummy(PersonDTO person) {
        Response response = null;

        logger.info("TEMPORAL PERSON DATA: " + person.toString());

        try {
            response = dummyRestClient.getDummy();

            logger.info("DUMMY RESPONSE: " + response.readEntity(String.class));
        }
        catch(Exception ex) {
            throw new WorkItemHandlerRuntimeException(ex);
        }   
        
        return "success";
    }

    public String callDummy(PersonsDTO personsList, PersonDTO person) {
        Response response = null;

        logger.info("TEMPORAL PERSON DATA: " + person.toString());

        try {
            response = dummyRestClient.getDummy();

            logger.info("DUMMY RESPONSE: " + response.readEntity(String.class));
        }
        catch(Exception ex) {
            throw new WorkItemHandlerRuntimeException(ex);
        }   
        
        return "success";
    }
}
