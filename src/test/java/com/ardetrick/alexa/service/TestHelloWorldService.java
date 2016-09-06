package com.ardetrick.alexa.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestHelloWorldService {

    @Test
    public void sampleTest() {
        HelloWorldService helloWorldService = new HelloWorldServiceImpl();
        final String hellToResponse = helloWorldService.helloTo("Alexa");
        assertEquals(hellToResponse, "Hello, Alexa");
    }

}
