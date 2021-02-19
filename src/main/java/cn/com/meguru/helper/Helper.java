package cn.com.meguru.helper;

public class Helper {
    public void swapChar(char[] chars, int i, int j) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    public void swapInt(int[] nums, int i, int j) {
        int c = nums[i];
        nums[i] = nums[j];
        nums[j] = c;
    }

    /**
     * 基于nums[workStart]进行partition
     */
    private int partition(int[] nums, int workStart, int workEnd) {
        if (workStart == workEnd) {
            return workStart;
        }
        int next = workStart + 1;
        if (nums[workStart] <= nums[next]) {
            swapInt(nums, next, workEnd);
            workEnd = workEnd - 1;
        } else {
            swapInt(nums, workStart, next);
            workStart = workStart + 1;
        }
        return partition(nums, workStart, workEnd);
    }
}
