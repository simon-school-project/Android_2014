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
		// ���û���Canvas�ı���ɫ
		canvas.drawColor(Color.LTGRAY);
		// ʵ��������
		Paint paint = new Paint();
		// ��ȥ���ʵľ��
		paint.setAntiAlias(true);
		// ���û��ʵĴ�ϸ���
		paint.setStrokeWidth(1);
		//���û��ʵ���ɫ
		paint.setColor(Color.RED);
		//��ȡ��Ļ�ĸ߶ȺͿ������һ�����ĵľ���
		Paint paintRect=new Paint();
		paintRect.setAntiAlias(true);
		paintRect.setStrokeWidth(1);
		paintRect.setColor(Color.BLUE);
		paintRect.setStyle(Paint.Style.STROKE);//����
		Paint paintRect1=new Paint();
		paintRect1.setAntiAlias(true);
		paintRect1.setStrokeWidth(2);
		paintRect1.setColor(Color.YELLOW);
		paintRect1.setStyle(Paint.Style.STROKE);
		canvas.drawRect(1,1,getWidth()-1, getHeight()-1,  paintRect);
		//��ȡ��Ļ�ĸ߶ȺͿ������9������
		for(int i=0;i<=9;i++){
			canvas.drawLine(0, i*height, getWidth(), i*height, paint);
			if(i%3==0)
				canvas.drawLine(0, i*height, getWidth(), i*height, paintRect1);}
		//��ȡ��Ļ�ĸ߶ȺͿ������9������
		for(int i=0;i<=9;i++){
			canvas.drawLine(i*width,0,i*width,getHeight(), paint);
			if(i%3==0)
				canvas.drawLine(i*width,0,i*width,getHeight(), paintRect1);}
		//���ƾŹ���������
		Paint frontPaint=new Paint();
		frontPaint.setColor(Color.RED);
		frontPaint.setTextSize(25);
		//�����������ʾ
		for(int i=0;i<9;i++){
			for(int j=1;j<=9;j++){
				canvas.drawText(puzzle[i][j-1], i*width+(width*0.3f), j*height-(height*0.3f),frontPaint);
//canvas.drawText(puzzle[i][j-1], (j-1)*width+(width*0.3f), (i+1)*height-(height*0.3f),frontPaint);
			}
		}

		//���Ƶ�����ֵ�С����
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
		//����¼�����
		if(event.getAction()!=MotionEvent.ACTION_DOWN){
			return super.onTouchEvent(event);
		}
		//���㴥����λ�����ĸ�������
		int x=(int)(event.getX()/width);
		int y=(int)(event.getY()/height);
		selectXY(x,y);
		new Keypad(getContext(),this).show();//�� ��KEYPAD.java
		return false;
	}
	

	//����һ�������εķ���
	private void getRect(float selX,float selY,Rect r){
		r.set((int)(selX*width+1), (int)(selY*height+1), (int)(selX*width+width-1), (int)(selY*height+height-1));	
	}
	//�õ�������ڵľ��ε�λ��
	public void selectXY(int x,int y){
		invalidate(selRect);

		if(y==-1) {selY=8;}
		else if(y==9) {selY=0;}
		else selY=y;

		if(x==-1) {selX=8;}
		else if(x==9){selX=0;}
		else selX=x;
		//���¾��εĳ��������Ͻ����������
		getRect(selX,selY,selRect);
		//���»��ƾ���
		invalidate(selRect);
	}
	public void setSelectTile(String d) {
		// TODO Auto-generated method stub
		int row,col;
		int finishflag = 0;
		String info = "";
		//1. ���ͬһ���Ƿ�����ͬ������ 
		for(row = 0;row<9;row++)
		{	if(!pu[selX][selY].equals(" ")){info="������";break;}
			if(puzzle[selX][row].equals(d))
			{
				info = "ͬһ������ͬ������";						
				break;
			}
		}
		
		//2.���ͬһ���Ƿ�����ͬ����
		for(col = 0;col<9;col++)
		{
			if(puzzle[col][selY].equals(d))
			{
				info = "ͬһ������ͬ������";						
				break;
			}
		}

		//3.������ڵľŹ����Ƿ�����ͬ����
		int x=selX/3;
		int Y=selY/3;
		for(col = x*3;col<x*3+3;col++)
			for(row = Y*3;row<Y*3+3;row++)
			{
				if(puzzle[col][row].equals(d))
				{
					info = "���ڵľŹ�������ͬ����";						
					break;
				}
					
			}

		//4.�ж�����������Ƿ�Ϊ0�����Ϊ0��������Ϊ�գ����info��Ϊ������ʾinfo���ݣ�Ϊ���򽫸þ��ο��puzzle�������������Ϊd�������»���ͼ��
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
		//5.����˫��ѭ����֤puzzle�������Ƿ���ڿ�ֵ�� ����������ڽ�finishflag��ֵΪ1
	
		for(row = 0;row<9;row++)
		for(col = 0;col<9;col++)
		{
			if(puzzle[row][col]=="")
				finishflag=1;
				
				
		}
		
			
				






		//6.����finishflag��ֵ�ж���Ϸ�Ƿ���������Ϊ0��ͨ�������������Ϸ
		if(finishflag==0){
			info = "���ɹ���";						
		
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
