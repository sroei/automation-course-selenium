package com.automation.api.components;

import java.io.IOException;

public interface Details<T> {
    T details() throws IOException;
}
