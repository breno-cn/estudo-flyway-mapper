package com.example.demo.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    private static final Logger log = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    private void receiveMessage(String message) {
        log.info("Received < {} >", message);
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
