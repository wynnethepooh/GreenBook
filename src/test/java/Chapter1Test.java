import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Chapter1Test {

    Chapter1 chapter1 = new Chapter1();

    @Test
    public void isUnique() {
        assertTrue(chapter1.isUnique("abcd"));
        assertFalse(chapter1.isUnique("abab"));
        assertTrue(chapter1.isUnique("ab cd"));
        assertTrue(chapter1.isUnique(""));

        assertTrue(chapter1.isUniqueNoDataStructures("abcd"));
        assertFalse(chapter1.isUniqueNoDataStructures("abab"));
        assertTrue(chapter1.isUniqueNoDataStructures("ab cd"));
        assertTrue(chapter1.isUniqueNoDataStructures(""));
    }

    @Test
    public void checkPermutation() {
        assertTrue(chapter1.checkPermutation("abcdefg", "efgabcd"));
        assertFalse(chapter1.checkPermutation("abcdefg", "efgabc"));
        assertFalse(chapter1.checkPermutation("abcdefg", "aabcdefg"));
        assertFalse(chapter1.checkPermutation("", "abcdefg"));
    }

    @Test
    public void urlify() {
        char[] url = "Mr%20John%20Smith".toCharArray();
        char[] str = "Mr John Smith    ".toCharArray();
        char[] result = chapter1.urlify(str, 13);
        assertTrue(java.util.Arrays.equals(url, result));

        char[] noSpaces = "MrJohnSmith".toCharArray();
        assertTrue(java.util.Arrays.equals(noSpaces, chapter1.urlify(noSpaces, 11)));

        char[] consecutiveSpaces = "Mr  JohnSmith    ".toCharArray();
        char[] consecutiveSpacesUrl = "Mr%20%20JohnSmith".toCharArray();
        result = chapter1.urlify(consecutiveSpaces, 13);
        System.out.println(consecutiveSpaces);
        System.out.println(consecutiveSpacesUrl);
        System.out.println(result);
        assertTrue(java.util.Arrays.equals(consecutiveSpacesUrl, result));
    }

    @Test
    public void palindromePermutation() {
        assertTrue(chapter1.palindromePermutation("Tact Coa"));
        assertTrue(chapter1.palindromePermutation("taco cat"));
        assertFalse(chapter1.palindromePermutation("abcd"));
        assertTrue(chapter1.palindromePermutation(" TacO Cat0"));
        assertTrue(chapter1.palindromePermutation(" Racecar"));
    }

    @Test
    public void oneAway() {
        assertTrue(chapter1.oneAway("pale", "ple")); // 0 1
        assertTrue(chapter1.oneAway("pales", "pale")); // 3 4
        assertTrue(chapter1.oneAway("pale", "bale")); //
        assertFalse(chapter1.oneAway("pale", "bake"));
        assertFalse(chapter1.oneAway("pale", "bakes"));
        assertTrue(chapter1.oneAway("bake", "barke"));
    }

    @Test
    public void stringCompression() {
        assertEquals("a2b1c5a3", chapter1.stringCompression("aabcccccaaa"));
        assertEquals("ab", chapter1.stringCompression("ab"));
        assertEquals("aa", chapter1.stringCompression("aa"));
        assertEquals("aabbccdd", chapter1.stringCompression("aabbccdd"));
        assertEquals("abc", chapter1.stringCompression("abc"));
    }

    @Test
    public void rotateMatrix() {
        int[][] matrix = new int[][] {
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}
        };

        int[][] rotated = new int[][] {
                {12, 8, 4, 0},
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3}
        };

        int[][] result = chapter1.rotateMatrix(matrix);
        printMatrix(matrix);
        printMatrix(result);

        for (int row = 0; row < matrix.length; row++) {
            assertTrue(Arrays.equals(rotated[row], result[row]));
        }
    }

    private void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(Arrays.toString(matrix[row]));
        }
        System.out.println();
    }
}
