package com.nindo.app;

import com.nindo.app.counter.Counter;

import junit.framework.TestCase;

/**
 * Created by nigelnindo on 8/15/17.
 */
public class CounterTests extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CounterTests(String testName )
    {
        super( testName );
    }

    public void testApp(){
        testInvalidInputs();
        testCount();
    }

    public void testInvalidInputs(){
        // make sure that both plates supplies are valid Kenyan plates
        assertEquals( (Integer) 0, Counter.getDifference("KBA 123J","KAY F237"));
    }

    public void testCount(){
        /**
         * -> values that come after one another should have a difference of
         * -> values different in the tens should still calculate correctly
         * -> values different in the hundreds should still calculate correctly
         * -> changing last letter of plate by moving to the next largest figure should have a difference of one
         * -> moving to new last letter of 'prefix' should result in a difference of one
         * -> moving to first letter of 'prefix should result in a difference of one
         */

        assertEquals( (Integer) 1, Counter.getDifference("KBA 049A","KBA 050A"));
        assertEquals( (Integer) 48, Counter.getDifference("KBE 050A","KBE 098A"));
        assertEquals( (Integer) 200, Counter.getDifference("KBD 050A","KBD 250A"));
        assertEquals( (Integer) 1, Counter.getDifference("KAA 999A","KAA 001B"));
        assertEquals( (Integer) 1, Counter.getDifference("KAZ 999Z","KBA 001A"));

    }

}
