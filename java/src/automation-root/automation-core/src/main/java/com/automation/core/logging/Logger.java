package com.automation.core.logging;

@SuppressWarnings("unused")
public interface Logger {
    void debug(String message);
    void debug(String format, Object... args);
    void debug(Exception exception, String message);
}
