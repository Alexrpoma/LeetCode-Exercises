
public class ReverseInteger {
  public static void main(String[] args) {
    int res = reverse(1534236469);
    System.out.println(res);
  }

  public static int reverse(int x) {
    int rest = 0;
    boolean isNegative = x < 0;
    x = Math.abs(x);
    while (x > 0) {
      int module = x % 10;
      long tmp = rest * 10L + module;
      if (tmp <= Integer.MIN_VALUE || tmp >= Integer.MAX_VALUE) {
        return 0;
      }
      rest = rest * 10 + module;
      x = x / 10;
    }
    return isNegative? rest * -1 : rest;
  }
}
