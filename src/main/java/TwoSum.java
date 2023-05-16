import java.util.*;
import java.util.stream.IntStream;

public class TwoSum {

  public static void main(String[] args) {
    List<Integer> numbers = List.of(2, 7, 11, 15);
    int[] nums = {2, 7, 11, 15};
    int target = 13;
    List<Integer> result0 = twoSumList(numbers, target);
    int[] result1 = twoSum(nums, target);
    int[] resultFast = twoSumFast(nums, target);

    System.out.println(result0);
    System.out.println(Arrays.toString(result1));
    System.out.println(Arrays.toString(resultFast));
    tmp(nums);
  }

  public static List<Integer> twoSumList(List<Integer> numbers, int target) {
    List<Integer> result = new ArrayList<>();
    IntStream.range(0, numbers.size()).forEach(item -> {
      IntStream.range(item + 1, numbers.size()).forEach(i -> {
        if(numbers.get(item) + numbers.get(i) == target && item != i) {
          result.add(item);
          result.add(i);
        }
      });
    });
    return result;
  }

  public static int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    IntStream.range(0, nums.length).forEach(item0 -> {
      IntStream.range(item0 + 1, nums.length).forEach(item1 -> {
        if(nums[item0] + nums[item1] == target && item0 != item1) {
          result[0] = item0;
          result[1] = item1;
        }
      });
    });
    return result;
  }

  public static int[] twoSumFast(int[] nums, int target) {
    Map<Integer, Integer> complements = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      Integer complementIndex = complements.get(nums[i]);
      if (complementIndex != null) {
        return new int[]{i, complementIndex};
      }
      complements.put(target - nums[i], i);
    }
    return nums;
  }

  public static void tmp(int[] nums) {
    IntStream result = Arrays.stream(nums).filter(i -> i > 2);
    List<Integer> list = result.boxed().toList();
    int[] array = Arrays.stream(nums).filter(i -> i > 2).toArray();
    System.out.println(list);
    System.out.println(Arrays.toString(array));
  }

}
