package cn.edu.siso.xueyao.threadrandomservicedemo;
/*
 * 线程产生随机数，并显示到TextVie控件中
 * 
 * */


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private static Handler handler = new Handler();
	private static TextView  labetTextView = null;
	private Button startbButton,stopButton;
	private static double randomDouble;

	public static void UpdateGUI(double refreshDouble)
	{
		randomDouble = refreshDouble;
		handler.post(RefreshLable);
		
	}
	
	private static Runnable RefreshLable = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			labetTextView.setText(String.valueOf(randomDouble));
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		labetTextView = (TextView)findViewById(R.id.label);
		final Intent intent = new Intent(this,RandonService.class);
		startbButton = (Button)findViewById(R.id.startbt);
		startbButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startService(intent);
			}
		});
		
		stopButton = (Button)findViewById(R.id.stopbt);
		stopButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				stopService(intent);
			}
		});
		
		
		
	
	
	}
}
