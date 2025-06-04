package com.example.backendtest._core.util;

public class ErrorResponse {
    private final String reason;

    public ErrorResponse(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}
