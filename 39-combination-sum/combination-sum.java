class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        trackme(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }

    private void trackme(List<List<Integer>> list, List<Integer> tempList,
                         int[] nums, int target, int start) {

        if (target < 0) return;

        else if (target == 0) {
            list.add(new ArrayList<>(tempList));
        }

        else {
            for (int i = start; i < nums.length; i++) {
                tempList.add(nums[i]);
                trackme(list, tempList, nums, target - nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
