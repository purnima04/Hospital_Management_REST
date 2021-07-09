### API Specs
* Hospital Management

### Build/Run

```
mvn clean package or mvn clean install -DskipTests
```

```
docker-compose up --build
```

### Hospital Management URLs
- relevant URLs - <https://github.com/purnima04/Hospital_Management_REST/tree/trunk>

### Hospital Management calls:

- hospital-controller operations

### GET - to get hospital details
- <localhost:8089/hospital-management/api/hospital/details>

Response

- initially without any data stored in database :

```
{
    "timestamp": "2021-07-09T11:16:29.981",
    "message": "No hospital found",
    "Notes": "Try again"
}

```

- with data stored in database :
```
[
    {
        "hospital_Id": 2,
        "hospital_name": "GMC",
        "hospital_address": "ABC akola address",
        "hospital_emergencyNo": 911,
        "hospital_mailId": "gmcHospital@gmc.com",
        "healthCareBranchEntity": {
            "branch_Id": 12,
            "branch_name": "Neuroscience",
            "branch_floorNo": 6
        },
        "hospitalResourcesEntity": {
            "resource_Id": 12,
            "bedsAvailable": 100,
            "bedsInUse": 200
        },
        "doctorEntity": [
            {
                "doctor_Id": 19,
                "doctor_name": "Dr. Ritwik",
                "doctor_designation": "HOD",
                "doctor_degree": "MBBS",
                "doctor_address": "def doctor Address",
                "doctor_emailId": "ritwik@nmc.com",
                "doctor_contactNo": "78xxxxxxxx",
                "patientEntity": [
                    {
                        "patient_Id": 29,
                        "patient_name": "Nikita",
                        "patient_In": "2021-07-09T11:53:37.408+00:00",
                        "patient_DOB": "05-12-1997",
                        "patient_contactNumber": "90xxxxxxxx",
                        "patient_emailId": "ayesha@gmail.com",
                        "patient_gender": "Female",
                        "patient_address": "ytuj jhgshgf hh",
                        "billingEntity": {
                            "bill_Id": 26,
                            "medicine": "Paracetamol",
                            "quantity": 3,
                            "unitValue": 52.4
                        }
                    }
                ]
            }
        ]
    }
]

```
### POST - to add hospital details

- <localhost:8089/hospital-management/api/hospital/details>

Request
- Body
```
{
  "hospital_Id":2,
  "hospital_name": "GMC",
  "hospital_address": "ABC akola address",
  "hospital_emergencyNo": 911,
  "hospital_mailId": "gmcHospital@gmc.com",
  "hospitalResourcesEntity": {
    "resource_Id":12,
    "bedsAvailable": 100,
    "bedsInUse": 200
  },
  "healthCareBranchEntity": {
    "branch_Id":12,
    "branch_name": "Neuroscience",
    "branch_floorNo": 6
  },
  "doctorEntity": [
    {
      "doctor_Id":19,
      "doctor_name": "Dr. Ritwik",
      "doctor_designation": "HOD",
      "doctor_degree": "MBBS",
      "doctor_address": "def doctor Address",
      "doctor_emailId": "ritwik@nmc.com",
      "doctor_contactNo":"78xxxxxxxx",
      "patientEntity":[
          {
          "patient_Id":29,
          "patient_name": "Nikita",
          "patient_contactNumber": "90xxxxxxxx",
          "patient_addres": "abc patient address",
          "patient_gender": "Female",
          "patient_emailId": "ayesha@gmail.com",
          "patient_address":"ytuj jhgshgf hh",
          "patient_DOB": "05-12-1997",
          "patient_In": "",
          "billingEntity": {
            "bill_Id":26,
            "medicine": "Paracetamol",
            "quantity": 3,
            "unitValue": 52.4
          }
      }
      ]
    }
  ]
}

```

