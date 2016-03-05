class ThreadDemo1
{
	public static void main(String [] args)
	{
		//new Thread().start();
		//Thread tt = new TestThread();//run();
		//tt.setDaemon(true);
		/*Thread tt = new Thread(new TestThread());
		tt.start();//run();
		int index = 0;
		while(true)
		{
			if(index ++ == 100)
				try{tt.join(10000);}catch(Exception e){}
			System.out.println("main(): "+ Thread.currentThread().getName());
		}*/
		TestThread tt = new TestThread();
	    /*tt.start();
	    tt.start();
	    tt.start();
	    tt.start();*/
	    new Thread(tt).start();
	    try{Thread.sleep(1);}catch(Exception e){}
	    tt.str = new String("method");
	    new Thread(tt).start();
	    /*new Thread(tt).start();
	    new Thread(tt).start();
*/

	    /*while(!bStop)
	    {
	    	get
	    	copy
	    }

	    bStop = true*/
	}
}

/*public void push(char c)
{
	data[index]=c;
	
	index++;
}*/



class TestThread implements Runnable //extends Thread
{
	int tickets =1000;
	String str = new String("");
	public void run()
	{
	if(str.equals("method"))
	{	
		while(true)
		{
			sale();
		}
	}
	else
	{
		while(true)
		{
			synchronized(str)
			{
				if(tickets > 0)
				{
				try{Thread.sleep(10);}catch(Exception e){}	
				synchronized(this){}
				System.out.println(Thread.currentThread().getName() +" is selling ticket" + tickets --);
				}
		    }
		}
	}
		
	}

	public synchronized void sale()
	{

				if(tickets > 0)
				{
				try{Thread.sleep(10);}catch(Exception e){}
				synchronized(str){}
				System.out.println("sale(): ");					
				System.out.println(Thread.currentThread().getName() +" is selling ticket" + tickets --);
				}
		    
	}
}
