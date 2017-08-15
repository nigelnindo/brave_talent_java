package com.nindo.app;

import com.nindo.app.extractor.Extractor;

import junit.framework.TestCase;

/**
 * Created by nigelnindo on 8/15/17.
 */
public class ExtractorTests extends TestCase {

    Extractor extractor = new Extractor();
    private static String NEGATIVE_RESULT = "NO PLATE";

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ExtractorTests(String testName )
    {
        super( testName );
    }

    public void testApp()
    {
        testTruePositive();
        testCaseInsensitive();
        testInvalidNumberPlates();
    }

    public void testTruePositive(){
        // should get the explicit number plate in the sentence
        assertEquals( "KCA 199A", extractor.extract("I saw a KCA 199A on the highway"));
    }

    public void testCaseInsensitive(){
        // should extract the number plate even whether in upper/lower/mixed case
        assertEquals( "KBA 951J", extractor.extract("Mercy just bought kBA 951j"));
    }

    public void testInvalidNumberPlates(){
        /**
         * -> should fail if a letter isn't the last character in plate suffix
         * -> should fail if any of first three characters in plate suffix is a string
         * -> should fail if any of the characters in plate suffix is a number
         */
        assertEquals( NEGATIVE_RESULT, extractor.extract("KBA 9511 was bought by Mercy"));
        assertEquals( NEGATIVE_RESULT, extractor.extract("KBA 9A5J was bought by Mercy"));
        assertEquals( NEGATIVE_RESULT, extractor.extract("KB3 951J was bought by Mercy"));
    }

    public void testNoNumberPlateInSentence(){
        // should not return any plate if there isn't a plate in the sentence
        assertEquals( NEGATIVE_RESULT, extractor.extract("She sells sea shells at the sea shore"));
    }

    public void testTwoPositivePlatePrefixes(){
        // should ignore 'Ken', which is a positive prefix, but is a name
        assertEquals( "KBC 367A", extractor.extract("Yesterday, Ken was driving a KBC 367A"));
    }


}
