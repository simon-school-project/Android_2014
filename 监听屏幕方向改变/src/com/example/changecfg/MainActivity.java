package com.example.changecfg;

import android.os.Bundle;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private  Button bnButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bnButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Configuration config = getResources().getConfiguration();
				
				if (config.orientation==Configuration.ORIENTATION_LANDSCAPE) {
					MainActivity.this.setRequestedOrientation(
							ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
					
				}
				if (config.orientation==Configuration.ORIENTATION_LANDSCAPE) {
					MainActivity.this.setRequestedOrientation(
							ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		String screen = newConfig.orientation==
				Configuration.ORIENTATION_LANDSCAPE?
						"横向屏幕":"竖向屏幕";
		Toast.makeText(this, "系统的屏幕方向发生改变"+"\n修改后的屏幕方向为："+screen, 1000).show();
	}
	
	

}
