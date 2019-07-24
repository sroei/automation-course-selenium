package com.automation.core.logging;

public class TraceLogger implements Logger {
    public void debug(String message) {
        System.out.println(message);
    }

    public void debug(String format, Object... args) {
        System.out.println(String.format(format, args));
    }

    public void debug(Exception exception, String message) {
        System.out.println(message + " " + exception.toString());
    }
}
