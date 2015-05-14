package cn.edu.siso.xueyao.simplerandomservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class RandomService extends Service {
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Toast.makeText(this, "(1)调用onCreate()", Toast.LENGTH_LONG).show();
	}

	

	@Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		Toast.makeText(this, "(2)调用onStart()", Toast.LENGTH_LONG).show();
		double RandomSum = Math.random();
		String string  = "随机数："+String.valueOf(RandomSum);
		Toast.makeText(this, string, Toast.LENGTH_LONG).show();
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Toast.makeText(this, "(3)调用onDestroy()", Toast.LENGTH_LONG).show();
	}
	
	
	
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	

	/**
	 * @param args
	 */
	
}
