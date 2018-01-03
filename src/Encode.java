//编码--初始化二进制基因序列
public class Encode{
	static int getSinGen() //获取单个的基因
	{
		int x=(int)(Math.random()*100);
		if(x<50)
			return 1;
		else
			return 0;
	}
	static int[][] encode(int sum,int length)
	{
		int zero= 0,one = 0;
		int[][] per = new int[sum][length];
		for(int i = 0;i<sum;i++)
		{
			for(int j = 0 ;j<length;j++)
			{
				
				per[i][j] = getSinGen();
				if(per[i][j] == 1)
					one++;
				else
					zero++;
			}
		}
		System.out.println("zero: "+ 1.0*zero/(zero+one)+ "one: "+1.0*one/(one+zero));
		return per; 
	}
}
