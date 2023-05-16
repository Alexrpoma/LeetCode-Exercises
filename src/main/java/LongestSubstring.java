import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestSubstring {
  //Given a string s, find the length of the longest substring without repeating characters.
  //example:
  // s = "abcabcbb"
  // output = 3
  // the answer is "abc", with the length 3

  public static void main(String[] args) {
    String s = "abcabcbb";
    solution(s);
  }

  public static void solution(String s) {
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
}
