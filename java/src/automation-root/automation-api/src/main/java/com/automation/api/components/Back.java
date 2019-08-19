package com.automation.api.components;

import java.io.IOException;

public interface Back<T> {
    T backToList() throws IOException;
}
