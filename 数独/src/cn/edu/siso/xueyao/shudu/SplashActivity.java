/**
 * 
 */
package cn.edu.siso.xueyao.shudu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends Activity {

	private Thread splashTimer;
	private long splashTime = 3000;
	private boolean isPaused = false;
	private boolean isSplashActive = true;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setFullScreen();// 全屏设置
		setContentView(R.layout.splash_activity);

		startSplashTimer();

	}

	public void setFullScreen() {
		// 隐藏标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// 定义全屏参数
		int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
		// 获得窗口对象
		Window myWindow = this.getWindow();
		
		// 设置Flag标识
		myWindow.setFlags(flag, flag);

	}

	public void startSplashTimer() {
		splashTimer = new Thread() {
			public void run() {
				try {
					// wait loop
					long ms = 0;
					while (isSplashActive && ms < splashTime) {
						sleep(100);

						if (!isPaused)
							ms += 100;
					}
//                     隐式启动的常规方法
					Intent intent =new Intent("cn.edu.siso.xueyao.shudu.logosample");
                    startActivity(intent);

				} catch (Exception ex) {
					Log.e("Splash", ex.getMessage());
				} finally {
					finish();//线程结束
				}
			}
		};
		splashTimer.start();
	}

	@Override
	protected void onPause() {
		super.onPause();
		isPaused = true;
	}

	@Override
	protected void onResume() {
		super.onResume();
		isPaused = false;
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		super.onKeyDown(keyCode, event);
		switch (keyCode) {
		case KeyEvent.KEYCODE_DPAD_DOWN:
		case KeyEvent.KEYCODE_DPAD_LEFT:
		case KeyEvent.KEYCODE_DPAD_RIGHT:
		case KeyEvent.KEYCODE_DPAD_UP:
		case KeyEvent.KEYCODE_DPAD_CENTER:
			isSplashActive = false;
			break;
		case KeyEvent.KEYCODE_BACK:
			android.os.Process.killProcess(android.os.Process.myPid());
			break;
		default:
			break;
		}
		return true;
	}


}
