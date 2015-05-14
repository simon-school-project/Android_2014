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
 * @author ѦҢ
 *2014-2-2
 * 
 */
public class PlaneGame extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//ȥ�����ڱ���
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//ȫ����ʾ
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		//��ȡPlaneView����
		final PlaneView planeView = new PlaneView(this);
		
		//��������
		setContentView(planeView);
		
		//planeView����ı�����ɫ
		planeView.setBackgroundColor(111);
			
		
		//��ȡ���ڹ�����
		WindowManager windowManager = getWindowManager();
		Display display = windowManager.getDefaultDisplay();
		DisplayMetrics metrics = new DisplayMetrics();
		
		//��ȡ��Ļ�Ŀ�͸�
		display.getMetrics(metrics);
		
		planeView.currentX = metrics.widthPixels/2;
		planeView.currentY = metrics.heightPixels-150;
		
		
	}

	

}
