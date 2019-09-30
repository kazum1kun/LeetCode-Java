import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> twoSumResult = twoSum(nums, 0 - nums[i], i);
            if (!twoSumResult.isEmpty()) {
                for (List<Integer> sublist : twoSumResult) {
                    ArrayList<Integer> integers = new ArrayList<>();
                    integers.add(nums[i]);
                    integers.add(sublist.get(0));
                    integers.add(sublist.get(1));
                    Collections.sort(integers);
                    result.add(integers);
                }
            }
        }

        List<List<Integer>> ar = new ArrayList<>();
        for (List<Integer> list : result) {
            List<Integer> a = new ArrayList<>(list);
            ar.add(a);
        }

        return ar;
    }


    public List<List<Integer>> twoSum(int[] nums, int target, int skip) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i == skip) continue;

            if (map.containsKey(target - nums[i])) {
                List<Integer> subResult = new ArrayList<>();
                subResult.add(target - nums[i]);
                subResult.add(nums[i]);
                result.add(subResult);
            } else {
                map.put(nums[i], i);
            }


        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        List<List<Integer>> result = ts.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        ts.printArray(result);
    }

    private void printArray(List<List<Integer>> list) {
        for (List<Integer> subList : list) {
            for (int i : subList) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
