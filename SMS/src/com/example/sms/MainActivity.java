package com.example.sms;

import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText address;
	EditText content;
	Button sendsms;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		address = (EditText)findViewById(R.id.edNumber);
		content = (EditText)findViewById(R.id.edContent);
		sendsms = (Button)findViewById(R.id.sendcontent);
		
		sendsms.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String addressStr = address.getText().toString();
				String contentStr = content.getText().toString();
				
				SmsManager smsManager = SmsManager.getDefault();
				PendingIntent sendIntent = PendingIntent.getBroadcast(
						MainActivity.this, 0, new Intent(), 0);
				smsManager.sendTextMessage(addressStr, null, contentStr, sendIntent, null);
				Toast.makeText(MainActivity.this, "短信发送完成", Toast.LENGTH_LONG).show();
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
