package com.siso.xueyao.activitylifecycle;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.util.Log;

public class MainActivity extends Activity {
	private static String TAG="LIFECYCLE";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i(TAG, "（1）现在系统调用了onCreate（）方法了！！");
		
		Button button =(Button)findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.i(TAG, "（2）现在系统调用了onStart()方法了！！");
	}
	
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		Log.i(TAG, "（3）现在系统调用了onRestoreInstanceState（）方法了！！");
	}
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(TAG, "（4）现在系统调用了onResume()方法了！！");
	}
	
	
	@Override
	protected void onSaveInstanceState(Bundle SaveInstanceState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(SaveInstanceState);
		Log.i(TAG, "（5）现在系统调用了onSaveInstanceState（）方法了！！");
	}
	
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i(TAG, "（6）现在系统调用了onRestart()方法了！！");
	}
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(TAG, "（7）现在系统调用了onPause()方法了！！");
	}
	
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(TAG, "（8）现在系统调用了onStop()方法了！！");
	}

	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(TAG, "（9）现在系统调用了onDestroy()方法了！！");
	}
}
