package com.nindo.app.apimodel;

/**
 * Created by nigelnindo on 8/16/17.
 */
public class ExtractorResponse extends ApiResponse {

    private final String result;

    public ExtractorResponse(String result){
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
