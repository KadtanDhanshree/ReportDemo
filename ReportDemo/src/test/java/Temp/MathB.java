package Temp;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MathB 
{
	@Test
	@Parameters({"m1","m2"})
	public void multiplication(int a, int b)
	{
		int mul=a*b;
        System.out.println("Multiplication: "+mul);
        Assert.assertEquals(mul, 100);
	}
		
	public void Division(int a, int b)
	{
		int div=a/b;
        System.out.println("Division: "+div);
	}
	
	
	public static void main(String[] args) 
	{
		MathB obj=new MathB();
		
	obj.multiplication(10, 5);
	obj.Division(10, 5);
	}
	
}
