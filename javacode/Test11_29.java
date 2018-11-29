/*
  使用for循环打印乘法口诀表 
  递归实现60!
   使用递归实现快速排
 */
public class Test11_29 {
	public static void main(String[] args) 
	{
		jiecheng();
		System.out.println(recursion(3));
		//System.out.println("hello world");
	}
	
	public static int recursion(int n)
	{
		if(n > 1)
		{
			return (n * recursion(n - 1));
		}
		else
		{
			return n;
		}
	}
	
	public static void jiecheng() //使用for循环打印乘法口诀表 
	{
		int a = 1;
		int b = 1;
		for(a = 1; a <= 9; a++)
		{
			for(b = 1; b <= a; b++) 
			{
				System.out.print(b + "*" + a + "=" + a*b + " ");
			}
			System.out.println();
		}
	}
}
