package com.ardetrick.alexa;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.*;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;

import com.ardetrick.alexa.intent.IntentHandlerService;
import org.apache.log4j.Logger;

import javax.inject.Inject;

/*
 * An implementation of a Speechlet which provides simple session
 * lifecycle management (launch, start, end) and delegates all
 * intents to another service.
 */
public class AlexaStarterSpeechlet implements Speechlet {

    private static final Logger log = Logger.getLogger(AlexaStarterSpeechlet.class);

    private final IntentHandlerService intentHandlerService;

    @Inject
    protected AlexaStarterSpeechlet(IntentHandlerService intentHandlerService) {
        this.intentHandlerService = intentHandlerService;
    }

    /*
     * Invoked at the start of an Alexa session. Does not handle any intents.
     */
    @Override
    public void onSessionStarted(final SessionStartedRequest request, final Session session)
            throws SpeechletException {
        log.info("onSessionStarted requestId=" + request.getRequestId() +
                ", sessionId=" + session.getSessionId());
    }

    /*
     * Invoked when the user invokes the Skill without providing an intent.
     */
    @Override
    public SpeechletResponse onLaunch(final LaunchRequest request, final Session session) throws SpeechletException {
        log.info("onLaunch requestId=" + request.getRequestId() + ", sessionId=" + session.getSessionId());

        String speechText = "Welcome to Alexa, you can ask me hello world";

        SimpleCard card = new SimpleCard();
        card.setTitle("Welcome!");
        card.setContent(speechText);

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt, card);
    }

    /*
     * Invoked by any intent requests.
     */
    @Override
    public SpeechletResponse onIntent(final IntentRequest request, final Session session) throws SpeechletException {
        log.info("onIntent requestId=" + request.getRequestId() + ", sessionId=" + session.getSessionId());

        Intent intent = request.getIntent();
        String intentName = (intent != null) ? intent.getName() : null;

        return intentHandlerService.handle(intentName, intent, session);
    }

    @Override
    public void onSessionEnded(final SessionEndedRequest request, final Session session)
            throws SpeechletException {
        log.info("onSessionEnded requestId=" + request.getRequestId() +
                ", sessionId=" + session.getSessionId());
    }

}
