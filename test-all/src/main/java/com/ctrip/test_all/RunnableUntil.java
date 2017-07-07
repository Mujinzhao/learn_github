package com.ctrip.test_all;

import java.util.concurrent.atomic.AtomicInteger;

public class RunnableUntil {
	
	private static AtomicInteger ThreadInt=new AtomicInteger(0);
	
	private static int NoInt=0;
	
	public static void setInt(int setNum)
	{
		ThreadInt.set(setNum);
	}
	
	public static int getInt()
	{
		return ThreadInt.get();
	}
	
	public static int add()
	{
		return ThreadInt.incrementAndGet();
	}
	
	public static int falseadd()
	{
		return NoInt++;
	}
	
	public static Runnable wrap(Runnable temp)
	{
		return () -> {
			temp.run();
		};
	}

}
