package com.ardetrick.alexa.service;

import com.google.inject.AbstractModule;

/*
 * A Service module.
 */
public class ServiceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(HelloWorldService.class).to(HelloWorldServiceImpl.class);
    }

}
