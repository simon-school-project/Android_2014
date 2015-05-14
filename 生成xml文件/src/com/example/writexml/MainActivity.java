package com.example.writexml;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.loveyous.wirtexml.domain.SmsInfo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private List<SmsInfo> smsInfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = (Button)findViewById(R.id.button1);
		
		smsInfo = new ArrayList<SmsInfo>();
		Random random = new Random();
		long number = 135000001;
		for (int i = 1; i <=10; i++) {
			smsInfo.add(new SmsInfo(System.currentTimeMillis(), random.nextInt(2)+1, "¶ÌÐÅÄÚÈÝ"+i,
					Long.toString(number+i)));

		}
		
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				StringBuilder sb = new StringBuilder();
				sb.append("<?xml version=\"1.0\"encoding=\"utf-8\"?>");
				sb.append("<smss>");
				for(SmsInfo info:smsInfo){
					sb.append("<sms>");
					sb.append("<address>");
					sb.append(info.getAddress());
					sb.append("</address>");
					
					sb.append("<type>");
					sb.append(info.getType());
					sb.append("</type>");
					
					sb.append("<data>");
					sb.append(info.getDate());
					sb.append("</data>");
					sb.append("</sms>");
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

}
