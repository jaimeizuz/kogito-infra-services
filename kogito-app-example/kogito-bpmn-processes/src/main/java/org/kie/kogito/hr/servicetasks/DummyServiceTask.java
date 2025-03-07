package org.kie.kogito.hr.servicetasks;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.kie.api.runtime.process.ProcessWorkItemHandlerException;
import org.kie.kogito.hr.rest.client.DummyRestClient;
import org.kie.kogito.internal.process.workitem.WorkItemExecutionException;
import org.kie.kogito.internal.process.workitem.WorkItemHandlerRuntimeException;

@ApplicationScoped
public class DummyServiceTask {

    @Inject
    @RestClient
    DummyRestClient dummyRestClient;

    Logger logger = Logger.getLogger(DummyServiceTask.class);

    public void callDummy() {
        Response response = null;

        try {
            response = dummyRestClient.getDummy();
        }
        catch(Exception ex) {
            throw new WorkItemHandlerRuntimeException(ex);
        }           
    }
}
