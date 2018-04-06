package lc.q11.ContainerWithMostWater;
/*
 * 11. Container With Most Water
 * Medium
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, 
 * such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] tc1 = {1,1}; // expected: 1
		int[] tc8 = {0,2}; // expected: 0
		int[] tc10 = {1,2,4,3}; //expected: 4
		System.out.println(maxArea1(tc10));
	}
	
//	76.55%
	public int maxArea2(int[] height) {
        int i = 0, j = height.length - 1;
        int s = i, e = j;
        int max = 0;
        boolean flag = true;
        while (i < j) {
            if (flag && height[i] < height[s]) {
                i ++;
                continue;
            }
            
            if (!flag && height[j] < height[e]) {
                j --;
                continue;
            }
            
            if (height[i] > height[j]) {
                flag = false;
                max = Math.max(height[j] * (j - i), max);
            } else {
                flag = true;
                max = Math.max(height[i] * (j - i), max);
            }
            
            if(flag) s = i ++; else  e = j --;
        }
        return max;
    }
	
//	No need to use DP 22.41%
	public static int maxArea1(int[] height)
	{
		int aIdx = 0;
		int bIdx = height.length-1;
		int max = 0;
		while(aIdx<bIdx)
		{
			int a = height[aIdx];
			int b = height[bIdx];
			int len = Math.min(a, b);
			int h = bIdx-aIdx;
			max = Math.max(max, len*h);
			if(a<b)
			{
				aIdx++;
			}else
			{
				bIdx--;
			}
		}
		return max;
	}
	
//	naive algorithm  TLE failed at test case 46/49 
	public static int maxArea(int[] height) 
	{
		int a = height[0];
		int b = height[1];
		int len = height.length;
		int max = 0;
		for(int i =0;i<len;i++)
		{
			a = height[i];
			for(int j = i+1;j<len;j++)
			{
				b = height[j];
				int area = 0;
				if(a==0 || b==0)
				{
					area = 0;
				}else
				{
					int h = Math.min(a, b);
					area = h*(j-i);
					max = Math.max(max, area);
				}
			}
		}
		return max;
    }
	

}
