package com.automation.extensions.contracts;

import com.google.gson.annotations.Expose;

public class DriverParams {
    @Expose
    private String source;

    @Expose
    private String driver;

    @Expose
    private String binaries;

    public String getSource() {
        return source;
    }

    public DriverParams setSource(String source) {
        this.source = source;
        return this;
    }

    public String getDriver() {
        return driver;
    }

    public DriverParams setDriver(String driver) {
        this.driver = driver;
        return this;
    }

    public String getBinaries() {
        return binaries;
    }

    public DriverParams setBinaries(String binaries) {
        this.binaries = binaries;
        return this;
    }
}
