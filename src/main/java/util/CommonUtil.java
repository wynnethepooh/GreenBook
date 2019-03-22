package util;

public class CommonUtil {

  /**
   * Checks if s2 is a substring of s1.
   *
   * @param s1 string
   * @param s2 string
   * @return true if s2 is a substring of s1
   */
  public boolean isSubstring(String s1, String s2) {
    return s1.contains(s2);
  }
}
