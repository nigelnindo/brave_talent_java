package com.nindo.app.extractor;

import com.nindo.app.counter.PlateCounterModel;
import com.nindo.app.counter.PlateCounterCreator;

/**
 * Created by nigelnindo on 8/15/17.
 */
public class Plate implements PlateCounterCreator {

    String prefix;
    String suffix;

    public Plate(String prefix, String suffix){
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public String formatPlate(){
        return (prefix + " " + suffix).toUpperCase();
    }


    public PlateCounterModel createPlateCounter() {
        if (formatPlate().equals("NO PLATE")){
            return null; // invalid plate model
        } else {
            return new PlateCounterModel(
                PlateCounterModel.getAlphabetValue(this.prefix.charAt(1)),
                PlateCounterModel.getAlphabetValue(this.prefix.charAt(2)),
                Integer.parseInt(this.suffix.substring(0,3)),
                PlateCounterModel.getAlphabetValue(this.suffix.charAt(3))
            );
        }
    }
}
