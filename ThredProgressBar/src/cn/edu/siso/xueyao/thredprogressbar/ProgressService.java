package cn.edu.siso.xueyao.thredprogressbar;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class ProgressService extends Service {
	private Thread wordThread;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Toast.makeText(this, "调用onCreat()", Toast.LENGTH_LONG).show();
	}

	@Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		Toast.makeText(this, "调用onStart()", Toast.LENGTH_LONG).show();
		wordThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					while (!Thread.interrupted()) {
						int scount= 0;
						for (int i = 0; i <=100; i++) {
							scount++;
							MainActivity.UpdateGUI(scount);
							Thread.sleep(100);
						}
						
					}
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		
		if (!wordThread.isAlive()) {
			wordThread.start();
		}
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Toast.makeText(this, "调用onDestroy()", Toast.LENGTH_LONG).show();
		wordThread.interrupt();
	}
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	
}
