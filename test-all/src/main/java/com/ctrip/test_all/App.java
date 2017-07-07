package com.ctrip.test_all;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import com.ctrip.test_commen.*;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import java.util.function.Function;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	MongoClient mongo;
    	ServerAddress addr = new ServerAddress("localhost",27017);
		String database = "test";//p.getProperty("db");//db:Metric
		String username = null;//;p.getProperty("username");
		String password = null;//p.getProperty("password");
		if (username == null || password == null) {
			mongo = new MongoClient(addr);
			System.out.println("MongoDB has Build");
		} else {
			mongo = new MongoClient(addr, Collections.singletonList(MongoCredential.
					createMongoCRCredential(username, database, password.toCharArray())));
		}
		DB db = mongo.getDB(database);
//		DBCollection collection=db.getCollection("Hotel.Offline.Service.Site_Wcf_Call");
//		DBCursor cursor=collection.find();
//		while(cursor.hasNext())
//		{
//			DBObject document=cursor.next();
//			System.out.println(document.get("Service_Action"));
//		}
		ScheduledThreadPoolExecutor timer=new ScheduledThreadPoolExecutor(2);
		long start=System.currentTimeMillis();
		AtomicInteger CurrentTime=new AtomicInteger((int)(start/1000/60));
		
		System.out.println("CurrentTime is "+CurrentTime);
		
		int testtime=5*65;
		String [][]tags=new String[4][];
		tags[0] = new String[4];//remote_addrees
		tags[0][0]="203.186.61.186";tags[0][1]="223.255.137.66";tags[0][2]="14.136.236.130";tags[0][3]="125.215.174.61";
		tags[1] = new String[6];//Service_Action
		tags[1][0]="SubmitHotelOrder";
		tags[1][1]="SearchLocation";
		tags[1][2]="GetHotelOrderDetail";
		tags[1][3]="GetHotelInfo";
		tags[1][4]="InsertHotelOrderLog";
		tags[1][5]="SearchHotelFormember2";
		tags[2] = new String[6];//Service_name
		tags[2][0]="HotelRestService";
		tags[2][1]="HotelOfflineBookingService";
		tags[2][2]="HotelBasicInfoService";
		tags[2][3]="HotelForOutService";
		tags[2][4]="HotelOrderService";
		tags[2][5]="HotelOfflineMailService";
		tags[3] = new String[3];//Service_IP
		tags[3][0]="172.21.101.126";
		tags[3][1]="172.21.201.196";
		tags[3][2]="172.21.201.197";
//		System.out.println( "last year is "+5*65);
		
		//    325 mintues
		//    325*100=32500
		//    32500*100=3250000
		
		//65天  93600 minutes
    
    	Runnable minuteJob=RunnableUntil.wrap(()->{
		
		int i,j,k;
//		for(i=0;i<30;i++){
    		int _minute=0;//RunnableUntil.add();
    		_minute=((int)(System.currentTimeMillis()/1000/60));
    		for(j=0;j<=30;j++){
		    		int _max=1;//(int)Math.abs(Math.random()*100);
		        	int _min=1;//(int)Math.abs(Math.random()*50);
		        	int _avg=1;//(int)Math.abs(Math.random()*50);
		        	int _count=1;//(int)Math.abs(Math.random()*50);
		        	int _sum=1;//(int)Math.abs(Math.random()*80);
		        	int _std=1;//(int)Math.abs(Math.random()*70);
		        	//生成随机的数值
		        	int num0=(int)Math.abs((Math.random()*50)%4);
		        	int num1=(int)Math.abs((Math.random()*50)%6);//5 5 5 3 2 2 3 1
		        	int num2=(int)Math.abs((Math.random()*100)%6);
		        	int num3=(int)Math.abs((Math.random()*50)%3);
		        	BasicDBObject Insert=new BasicDBObject();
		        	Insert.put("_sum", _sum);
		        	Insert.put("_avg", _avg);
		        	Insert.put("_max", _max);
		        	Insert.put("_min",_min);
		        	Insert.put("_count", _count);
		        	Insert.put("_std", _std);
		        	Insert.put("_minute", _minute);
		        	Insert.put("Service_Action", tags[1][num1]);
		        	Insert.put("Service_Name", tags[2][num2]);
		        	Insert.put("remote_addr", tags[0][num0]);
		        	Insert.put("Service_IP", tags[3][num3]);
//		        	System.out.println("_Minute= "+_minute+"Max="+_max+" Min="+_min+" Avg="+_avg+" Count="+_count+" Sum="+_sum+" Std="+_std);
	//	        	System.out.println();
		    		db.getCollection("Hotel.Offline.Service.Site_Wcf_Call").insert(Insert);
    		}
		
//			System.out.println("RunnableUntil.Int= " +RunnableUntil.falseadd());
	});
    timer.scheduleAtFixedRate(minuteJob, 0,60000, TimeUnit.MILLISECONDS);
    }
    //每隔两分钟 执行一次
    	//db.getCollection("Hotel.Offline.Service.Site_Wcf_Call").insert(Insert);
    	//System.out.println("Max="+_max+" Min="+_min+" Avg="+_avg+" Count="+_count+" Sum="+_sum+" Std="+_std);
    	
    
    
//    int i,j,k;
//    Runnable qutureJob=RunnableUntil.wrap(()->{
//		for(k=0;k<114;k++){
////		RunnableUntil.setInt(-10000/15);
////		for(i=0;i<10000;i++){
//			int _quarter=0;//RunnableUntil.add();
//			_quarter=(int)(System.currentTimeMillis()/1000/60/15)-5760;
//			for(j=0;j<=5760;j++){
//	    		int _max=1;//(int)Math.abs(Math.random()*100);
//	        	int _min=1;//(int)Math.abs(Math.random()*50);
//	        	int _avg=1;//(int)Math.abs(Math.random()*50);
//	        	int _count=1;//(int)Math.abs(Math.random()*50);
//	        	int _sum=1;//(int)Math.abs(Math.random()*80);
//	        	int _std=1;//(int)Math.abs(Math.random()*70);
//	        	//生成随机的数值
//	        	int num0=(int)Math.abs((Math.random()*50)%4);
//	        	int num1=(int)Math.abs((Math.random()*50)%6);//5 5 5 3 2 2 3 1
//	        	int num2=(int)Math.abs((Math.random()*100)%6);
//	        	int num3=(int)Math.abs((Math.random()*50)%3);
//	        	BasicDBObject Insert=new BasicDBObject();
//	        	Insert.put("_sum", _sum);
//	        	Insert.put("_avg", _avg);
//	        	Insert.put("_max", _max);
//	        	Insert.put("_min",_min);
//	        	Insert.put("_count", _count);
//	        	Insert.put("_std", _std);
//	        	Insert.put("_quarter", _quarter+j);
//	        	Insert.put("Service_Action", tags[1][num1]);
//	        	Insert.put("Service_Name", tags[2][num2]);
//	        	Insert.put("remote_addr", tags[0][num0]);
//	        	Insert.put("Service_IP", tags[3][num3]);
////		        	System.out.println("_quarter= "+_quarter+"Max="+_max+" Min="+_min+" Avg="+_avg+" Count="+_count+" Sum="+_sum+" Std="+_std);
//	//	        	System.out.println();
//		    		db.getCollection("_quarter.Hotel.Offline.Service.Site_Wcf_Call").insert(Insert);
//			}
//		}
//    }
////    });
//    
////    timer.scheduleAtFixedRate(qutureJob, 0,60000*13, TimeUnit.MILLISECONDS);
//    }
}
