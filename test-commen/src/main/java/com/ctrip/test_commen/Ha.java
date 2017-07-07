package com.ctrip.test_commen;

/**
 * Hello world!
 *
 */
public class Ha 
{
	private int a=0;
	private int b=0;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b=b;
	}
	
	public int comput(int a,int b)
	{
		this.setA(a);
		this.setB(b);
		return (this.getA()+this.getB());
	}
}
