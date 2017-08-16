package com.nindo.app;


import com.nindo.app.apimodel.*;
import com.nindo.app.counter.Counter;
import com.nindo.app.counter.PlateCounterModel;
import com.nindo.app.extractor.Extractor;
import com.nindo.app.extractor.Plate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@RestController
public class App 
{
    Extractor extractor = new Extractor();

    @RequestMapping("/api/extractor")
    public ApiResponse extractor(@RequestParam(value="sentence", defaultValue="") String sentence){
        if ("".equals(sentence)){
            return new ErrorResponse("Supply 'sentence' parameter");
        }
        return new ExtractorResponse(extractor.extract(sentence).formatPlate());
    }

    @RequestMapping("/api/difference")
    public ApiResponse difference(@RequestParam Map<java.lang.String, java.lang.String> params){
        String first = params.get("firstPlate");
        String second = params.get("secondPlate");
        if (null == first || null == second){
            return new ErrorResponse("Supply both 'firstPlate' & 'secondPlate' parameters");
        }
        return new CounterResponse(Counter.getDifference(first,second));
    }

    @RequestMapping("/")
    public String home(){
        return "Hello World";
    }

    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
