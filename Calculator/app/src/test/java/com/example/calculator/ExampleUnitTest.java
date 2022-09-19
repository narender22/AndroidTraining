package com.example.calculator;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class ExampleUnitTest {
    /*
    * create an mock object of that specific class
    * */
    @Mock
    Operation operation;

    @Before
    public void init() {
        operation = new Operation();
    }

    @Test
    public void addition_isCorrect() {
//        addition test
        assertEquals(2, operation.add(1, 1));
        assertEquals(0, operation.add(1, -1));
    }

    @Test
    public void subtraction_isCorrect(){
        //        subtraction test
        assertEquals(0, operation.sub(1, 1));
        assertEquals(15, operation.sub(20, 5));
    }

    @Test
    public void multiplicationIsCorrect(){
        //        Multiplication test
        assertEquals(27, operation.mul(9, 3));
        assertEquals(-27, operation.mul(-9, 3));
    }

    @Test
    public void divisionIsCorrect(){
        //        Division
        assertEquals(3, operation.div(9, 3));
        assertEquals(-3, operation.div(-9, 3));
    }
}