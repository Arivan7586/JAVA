/*
  ʹ��forѭ����ӡ�˷��ھ��� 
  �ݹ�ʵ��60!
   ʹ�õݹ�ʵ�ֿ�����
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
	
	public static void jiecheng() //ʹ��forѭ����ӡ�˷��ھ��� 
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
