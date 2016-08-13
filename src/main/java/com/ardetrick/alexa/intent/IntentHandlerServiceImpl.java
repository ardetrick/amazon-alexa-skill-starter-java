package com.ardetrick.alexa.intent;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;

import javax.inject.Inject;
import java.util.Map;

class IntentHandlerServiceImpl implements IntentHandlerService {

    private final Map<String, IntentAction> intentActions;

    @Inject
    protected IntentHandlerServiceImpl(final Map<String, IntentAction> intentActions) {
        this.intentActions = intentActions;
    }

    @Override
    public SpeechletResponse handle(final String intentName, final Intent intent, final Session session)
            throws SpeechletException {
        SpeechletResponse speechletResponse;

        if(intentActions.containsKey(intentName)) {
            speechletResponse = intentActions.get(intentName).perform(intent, session);
        } else {
            throw new SpeechletException("Invalid Intent: " + intentName);
        }

        return speechletResponse;
    }

}
