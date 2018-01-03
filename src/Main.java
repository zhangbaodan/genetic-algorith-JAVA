

//通过遗传编码求函数最值
public class Main {
	static int n = 500; //迭代次数
	static int per_sum = 500; //每代中总人数
	static int gen_len = 22; //基因长度
	static double max = 99999999;
	static double s = -2; //x的取值左端点
	static double e = 0;//x的取值右端点
	static double fmax = -max;
	static double fmin = max;
	static double pc = 0.6; //交叉概率
	static double pm = 0.01; //突变概率 
	static double ansx;  //最大值点  
	static double ansy;  //最大值
	static double[] x; //十进制编码   
	static double[] fun; //函数值
	static double[] fit; //适应度
	static double fit_sum; //适应总值
	static int[][] per; //每个个体的二级制编码  
	static void genDeal()
	{
		fit = new double[per_sum];
		fun = new double[per_sum];
		x = new double[per_sum];
		for(int i = 0;i<per_sum;i++)//获取十进制编码
			x[i] = Decode.decode(per[i],s,e);
		fmax = -max;
		fmin = max;
		for(int i = 0;i<per_sum;i++)//获取对应函数值
		{
			fun[i] =  Function.getY(x[i]);
			if(fun[i]>fmax)
				fmax = fun[i];
			if(fun[i]<fmin)
				fmin = fun[i];
//			if(fun[i]<0)
//				fun[i] = 0;	
		}
		fit_sum = 0;
		for(int i = 0;i<per_sum;i++)
		{
			fit[i] = (fun[i] - fmin)/(fmax - fmin);
			fit_sum += fit[i];
		}
//		fit_sum = 0;
//		for(int i = 0;i<per_sum;i++)//保证适应度为正值
//		{		
//			fit[i] = fun[i];
//			fit_sum += fit[i];
//			
//		}		
	}
	static void output()
	{
		for(int i = 0;i<per_sum;i++)
		{
			System.out.print("二进制编码：");
			for(int j = 0;j<gen_len;j++)
				System.out.print(per[i][j] +" ");			
			System.out.print("十进制编码: "+x[i] +
					" 函数值： "+ fun[i] + " 适应度： " + fit[i]);
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		per = Encode.encode(per_sum,gen_len); 
		for(int i = 0;i<n;i++)
		{
			genDeal();	
			per = Selection.selection(per, fit, fit_sum);//选择--OK			
			per = Copulation.copulation(per,pc);//交配		
			per = Mutation.mutation(per, pm);//变异	
		}
		double fun_max = -max;
		int ti = 0;
		for(int i = 0;i<per_sum;i++)
		{
			if(fun[i]>fun_max)
			{
				fun_max = fun[i];
				ti = i;
			}
		}
		ansx = x[ti];
		ansy = fun[ti];
		System.out.println();
		System.out.println("最大值点：" + ansx + "最大值：" + ansy);
			
	}

}
