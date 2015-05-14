package cn.edu.siso.xueyao.intentwork;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends Activity {
TextView inset02;
Button Okbutton1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		inset02 = (EditText)findViewById(R.id.inset02);
		Okbutton1 = (Button)findViewById(R.id.Okbutton1);
		
		Okbutton1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String uriString = inset02.getText().toString();
				Uri uri = Uri.parse(uriString);
				Intent intent = new Intent(null,uri);
				setResult(RESULT_OK,intent);
				finish();
				
						
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third, menu);
		return true;
	}

}
