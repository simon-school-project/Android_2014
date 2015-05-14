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
 * @author 薛尧
 *2014-2-9
 *程序的启动界面
 *功能：
 *	1.包括版本号
 *	2.界面5s后跳入程序主界面
 */
public class SplashActivity extends Activity
{
	//定义TextView对象
	private TextView version;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//设置窗口标题隐藏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//启动splash界面
		setContentView(R.layout.splash);
		//启动界面布满整个窗口
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		//载入TextView控件
		version = (TextView)findViewById(R.id.splash_version);
		
		version.setText("版本号V 1.0");
		//开始
		Start();
		
	}

	/**
	 * 
	 */
	private void Start() {
		// TODO Auto-generated method stub
		//新建一个线程
		new Thread(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				try {
					//休眠5000ms
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//创建intent对象
				Intent intent = new Intent();
				
				intent.setClass(SplashActivity.this, Main.class);
				//启动intent对象
				startActivity(intent);
			}
			//开始线程
		}.start();
	}

	
}
