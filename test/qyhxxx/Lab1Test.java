package qyhxxx;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class Lab1Test {
    private int input;
    private boolean expected;
    private Lab1 lab1 = null;

    public Lab1Test(int input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Before
    public void setUp() {
        lab1 = new Lab1();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][] {
                {1, true},
                {9, false},
                {12, true},
                {24, false},
                {58, true},
                {-1, false}
        });
    }

    @Test
    public void testSolve() {
        assertEquals(this.expected, lab1.solve(this.input));
    }
}
