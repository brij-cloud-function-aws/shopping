package com.brij.serverless.shopping.handler;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;
/*
If we want to expose our string reverser again via an HTTP request, then Spring Cloud Function AWS ships with SpringBootRequestHandler.
 It implements AWS's RequestHandler and is in charge of dispatching the AWS request to our function.
 */
public class StringReverseHandler extends SpringBootRequestHandler<String, String> {

}
