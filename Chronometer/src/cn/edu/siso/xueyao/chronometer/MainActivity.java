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
		//��ȡ��ʱ�����
		chronometer = (Chronometer)findViewById(R.id.chronometer1);
		//��ȡ����ʼ�����
		startButton = (Button)findViewById(R.id.button1);
		startButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//���ÿ�ʼ��ʱʱ��
				chronometer.setBase(SystemClock.elapsedRealtime());
				//������ʱ��
				chronometer.start();
				//��ť������״̬��false ������
				startButton.setEnabled(false);
			}
		});
		//ΪChronometer���¼�������
		chronometer.setOnChronometerTickListener(new OnChronometerTickListener() {
			
			@Override
			public void onChronometerTick(Chronometer chronometer) {
				// TODO Auto-generated method stub
				//����ӿ�ʼ��ʱ�����ڳ���20s
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
