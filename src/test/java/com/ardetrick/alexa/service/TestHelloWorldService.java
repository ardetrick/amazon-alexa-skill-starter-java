package com.ardetrick.alexa.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestHelloWorldService {

    @Test
    public void sampleTest() {
        HelloWorldService helloWorldService = new HelloWorldServiceImpl();
        final String helloToResponse = helloWorldService.helloTo("World");
        assertEquals("Well hello, World. Welcome to Alexa development!", helloToResponse);
    }

}
