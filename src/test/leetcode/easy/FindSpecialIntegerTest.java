package test.leetcode.easy;

import org.junit.jupiter.api.Test;
import org.vinuvicho.leetcode.easy.FindSpecialInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindSpecialIntegerTest {
    private static final FindSpecialInteger c = new FindSpecialInteger();

    @Test
    void findSpecialInteger() {
        int[] arr = {1, 2, 2, 6, 6, 7, 10, 10, 10};
        assertEquals(10, c.findSpecialInteger(arr));
    }
    @Test
    void findSpecialInteger2() {
        int[] arr = {1, 2, 2, 6, 6, 6, 7, 10, 10};
        assertEquals(6, c.findSpecialInteger(arr));
    }
    @Test
    void findSpecialInteger3() {
        int[] arr = {2, 2, 2, 6, 6, 7, 10, 10, 11};
        assertEquals(2, c.findSpecialInteger(arr));
    }
}
