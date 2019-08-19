package com.automation.api.components;

@SuppressWarnings("unused")
public interface PageNavigator<T> {
    T next();

    T previous();

    int pages();

    int page();
}