Response 
```
{
    "hospital_Id": 2,
    "hospital_name": "GMC",
    "hospital_address": "ABC akola address",
    "hospital_emergencyNo": 911,
    "hospital_mailId": "gmcHospital@gmc.com",
    "healthCareBranchEntity": {
        "branch_Id": 12,
        "branch_name": "Neuroscience",
        "branch_floorNo": 6
    },
    "hospitalResourcesEntity": {
        "resource_Id": 12,
        "bedsAvailable": 100,
        "bedsInUse": 200
    },
    "doctorEntity": [
        {
            "doctor_Id": 19,
            "doctor_name": "Dr. Ritwik",
            "doctor_designation": "HOD",
            "doctor_degree": "MBBS",
            "doctor_address": "def doctor Address",
            "doctor_emailId": "ritwik@nmc.com",
            "doctor_contactNo": "78xxxxxxxx",
            "patientEntity": [
                {
                    "patient_Id": 29,
                    "patient_name": "Nikita",
                    "patient_In": null,
                    "patient_DOB": "05-12-1997",
                    "patient_contactNumber": "90xxxxxxxx",
                    "patient_emailId": "ayesha@gmail.com",
                    "patient_gender": "Female",
                    "patient_address": "ytuj jhgshgf hh",
                    "billingEntity": {
                        "bill_Id": 26,
                        "medicine": "Paracetamol",
                        "quantity": 3,
                        "unitValue": 52.4
                    }
                }
            ]
        }
    ]
}
```
### PUT - to update hospital details

- <localhost:8089/hospital-management/api/hospital/details/hospital_Id>

Request
- Body
```
{
  "hospital_Id":2,
  "hospital_name": "GMCP",
  "hospital_address": "ABC akola address",
  "hospital_emergencyNo": 911,
  "hospital_mailId": "gmcHospital@gmc.com",
  "hospitalResourcesEntity": {
    "resource_Id":12,
    "bedsAvailable": 100,
    "bedsInUse": 200
  },
  "healthCareBranchEntity": {
    "branch_Id":12,
    "branch_name": "Neuroscience",
    "branch_floorNo": 6
  },
  "doctorEntity": [
    {
      "doctor_Id":19,
      "doctor_name": "Dr. Ritwik",
      "doctor_designation": "HOD",
      "doctor_degree": "MBBS",
      "doctor_address": "def doctor Address",
      "doctor_emailId": "ritwik@nmc.com",
      "doctor_contactNo":"78xxxxxxxx",
      "patientEntity":[
          {
          "patient_Id":29,
          "patient_name": "Nikita",
          "patient_contactNumber": "90xxxxxxxx",
          "patient_addres": "abc patient address",
          "patient_gender": "Female",
          "patient_emailId": "ayesha@gmail.com",
          "patient_address":"ytuj jhgshgf hh",
          "patient_DOB": "05-12-1997",
          "patient_In": "",
          "billingEntity": {
            "bill_Id":26,
            "medicine": "Paracetamol",
            "quantity": 3,
            "unitValue": 52.4
          }
      }
      ]
    }
  ]
}

```

Response
```
{
    "hospital_Id": 2,
    "hospital_name": "GMCP",
    "hospital_address": "ABC akola address",
    "hospital_emergencyNo": 911,
    "hospital_mailId": "gmcHospital@gmc.com",
    "healthCareBranchEntity": {
        "branch_Id": 12,
        "branch_name": "Neuroscience",
        "branch_floorNo": 6
    },
    "hospitalResourcesEntity": {
        "resource_Id": 12,
        "bedsAvailable": 100,
        "bedsInUse": 200
    },
    "doctorEntity": [
        {
            "doctor_Id": 19,
            "doctor_name": "Dr. Ritwik",
            "doctor_designation": "HOD",
            "doctor_degree": "MBBS",
            "doctor_address": "def doctor Address",
            "doctor_emailId": "ritwik@nmc.com",
            "doctor_contactNo": "78xxxxxxxx",
            "patientEntity": [
                {
                    "patient_Id": 29,
                    "patient_name": "Nikita",
                    "patient_In": null,
                    "patient_DOB": "05-12-1997",
                    "patient_contactNumber": "90xxxxxxxx",
                    "patient_emailId": "ayesha@gmail.com",
                    "patient_gender": "Female",
                    "patient_address": "ytuj jhgshgf hh",
                    "billingEntity": {
                        "bill_Id": 26,
                        "medicine": "Paracetamol",
                        "quantity": 3,
                        "unitValue": 52.4
                    }
                }
            ]
        }
    ]
}
```
### DELETE - to delete hospital details

- <localhost:8089/hospital-management/api/hospital/details?hospital_Id=3>

Request
- Body
- Path params - hospital_Id

Response
```
Deleted hospital information successfully
```

### GET - to access hospital details by hospital_Id

- <localhost:8089/hospital-management/api/hospital/details/hospital_Id>

