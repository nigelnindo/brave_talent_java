package com.nindo.app.apimodel;

/**
 * Created by nigelnindo on 8/16/17.
 */
public class CounterResponse extends ApiResponse {

    private final int result;

    public CounterResponse(int result){
        this.result = result;
    }

    public int getResult() {
        return result;
    }

}
