package stringTest;

public class StringSplitTest {

	public static void main(String[] args) {
		String v1 = "1.11.0";
		String v2 = "1.11.1";
		System.out.println(compare(v1,v2));
	}

	public static boolean compare(String v1, String v2)
	{
		String[] v1Array = v1.split("\\.");
		String[] v2Array = v2.split("\\.");
		int len1 = v1Array.length;
		int len2 = v2Array.length;
		int[] v1Int = new int[len1];
		int[] v2Int = new int[len2];
		boolean flag = false;
		if(len1 != len2)
		{
			System.out.println("Invalid 2 version lengths");
			return flag;
		}
		else
		{
			for(int i =0; i<len1;i++)
			{
				v1Int[i] = Integer.parseInt(v1Array[i]);
				v2Int[i] = Integer.parseInt(v2Array[i]);
				
				if(v1Int[i]<v2Int[i])
				{
					System.out.println("version1 is older than version2");
					return  true;
				}
				else if(v1Int[i]>v2Int[i])
				{
					System.out.println("version1 is newer than version2");
					return false;
				}
				else
					continue;
			}
		}
		System.out.println("These two versions are the same.");
		return true;
	}
}
