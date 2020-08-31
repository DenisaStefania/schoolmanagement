package com.frequentis.training.response;

public class Response {
    private boolean success;
    private int result;

    public Response(boolean success, int result) {
        this.success = success;
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getResult() {
        return result;
    }
}
