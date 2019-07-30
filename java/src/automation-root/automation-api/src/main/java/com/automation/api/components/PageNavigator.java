package com.automation.api.components;

public interface PageNavigator<T> {
    T next();

    T previous();

    int pages();

    int page();
}