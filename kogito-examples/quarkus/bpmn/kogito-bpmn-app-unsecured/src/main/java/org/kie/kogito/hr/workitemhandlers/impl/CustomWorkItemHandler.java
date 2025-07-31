package org.kie.kogito.hr.workitemhandlers.impl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.kie.api.runtime.process.ProcessWorkItemHandlerException;
import org.kie.api.runtime.process.ProcessWorkItemHandlerException.HandlingStrategy;
import org.kie.kogito.hr.rest.client.DummyRestClient;
import org.kie.kogito.internal.process.workitem.KogitoWorkItem;
import org.kie.kogito.internal.process.workitem.KogitoWorkItemHandler;
import org.kie.kogito.internal.process.workitem.KogitoWorkItemManager;
import org.kie.kogito.internal.process.workitem.Policy;
import org.kie.kogito.internal.process.workitem.WorkItemExecutionException;
import org.kie.kogito.internal.process.workitem.WorkItemHandlerRuntimeException;
import org.kie.kogito.internal.process.workitem.WorkItemTransition;
import org.kie.kogito.process.workitems.impl.DefaultKogitoWorkItemHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
public class CustomWorkItemHandler extends DefaultKogitoWorkItemHandler {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomWorkItemHandler.class);

    private int errorsCount = 0;
    
    //@Inject
    //@RestClient
    DummyRestClient dummyRestClient;

    public CustomWorkItemHandler(){}

    public CustomWorkItemHandler(DummyRestClient dummyRestClient) {
        this.dummyRestClient = dummyRestClient;
    }

    @Override
    public Optional<WorkItemTransition> activateWorkItemHandler(KogitoWorkItemManager manager, KogitoWorkItemHandler handler, KogitoWorkItem workitem, WorkItemTransition transition) {

        String errorStrategy = (String) workitem.getParameter("errorStrategy");
        Boolean throwException = (Boolean) workitem.getParameter("throwException");

        LOGGER.info("CALLING CustomWorkItemHandler WITH ERRORSTRATEGY " + errorStrategy);


        /*
        Response response = null;

        try {
            dummyRestClient.getDummy();
        }
        catch(Exception ex) {
            handleError(errorStrategy, ex);
        }
        */

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create("http://localhost:19002/dummy"))
          .header("Accept", "application/json")
          .GET()
          .build();

        try {
            //ObjectMapper objectMapper = new ObjectMapper();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() < 200 || response.statusCode() > 299) {
                if(errorStrategy.equals("RETRY")
                    || errorStrategy.equals("COMPLETE")
                    || errorStrategy.equals("RETHROW")
                    || errorStrategy.equals("ABORT")) {

                    LOGGER.info("HANDLING WIH ERROR");
                    
                    //handleError(workitem.getProcessInstance().getProcessId(), errorStrategy, new WorkItemExecutionException(errorStrategy), -1);
                    //throw new WorkItemExecutionException("unknownerror");
                    handleError(null, errorStrategy, new WorkItemExecutionException(errorStrategy), 0);

                //} else if (errorStrategy.equals("ABORT")) {
                    
                //    LOGGER.info("ABORTING WIH");

                //    return Optional.of(handler.abortTransition(workitem.getPhaseStatus()));
                } else {
                    // Don’t forget to finish the work item otherwise the process
                    // will be active infinitely and never will pass the flow
                    // to the next node.
                    LOGGER.info("OTHER STRATEGY");

                    return Optional.of(handler.completeTransition(workitem.getPhaseStatus(), new HashMap<>()));
                }
            }
        }
        catch (IOException | InterruptedException e) {
            throw new RuntimeException("Failed to fetch posts", e);
        }
        
        /*
        if(throwException) {
            errorsCount = new Random().nextInt(3);
            if(errorsCount < 2) {
                if(errorStrategy.equals("RETRY")
                    || errorStrategy.equals("COMPLETE")
                    || errorStrategy.equals("RETHROW")) {

                    LOGGER.info("HANDLING WIH ERROR");
                    
                    handleError(errorStrategy, new WorkItemExecutionException(errorStrategy));

                } else if (errorStrategy.equals("ABORT")) {
                    
                    LOGGER.info("ABORTING WIH");

                    return Optional.of(handler.abortTransition(workitem.getPhaseStatus()));
                } else {
                    // Don’t forget to finish the work item otherwise the process
                    // will be active infinitely and never will pass the flow
                    // to the next node.
                    LOGGER.info("OTHER STRATEGY");

                    return Optional.of(handler.completeTransition(workitem.getPhaseStatus(), new HashMap<>()));
                }
            }
        }
        */

        LOGGER.info("WIH SUCCESSFULLY EXECUTED");
        return Optional.of(handler.completeTransition(workitem.getPhaseStatus(), new HashMap<>()));
    }

    @Override
    public Optional<WorkItemTransition> abortWorkItemHandler(KogitoWorkItemManager manager, KogitoWorkItemHandler handler, KogitoWorkItem workitem, WorkItemTransition transition) {
        LOGGER.debug("ABORT!");
        return Optional.empty();
    }

    private void handleError(String processId, String strategy, Throwable ex, int retries) {
        
        throw new ProcessWorkItemHandlerException(processId,
                ProcessWorkItemHandlerException.HandlingStrategy.valueOf(strategy),
                ex,
                retries);
        
        //throw new WorkItemHandlerRuntimeException(ex);
    }
}