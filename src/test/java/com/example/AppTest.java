package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void equals(){

        assertEquals(1, 1);
    }

    @Test
    public void dev() throws ParseException {
        String[] arr = {"java", "py"};
        Contract contract = new Contract(1,"make", arr, "10/10/2022", "11/12/2022", 45);
        Dev dev = new Dev("jas", 4, arr,6,"24/01/2022", "23/12/2022", 30);
        double score = SMP.scoreEval(dev, contract);
        assertEquals(2.15, score, 0.05);
    }
}
