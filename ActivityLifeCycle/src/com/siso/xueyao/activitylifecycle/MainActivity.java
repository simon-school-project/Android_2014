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
		Log.i(TAG, "��1������ϵͳ������onCreate���������ˣ���");
		
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
		Log.i(TAG, "��2������ϵͳ������onStart()�����ˣ���");
	}
	
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		Log.i(TAG, "��3������ϵͳ������onRestoreInstanceState���������ˣ���");
	}
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i(TAG, "��4������ϵͳ������onResume()�����ˣ���");
	}
	
	
	@Override
	protected void onSaveInstanceState(Bundle SaveInstanceState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(SaveInstanceState);
		Log.i(TAG, "��5������ϵͳ������onSaveInstanceState���������ˣ���");
	}
	
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.i(TAG, "��6������ϵͳ������onRestart()�����ˣ���");
	}
	
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i(TAG, "��7������ϵͳ������onPause()�����ˣ���");
	}
	
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i(TAG, "��8������ϵͳ������onStop()�����ˣ���");
	}

	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i(TAG, "��9������ϵͳ������onDestroy()�����ˣ���");
	}
}
