package com.ardetrick.alexa;

import com.ardetrick.alexa.intent.IntentModule;
import com.ardetrick.alexa.service.ServiceModule;
import com.google.inject.AbstractModule;

/*
 * A parent module to install the all modules required by the application.
 */
public class AlexaStarterApplicationModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new ServiceModule());
        install(new IntentModule());
    }

}
