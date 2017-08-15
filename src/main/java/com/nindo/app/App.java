package com.nindo.app;


import com.nindo.app.extractor.Extractor;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Extractor extractor = new Extractor();
        System.out.println(extractor.extract("Ken had a KBA 123a"));
    }
}
