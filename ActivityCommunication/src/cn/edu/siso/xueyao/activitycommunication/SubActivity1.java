package cn.edu.siso.xueyao.activitycommunication;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SubActivity1 extends Activity {
EditText editText = null;
Button button01 = null;
Button button02 = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sub_activity1);
		editText= (EditText)findViewById(R.id.editText1);
		button01 = (Button)findViewById(R.id.button11);
		button01.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String uriString = editText.getText().toString();
				Uri dataUri = Uri.parse(uriString);
				Intent result = new Intent(null,dataUri);
				setResult(RESULT_OK, result);
				finish();
			}
		});
		
		button02 = (Button)findViewById(R.id.button22);
		button02.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setResult(RESULT_CANCELED, null);
				finish();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sub_activity1, menu);
		return true;
	}

}
