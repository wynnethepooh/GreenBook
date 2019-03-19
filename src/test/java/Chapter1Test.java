import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Disabled;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class Chapter1Test {

    Chapter1 chapter1 = new Chapter1();

    @Test
    public void isUnique() {
        assertTrue(chapter1.isUnique("abcd"),
                "isUnique('abcd') should have returned true");
        assertFalse(chapter1.isUnique("abab"),
                "isUnique('abab') should have returned false");
        assertTrue(chapter1.isUnique("ab cd"),
                "isUnique('ab cd') should have returned true");
        assertTrue(chapter1.isUnique(""),
                "isUnique('') should have returned true");

        assertTrue(chapter1.isUniqueNoDataStructures("abcd"),
                "isUnique('abcd') should have returned true");
        assertFalse(chapter1.isUniqueNoDataStructures("abab"),
                "isUnique('abab') should have returned false");
        assertTrue(chapter1.isUniqueNoDataStructures("ab cd"),
                "isUnique('ab cd') should have returned true");
        assertTrue(chapter1.isUniqueNoDataStructures(""),
                "isUnique('') should have returned true");
    }
    @Test
    public void checkPermutation() {
        assertTrue(chapter1.checkPermutation("abcdefg", "efgabcd"),
                "checkPermutation('abcdefg', 'efgabcd' should have returned true");
        assertFalse(chapter1.checkPermutation("abcdefg", "efgabc"),
                "checkPermutation('abcdefg', 'efgabc') should have returned false");
        assertFalse(chapter1.checkPermutation("abcdefg", "aabcdefg"),
                "checkPermutation('abcdefg', aabcdefg') should have returned false");
        assertFalse(chapter1.checkPermutation("", "abcdefg"),
                "checkPermutation('', 'abcdefg') should have returned false");
    }

    @Test
    public void urlify() {
        char[] url = "Mr%20John%20Smith".toCharArray();
        char[] str = "Mr John Smith    ".toCharArray();
        char[] result = chapter1.urlify(str, 13);
        assertTrue(java.util.Arrays.equals(url, result),
                "urlify('Mr John Smith') should have returned 'Mr%20John%20Smith'");

        char[] noSpaces = "MrJohnSmith".toCharArray();
        assertTrue(java.util.Arrays.equals(noSpaces, chapter1.urlify(noSpaces, 11)),
                "urlify('MrJohnSmith') should have returned 'MrJohnSmith'");

        char[] consecutiveSpaces = "Mr  JohnSmith    ".toCharArray();
        char[] consecutiveSpacesUrl = "Mr%20%20JohnSmith".toCharArray();
        result = chapter1.urlify(consecutiveSpaces, 13);
        System.out.println(consecutiveSpaces);
        System.out.println(consecutiveSpacesUrl);
        System.out.println(result);
        assertTrue(java.util.Arrays.equals(consecutiveSpacesUrl, result),
                "urlify('Mr  JohnSmith    ') should have returned 'Mr%20%20JohnSmith'");
    }

    @Test
    public void palindromePermutation() {
        assertTrue(chapter1.palindromePermutation("Tact Coa"),
                "palindromePermutation('Tact Coa') should have returned true");
        assertTrue(chapter1.palindromePermutation("taco cat"),
                "palindromePermutation('taco cat') should have returned true");
        assertFalse(chapter1.palindromePermutation("abcd"),
                "palindromePermutation('abcd') should have returned false");
        assertTrue(chapter1.palindromePermutation(" TacO Cat0"),
                "palindromePermutation(' TacO Cat0') should have returned true");
        assertTrue(chapter1.palindromePermutation(" Racecar"),
                "palindromePermutation(' Racecar') should have returned true");
    }

    @Test
    public void oneAway() {
        assertTrue(chapter1.oneAway("pale", "ple"),
                "oneAway('pale', 'ple') should have returned true");
        assertTrue(chapter1.oneAway("pales", "pale"),
                "oneAway('pales', 'pale') should have returned true");
        assertTrue(chapter1.oneAway("pale", "bale"),
                "oneAway('pale', 'bale') should have returned true");
        assertFalse(chapter1.oneAway("pale", "bake"),
                "oneAway('pale', 'bake') should have returned false");
        assertFalse(chapter1.oneAway("pale", "bakes"),
                "oneAway('pale', 'bakes') should have returned false");
        assertTrue(chapter1.oneAway("bake", "barke"),
                "oneAway('bake', 'barke') should have returned true");
    }

    @Disabled
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
        System.out.println(matrixString(matrix));
        System.out.println(matrixString(result));

        for (int row = 0; row < matrix.length; row++) {
            if (!Arrays.equals(rotated[row], result[row])) {
                fail("expected:\n" + matrixString(rotated) + "\n" +
                        "actual:\n" + matrixString(result));
            }
        }
    }

    private String matrixString(int[][] matrix) {
        StringBuilder str = new StringBuilder();
        for (int row = 0; row < matrix.length; row++) {
            str.append(Arrays.toString(matrix[row]) + '\n');
        }
        return str.toString();
    }

    @Disabled
    @Test
    public void zeroMatrix() {
        int[][] matrix = new int[][] {
                {1, 2, 3, 4},
                {5, 0, 7, 8},
                {9, 10, 11, 12}
        };

        int[][] zeroed = new int[][] {
                {1, 0, 3, 4},
                {0, 0, 0, 0},
                {9, 0, 11, 12}
        };

        int[][] result = chapter1.rotateMatrix(matrix);
        System.out.println(matrixString(matrix));
        System.out.println(matrixString(result));

        for (int row = 0; row < matrix.length; row++) {
            if (!Arrays.equals(zeroed[row], result[row])) {
                fail("expected:\n" + matrixString(zeroed) + "\n" +
                        "actual:\n" + matrixString(result));
            }
        }
    }

    @Disabled
    @Test
    public void stringRotation() {
        assertTrue(chapter1.stringRotation("erbottlewat", "waterbottle"));
        assertFalse(chapter1.stringRotation("waterbottle", "bottleerwat"));
        assertFalse(chapter1.stringRotation("abcde", ""));
        assertFalse(chapter1.stringRotation("", "abcde"));
    }
}
