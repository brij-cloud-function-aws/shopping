# shopping
This application uses spring cloud function and the application is deployed to AWS using SAM cli.
It uses H2 datababase 

During development the the url are 
Get:
http://localhost:8080/shopping/api/cartFindByCustomerIdFunction/1

POST
http://localhost:8080/shopping/api/cartAddUpdateFunction
{"cartId":"78ebb527-e249-4a44-aed9-96254c5327fd", "customerId":"cust1"}
