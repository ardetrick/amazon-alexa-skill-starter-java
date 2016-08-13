package com.ardetrick.alexa.service;

/*
 * A simple implementation of the HelloWOrldService interface.
 */
public class HelloWorldServiceImpl implements HelloWorldService {

    protected HelloWorldServiceImpl() {

    }

    @Override
    public String helloTo(final String name) {
        return "Hello, " + name;
    }

}
