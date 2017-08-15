package com.nindo.app;


import com.nindo.app.counter.Counter;
import com.nindo.app.counter.PlateCounterModel;
import com.nindo.app.extractor.Extractor;
import com.nindo.app.extractor.Plate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
        System.out.println( "Hello World!" );
        Extractor extractor = new Extractor();
        Plate extractedPlate = extractor.extract("Mercy just bought kBA 951j");
        System.out.println(extractedPlate.formatPlate());
        PlateCounterModel counter = extractedPlate.createPlateCounter();
        if (null != counter){
            System.out.println(counter.getSecondSuffix());
        } else {
            System.out.print("We had an invalid counter.");
        }
        */
        System.out.println(Counter.getDifference("KBA 001A","KBA 005A"));
    }
}
