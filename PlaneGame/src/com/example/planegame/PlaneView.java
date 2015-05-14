package com.example.planegame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class PlaneView extends View {

	public float currentX;
	public float currentY;
	Bitmap plane;
	public PlaneView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		plane = BitmapFactory.decodeResource(context.getResources(),
				R.drawable.plane);
		
		setFocusable(true);
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Paint p = new Paint();
		canvas.drawBitmap(plane, currentX, currentY,p);
	}
	
	

}
