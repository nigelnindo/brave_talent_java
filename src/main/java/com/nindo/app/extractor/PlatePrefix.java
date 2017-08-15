package com.nindo.app.extractor;

/**
 * Created by nigelnindo on 8/15/17.
 */
public class PlatePrefix {

    String word;
    int index;

    public PlatePrefix(String word, int index){
        this.word = word;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getWord() {
        return word;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
