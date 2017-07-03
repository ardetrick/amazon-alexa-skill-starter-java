package com.ardetrick.alexa.service;

/*
 * A simple implementation of the HelloWorldService interface.
 */
public class HelloWorldServiceImpl implements HelloWorldService {

    HelloWorldServiceImpl() {

    }

    @Override
    public String helloTo(final String name) {
        return "Well hello, " + name + ". Welcome to Alexa development!";
    }

}
