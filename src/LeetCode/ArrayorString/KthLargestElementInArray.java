package LeetCode.ArrayorString;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
        kthLargestElementInArray.findKthLargest(nums,k);
    }
    public int findKthLargest(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);

            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
