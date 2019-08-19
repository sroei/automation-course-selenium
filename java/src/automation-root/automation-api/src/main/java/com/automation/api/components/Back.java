package com.automation.api.components;

import java.io.IOException;

@SuppressWarnings("unused")
public interface Back<T> {
    T backToList() throws IOException;
}