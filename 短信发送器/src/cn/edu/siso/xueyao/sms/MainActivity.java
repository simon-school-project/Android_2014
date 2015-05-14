package cn.edu.siso.xueyao.sms;


import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText etNumber,etContent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etNumber  = (EditText)findViewById(R.id.etnumber);
		etContent = (EditText)findViewById(R.id.dtcontent);
		
		findViewById(R.id.btsend).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String number = etNumber.getText().toString();
				String content = etContent.getText().toString();
				
				SmsManager sms = SmsManager.getDefault();
				ArrayList<String> texts = sms.divideMessage(content);
				for (String text:texts) {
					sms.sendTextMessage(number, null, text, null, null);

				}
				Toast.makeText(MainActivity.this, "·¢ËÍ³É¹¦", Toast.LENGTH_SHORT).show();
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
