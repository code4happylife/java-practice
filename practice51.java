class Producer implements Runnable
{
	Q q;
	public Producer(Q q)
	{
		this.q = q;
	}
	public void run()
	{
	    int i = 0;
		while(true)
		{
			/*synchronized(q)
			{
				if(q.bFull)
					try{q.wait();}catch(Exception e){}
				if(i==0)
				{
				q.name = "zhangsan";
				try{Thread.sleep(1);}catch(Exception e){}
				q.sex = "male";
				}
				else
				{
				q.name = "lisi";
				q.sex = "female";
				}
				q.bFull = true;
				q.notify();
		    }*/
		    if(i == 0)
		    	q.put("zhangsan","male");
		    else
		    	q.put("lisi","female");
			i = (i+1)%2;
		}
	}
}

class Consumer implements Runnable
{
	Q q;
	public Consumer(Q q)
	{
		this.q = q;

	}
	public void run()
	{
		while(true)
		{
			/*synchronized(q)
			{
				if(!q.bFull)
					try{q.wait();}catch(Exception e){}
				System.out.print(q.name);	
				System.out.println(":"+q.sex);
				q.bFull = false;
				q.notify();
			}	*/
			q.get();
		}
	}

}

class Q
{
	private String name = "unknown";
	private String sex = "unknown";
	private boolean bFull = false;
	public synchronized void put(String name,String sex)
	{
		if(bFull)
			try{wait();}catch(Exception e){}
		this.name = name;
		try{Thread.sleep(1);}catch(Exception e){}
		this.sex = sex;
		bFull = true;
		notify();
	}
	public synchronized void get()
	{
		if(!bFull)
			try{wait();}catch(Exception e){}
		System.out.print(name);	
		System.out.println(":"+sex);
		bFull = false;
		notify();
	}
}

class ThreadCommunication
{
	public static void main (String [] args)
	{
		/*Q q = new Q();
		new Thread(new Producer(q)).start();
		new Thread(new Consumer(q)).start();*/
		ThreadTest tt = new ThreadTest();
		new Thread(tt).start();
		
		for(int i = 0;i<100;i++)
		{
			if(i == 50)
					tt.stopMe();
			System.out.println("main() is running");
		}
	}
}

class ThreadTest implements Runnable
{
	boolean bStop = false;
	public void stopMe()
	{
		bStop = true;
	}
	public void run()
	{
		while(!bStop)
		{
			System.out.println(Thread.currentThread().getName()+"is running");
		}
	}
}
