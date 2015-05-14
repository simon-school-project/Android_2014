package cn.edu.siso.xueyao.checkbox;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		CheckBox checkBox01 = (CheckBox)findViewById(R.id.checkBox1);
		CheckBox checkBox02 = (CheckBox)findViewById(R.id.checkBox2);
		RadioButton button01 = (RadioButton)findViewById(R.id.radioButton1);
		RadioButton button02 = (RadioButton)findViewById(R.id.radioButton2);
		/*
		checkBox01.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		checkBox02.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		button01.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		
		button02.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
		*/
		CheckBox.OnClickListener cheClickListener = new CheckBox.OnClickListener()
		{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		
		RadioButton.OnClickListener rClickListener =new RadioButton.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
			
		};
		checkBox01.setOnClickListener(cheClickListener);
		checkBox02.setOnClickListener(cheClickListener);
		
		button01.setOnClickListener(rClickListener);
		button02.setOnClickListener(rClickListener);
	}
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
