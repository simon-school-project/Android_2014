package com.example.handler;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.text.format.Time;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	int [] imageIds = new int[]{
			R.drawable.a,
			R.drawable.b,
			R.drawable.c,
			R.drawable.d,
	};
	int currentImageId =0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final ImageView show = (ImageView)findViewById(R.id.imageView1);
		final Handler handler = new Handler(){

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				if (msg.what==0x1233) {
					show.setImageResource(imageIds[currentImageId++%imageIds.length]);
				}
			}
			
		};
		
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				handler.sendEmptyMessage(0x1233);
			}
		},0,1200);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
