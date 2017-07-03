package com.ardetrick.alexa;

import java.util.Set;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Guice;
import org.apache.log4j.Logger;

/**
 * This class is the handler for an Alexa Skill deployed as an AWS Lambda function.
 */
public final class AlexaStarterSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {

    /*
     * This Id can be found on https://developer.amazon.com/edw/home.html#/ by clicking "Edit" on the relevant
     * Alexa Skill. Enter the application id as an environment variable when configuring the Lambda in the AWS Console.
     */
    private static final Set<String> supportedApplicationIds = ImmutableSet.of(System.getenv("APPLICATION_ID"));

    public AlexaStarterSpeechletRequestStreamHandler() {
        super(Guice.createInjector(new AlexaStarterApplicationModule()).getInstance(AlexaStarterSpeechlet.class),
                supportedApplicationIds);
    }

}
