/**
 * 
 */
package me.loveyous.xueyao.planegame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

/**
 * @author ѦҢ
 *2014-2-2
 * 
 */
@SuppressLint("DrawAllocation")
public class PlaneView extends View
{

	/**
	 * @param context
	 */
	public float currentX;//�ɻ���X���λ��
	public float currentY;//�ɻ���Y���λ��
	Bitmap plane;
	
	public PlaneView(Context context)
	{
		super(context);
		// TODO Auto-generated constructor stub
		
		//����ɻ�ͼƬ
		plane = BitmapFactory.decodeResource(getResources(), R.drawable.plane);
		
		//���ý���
		setFocusable(true);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		//��������
		Paint p = new Paint();
		
		//���Ʒɻ�
		canvas.drawBitmap(plane, currentX,currentY, p);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		
		//�޸�currentX��currentY��������
		currentX = event.getX();
		currentY = event.getY()-100;
		
		//֪ͨ��ǰ����ػ��Լ�
		invalidate();
		
		//����true �����ô������Ѿ�������¼�
		return true;
		
	}
	
	
	
	
	
}
