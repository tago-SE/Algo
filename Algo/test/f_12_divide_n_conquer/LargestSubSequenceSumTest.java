/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f_12_divide_n_conquer;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiago
 */
public class LargestSubSequenceSumTest {
    
    public LargestSubSequenceSumTest() {
    }

    public void testSumSequence() {
    }


    public void testMaxSumAtIndex() {
    }

    @Test
    public void testSolve() {
        int[] a = {24, 35, -87, 21, 80, -12, 32, -90, 45, 10};
        int max = LargestSubSequenceSum.solve(a);
        int expected = 21 + 80 - 12 + 32;
        assertEquals(max, expected);
    }
    
}
