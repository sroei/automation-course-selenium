package com.automation.core.components;

public interface Fluent {
    <T> T changeContext();
    <T> T changeContext(String application);
}
