//挑选优秀的小朋友
public class Selection {
	static int [][] per_new;
	static double[] fit_percent;
	static int[][] selection(int[][] per,double[] fit,double fit_sum)
	{

		fit_percent = new double[per.length];
		for(int i = 0;i<per.length;i++)
			fit_percent[i] = fit[i]/fit_sum;
		for(int i = 1;i<per.length;i++)
			fit_percent[i] += fit_percent[i-1];
		per_new = new int[per.length][per[0].length];
		int k = 0;
		while(k<per.length)
		{
			double  x = (double)(Math.random()*1);
			if(x<fit_percent[0])
				per_new[k++] = per[0];
			else
			{
				int flag = 0;
				for(int j = 1;j<per.length;j++)
				{
					if(x<fit_percent[j]&&fit[j]!=0)
					{
						flag = 1;
						for(int l = 0;l<per[j].length;l++)
							per_new[k][l] = per[j][l];
						k++;
						break;
					}
				}
				if(flag == 0)
				{
					per_new[k++] = per[0];
				}
			}
		}
		return per_new;
	}
}
