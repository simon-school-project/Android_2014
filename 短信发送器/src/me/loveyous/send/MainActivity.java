package me.loveyous.send;

import android.os.Bundle;
import android.app.Activity;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	private EditText number,content;
	private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = (EditText)findViewById(R.id.etNumber);
        content = (EditText)findViewById(R.id.etContent);
        send = (Button)findViewById(R.id.btSend);
        send.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String conString = content.getText().toString().trim();
		String numString = number.getText().toString().trim();
		if (TextUtils.isEmpty(numString)||TextUtils.isEmpty(conString)) {
			
			Toast.makeText(this, "电话号码或者内容不能为空", Toast.LENGTH_SHORT).show();
			return;
		}else {
			SmsManager smsManager = SmsManager.getDefault();
			smsManager.sendTextMessage(numString, null, conString, null, null);
		}
	}
    
}
