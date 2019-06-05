package Temp;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MathA
{	
	
	@Test
	@Parameters({"a1","a2"})
	public void Add(int a, int b)
	{
		int add=a+b;
        System.out.println("Addition:"+add);
        Assert.assertEquals(add, 24);
	}
	
	public void Subtract(int a, int b)
	{
		int sub=a-b;
        System.out.println("Subtraction:"+sub);
	}

	@BeforeTest
	public void beforeeverytestcase()
	{
		System.out.println("this method will trigger before every test dcase");
	}
	public static void main(String[] args) 
	{
		MathA obj=new MathA();
		
		obj.Add(10, 5);
		obj.Subtract(10, 5);
	}
}
