package com.example.planegame;

import android.os.Bundle;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

	private int speed =10;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		final PlaneView planeView = new PlaneView(this);
		setContentView(planeView);
		
		WindowManager windowManager = getWindowManager();
		Display display = windowManager.getDefaultDisplay();
		DisplayMetrics metrics = new DisplayMetrics();
		display.getMetrics(metrics);
		
		planeView.currentX = metrics.widthPixels/2;
		planeView.currentY = metrics.heightPixels-40;
		
		planeView.setOnKeyListener(new OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				switch (event.getKeyCode()) {
				case KeyEvent.KEYCODE_S:
					planeView.currentY += speed;
					break;

				case KeyEvent.KEYCODE_W:
					planeView.currentY -= speed;				
					break;
				case KeyEvent.KEYCODE_A:
					planeView.currentX += speed;
					break;
				case KeyEvent.KEYCODE_D:
					planeView.currentX -= speed;
					break;
				}
				planeView.invalidate();
				return true;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
