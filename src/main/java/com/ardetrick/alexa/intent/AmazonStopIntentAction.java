package com.ardetrick.alexa.intent;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;

/**
 * An intent that supports either of the following actions:
 *  - Let the user stop an action (but remain in the skill)
 *  - Let the user completely exit the skill
 */
public class AmazonStopIntentAction implements IntentAction {

    protected AmazonStopIntentAction() {

    }

    @Override
    public SpeechletResponse perform(Intent intent, Session session) {
        String speechText = "Good bye!";

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        return SpeechletResponse.newTellResponse(speech);
    }

}
