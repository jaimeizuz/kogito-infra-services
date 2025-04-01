# Kogito and Infrastructure services

## Create and run Kogito App (for quarkus:dev execution)
1. In "kogito-app-example/kogito-bpmn-processes" folder, run `mvn "-Pbamoe-community" "-Pbamoe-persistence-postgresql" "-Pembedded-postgresql" "-Pdevelopment" clean quarkus:dev`
2. Access the jBPM Dev-UI in [http://localhost:8080/q/dev-ui/org.jbpm.jbpm-quarkus-devui/process-instances]() to check everything is up and running.

## Create and run Kogito App (for docker-compose)
1. In the root folder "kogito-infra-services", run `docker compose --profile full --profile kogito-bpmn-processes up -d`. This will start the full stack except  
   Kibana and Grafana. To include them, run `docker compose --profile full --profile kogito-bpmn-processes --profile dashboards up -d`.
2. In "kogito-app-example/kogito-bpmn-processes" folder, run `mvn "-Pbamoe-community" "-Pdevelopment" "-Pbamoe-persistence-postgresql" "-Pbamoe-kafka-events" "-Popentelemetry-traces-logs-metrics" "-Pcontainer" clean package` to create the Kogito app Docker image.

These are the main web applications exposed in the docker-compose:
- Kogito Management Console: [http://localhost:8280/]()
- Kafka events console (based on Redpanda UI): [http://localhost:9001/]()
- PostgreSQL database: [postgresql://postgres:5432/kogito]() (user: kogito-user, password: kogito-pass)
- Jaeger UI (traces): [http://localhost:16686/]()
- Kibana: [http://localhost:5601/]()
- Grafana: [http://localhost:3000]()

To start a process instance, just execute this HTTP request: \
```
    curl --location 'http://localhost:8080/hiring' \
        --header 'Accept: application/json' \
        --header 'Content-Type: application/json' \
        --data-raw '{
            "candidateData": {
                "name": "Jon",
                "lastName": "Snow",
                "email": "jon@snow.org",
                "experience": 5,
                "skills": ["Java", "Kogito", "Fencing"]
            },
            "expirationTime" : "PT120S",
            "throwException" : false
            }'
```