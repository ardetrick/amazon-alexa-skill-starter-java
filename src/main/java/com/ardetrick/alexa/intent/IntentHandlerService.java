package com.ardetrick.alexa.intent;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletException;
import com.amazon.speech.speechlet.SpeechletResponse;

/**
 * An interface for a service that routes intents to their supporting actions.
 */
public interface IntentHandlerService {

    /*
     * Inspects the intentName and forwards the Intent and Session objects
     * to another class to actually execute the intent.
     *
     * throws SpeechletException if there is no implementation for intentName.
     */
    SpeechletResponse handle(final String intentName, final Intent intent, final Session session)
            throws SpeechletException;

}
