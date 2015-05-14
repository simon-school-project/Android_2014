package me.loveyous.sms;

import android.os.Bundle;
import android.app.Activity;

import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
   private TextView callNumber,content;
   private Button  send;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		callNumber = (TextView)findViewById(R.id.callNumber);
		content = (TextView)findViewById(R.id.content);
		send = (Button)findViewById(R.id.btsend);
		send.setOnClickListener(this);
	}
	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btsend:
				String numberString = callNumber.getText().toString().trim();
				String contentString = content.getText().toString().trim();
				if (TextUtils.isEmpty(numberString)||TextUtils.isEmpty(contentString)) {
					Toast.makeText(this, "手机号码和内容不得为空", Toast.LENGTH_SHORT).show();
					return;
				}else {
					SmsManager smsManager = SmsManager.getDefault();
					smsManager.sendTextMessage(numberString, null, contentString, null, null);
				}
				
			break;

		default:
			break;
		}
	}



}
