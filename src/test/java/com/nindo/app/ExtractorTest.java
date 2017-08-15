package com.nindo.app;

import com.nindo.app.counter.Counter;
import com.nindo.app.extractor.Extractor;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by nigelnindo on 8/15/17.
 */
public class ExtractorTest  extends TestCase {

    Extractor extractor = new Extractor();
    private static String NEGATIVE_RESULT = "NO PLATE";

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ExtractorTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( ExtractorTest.class );
    }

    public void testApp()
    {
        testTruePositive();
        testCaseInsensitive();
        testInvalidNumberPlates();
    }

    public void testTruePositive(){
        // should get the explicit number plate in the sentence
        assertEquals( extractor.extract("I saw a KCA 199A on the highway"), "KCA 199A" );
    }

    public void testCaseInsensitive(){
        // should extract the number plate even whether in upper/lower/mixed case
        assertEquals( extractor.extract("Mercy just bought kBA 951j"), "KBA 951J");
    }

    public void testInvalidNumberPlates(){
        /**
         * -> should fail if a letter isn't the last character in plate suffix
         * -> should fail if any of first three characters in plate suffix is a string
         * -> should fail if any of the characters in plate suffix is a number
         */
        assertEquals( extractor.extract("KBA 9511 was bought by Mercy"), NEGATIVE_RESULT);
        assertEquals( extractor.extract("KBA 9A5J was bought by Mercy"), NEGATIVE_RESULT);
        assertEquals( extractor.extract("KB3 951J was bought by Mercy"), NEGATIVE_RESULT);
    }

    public void testNoNumberPlateInSentence(){
        // should not return any plate if there isn't a plate in the sentence
        assertEquals( extractor.extract("She sells sea shells at the sea shore"), NEGATIVE_RESULT);
    }

    public void testTwoPositivePlatePrefixes(){
        // should ignore 'Ken', which is a positive prefix, but is a name
        assertEquals( extractor.extract("Yesterday, Ken was driving a KBC 367A"), "KBC 367A" );
    }


}
