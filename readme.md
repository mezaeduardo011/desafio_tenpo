# API Tenpo


## Run the app (Default Port 8888)

---
Start up your application by running docker-compose at the root of the project:


    $ docker-compose up 


Tenpo.postman_collection.json file to run the collection. 

---

## POST
`Sign Up` localhost:8888/api/users

## POST
`Login` localhost:8888/api/auth/login

## POST
`Sum` localhost:8888/api/suma

 
## GET
`History` localhost:8888/api/history/{page}/{size}

## POST
`Logout` localhost:8888/api/auth/logout

---
## POST localhost:8888/api/users
`Sign Up`



**Parameters**

| Name       | Required | Type    |
|:-----------|:--------:|:--------|
| `email`    | required | String  |
| `password` | required | String |

**Response**

```
{
    "result": "Create successfully"
}

```
___

## POST localhost:8888/api/auth/login
`Login`


**Parameters**

| Name   | Required | Type    |
|:-------|:--------:|:--------|
| `email` | required | String |
| `password` | required | String |

**Response**

```
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIyIiwiaWF0IjoxNjUyNzI1OTU4LCJzdWIiOiJ1c2VyQHRlc3QuY29tIiwiaXNzIjoiTWFpbiIsImV4cCI6MTY1MzMzMDc1OH0.VOBrdfOjaakYewccWAH4TpSF_VsbALQFCt6is_zGNjo"
}
```
___
## POST  localhost:8888/api/suma
`Sum`

` Header required : Type Authorization Bearer Token`

        Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ




**Parameters**

|   Name | Required | Type    |
|-------:|:--------:|:--------|
| `num1` | required | Integer |
| `num2` | required | Integer |

**Response**

```
{
    "result": 22
}
```
___


## POST  localhost:8888/api/history/{page}/{size}
`History`


**Response**

```

[
    {
        "id": 1,
        "userEmail": "user1@test.com",
        "userId": 1,
        "dateAt": "16-05-2022 09:05:24",
        "endpoint": "ServletWebRequest: uri=/api/auth/login;client=172.19.0.1"
    },
    {
        "id": 2,
        "userEmail": "user1@test.com",
        "userId": 1,
        "dateAt": "16-05-2022 09:05:30",
        "endpoint": "ServletWebRequest: uri=/api/suma;client=172.19.0.1"
    },
    {
        "id": 3,
        "userEmail": "user1@test.com",
        "userId": 1,
        "dateAt": "16-05-2022 09:05:33",
        "endpoint": "ServletWebRequest: uri=/api/auth/logout;client=172.19.0.1"
    }
]

```
___
## POST localhost:8888/api/auth/logout
`Logout`


` Header required : Type Authorization Bearer Token`

        Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ



**Response**

```
{
    "message": "Logout successfully"
}

```
___


