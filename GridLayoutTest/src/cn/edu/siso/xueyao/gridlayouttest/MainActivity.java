package cn.edu.siso.xueyao.gridlayouttest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.Menu;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends Activity {

	GridLayout gridLayout;
	String[] chaStrings = new String[]
			{"7","8","9","/",
			"4","5","6","*",
			"1","2","3","-",
			".","0","=","+"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gridLayout = (GridLayout)findViewById(R.id.GridLayout1);
		for (int i = 0; i < chaStrings.length; i++) {
			Button bn = new Button(this);
			bn.setText(chaStrings[i]);
			bn.setTextSize(40);
			GridLayout.Spec roSpec = GridLayout.spec(i/4+2);
			GridLayout.Spec cSpec = GridLayout.spec(i%4);
			GridLayout.LayoutParams params = new GridLayout.LayoutParams(roSpec, cSpec);
			params.setGravity(Gravity.FILL);
			gridLayout.addView(bn,params);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
