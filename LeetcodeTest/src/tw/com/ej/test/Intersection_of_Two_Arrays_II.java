package tw.com.ej.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection_of_Two_Arrays_II {
	public int[] intersect(int[] nums1, int[] nums2) {
        int[] map = new int[1001];
        for(int num : nums2){
            map[num]++;
        }
        int ans[] = new int[nums1.length + nums2.length];
        int i = 0;
        for(int num : nums1){
            if(map[num]>0){
                map[num]--;
                ans[i++] = num;
            }
        }
        return Arrays.copyOf(ans, i);
    }
	
	
	
	public int[] intersect_EJ(int[] nums1, int[] nums2) {
		List<Integer> l = new ArrayList<Integer>();
        Arrays.sort(nums1);
		for(int i=0;i<nums2.length;i++) {
			if(Arrays.binarySearch(nums1, nums2[i])>=0) {
				l.add(nums2[i]);
				nums1[Arrays.binarySearch(nums1, nums2[i])] = -1;
                Arrays.sort(nums1);
			}
            
		}
		nums1 =new int[l.size()];
		
		for(int j=0;j<l.size();j++) nums1[j]=l.get(j);
		return nums1;
	}
}
