package tw.com.ej.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

public class Three_Sum {
	@Test
	public void aa() {
		int[] uuuu = {-1,0,1,2,-1,-4};
		System.out.println(threeSum(uuuu));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> aa = new ArrayList<List<Integer>>();
		if (nums.length < 3)return aa;
		Set<List<Integer>> answer = new HashSet<List<Integer>>();
		Arrays.sort(nums);
		
		for(int i=0,len=nums.length;i<len-2;i++) {
			for (int j=i+1;j<len-1;j++) {
				for(int k=j+1 ;k<len;k++) {
					if(nums[i]+nums[j]+nums[k]==0) {answer.add(Arrays.asList(nums[i],nums[j],nums[k]));}
				}
			}
		}
		
		aa.addAll(answer);
		return aa;
	}
}
