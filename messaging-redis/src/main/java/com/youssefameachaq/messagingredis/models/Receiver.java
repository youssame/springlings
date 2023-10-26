package com.youssefameachaq.messagingredis.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicInteger;

public class Receiver {
    private final Logger logger = LoggerFactory.getLogger(Receiver.class);
    private final AtomicInteger atomicInteger = new AtomicInteger();

    public void receiveMessage(String message) {
        logger.info("Received <" + message + ">");
        atomicInteger.incrementAndGet();
    }
    public int getCounter() {
        return atomicInteger.get();
    }
}
