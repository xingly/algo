package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * 三数之和
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        int len = nums.length;
        if (nums == null || len < 3) {
            return ret;
        }
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 若当前元素大于0，则三数之和一定大于0
            if (nums[i] > 0) break;
            // 排重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ret.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum > 0) {
                    left++;
                } else if (sum < 0) {
                    right++;
                }
            }
        }
        return ret;
    }

    /**
     * 求数组中众数
     *
     * @param nums
     * @return
     */
    public static Integer majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int count = 0;
        int candidate = nums[0];
        // 匹配阶段
        for (int num : nums) {
            if (candidate == num) {
                count++;
                continue;
            }
            if (count == 0) {
                candidate = num;
                count++;
                continue;
            }
            count--;
        }

        // 计数阶段
        count = 0;
        for (int num : nums) {
            if (candidate == num) {
                count++;
            }
        }
        if (count > nums.length / 2) return candidate;

        return null;
    }


    public static void main(String[] args) {
        // test three sum
        int[] nums = {3, 1, -2, -4, 6};
        List<List<Integer>> list = threeSum(nums);
        list.forEach(e -> {
            System.out.println(e.toString());
        });

        // 众数
        int[] nums2 = {1, 1, 2, 2, 3, 2, 2, 2};
        System.out.println(majorityElement(nums2));
    }
}