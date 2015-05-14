package cn.edu.siso.xueyao.intentwork;

import java.lang.reflect.InvocationTargetException;

import android.R.integer;
import android.R.interpolator;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts.Data;
import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
TextView textView;
Button oneButton,twobButton,threebButton;
EditText editText;
private static final int SUBACTIVITY=1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText = (EditText)findViewById(R.id.mainsetText);
		oneButton = (Button)findViewById(R.id.button1);
		textView = (TextView)findViewById(R.id.mainputText);
		oneButton.setOnClickListener(new OnClickListener() {
	
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,SecondActivity.class);
				intent.putExtra("name", editText.getText().toString());
				startActivity(intent);
			}
		});
		
		
		twobButton = (Button)findViewById(R.id.button2);
		twobButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,ThirdActivity.class);
				startActivityForResult(intent,SUBACTIVITY);
			}
		});
		
		
		threebButton = (Button)findViewById(R.id.button3);
		threebButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.siso.edu.cn"));
				startActivity(intent);
			}
		});
		
	}



	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		switch (requestCode) {
		case SUBACTIVITY:
			if (resultCode==RESULT_OK) {
				Uri uri = data.getData();
				textView.setText(uri.toString());
			}
			break;

		default:
			break;
		}
	}
	

}
