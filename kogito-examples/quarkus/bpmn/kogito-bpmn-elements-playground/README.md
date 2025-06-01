``mvn "-Pbamoe-community" "-Pbamoe-persistence-postgresql" "-Pembedded-postgresql" "-Pbamoe-audit" "-Pdevelopment" clean quarkus:dev``

```
curl --location 'http://localhost:8080/MultiinstanceElementsProcess' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data-raw '{
    "personListWrapper": {
        "personsList": [
            {
                "name": "Jaime",
                "lastName": "García",
                "email": "fake@fake.com"
            },
            {
                "name": "Carlos",
                "lastName": "Suárez",
                "email": "fake@fake.com"
            },
            {
                "name": "Diego",
                "lastName": "Rodríguez",
                "email": "fake@fake.com"
            }
        ]
    },
    "personArrayList": [
        {
            "name": "Jaime",
            "lastName": "García",
            "email": "fake@fake.com"
        },
        {
            "name": "Carlos",
            "lastName": "Suárez",
            "email": "fake@fake.com"
        },
        {
            "name": "Diego",
            "lastName": "Rodríguez",
            "email": "fake@fake.com"
        }
    ],
    "person": {
        "name": "Ricardo",
        "lastName": "Perez",
        "email": "fake@fake.com"
    }
}'
```