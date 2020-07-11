# shopping
This application uses spring cloud function and the application is deployed to AWS using SAM cli.
It uses H2 datababase 

During development the the url are 
## Get:
http://localhost:8080/shopping/api/cartFindByCustomerIdFunction/1


## http://localhost:8080/shopping/api/cartAddUpdateFunction
POST (Header -"Content-Type":"application/json")
(Does not work with old postman in browser client, but works in New postman)
{"cartId":"78bb01e7-e641-4626-9d23-4e5208d6ccdc","customerId":1,"items":[{"id":"e3c8f757-6961-40ce-b57e-8236ceada3fe","sku":"SKU1","qty":12,"unitCost":10,"cartId":"78bb01e7-e641-4626-9d23-4e5208d6ccdc"}]}

using curl (this work in a linux window git bash, somehow curl fails to post message using this)
curl -X POST -H "Content-Type: application/json" -d '{"cartId":"78bb01e7-e641-4626-9d23-4e5208d6ccdc","customerId":1,"items":[{"id":"e3c8f757-6961-40ce-b57e-8236ceada3fe","sku":"SKU1","qty":12,"unitCost":10,"cartId":"78bb01e7-e641-4626-9d23-4e5208d6ccdc"}]}'  http://localhost:8080/shopping/api/cartAddUpdateFunction

## Create a new cart
POST (Header -"Content-Type":"application/json")
{"customerId":1,"items":[{"sku":"SKU1","qty":12,"unitCost":10}]}

## Add item to a cart new cart
POST (Header -"Content-Type":"application/json")
{"cartId":"78bb01e7-e641-4626-9d23-4e5208d6ccdc","customerId":1,"items":[{"id":"e3c8f757-6961-40ce-b57e-8236ceada3fe","sku":"SKU1","qty":12,"unitCost":10,"cartId":"78bb01e7-e641-4626-9d23-4e5208d6ccdc"}, {"sku":"SKU1","qty":12,"unitCost":10}]}


## Delete stack 
aws cloudformation delete-stack --stack-name shopping --region us-east-1
