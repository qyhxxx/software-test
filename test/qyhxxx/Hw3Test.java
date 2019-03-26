package qyhxxx;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class Hw3Test {
    private int input;
    private String expected;
    private Hw3 hw3 = null;
    private ByteArrayOutputStream baos = null;

    public Hw3Test(int input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Before
    public void SetUp(){
        hw3 = new Hw3();
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData(){
        return Arrays.asList(new Object[][]{
                {1, "Prime: 2\r\n"},
                {3, "Prime: 2\r\nPrime: 3\r\nPrime: 5\r\n"}
        });
    }

    @SuppressWarnings("static-access")
    @Test
    public void TestPrintPrimes(){
        Hw3.printPrimes(this.input);
        assertEquals(this.expected, baos.toString());
    }
}