class Solution {
    public void nextPermutation(int[] nums) {
        int piv = -1;
        int n = nums.length;

        // Step 1: find pivot
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                piv = i;
                break;
            }
        }

        // Step 2: if no pivot
        if (piv == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: find next greater element
        for (int i = n - 1; i > piv; i--) {
            if (nums[i] > nums[piv]) {
                swap(nums, i, piv);
                break;
            }
        }

        // Step 4: reverse suffix
        int i = piv + 1;
        int j = n - 1;

        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}