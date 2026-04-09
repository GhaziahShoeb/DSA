class Solution {
    public int[] rearrangeArray(int[] nums) {
        List <Integer> pos = new ArrayList<>();
        List <Integer> neg = new ArrayList<>();

        for(int i =0 ; i<nums.length;i++){
            if(0<nums[i]){
                pos.add(nums[i]);
            }else{
                neg.add(nums[i]);
            }
        }
        for(int i =0;i<nums.length/2;i++){
            nums[2*i] = pos.get(i);
            nums[2*i+1] = neg.get(i);
        }
        return nums;
    }
    public static void main(String[] args){
        int[] A = {1,2,-4,-5};
        int n = A.length;

        Solution obj = new Solution();
        int[] result = obj.rearrangeArray(A);

        for(int num:result){
            System.out.print(num+" ");
        }
    }
}