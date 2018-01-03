//二进制转十进制--解码
public class Decode {
	static double decode(int[] per,double s,double e)
	{
		int d = 1;
		double ans = 0;
		for(int i = per.length-1;i>=0;i--)
		{
			ans += per[i] * d;
			d = d*2;
		}
		ans =  s + ans * (e - s) / (d - 1);
		return ans;
	}
}
