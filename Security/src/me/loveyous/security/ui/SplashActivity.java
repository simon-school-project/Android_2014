/**
 * 
 */
package me.loveyous.security.ui;

import me.loveyous.security.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * @author ѦҢ
 *2014-2-9
 *�������������
 *���ܣ�
 *	1.�����汾��
 *	2.����5s���������������
 */
public class SplashActivity extends Activity
{
	//����TextView����
	private TextView version;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//���ô��ڱ�������
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//����splash����
		setContentView(R.layout.splash);
		//�������沼����������
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//����TextView�ؼ�
		version = (TextView)findViewById(R.id.splash_version);
		
		version.setText("�汾��V 1.0");
		//��ʼ
		Start();
		
	}

	/**
	 * 
	 */
	private void Start() {
		// TODO Auto-generated method stub
		//�½�һ���߳�
		new Thread(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					//����5000ms
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//����intent����
				Intent intent = new Intent();
				
				intent.setClass(SplashActivity.this, Main.class);
				//����intent����
				startActivity(intent);
			}
			//��ʼ�߳�
		}.start();
	}

	
}
