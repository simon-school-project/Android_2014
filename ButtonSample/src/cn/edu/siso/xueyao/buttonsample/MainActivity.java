package cn.edu.siso.xueyao.buttonsample;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button button = (Button)findViewById(R.id.button1);
		final ImageButton imageButton =(ImageButton)findViewById(R.id.imageButton1);
		final TextView textView = (TextView)findViewById(R.id.textView1);
		/*
		 * Button.OnClickListener buttonListener = new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.button1:
					textView.setText("Button按钮");
					break;

				case R.id.imageButton1:
					textView.setText("ImageButton按钮");
					break;
				}
			}};

		button.setOnClickListener(buttonListener);
		imageButton.setOnClickListener(buttonListener);
		 */
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				textView.setText("Button按钮");
			}
		});
		 
		imageButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				textView.setText("imageButton按钮");
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
