package cn.edu.siso.xueyao.chronometer;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;

public class MainActivity extends Activity {

	Chronometer chronometer;
	Button startButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//获取计时器组件
		chronometer = (Chronometer)findViewById(R.id.chronometer1);
		//获取“开始”组件
		startButton = (Button)findViewById(R.id.button1);
		startButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//设置开始计时时间
				chronometer.setBase(SystemClock.elapsedRealtime());
				//启动计时器
				chronometer.start();
				//按钮的启用状态，false 不可用
				startButton.setEnabled(false);
			}
		});
		//为Chronometer绑定事件监听器
		chronometer.setOnChronometerTickListener(new OnChronometerTickListener() {
			
			@Override
			public void onChronometerTick(Chronometer chronometer) {
				// TODO Auto-generated method stub
				//如果从开始计时到现在超过20s
				if (SystemClock.elapsedRealtime()-chronometer.getBase()>20*1000) {
					chronometer.stop();
					startButton.setEnabled(true);
				}
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
