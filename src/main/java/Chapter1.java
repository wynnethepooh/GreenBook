import java.util.HashMap;
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

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < letters.length(); i++) {
            if (map.containsKey(letters.charAt(i))) {
                return false;
            } else {
                map.put(letters.charAt(i), 1);
            }
        }

        return true;
    }

    public boolean isUniqueNoDataStructures(String letters) {
        return false;
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
        return false;
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
        return null;
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
        return false;
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

}
