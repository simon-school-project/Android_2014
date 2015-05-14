package cn.edu.siso.edu.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.R.string;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button mybutton01,mybutton02;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mybutton01 = (Button)findViewById(R.id.button1);
		mybutton01.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				myHandler.sendEmptyMessage(0);
			}
		});
		mybutton02 = (Button)findViewById(R.id.button2);
		mybutton02.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Message myMessage = new Message();
				myMessage.what=1;
				Bundle myBundle = new Bundle();
				myBundle.putString("name", "刘馨妍");
				myBundle.putString("number", "1234567890");
				myMessage.setData(myBundle);
				myHandler.sendMessage(myMessage);
			}
		});
		
		
	}

	Handler myHandler = new Handler()
	{
		public void handleMessage(Message msg){
			super.handleMessage(msg);
			switch (msg.what) {
			case 0:
				Toast.makeText(MainActivity.this, "结果是："+msg.what, Toast.LENGTH_LONG).show();
				break;
			case 1:
				Bundle myBundle1 = msg.getData();
				String myName = myBundle1.getString("name");
				String myNumber = myBundle1.getString("number");
				Toast.makeText(MainActivity.this, "姓名："+myName+",号码:"+myNumber+",结果是："+msg.what, Toast.LENGTH_LONG).show();
				break;

			
			}
		}
		
	};

}
