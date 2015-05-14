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
 * @author 薛尧
 *2014-2-2
 * 
 */
@SuppressLint("DrawAllocation")
public class PlaneView extends View
{

	/**
	 * @param context
	 */
	public float currentX;//飞机在X轴的位置
	public float currentY;//飞机在Y轴的位置
	Bitmap plane;
	
	public PlaneView(Context context)
	{
		super(context);
		// TODO Auto-generated constructor stub
		
		//定义飞机图片
		plane = BitmapFactory.decodeResource(getResources(), R.drawable.plane);
		
		//设置焦点
		setFocusable(true);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		//创建画笔
		Paint p = new Paint();
		
		//控制飞机
		canvas.drawBitmap(plane, currentX,currentY, p);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		
		//修改currentX、currentY两个属性
		currentX = event.getX();
		currentY = event.getY()-100;
		
		//通知当前组件重绘自己
		invalidate();
		
		//返回true 表明该处理方法已经处理该事件
		return true;
		
	}
	
	
	
	
	
}
