package com.nindo.app.apimodel;

/**
 * Created by nigelnindo on 8/16/17.
 */
public class StringResponse extends ApiResponse {

    private final String type;
    private final String content;

    public StringResponse(String prefix, String content){
        this.type = prefix;
        this.content = content;
    }

    public String getErrorPrefix() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
