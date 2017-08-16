package com.nindo.app.apimodel;

/**
 * Created by nigelnindo on 8/16/17.
 */
public class ErrorResponse extends ApiResponse {

    private final String error;

    public ErrorResponse(String error){
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
