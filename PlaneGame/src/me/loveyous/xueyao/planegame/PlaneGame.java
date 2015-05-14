package me.loveyous.xueyao.planegame;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.app.Activity;



/**
 * @author 薛尧
 *2014-2-2
 * 
 */
public class PlaneGame extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//去掉窗口标题
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//全屏显示
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		//获取PlaneView对象
		final PlaneView planeView = new PlaneView(this);
		
		//启动界面
		setContentView(planeView);
		
		//planeView界面的背景颜色
		planeView.setBackgroundColor(111);
			
		
		//获取窗口管理器
		WindowManager windowManager = getWindowManager();
		Display display = windowManager.getDefaultDisplay();
		DisplayMetrics metrics = new DisplayMetrics();
		
		//获取屏幕的宽和高
		display.getMetrics(metrics);
		
		planeView.currentX = metrics.widthPixels/2;
		planeView.currentY = metrics.heightPixels-150;
		
		
	}

	

}
