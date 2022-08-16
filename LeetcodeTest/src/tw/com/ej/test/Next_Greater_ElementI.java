package tw.com.ej.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Next_Greater_ElementI {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        List<Integer> n2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
		for(int i =0;i<nums1.length;i++) {
			int j=n2.indexOf(nums1[i])+1;
			while(j<nums2.length) {
				if(nums2[j]>nums1[i]) {
					nums1[i]=nums2[j];
					break;
				}
				j++;
			}
			if(j==nums2.length)nums1[i]=-1;
		}
        
        
        
        
        return nums1;
    }
}
