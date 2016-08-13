package com.ardetrick.alexa;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Guice;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestNiceRideSpeechlet {

    @Test
    public void sampleTest() throws SpeechletException {
        // create the speechlet
        AlexaStarterSpeechlet alexaStarterSpeechlet = Guice
                .createInjector(new AlexaStarterApplicationModule())
                .getInstance(AlexaStarterSpeechlet.class);

        // build a sample IntentRequest
        IntentRequest request = IntentRequest.builder()
                .withIntent(Intent.builder()
                        .withName("HelloWorldIntent")
                        .withSlots(ImmutableMap.of("Name", Slot.builder()
                                .withValue("Alexa")
                                .withName("Name")
                                .build()))
                        .build())
                .withRequestId("id")
                .build();

        // build a sample Session
        Session session = Session.builder()
                .withSessionId("id")
                .withUser(User.builder()
                        .withUserId("a")
                        .build())
                .build();

        SpeechletResponse speechletResponse = alexaStarterSpeechlet.onIntent(request, session);
        String text = ((PlainTextOutputSpeech) speechletResponse.getOutputSpeech()).getText();

        assertTrue(text.equals("Hello, Alexa"));
    }

}
