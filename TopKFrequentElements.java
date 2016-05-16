/*
 Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note:

    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

*/

import java.util.*;

public class TopKFrequentElements {
	public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!hp.containsKey(nums[i])){
                hp.put(nums[i], 1);
            }else{
                hp.put(nums[i], hp.get(nums[i])+1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        pq.addAll(hp.entrySet());
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < k; i++){
            res.add(pq.poll().getKey());
        }
        return res;
    }

	public static void main(String[] args) {
		int[] nums = new int[] {1,1,3,3,2,2,2,2,4,4,4,4,5,6,6,7};
		int val = 3;
		for(int i=0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		List<Integer> res = topKFrequent(nums, val);
		System.out.println();
        System.out.println("Top " + val + " elements: " + res);
		return;
	}	
}
