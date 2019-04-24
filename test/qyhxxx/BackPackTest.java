package qyhxxx;

import org.junit.Test;

import static org.junit.Assert.*;

public class BackPackTest {

    @Test
    public void testBackPack_Solution() {
        int m = 10;
        int n = 3;
        int w[] = {3, 4, 5};
        int p[] = {4, 5, 6};
        assertEquals(11, BackPack.BackPack_Solution(m, n, w, p)[n][m]);
    }
}