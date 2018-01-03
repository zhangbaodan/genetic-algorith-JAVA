//交配
public class Copulation {
	static int gen_len;
	static int per_sum;
	static int cpoint;
	static int[] temp_per;
	static int[][] copulation(int[][] per,double pc)
	{
		
		gen_len = per[0].length;
		per_sum = per.length;
		temp_per = new int[gen_len];
		for(int i = 0;i<per_sum-1;i++)
		{
			
			double x =(double)(Math.random()*1);
			if(x < pc)//发生交配--和后一个交配
			{
				cpoint = (int)(Math.random()*gen_len);
				for(int j =0;j<cpoint;j++)
					temp_per[j] = per[i][j];
				for(int j = 0;j<cpoint;j++)
					per[i][j] = per[i+1][j];
				for(int j = 0;j<cpoint;j++)
					per[i+1][j] = temp_per[j];

			}
		}
		return per;
	}
}
