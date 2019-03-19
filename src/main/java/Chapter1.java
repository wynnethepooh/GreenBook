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

    public boolean is_pow_2(long value) {
        if (value == 2) 
            return true;
        if ((value < 2) || (value % 2 == 1))
            return false;
        return is_pow_2(value / 2);
    }
    /**
     * Given a string, write a function to check if it is a permutation of a
     * palindrome. A palindrome is a word or phrase that is the same forwards
     * and backwards. A permutation is a rearrangement of letters. The
     * palindrome does not need to be limited to just dictionary words.
     *
     * @param str string
     * @return true if string is a permutation of a palindrome
     */
    public boolean palindromePermutation(String str) {
        long[] chars = new long[4];
        boolean freeby = true;

        for (char c : str.toCharArray()) 
            chars[c/64] ^= ((long)1 << c%64);

        for (int idx = 0; idx < chars.length; idx++) {
            if (chars[idx] != 0) {
                if (freeby) {
                    if (!is_pow_2(chars[idx]))
                        return false;
                    freeby = false;
                }
                return false;
            }
        }
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
        return false;
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
        return null;
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
        return null;
    }

    /**
     * Write an algorithm such that if an element in an MxN matrix is 0, its
     * entire row and column are set to 0.
     *
     * @param matrix MxN matrix
     * @return zeroed matrix
     */
    public int[][] zeroMatrix(int[][] matrix) {
        return null;
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
