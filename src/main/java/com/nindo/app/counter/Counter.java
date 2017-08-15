package com.nindo.app.counter;

import com.nindo.app.extractor.Extractor;
import com.nindo.app.extractor.Plate;

public class Counter {

    private static int MAX_CONSTANT = 999 * 26;

    public static Integer getDifference(String firstPlate, String secondPlate){
        Extractor extractor = new Extractor();
        Plate _firstPlate = extractor.extract(firstPlate);
        Plate _secondPlate = extractor.extract(secondPlate);
        if ( "NO PLATE".equals(_firstPlate.formatPlate()) || "NO PLATE".equals(_secondPlate.formatPlate())){
            //invalid Plates were supplied
            return 0;
        }
        int firstValue = compute(_firstPlate.createPlateCounter());
        int secondValue = compute(_secondPlate.createPlateCounter());
        if (firstValue > secondValue){
            return firstValue - secondValue;
        } else {
            return secondValue - firstValue;
        }
    }

    private static int compute(PlateCounterModel plateCounter){
        int secondPrefix = plateCounter.secondPrefix;
        if (plateCounter.firstPrefix > 1){
            secondPrefix = 26;
        }
        int suffixValue = (plateCounter.firstSuffix + (999 * (plateCounter.secondSuffix - 1)));
        return (plateCounter.firstPrefix * secondPrefix * MAX_CONSTANT) - (MAX_CONSTANT - suffixValue);
    }

}