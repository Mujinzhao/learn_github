package com.ctrip.test_all;

import java.util.ArrayList;
import java.util.HashMap;

public class App_two
{
	private int sum;
	private int count;
	
	App_two()
	{
	}
	App_two(int a,int b)
	{
		this.sum=a;
		this.count=b;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public void add(App_two temp)
	{
		this.count+=temp.getCount();
		this.sum+=temp.getSum();
	}
	@Override
	public String toString() {
		return "MetricValue [sum=" + sum + ", count=" + count + "]";
	}
}
