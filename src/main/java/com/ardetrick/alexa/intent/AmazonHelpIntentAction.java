package com.ardetrick.alexa.intent;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.SimpleCard;

/**
 * Provide help about how to use the skill.
 */
public class AmazonHelpIntentAction implements IntentAction {

    protected AmazonHelpIntentAction() {

    }

    @Override
    public SpeechletResponse perform(Intent intent, Session session) {
        String speechText = "Provide help about how to use the skill.";

        SimpleCard card = new SimpleCard();
        card.setTitle("Help");
        card.setContent(speechText);

        PlainTextOutputSpeech speech = new PlainTextOutputSpeech();
        speech.setText(speechText);

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(speech);

        return SpeechletResponse.newAskResponse(speech, reprompt, card);
    }
}
