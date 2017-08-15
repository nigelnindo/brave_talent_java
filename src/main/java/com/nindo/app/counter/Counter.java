package com.nindo.app.counter;

import com.nindo.app.extractor.Extractor;
import com.nindo.app.extractor.Plate;

public class Counter {

    public static int MAX_CONSTANT = 999 * 26;
    public static int FIRST_PREFIX_CONSTANT = 999 * 26 *26;
    public static int SECOND_PREFIX_CONSTANT = 999 * 26 ;

    public static Integer getDifference(String firstPlate, String secondPlate){
        Extractor extractor = new Extractor();
        Plate _firstPlate = extractor.extract(firstPlate);
        Plate _secondPlate = extractor.extract(secondPlate);
        if ( "NO PLATE".equals(_firstPlate.formatPlate()) || "NO PLATE".equals(_secondPlate.formatPlate())){
            //invalid Plates were supplied
            return 0;
        }
        int firstValue = compute2(_firstPlate.createPlateCounter());
        int secondValue = compute2(_secondPlate.createPlateCounter());
        if (firstValue > secondValue){
            return firstValue - secondValue;
        } else {
            return secondValue - firstValue;
        }
    }

    /*
    public static int compute(PlateCounterModel plateCounter){
        int secondPrefix = plateCounter.secondPrefix;
        if (plateCounter.firstPrefix > 1){
            secondPrefix = 26;
        }
        int suffixValue = (plateCounter.firstSuffix + (999 * (plateCounter.secondSuffix - 1)));
        return (plateCounter.firstPrefix * secondPrefix * MAX_CONSTANT) - (MAX_CONSTANT - suffixValue);
    }
    */

    public static int compute2(PlateCounterModel plateCounter){
        return (
                ((plateCounter.firstPrefix - 1) * FIRST_PREFIX_CONSTANT) +
                ((plateCounter.secondPrefix -1) * SECOND_PREFIX_CONSTANT) +
                (plateCounter.firstSuffix + (999 * (plateCounter.secondSuffix - 1)))
        );
    }

}