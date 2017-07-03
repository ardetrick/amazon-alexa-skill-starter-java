package com.ardetrick.alexa.intent;

import com.amazon.speech.slu.Intent;
import com.amazon.speech.slu.Slot;
import com.amazon.speech.speechlet.Session;
import com.amazon.speech.speechlet.SpeechletResponse;
import com.amazon.speech.ui.PlainTextOutputSpeech;
import com.amazon.speech.ui.Reprompt;
import com.amazon.speech.ui.StandardCard;
import com.ardetrick.alexa.service.HelloWorldService;

import javax.inject.Inject;
import java.util.Optional;

public class HelloWorldIntentAction implements IntentAction {

    private static final String SLOT_NAME = "Name";

    private final HelloWorldService helloWorldService;

    @Inject
    protected HelloWorldIntentAction(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @Override
    public SpeechletResponse perform(final Intent intent,final Session session) {
        return Optional.ofNullable(intent.getSlot(SLOT_NAME))
                .map(Slot::getValue)
                .map(this::getHelloResponse)
                .orElse(getRepromptResposne());
    }

    /*
     * Returns a SpeechletResponse which reprompts the user to try again.
     */
    private SpeechletResponse getRepromptResposne() {
        final String responseText = "I am sorry, who are you? Try saying 'hello, World'";

        StandardCard standardCard = new StandardCard();
        standardCard.setTitle("Who are you?");
        standardCard.setText(responseText);

        PlainTextOutputSpeech plainTextOutputSpeech = new PlainTextOutputSpeech();
        plainTextOutputSpeech.setText(responseText);

        Reprompt reprompt = new Reprompt();
        reprompt.setOutputSpeech(plainTextOutputSpeech);

        return SpeechletResponse.newAskResponse(plainTextOutputSpeech, reprompt, standardCard);
    }

    /*
     * Returns a SpeechletResponse which says hello.
     */
    private SpeechletResponse getHelloResponse(final String name) {
        StandardCard standardCard = new StandardCard();

        final String responseText = helloWorldService.helloTo(name);

        standardCard.setTitle("Hello, World");
        standardCard.setText(responseText);

        PlainTextOutputSpeech plainTextOutputSpeech = new PlainTextOutputSpeech();
        plainTextOutputSpeech.setText(responseText);

        return SpeechletResponse.newTellResponse(plainTextOutputSpeech, standardCard);
    }

}
