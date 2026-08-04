class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            int curr = nums[i];
            int next = nums[i+1];

            for(int j=curr+1;j<next;j++){
                result.add(j);
            }
        }
        return result;
    }
}