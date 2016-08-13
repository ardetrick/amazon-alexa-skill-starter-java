package com.ardetrick.alexa;

import com.amazon.speech.speechlet.lambda.SpeechletRequestStreamHandler;
import com.google.inject.Guice;

import java.util.HashSet;
import java.util.Set;

/**
 * This class could be the handler for an AWS Lambda function powering an Alexa Skills Kit
 * experience. To do this, simply set the handler field in the AWS Lambda console to
 * "com.ardetrick.alexa.niceride.AlexaStarterSpeechletRequestStreamHandler" For this to work, you'll
 * also need to build this project using the {@code lambda-compile} Ant task and upload
 * the resulting zip file to power your function.
 */
public final class AlexaStarterSpeechletRequestStreamHandler extends SpeechletRequestStreamHandler {

    private static final Set<String> supportedApplicationIds;

    static {
        /*
         * This Id can be found on https://developer.amazon.com/edw/home.html#/ "Edit" the relevant
         * Alexa Skill and put the relevant Application Ids in this Set.
         */
        supportedApplicationIds = new HashSet<>();
        // replace this with your own ID
        supportedApplicationIds.add("amzn1.ask.skill.123abc-123abc-123abc-123abc-123abc");
    }

    public AlexaStarterSpeechletRequestStreamHandler() {
        super(Guice.createInjector(new AlexaStarterApplicationModule()).getInstance(AlexaStarterSpeechlet.class),
                supportedApplicationIds);
    }
}