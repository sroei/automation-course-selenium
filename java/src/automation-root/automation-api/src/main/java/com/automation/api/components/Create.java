package com.automation.api.components;

import java.io.IOException;

public interface Create<T> {
    T create() throws IOException;
}
