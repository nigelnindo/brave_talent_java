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
        Extractor extractor = new Extractor();
        /*
        System.out.println( "Hello World!" );
        Plate extractedPlate = extractor.extract("Mercy just bought kBA 951j");
        System.out.println(extractedPlate.formatPlate());
        PlateCounterModel counter = extractedPlate.createPlateCounter();
        if (null != counter){
            System.out.println(counter.getSecondSuffix());
        } else {
            System.out.print("We had an invalid counter.");
        }
        */
        System.out.println(Counter.compute2(extractor.extract("KAY 999Z").createPlateCounter()));
        System.out.println(Counter.compute2(extractor.extract("KAZ 001A").createPlateCounter()));
        System.out.println(Counter.compute2(extractor.extract("KAZ 999Z").createPlateCounter()));
        System.out.println(Counter.compute2(extractor.extract("KBA 001A").createPlateCounter()));
    }
}
