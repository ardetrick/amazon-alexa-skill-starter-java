package com.ardetrick.alexa.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestNiceRideService {

    @Test
    public void sampleTest() {
        HelloWorldService helloWorldService = new HelloWorldServiceImpl();
        final String hellToResponse = helloWorldService.helloTo("Alexa");
        assertEquals(hellToResponse, "Hello, Alexa");
    }

}
