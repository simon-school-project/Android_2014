package cn.edu.siso.xueyao.intentwork;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class SecondActivity extends Activity {
TextView twoTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		twoTextView = (TextView)findViewById(R.id.twotextView1);
		Bundle extras = getIntent().getExtras();
		String string = extras.getString("name");
		twoTextView.setText(string);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

}
