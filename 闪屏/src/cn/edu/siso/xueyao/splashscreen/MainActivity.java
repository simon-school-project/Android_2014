package cn.edu.siso.xueyao.splashscreen;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,Splash.class);
				startActivity(intent);
				MainActivity.this.finish();
				overridePendingTransition(android.R.anim.slide_in_left,
						android.R.anim.slide_out_right);
			}
		}, 5000);
	}

	

}
