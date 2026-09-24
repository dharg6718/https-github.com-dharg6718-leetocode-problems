class Solution {
    public int smallestIndex(int[] nums) {
        int index = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            int temp=nums[i];
            while(temp>0){
                sum+=temp%10;
                temp=temp/10;
            }
            if(sum == i){
                index = Math.min(i,index);
            }
        }
        return (index==Integer.MAX_VALUE)?-1:index;
    }
}