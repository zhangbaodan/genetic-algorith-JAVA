
public class Mutation {
	static int gen_len;
	static int per_sum;
	static int mpoint;
	static int[][] mutation(int[][] per,double pm)
	{
		gen_len = per[0].length;
		per_sum = per.length;
		for(int i = 0;i<per_sum;i++)
		{
			double x =(double)(Math.random()*1);
			
			if(x < pm)
			{
				mpoint = (int)(Math.random()*gen_len);			
				if(per[i][mpoint]==0)
					per[i][mpoint] = 1;
				else
					per[i][mpoint] = 0;

			}
		}
		return per;
	}
}
