package com.example.progressdialog;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.R.integer;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	final static int MAX_PROGRESS = 100;
	private int[] data = new int[50];
	int progressStatus = 0;
	int hasData = 0;
	ProgressDialog pd1,pd2;
	
	private Button showSpinner ,showIndeterminate,showProgress;
	Handler handler = new Handler(){
		public void handleMessage(Message msg) 
		{
			if (msg.what == 0x123) {
				pd2.setProgress(progressStatus);
			}
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		showSpinner = (Button)findViewById(R.id.button1);
		showIndeterminate = (Button)findViewById(R.id.button2);
		showProgress = (Button)findViewById(R.id.button3);
		
		showSpinner.setOnClickListener(this);
		showIndeterminate.setOnClickListener(this);
		showProgress.setOnClickListener(this);
	}
	

	public int doWork() {
		// TODO Auto-generated method stub
		data[hasData++] = (int)(Math.random()*100);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return hasData;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:
			ProgressDialog.show(this, "任务执行中", 
					"任务执行中，请稍等",false,true);
			break;

		case R.id.button2:
			pd1 = new ProgressDialog(MainActivity.this);
			pd1.setTitle("任务正在执行中");
			pd1.setMessage("任务执行中，请稍等");
			pd1.setCancelable(true);
			pd1.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			pd1.setIndeterminate(true);
			pd1.show();
			break;
		case R.id.button3:
			progressStatus = 0;
			hasData = 0;
			pd2 = new ProgressDialog(MainActivity.this);
			pd2.setMax(MAX_PROGRESS);
			pd2.setTitle("任务完成百分比");
			pd2.setMessage("耗时任务的完成百分比");
			pd2.setCancelable(false);
			pd2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			pd2.setIndeterminate(false);
			pd2.show();
			
			new Thread(){

				@Override
				public void run() {
					// TODO Auto-generated method stub
					while(progressStatus<MAX_PROGRESS){
						progressStatus = MAX_PROGRESS*doWork()/data.length;
						handler.sendEmptyMessage(0x123);
					}
					
					if (progressStatus >= MAX_PROGRESS) {
						pd2.dismiss();
					}
				}

				
				
			}.start();
			break;
		}
	}

}
