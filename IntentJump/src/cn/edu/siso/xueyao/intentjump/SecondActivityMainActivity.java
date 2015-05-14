package cn.edu.siso.xueyao.intentjump;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SecondActivityMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second_activity_main, menu);
		return true;
	}

}
