package com.example.sudokuhz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class PuzzleView extends View {

	private final Rect selRect=new Rect();
	private float width,height;
	private int selX,selY;
	private PuzzleView myview;
	public String[][] pu=new String[][]{
			
			{"3","6"," "," "," "," "," "," "," "},
			{" "," ","4","2","3"," "," "," "," "},
			{" "," "," "," "," ","4","2"," "," "},
			{" ","7"," ","4","6"," "," "," ","3"},
			{"8","2"," "," "," "," "," ","1","4"},
			{"5"," "," "," ","1","3"," ","2"," "},
			{" "," ","1","9"," "," "," "," "," "},
			{" "," ","7"," ","4","8","3"," "," "},
			{" "," "," "," "," "," "," ","4","5"},


};
	public String[][]  puzzle = new String[][]{
		
				{"3","6"," "," "," "," "," "," "," "},
				{" "," ","4","2","3"," "," "," "," "},
				{" "," "," "," "," ","4","2"," "," "},
				{" ","7"," ","4","6"," "," "," ","3"},
				{"8","2"," "," "," "," "," ","1","4"},
				{"5"," "," "," ","1","3"," ","2"," "},
				{" "," ","1","9"," "," "," "," "," "},
				{" "," ","7"," ","4","8","3"," "," "},
				{" "," "," "," "," "," "," ","4","5"},
	

	};
 
	private String easy[][] = new String[][]{
			{"3","6"," "," "," "," "," "," "," "},
			{" "," ","4","2","3"," "," "," "," "},
			{" "," "," "," "," ","4","2"," "," "},
			{" ","7"," ","4","6"," "," "," ","3"},
			{"8","2"," "," "," "," "," ","1","4"},
			{"5"," "," "," ","1","3"," ","2"," "},
			{" "," ","1","9"," "," "," "," "," "},
			{" "," ","7"," ","4","8","3"," "," "},
			{" "," "," "," "," "," "," ","4","5"},
	};
	private String medium[][] = new String[][]{
			{"6","5"," "," "," "," "," ","7"," "},
			{" "," "," ","5"," ","6"," "," "," "},
			{" ","1","4"," "," "," "," "," ","5"},
			{" ","7"," ","4","6"," "," "," ","3"},
			{" "," ","2","3","1","4","7"," "," "},
			{" "," "," ","7"," "," ","8"," "," "},
			{"5"," "," "," "," "," ","6","3"," "},
			{" ","9"," ","3"," ","1"," ","8"," "},
			{" "," "," "," "," "," ","6"," "," "},
	};
	private String hard[][] = new String[][]{
			{"1","2","3","4","5","6","7","8","9"},
			{" "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "},
			{" "," "," "," "," "," "," "," "," "},
	};



	public PuzzleView(Context context, int diff) {
		super(context);
		Game new_game = (Game)context;
		int m=0;
		setFocusable(true);
		setFocusableInTouchMode(true);
		for(int i=0;i<9;i++)
			for(int j=0;j<9;j++)
			{
				switch(diff)
				{
				case 0:
					
					break;
				case 1:
					puzzle[i][j] = easy[i][j];
					pu[i][j]=puzzle[i][j]; 
					break;
				case 2:
					puzzle[i][j] = medium[i][j];
					pu[i][j]=puzzle[i][j]; 
					break;
				case 3:
					puzzle[i][j] = hard[i][j];
					pu[i][j]=puzzle[i][j]; 
					break;
			
				case -1:
					puzzle[i][j]=new_game.continueString.substring(m,m+1);
					System.out.print(puzzle[i][j]);
					m++;
					break;
				}
			}
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		// 设置画布Canvas的背景色
		canvas.drawColor(Color.LTGRAY);
		// 实例化画笔
		Paint paint = new Paint();
		// 消去画笔的锯齿
		paint.setAntiAlias(true);
		// 设置画笔的粗细宽度
		paint.setStrokeWidth(1);
		//设置画笔的颜色
		paint.setColor(Color.RED);
		//获取屏幕的高度和宽度来画一个空心的矩形
		Paint paintRect=new Paint();
		paintRect.setAntiAlias(true);
		paintRect.setStrokeWidth(1);
		paintRect.setColor(Color.BLUE);
		paintRect.setStyle(Paint.Style.STROKE);//空心
		Paint paintRect1=new Paint();
		paintRect1.setAntiAlias(true);
		paintRect1.setStrokeWidth(2);
		paintRect1.setColor(Color.YELLOW);
		paintRect1.setStyle(Paint.Style.STROKE);
		canvas.drawRect(1,1,getWidth()-1, getHeight()-1,  paintRect);
		//获取屏幕的高度和宽度来画9条横线
		for(int i=0;i<=9;i++){
			canvas.drawLine(0, i*height, getWidth(), i*height, paint);
			if(i%3==0)
				canvas.drawLine(0, i*height, getWidth(), i*height, paintRect1);}
		//获取屏幕的高度和宽度来画9条竖线
		for(int i=0;i<=9;i++){
			canvas.drawLine(i*width,0,i*width,getHeight(), paint);
			if(i%3==0)
				canvas.drawLine(i*width,0,i*width,getHeight(), paintRect1);}
		//绘制九宫格内数字
		Paint frontPaint=new Paint();
		frontPaint.setColor(Color.RED);
		frontPaint.setTextSize(25);
		//横向的数字显示
		for(int i=0;i<9;i++){
			for(int j=1;j<=9;j++){
				canvas.drawText(puzzle[i][j-1], i*width+(width*0.3f), j*height-(height*0.3f),frontPaint);
//canvas.drawText(puzzle[i][j-1], (j-1)*width+(width*0.3f), (i+1)*height-(height*0.3f),frontPaint);
			}
		}

		//绘制点击出现的小矩形
		Paint selPaint=new Paint();
		selPaint.setColor(Color.GREEN);
		canvas.drawRect(selRect, selPaint);

		getRect(selX,selY,selRect);

	}
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		width=w/9f;
		height=h/9f;
		//getRect(selX,selY,selRect);
		setFocusable(true);
		setFocusableInTouchMode(true);
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		//检测事件类型
		if(event.getAction()!=MotionEvent.ACTION_DOWN){
			return super.onTouchEvent(event);
		}
		//计算触屏的位置在哪个矩形上
		int x=(int)(event.getX()/width);
		int y=(int)(event.getY()/height);
		selectXY(x,y);
		new Keypad(getContext(),this).show();//调 用KEYPAD.java
		return false;
	}
	

	//设置一个画矩形的方法
	private void getRect(float selX,float selY,Rect r){
		r.set((int)(selX*width+1), (int)(selY*height+1), (int)(selX*width+width-1), (int)(selY*height+height-1));	
	}
	//得到点击所在的矩形的位置
	public void selectXY(int x,int y){
		invalidate(selRect);

		if(y==-1) {selY=8;}
		else if(y==9) {selY=0;}
		else selY=y;

		if(x==-1) {selX=8;}
		else if(x==9){selX=0;}
		else selX=x;
		//更新矩形的长、宽、左上角坐标等属性
		getRect(selX,selY,selRect);
		//重新绘制矩形
		invalidate(selRect);
	}
	public void setSelectTile(String d) {
		// TODO Auto-generated method stub
		int row,col;
		int finishflag = 0;
		String info = "";
		//1. 检查同一列是否有相同的数字 
		for(row = 0;row<9;row++)
		{	if(!pu[selX][selY].equals(" ")){info="不可填";break;}
			if(puzzle[selX][row].equals(d))
			{
				info = "同一列有相同的数字";						
				break;
			}
		}
		
		//2.检查同一行是否有相同数字
		for(col = 0;col<9;col++)
		{
			if(puzzle[col][selY].equals(d))
			{
				info = "同一行有相同的数字";						
				break;
			}
		}

		//3.检查所在的九宫格是否有相同数字
		int x=selX/3;
		int Y=selY/3;
		for(col = x*3;col<x*3+3;col++)
			for(row = Y*3;row<Y*3+3;row++)
			{
				if(puzzle[col][row].equals(d))
				{
					info = "所在的九宫格有相同数字";						
					break;
				}
					
			}

		//4.判断输入的数字是否为0，如果为0则将其重置为空，如果info不为空则显示info内容，为空则将该矩形框的puzzle数组的内容重置为d。并重新绘制图形
		if(info.equals(""))
		{
			if(d.equals("0")) 
				d ="";
			puzzle[selX][selY] = d;
			invalidate(selRect);
		}
		else
		{
			Toast.makeText(this.getContext(), info, Toast.LENGTH_SHORT).show();
		}
		//5.利用双重循环验证puzzle数组内是否存在空值” ”，如果存在将finishflag赋值为1
	
		for(row = 0;row<9;row++)
		for(col = 0;col<9;col++)
		{
			if(puzzle[row][col]=="")
				finishflag=1;
				
				
		}
		
			
				






		//6.根据finishflag的值判断游戏是否结束，如果为0则通过，否则继续游戏
		if(finishflag==0){
			info = "您成功了";						
		
		}

	}
//		public boolean onKeyDown(int keyCode, KeyEvent event) {
//		// TODO Auto-generated method stub
//		switch(keyCode){
//		case KeyEvent.KEYCODE_DPAD_UP:
//			selectXY(selX,selY-1);
//			break;
//		case KeyEvent.KEYCODE_DPAD_DOWN:
//			selectXY(selX-1,selY);
//			break;
//		case KeyEvent.KEYCODE_DPAD_LEFT:
//			selectXY(selX,selY-1);
//			break;
//		case KeyEvent.KEYCODE_DPAD_RIGHT:
//			selectXY(selX,selY-1);
//			break;
//
//
//		default:
//			return super.onKeyDown(keyCode, event);
//		}
//		return true;
//	}


}
