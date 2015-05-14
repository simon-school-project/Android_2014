package me.loveyous.xueyao;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Logo extends Activity {

	String string ="123";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.logo);
		
		TextView textView = (TextView)findViewById(R.id.textView1);
		
		textView.setText(string);
	}
	
}
