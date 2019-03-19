import java.util.HashSet;
import java.util.Set;

public class Chapter1 {

    /**
     * Implement an algorithm to determine if a string has all unique characters.
     *
     * What if you cannot use additional data structures?
     * @param letters string
     * @return true if string has all unique characters
     */
    public boolean isUnique(String letters) {
        long[] chars = new long[4];

        for (char c : letters.toCharArray()) {
            if (((chars[c/64] >> c%64) & 1) != 0) 
                return false;
            chars[c/64] |= ((long)1 << c%64);
        }
        return true;
    }

    public boolean isUniqueNoDataStructures(String letters) {
        return isUnique(letters);
    }

    /**
     * Given two strings, write a method to decide if one is a permutation of
     * the others.
     *
     * @param s1 string 1
     * @param s2 string 2
     * @return true if string 1 is permutation of string 2
     */
    public boolean checkPermutation(String s1, String s2) {
        byte[] chars = new byte[256];

        if (s1.length() != s2.length()) 
            return false;

        for (char c : s1.toCharArray()) {
            chars[c]++;
        }

        for (char c : s2.toCharArray()) {
            if (chars[c]-- == 0) 
                return false;
        }
        return true;
    }

    /**
     * Write a method to replace all spaces in a string with '%20'. You may
     * assume that the string has sufficient space at the end to hold the
     * additional characters, and that you are given the "true" length of the
     * string. (Note: If implementing in Java, please use a character array so
     * that you can perform in place.)
     *
     * @param str string
     * @param len true length of string
     * @return URLified string
     */
    public char[] urlify(char[] str, int len) {
        int new_size = len;
        char temp;

        for (int idx = 0; idx < len; idx++) {
            if (str[idx] == ' ')
                new_size += 2;
        }

        for (int idx = len-1; idx > 0; idx--) { 
            if (str[idx] == ' ') {
                str[new_size-- - 1] = '0';
                str[new_size-- - 1] = '2';
                str[new_size-- - 1] = '%';
            }
            else {
                temp = str[idx];
                str[idx] = str[new_size - 1];
                str[new_size-- - 1] = temp;
            }
        }
        return str;
    }

    /**
     * Given a string, write a function to check if it is a permutation of a
     * palindrome. A palindrome is a word or phrase that is the same forwards
     * and backwards. A permutation is a rearrangement of letters. The
     * palindrome does not need to be limited to just dictionary words.
     *
     * Example:
     *  Input:  Tact Coa
     *  Output: True (permutations: "taco cat", "atco cta", etc.)
     *
     * @param str string
     * @return true if string is a permutation of a palindrome
     */
    public boolean palindromePermutation(String str) {
        byte[] chars = new byte[256];
        byte sum = 0;
        for (char c : str.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') 
                chars[c] ^= 1;
        }

        for (char c : str.toCharArray())
            sum += chars[c];
        
        if (sum > 1)
            return false;
        return true;
    }
    public boolean palindromePermutationMax(String str) {
        byte[] chars = new byte[256];
        byte sum = 0;
        for (char c : str.toCharArray())
            chars[c] ^= 1;

        for (char c : str.toCharArray())
            sum += chars[c];
        
        if (sum > 1)
            return false;
        return true;
    }

    /**
     * There are three types of edits that can be performed on strings: insert
     * a character, remove a character, or replace a character. Given two
     * strings, write a function to check if they are one edit (or zero edits) away.
     *
     * Example
     *  pale, ple -> true
     *  pales, pale -> true
     *  pale, bale -> true
     *  pale, bake -> false
     *
     * @param s1 first string
     * @param s2 second string
     * @return
     */
    public boolean oneAway(String s1, String s2) {
        int h1 = 0;
        int t1 = s1.length() -1;
        int h2 = 0;
        int t2 = s2.length() -1;

        while (h1 <= t1 && h2 <= t2) {
           if (s1.charAt(h1) == s2.charAt(h2)) { 
                h1 += 1;
                h2 += 1;
           }
           else 
                break;
        }

        while (h1 <= t1 && h2 <= t2) {
            if (s1.charAt(t1) == s2.charAt(t2)) {
                t1 -= 1;
                t2 -= 1;
            }
            else
                break;
        }

        if (Math.abs(t1 - h1 + t2 - h2) > 1)
            return false;
        return true;
    }

    private void build(StringBuilder s, char c, int count) {
        if (count > 0) {
            s.append(c);
            s.append("" + count);
        }
    }

    /**
     * Implement a method to perform basic string compression using the counts
     * of repeated characters. For example, the string aabcccccaaa would become
     * a2b1c5a3. If the "compressed" string would not become smaller than the
     * original string, your method should return the original string. You can
     * assume the string has only uppercase and lowercase letters (a-z).
     *
     * @param str string
     * @return compressed string
     */
    public String stringCompression(String str) {
        StringBuilder s = new StringBuilder();
        int count = 0;
        char chr = 0;

        for (char c : str.toCharArray()) {
            if (c == chr)
                count++;
            else {
                build(s, chr, count);
                chr = c;
                count = 1;
            }
        }
        build(s, chr, count);

        if (s.length() < str.length()) 
            return s.toString();
        return str;
    }


    private void matrix_swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];

        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }

    private void matrix_rotation(int[][] matrix, int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        matrix_swap(matrix, x1, y1, x2, y2);
        matrix_swap(matrix, x1, y1, x3, y3);
        matrix_swap(matrix, x1, y1, x4, y4);
    }

    private void rotate_matrix(int[][] matrix, int start, int end) {
        if (end - start < 2)
            return;
        
        for (int idx = start; idx < end - 1; idx++) {
            matrix_rotation(matrix, start, idx, idx, end - 1, end - 1, end - 1 - (idx - start), end - 1 - (idx - start), start);
        }

        rotate_matrix(matrix, start + 1, end - 1);
        
    }
    /**
     * Given an image represented by an NxN matrix, where each pixel in the
     * image is 4 bytes, write a method to rotate the image by 90 degrees. Can
     * you do this in place?
     *
     * @param matrix matrix to rotate
     * @return rotated matrix
     */
    public int[][] rotateMatrix(int[][] matrix) {
        rotate_matrix(matrix, 0, matrix.length);
        return matrix;
    }

    /**
     * Write an algorithm such that if an element in an MxN matrix is 0, its
     * entire row and column are set to 0.
     *
     * @param matrix MxN matrix
     * @return zeroed matrix
     */
    public int[][] zeroMatrix(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] cols;

        if (matrix.length == 0)
            return matrix;

        cols = new int[matrix[0].length];
        
        for (int idx = 0; idx < matrix.length; idx++) {
            for (int idy = 0; idy < matrix[0].length; idy++) {
                if (matrix[idx][idy] == 0) {
                    rows[idx] |= 1;
                    cols[idy] |= 1;
                }
            }
        }

        for (int idx = 0; idx < matrix.length; idx++) {
            for (int idy = 0; idy < matrix[0].length; idy++) {
                if (rows[idx] > 0 || cols[idy] > 0)
                    matrix[idx][idy] = 0;
            }
        }

        return matrix;
    }

    /**
     * Assume you have a method isSubstring which checks if one word is a
     * substring of another. Given two strings, s1 and s2, write code to check
     * if s2 is a rotation of s1 using only one call to isSubstring
     * (e.g. "waterbottle" is a rotation of "erbottlewat").
     *
     * @param s1 string 1
     * @param s2 string 2
     * @return true if s1 is a rotation of s2
     */
    public boolean stringRotation(String s1, String s2) {
        return false;
    }

}
