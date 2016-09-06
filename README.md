# Alexa Starter Project - Java

This project provides some initial structure and patterns for developing an Alexa Skill. There are other sample Java Alexa projects that demonstrate the basics, however, this project aims to go beyond a single file demo and explore a matured design.

The application is to be deployed as an Amazon Web Services (AWS) Lambda Function. This means you will need an Amazon Web Services account.

## Build

The application is built using Gradle. Use the gradle wrapper to run the build command.

    ./gradlew build

The deployment artifact is built as a 'fat jar' and placed in `./build/distributions` as a zip file. Use this file when deploying to an AWS Lambda.

## Deployment

The application is to be deployed as an AWS Lambda Function. Follow these steps for the details on how to set up an Alexa Lambda Function [https://developer.amazon.com/appsandservices/solutions/alexa/alexa-skills-kit/docs/developing-an-alexa-skill-as-a-lambda-function].

At a high level you will need to complete the following steps:

1. Start to create the Alexa Skill in the Amazon Developer Console (you need the Application Id).
1. Take the Alexa Skill Application Id and add it to AlexaStarterSpeechletRequestStreamHander `supportedApplicationIds` map.
1. Rebuild the application.
1. Create the AWS Lambda Function in the AWS Developer Console.
1. Deploy the zip from `./build/distributions` to the Lambda Function.
1. Test the Lambda Function using the AWS Lambda Function developer console (use the Alexa sample template).
1. Deploy the Lambda Function (make sure you are in US East).
1. Return the Alexa Skill developer console and add the deployed Lambda Function's ARN.
1. Test using the Alexa Skill developer console.

Although the initial setup of the Lambda Function and Alexa Skill can be a little tedious, many of these are one time tasks. After initial configuration you may only be uploading new zip files, although it is likely you will also be changing the json schema, adding new sample intenets, and perhaps building more robust Lambda Function sample requests.

## Tools

The code uses the following tools:

- Guice for dependency injection
- Log4j for logging
- JUnit for testing
- Gradle for building

## AWS Cloud Watch

The application comes with the necissary dependencies and configuration to use AWS Cloud Watch for logging once deployed as a Lambda Function. Additional configuration can be made by modifying the log4j properties in `src/main/java/resources`.