Response
- if no hospital found correspond to queried hospital_Id
```
{
    "timestamp": "2021-07-09T12:36:10.78",
    "message": "Hospital not found",
    "Notes": "Try again"
}
```
- if hospital found correspond to queried hospital_Id
```
{
    "hospital_Id": 2,
    "hospital_name": "GMC",
    "hospital_address": "ABC akola address",
    "hospital_emergencyNo": 911,
    "hospital_mailId": "gmcHospital@gmc.com",
    "healthCareBranchEntity": {
        "branch_Id": 12,
        "branch_name": "Neuroscience",
        "branch_floorNo": 6
    },
    "hospitalResourcesEntity": {
        "resource_Id": 12,
        "bedsAvailable": 100,
        "bedsInUse": 200
    },
    "doctorEntity": [
        {
            "doctor_Id": 19,
            "doctor_name": "Dr. Ritwik",
            "doctor_designation": "HOD",
            "doctor_degree": "MBBS",
            "doctor_address": "def doctor Address",
            "doctor_emailId": "ritwik@nmc.com",
            "doctor_contactNo": "78xxxxxxxx",
            "patientEntity": [
                {
                    "patient_Id": 29,
                    "patient_name": "Nikita",
                    "patient_In": "2021-07-09T12:38:49.146+00:00",
                    "patient_DOB": "05-12-1997",
                    "patient_contactNumber": "90xxxxxxxx",
                    "patient_emailId": "ayesha@gmail.com",
                    "patient_gender": "Female",
                    "patient_address": "ytuj jhgshgf hh",
                    "billingEntity": {
                        "bill_Id": 26,
                        "medicine": "Paracetamol",
                        "quantity": 3,
                        "unitValue": 52.4
                    }
                }
            ]
        }
    ]
}
```
### DOST - to add one more hospital

- <localhost:8089/hospital-management/api/hospital/details>

Request
- Body
```
{
  "hospital_Id":3,
  "hospital_name": "NMC",
  "hospital_address": "NMC address",
  "hospital_emergencyNo": 912,
  "hospital_mailId": "NMCHospital@nmc.com",
  "hospitalResourcesEntity": {
    "resource_Id":13,
    "bedsAvailable": 200,
    "bedsInUse": 400
  },
  "healthCareBranchEntity": {
    "branch_Id":13,
    "branch_name": "Neuroscience",
    "branch_floorNo": 7
  },
  "doctorEntity": [
    {
      "doctor_Id":20,
      "doctor_name": "Dr. Revu",
      "doctor_designation": "HOD",
      "doctor_degree": "MBBS MS",
      "doctor_address": "def doctor Address",
      "doctor_emailId": "rEVU@nmc.com",
      "doctor_contactNo":"78xxxxxxxx",
      "patientEntity":[
          {
          "patient_Id":28,
          "patient_name": "Nik",
          "patient_contactNumber": "99Xxxxxxxx",
          "patient_addres": "DEF patient address",
          "patient_gender": "Male",
          "patient_emailId": "nik@gmail.com",
          "patient_address":"ytuj jhgshgf hh",
          "patient_DOB": "30-12-1999",
          "patient_In": "",
          "billingEntity": {
            "bill_Id":27,
            "medicine": "Aspirin",
            "quantity": 3,
            "unitValue": 50.4
          }
      }
      ]
    }
  ]
}
```

Response
```
{
    "hospital_Id": 3,
    "hospital_name": "NMC",
    "hospital_address": "NMC address",
    "hospital_emergencyNo": 912,
    "hospital_mailId": "NMCHospital@nmc.com",
    "healthCareBranchEntity": {
        "branch_Id": 13,
        "branch_name": "Neuroscience",
        "branch_floorNo": 7
    },
    "hospitalResourcesEntity": {
        "resource_Id": 13,
        "bedsAvailable": 200,
        "bedsInUse": 400
    },
    "doctorEntity": [
        {
            "doctor_Id": 20,
            "doctor_name": "Dr. Revu",
            "doctor_designation": "HOD",
            "doctor_degree": "MBBS MS",
            "doctor_address": "def doctor Address",
            "doctor_emailId": "rEVU@nmc.com",
            "doctor_contactNo": "78xxxxxxxx",
            "patientEntity": [
                {
                    "patient_Id": 28,
                    "patient_name": "Nik",
                    "patient_In": null,
                    "patient_DOB": "30-12-1999",
                    "patient_contactNumber": "99Xxxxxxxx",
                    "patient_emailId": "nik@gmail.com",
                    "patient_gender": "Male",
                    "patient_address": "ytuj jhgshgf hh",
                    "billingEntity": {
                        "bill_Id": 27,
                        "medicine": "Aspirin",
                        "quantity": 3,
                        "unitValue": 50.4
                    }
                }
            ]
        }
    ]
}
```


### Technology Stack
* Java 8, Spring Boot, Hibernate
* PostgreSQL
* Docker
* Swagger
* Git
