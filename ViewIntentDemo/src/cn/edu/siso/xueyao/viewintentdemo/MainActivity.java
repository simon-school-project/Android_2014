package cn.edu.siso.xueyao.viewintentdemo;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	private Button button = null;
	private EditText editText = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button)findViewById(R.id.button1);
		editText = (EditText)findViewById(R.id.editText1);
			
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					String string = editText.getText().toString();
					//隐式启动，跳转到网址
					//Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://"+string));
					
					//隐式启动，跳转并拨打电话
					//Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+string));
					//隐式启动，跳转并拨打电话界面
					Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+string));
					startActivity(intent);
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
