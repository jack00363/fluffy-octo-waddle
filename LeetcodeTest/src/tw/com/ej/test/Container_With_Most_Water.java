package tw.com.ej.test;

import org.junit.Test;

public class Container_With_Most_Water {
//自己寫
	public int maxArea1(int[] height) {
		//總跑次數為 Array項目數*Array項目數/2
		int h = 0;
		for (int i = 0; i < height.length - 1; i++) {
			for (int j = i + 1; j < height.length; j++) {
				h = Math.max(h, Math.min(height[i], height[j]) * (j - i));
			}
		}
		return h;
	}
	
	
	
	//別人寫
	public int maxArea(int[] height) {
		//總跑次數為 height.length 
        int maxWater=0, left=0, right=height.length-1;
		while(left<right) {
			maxWater = Math.max(maxWater,(right-left)*Math.min(height[left], height[right]));
			
			//重點
			if(height[left]<height[right]) left++;
			else right--;
			//重點
		}
		return maxWater;
    }
}
