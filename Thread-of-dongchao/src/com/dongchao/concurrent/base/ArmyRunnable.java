package com.dongchao.concurrent.base;

public class ArmyRunnable implements Runnable {

   volatile boolean keepRunning = true;

	public void run() {
		
		// TODO Auto-generated method stub
		while(keepRunning){
			for(int i=0;i<5;i++){
				System.out.println(Thread.currentThread().getName()+"进攻对方["+i+"]");
			
			Thread.yield();
			}
		}
		
		System.out.println(Thread.currentThread().getName()+"结束了战斗");
	}

}
