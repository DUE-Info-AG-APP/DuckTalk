[![Build Status](https://travis-ci.org/DUE-Info-AG-APP/DuckTalk.svg?branch=master)](https://travis-ci.org/DUE-Info-AG-APP/DuckTalk)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=DuckTalk&metric=alert_status)](https://sonarcloud.io/dashboard?id=DuckTalk)
# Description
#### A simple messaging service.

# API
## Models
### Message model:
```
id: [PK] integer
sender: text
recipient: text
timestamp: timestamp with timezone
data: text
```

### User model:
```
username: text
password: text
contacts: character varying[] (255)
```

## Possible Requests

#### Get list of all users on the server
```
GET /users
```
Returned Status Codes:
```
200 OK
500 Internal Server Error
```

#### Create new user
```
POST /users
{
    "username": "user_x",
    "password": "1234"
}
```
Returned Status Codes:
```
201 Created
400 Bad Request
409 Conflict: username already in use
500 Internal Server Error
```

#### Get data of specific user
```
GET /users/{username}
```
Required Headers:
```
Authorization: BASIC username:password in BASE64
```
Returned Status Codes:
```
200 OK
404 Not Found
401 Unauthorized: authentication header not provided correctly
403 Forbidden: wrong username or password
500 Internal Server Error
```

#### Add contact to user
```
POST /users/{username}/contacts
{
    "username": "nameofcontact"
}
```
Required Headers:
```
Authorization: BASIC username:password in BASE64
```
Returned Status Codes:
```
201 Created
404 Not Found: user specified in URL or user specified in payload not found
401 Unauthorized: authentication header not provided correctly
403 Forbidden: wrong username or password
409: Conflict: user specified in payload is already a contact of user specified in URL
500 Internal Server Error
```

#### Send message
```
POST /messages
{
    "sender": "user_x",
    "recipient": "user_y",
    "timestamp": "2019-05-07T16:01:45+02:00",
    "data": "bla bla bla"
}
```
Required Headers:
```
Authorization: BASIC username:password in BASE64
```
Returned Status Codes:
```
201 Created
400 Bad Request (-> timestamp probably provided in wrong format)
404 Not Found: sender or recipient not found
401 Unauthorized: authentication header not provided correctly
403 Forbidden: wrong username or password
500 Internal Server Error
```


#### Get messages
relating to specified sender and recipient
where authorization has to be provided with either the
senders or the recipients credentials
```
GET /messages?sender="senderusername"&recipient="recipientusername"
```
Required Headers:
```
Authorization: BASIC username:password in BASE64
```

# Library Documentation
https://square.github.io/retrofit/
