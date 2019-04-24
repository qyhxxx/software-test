package qyhxxx;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void testBubbleSort() {
        int arr[] = new int[]{1,6,2,2,5};
        assertTrue(Arrays.equals(new int[]{1, 2, 2, 5, 6}, BubbleSort.BubbleSort(arr)));
    }
}