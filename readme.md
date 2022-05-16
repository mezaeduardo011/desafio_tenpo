# API Tenpo

## POST
`Sign Up` [localhost:8080/api/users]()

## POST
`Login` [localhost:8080/api/auth/login]()

## POST
`Sum` [localhost:8080/api/suma]()

## POST
`History POST` [localhost:8080/api/history]()

## GET
`History GET` [localhost:8080/api/history/{page}/{size}]()

## POST
`Logout` [localhost:8080/api/auth/logout]()
___

## POST localhost:8080/api/users
`Sign Up`



**Parameters**

|          Name | Required |  Type|                                                                                                                                                            |
| -------------:|:--------:|:-------:|-
|     `email` | required | string|                                                          |
|     `password` | required | string|                                                              |

-
**Response**

```
{
    "id": 1,
    "email": "user@test.com",
    "password": "$argon2id$v=19$m=1024,t=1,p=1$1rxPSU0ij2MU5K1u/tmJUQ$0d42ClOBrpOPNozz5kp7fou+jsqQ7VI2/buDi4lyoqg"
}

```
___

## POST localhost:8080/api/auth/login
`Login`


**Parameters**

|          Name | Required |  Type   ||
| -------------:|:--------:|:-------:| --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     `email` | required | string  | |
|     `password` | required | string ||

-
**Response**

```

eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwiaWF0IjoxNjUyNjY0MzEyLCJzdWIiOiJ1c2VyQHRlc3QuY29tIiwiaXNzIjoiTWFpbiIsImV4cCI6MTY1MzI2OTExMn0.wZU_r1VQPbLI0tpUKTtC9egbNCc-P8RIS-Rx1NOr1CY

```
___
## POST localhost:8080/api/suma
`Sum`



**Parameters**

|          Name | Required |  Type   |                                                                                                                                                          |
| -------------:|:--------:|:-------:| --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     `num1` | required | integer  | |
|     `num2` | required | integer  | |

-
**Response**

```
20

```
___
## POST localhost:8080/api/history
`History POST`


**Parameters**

|          Name | Required |  Type   |     -                                                                                                                                                |
| -------------:|:--------:|:-------:| --------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|     `user_email` | required | string| -
|     `user_id` | required | integer| -
|     `fecha_creacion` | required | string| -
|     `endpoint` | required | string| -
|     `data` | required | string| -

-
**Response**

```

{
    "id": 2,
    "user_email": "user@test.com",
    "user_id": 1,
    "fecha_creacion": "15/05/2022",
    "endpoint": "localhost:8080/api/suma",
    "data": "10 + 10"
}

```
___

## POST localhost:8080/api/history/{page}/{size}
`History GET`


**Response**

```

[
    {
        "id": 1,
        "user_email": "",
        "user_id": 0,
        "fecha_creacion": "",
        "endpoint": "",
        "data": ""
    },
    {
        "id": 2,
        "user_email": "user@test.com",
        "user_id": 1,
        "fecha_creacion": "15/05/2022",
        "endpoint": "localhost:8080/api/suma",
        "data": "10 + 10"
    }
]

```
___
## POST localhost:8080/api/auth/logout
`Logout`



-

**Response**

```

{
    True
}

```
___


