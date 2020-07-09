# shopping
This application uses spring cloud function and the application is deployed to AWS using SAM cli.
It uses H2 datababase 

During development the the url are 
Get:
http://localhost:8080/shopping/api/cartFindByCustomerIdFunction/1

POST (Header -"Content-Type":"application/json")
http://localhost:8080/shopping/api/cartAddUpdateFunction(Does not work with old postman in browser client, but works in New postman)
{"cartId":"78bb01e7-e641-4626-9d23-4e5208d6ccdc","customerId":1,"items":[{"id":"e3c8f757-6961-40ce-b57e-8236ceada3fe","sku":"SKU1","qty":12,"unitCost":10,"cartId":"78bb01e7-e641-4626-9d23-4e5208d6ccdc"}]}

using curl (this work in a linux window git bash, somehow curl fails to post message using this)
curl -X POST -H "Content-Type: application/json" -d '{"cartId":"78bb01e7-e641-4626-9d23-4e5208d6ccdc","customerId":1,"items":[{"id":"e3c8f757-6961-40ce-b57e-8236ceada3fe","sku":"SKU1","qty":12,"unitCost":10,"cartId":"78bb01e7-e641-4626-9d23-4e5208d6ccdc"}]}'  http://localhost:8080/shopping/api/cartAddUpdateFunction
