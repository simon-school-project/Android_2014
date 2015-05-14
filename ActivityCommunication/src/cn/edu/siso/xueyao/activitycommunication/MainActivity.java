package cn.edu.siso.xueyao.activitycommunication;

import android.R.integer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private static final int SUBACTIVITY1=1;
	private static final int SUBACTIVITY2=2;
	TextView textView = null;
	Button button01 = null;
	Button button02 = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView)findViewById(R.id.textView1);
		button01 = (Button)findViewById(R.id.button01);
		button02 = (Button)findViewById(R.id.button02);
		button01.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,SubActivity1.class);
				startActivityForResult(intent, SUBACTIVITY1);
			}
		});
		
		button02.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,SubActivity2.class);
				startActivityForResult(intent, SUBACTIVITY2);
			}
		});
	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		switch (requestCode) {
		case SUBACTIVITY1:
			if(resultCode==RESULT_OK)
			{
				Uri uriData = data.getData();
				textView.setText(uriData.toString());
			}
			break;
		case SUBACTIVITY2:
			break;
		
		}
	}

}
