# springassessment
# This spring assessment is componenet based and different components are controller, service, and repository and developed with Java 17.
# IDE used is Spring tool suite
# This spring assessment has 4 endpoints 1 POST and 3 GET.
# i. api/rewards (GET)- This endpoint returns list of monthly rewards and total rewards from database.
# ii. api/rewards/{customerId} (GET)- This endpoint returns the records of customerId passed during endpoint call from REWARD table.
# iii. api/calcRewards (POST) - This endpoint will calculate the rewards based on the transaction and insert transaction records in TRANSACTION and calculated rewards into REWARD table.
# iv. api/transactions (GET) - This endpoint will fetch records from the TRANSACTION table.
# To test the endpoint I have used POSTMAN.
# POST method payload curl:
# curl --location 'http://localhost:8080/api/    calcRewards' \--header 'Content-Type: application/json' \--data '{  "customerId": 101,  "transAmount": 150,  "date": "2025-01-28 16:30:00"}'
# All the endpoints are tested and validated using POSTMAN.
