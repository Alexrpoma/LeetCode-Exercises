import java.util.*;

public class LongestSubstring {
  //Given a string s, find the length of the longest substring without repeating characters.
  //example:
  // s = "abcabcbb"
  // output = 3
  // the answer is "abc", with the length 3

  public static void main(String[] args) {
    String s = "pwwkew";
    //solution(s);
    //solution(s);
    fastSolution(s);
  }

  public static void partialSolution(String s) {
    String[] letters = s.split("");
    System.out.println(Arrays.toString(letters));
    List<String> list = new ArrayList<>();
    List<String> tmp = new ArrayList<>();
    for (String letter : letters) {
      if (!tmp.contains(letter)) {
        tmp.add(letter);
      } else {
        if (tmp.size() > list.size()) {
          list.clear();
          list.addAll(tmp);
        }
        tmp.clear();
        tmp.add(letter);
      }
    }
    System.out.println(list);
    System.out.println("length: " + list.size());
  }

  public static void solution(String s) {
    System.out.println(s);
    int maxLength = 0;
    for (int i = 0; i < s.length(); i++) {
      StringBuilder currentSubString = new StringBuilder();
      for (int j = i; j < s.length(); j++) {
        if (currentSubString.indexOf(String.valueOf(s.charAt(j))) != -1) {
          break;
        }
        currentSubString.append(s.charAt(j));
        maxLength = Math.max(maxLength, currentSubString.length());
      }
      System.out.printf("Array: %s, max length: %d\n", currentSubString, maxLength);
    }
  }

  public static void fastSolution(String s) {
    int maxLength = 0;
    Map<Character, Integer> visitedCharacters = new HashMap<>();
    for (int right = 0, left = 0; right < s.length(); right++) {
      char currentCharacter = s.charAt(right);
      if (visitedCharacters.containsKey(currentCharacter) && visitedCharacters.get(currentCharacter) >= left) {
        left = visitedCharacters.get(currentCharacter) + 1;
      }
      maxLength = Math.max(maxLength, right - left + 1);
      visitedCharacters.put(currentCharacter, right);
    }
    System.out.println(maxLength);
  }
}
