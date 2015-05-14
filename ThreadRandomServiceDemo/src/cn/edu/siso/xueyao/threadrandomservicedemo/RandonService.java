package cn.edu.siso.xueyao.threadrandomservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class RandonService extends Service {
	 
	private Thread workThread;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Toast.makeText(this, "(1)调用onCreate()", Toast.LENGTH_LONG).show();
		workThread = new Thread(null,backgroundWork,"WorkThread");
	}
	
	@Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		Toast.makeText(this, "(2)调用onStart()", Toast.LENGTH_LONG).show();
		if(!workThread.isAlive())
		{
			workThread.start();
		}
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Toast.makeText(this, "(3)调用onDestroy()", Toast.LENGTH_LONG).show();
		workThread.interrupt();
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	private Runnable backgroundWork = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
				try {
					while (!Thread.interrupted()) {
						double randomDouble = Math.random();
						MainActivity.UpdateGUI(randomDouble);
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO: handle exception
					
				}
		}
	};
	

	
	

}
