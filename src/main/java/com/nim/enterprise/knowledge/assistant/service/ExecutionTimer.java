package com.nim.enterprise.knowledge.assistant.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;


public final class ExecutionTimer {
    private static final Logger log = LoggerFactory.getLogger(ExecutionTimer.class);
    private ExecutionTimer() {
    }
    public static <T> T measure(String operation,
                                Supplier<T> supplier) {

        long start = System.nanoTime();

        try {
            return supplier.get();
        } finally {
            logDuration(operation, start);
        }
    }

    public static void measure (
            String operation,
            Runnable action) {
        long start = System.nanoTime();

        try {
            action.run();
        } finally {
            logDuration(operation, start);
        }
    }
    private static void logDuration(
            String operation,
            long start) {

        long durationMs = TimeUnit.NANOSECONDS.toMillis(
                System.nanoTime() - start
        );

        log.info("{} completed in {} ms", operation, durationMs);
    }

}
