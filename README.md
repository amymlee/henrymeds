# henrymeds
Henry Meds Reservation API

This Spring Boot project implements the APIs for a simple reservation system where the APIs can be used by providers and clients. 

Provider APIs 
```
POST /provider/new
POST /provider/availabilities
```

Client APIs
```
POST /client/new
GET /client/availabilities
POST /client/reserve
PUT /client/confirm
```

For `POST /provider/new`, the provider provides a JSON request body in the following form:
```
{
  "first_name": "John",
  "last_name": "Doe"
}
```
which then returns a providerId, which is needed in the request body for posting availabilities:
```
{
  "provider_id": 1
}
```

For `POST /provider/availabilities`, the provider must provide a valid providerId and the specified time ranges in ISO format in the request body:
```
{
    "provider_id": 1, 
    "time_ranges": [
        {"start_time": "2023-12-11T01:30:00", "end_time": "2023-12-12T02:30:00"}
    ]
}
```

Clients can view availabilities without needing a clientId using `GET /client/availabilities`, but will need to register and obtain a clientId using `POST /client/new` in order to reserve an appointment with a provider. An example response body for `GET /client/availabilities` looks like this: 
```
[
    {
        "slot_id": 1,
        "provider_name": "John Doe",
        "start_time": "2023-12-11T01:30:00",
        "end_time": "2023-12-11T01:45:00"
    },
    {
        "slot_id": 2,
        "provider_name": "John Doe",
        "start_time": "2023-12-11T01:45:00",
        "end_time": "2023-12-11T02:00:00"
    }
]
```

For `POST /client/reserve`, the client must pass in a valid clientId and slotId in the request body: 
```
{
    "client_id": 1, 
    "slot_id": 1
}
```
A reservationId will be returned in the response body: 
```
{
    "reservation_id": 1
}
```

To confirm a reservation using `PUT /client/confirm`, the client must pass in a valid clientId and reservationId in the request body. The client can only confirm if it has already reserved the slot beforehand, otherwise a 403 will be returned: 
```
{
    "client_id": 1, "reservation_id": 1
}
```

Reservations must be made 24 hours in advance. Also reservations and slots will be released if client has not confirmed their reservation after 30 minutes have passed. ReservationService details the methods and implementations in which reservations are scheduled, confirmed and released. 



