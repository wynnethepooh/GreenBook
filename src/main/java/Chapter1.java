
import java.util.HashSet;
import java.util.Set;

public class Chapter1 {

  /**
   * Implement an algorithm to determine if a string has all unique characters.
   * <p>
   * What if you cannot use additional data structures?
   *
   * @param letters string
   * @return true if string has all unique characters
   */
  public boolean isUnique(String letters) {
    Set<Character> uniqueLetters = new HashSet<>();
    for (int i = 0; i < letters.length(); i++) {
      if (uniqueLetters.contains(letters.charAt(i))) {
        return false;
      } else {
        uniqueLetters.add(letters.charAt(i));
      }
    }
    return true;
  }

  public boolean isUniqueNoDataStructures(String letters) {
    for (int i = 0; i < letters.length() - 1; i++) {
      for (int k = i + 1; k < letters.length(); k++) {
        if (letters.charAt(i) == letters.charAt(k)) {
          return false;
        }
      }
    }
    return true;
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
    String sorted1 = sort(s1);
    String sorted2 = sort(s2);

    return sorted1.equals(sorted2);
  }

  private String sort(String s) {
    char[] sorted = s.toCharArray();
    java.util.Arrays.sort(sorted);
    return new String(sorted);
  }

  public boolean checkPermutationByCount(String s1, String s2) {
    int[] letters1 = new int[256];
    int[] letters2 = new int[256];

    if (s1.length() != s2.length()) {
      return false;
    }

    for (int i = 0; i < s1.length(); i++) {
      letters1[s1.charAt(i)]++;
    }
    for (int i = 0; i < s2.length(); i++) {
      letters2[s2.charAt(i)]++;
    }
    for (int i = 0; i < 256; i++) {
      if (letters1[i] != letters2[i]) {
        return false;
      }
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
    int last = str.length - 1; // last updated in URLified
    int curr = len - 1;

    while (last > curr) {
      if (str[curr] != ' ') {
        str[last] = str[curr];
        last--;
        curr--;
      } else {
        str[last] = '0';
        str[--last] = '2';
        str[--last] = '%';
        last--;
        curr--;
      }
    }

    return str;
  }

  /**
   * Given a string, write a function to check if it is a permutation of a
   * palindrome. A palindrome is a word or phrase that is the same forwards
   * and backwards. A permutation is a rearrangement of letters. The
   * palindrome does not need to be limited to just dictionary words.
   * <p>
   * Example:
   * Input:  Tact Coa
   * Output: True (permutations: "taco cat", "atco cta", etc.)
   *
   * @param str string
   * @return true if string is a permutation of a palindrome
   */
  public boolean palindromePermutation(String str) {
    String lowerStr = str.toLowerCase();
    boolean odd = false;

    int z = Character.getNumericValue('z');
    int a = Character.getNumericValue('a');

    int letterCountSize = z - a;
    int[] letterCount = new int[letterCountSize];

    for (int i = 0; i < lowerStr.length(); i++) {
      int numValue = Character.getNumericValue(lowerStr.charAt(i));
      if (numValue <= z && numValue >= a) {
        letterCount[numValue - a]++;
      }
    }

    for (int i = 0; i < letterCount.length; i++) {
      if (letterCount[i] % 2 == 1) {
        if (odd) {
          return false;
        } else {
          odd = true;
        }
      }
    }
    return true;
  }

  /**
   * There are three types of edits that can be performed on strings: insert
   * a character, remove a character, or replace a character. Given two
   * strings, write a function to check if they are one edit (or zero edits) away.
   * <p>
   * Example
   * pale, ple -> true
   * pales, pale -> true
   * pale, bale -> true
   * pale, bake -> false
   *
   * @param s1 first string
   * @param s2 second string
   * @return
   */
  public boolean oneAway(String s1, String s2) {
    int frontEqual = 0, endEqual;

    if (s1.length() - s2.length() > 1 || s1.length() - s2.length() < -1) {
      return false;
    }

    // s1 will always be longer, so swap if it is not
    if (s1.length() < s2.length()) {
      String temp = s1;
      s1 = s2;
      s2 = temp;
    }
    endEqual = s1.length() - 1;

    // Compare fronts of strings
    for (int i = 0; i < s2.length(); i++) {
      if (s1.charAt(i) == s2.charAt(i)) {
        frontEqual = i;
      } else {
        break;
      }
    }

    // Compare ends of strings
    for (int i = s2.length() - 1, k = s1.length() - 1; i >= frontEqual; i--, k--) {
      if (s1.charAt(k) == s2.charAt(i)) {
        endEqual = i;
      } else {
        break;
      }
    }

    if (endEqual - frontEqual > 1) {
      return false;
    } else {
      return true;
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
    int count = 1;
    StringBuilder finalStr = new StringBuilder();

    if (str.length() < 3) {
      return str;
    }

    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) == str.charAt(i - 1)) {
        count++;
      } else {
        finalStr.append(str.charAt(i - 1));
        finalStr.append(count);
        count = 1;
      }
    }
    finalStr.append(str.charAt(str.length() - 1));
    finalStr.append(count);

    return (finalStr.length() >= str.length()) ? str : finalStr.toString();
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
    int len = matrix.length;
    int[][] rotated = new int[len][len];
    int y = len - 1;

    for (int row = 0; row < len; row++) {
      for (int col = 0; col < len; col++) {
        rotated[col][y] = matrix[row][col];
      }
      y--;
    }

    return rotated;
  }

  public void rotateMatrixInPlace(int[][] matrix) {
    int n = matrix.length;

    // Go into each layer of the matrix
    for (int layer = 0; layer < n / 2; layer++) {
      int first = layer;
      int last = (n - 1) - layer;

      for (int i = first; i < last; i++) {
        int offset = i - layer;

        // Save top
        int temp = matrix[first][i];

        // Set top to bottom left
        matrix[first][i] = matrix[last - offset][first];

        // Set bottom left to bottom right
        matrix[last - offset][first] = matrix[last][last - offset];

        // Set bottom right to top right
        matrix[last][last - offset] = matrix[i][last];

        // Set top right to saved top left
        matrix[i][last] = temp;
      }
    }
  }

  /**
   * Write an algorithm such that if an element in an MxN matrix is 0, its
   * entire row and column are set to 0.
   *
   * @param matrix MxN matrix
   */
  public void zeroMatrix(int[][] matrix) {
    Set<Integer> zeros = new HashSet<>();

    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {
        if (matrix[row][col] == 0) {
          zeros.add(row);
          zeros.add(col);
        }
      }
    }

    for (int row = 0; row < matrix.length; row++) {
      for (int col = 0; col < matrix[row].length; col++) {

        if (zeros.contains(row) || zeros.contains(col)) {
          matrix[row][col] = 0;
        }
      }
    }
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
    if (s1.length() == s2.length() && s1.length() > 0) {
      String s1s1 = s1 + s1;
      return isSubstring(s1s1, s2);
    }
    return false;
  }

  /**
   * Checks if s2 is a substring of s1.
   *
   * @param s1 string
   * @param s2 string
   * @return true if s2 is a substring of s1
   */
  private boolean isSubstring(String s1, String s2) {
    return s1.contains(s2);
  }

}
