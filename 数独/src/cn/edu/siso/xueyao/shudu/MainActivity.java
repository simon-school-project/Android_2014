package cn.edu.siso.xueyao.shudu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	private Button btSimple,
					btCommon,
					btDifficulty;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btSimple = (Button)findViewById(R.id.simple);
		btCommon = (Button)findViewById(R.id.common);
		btDifficulty = (Button)findViewById(R.id.difficulty);
		
		btSimple.setOnClickListener(this);
		btCommon.setOnClickListener(this);
		btDifficulty.setOnClickListener(this);
	}

	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.simple:
			
			break;
		case R.id.common:
			
			break;	
		case R.id.difficulty:
			
			break;
		}
	}

}
