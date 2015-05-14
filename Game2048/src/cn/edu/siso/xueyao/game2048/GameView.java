package cn.edu.siso.xueyao.game2048;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class GameView extends GridLayout {

	public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		initGameView();
	}

	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initGameView();
	}

	public GameView(Context context) {
		super(context);
		initGameView();
		
	}

	private void initGameView() {
		setColumnCount(4);
		setBackgroundColor(0xffbbada0);
		setOnTouchListener(new View.OnTouchListener() {
			private float startX,startY,offsetX,offsetY;
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				
				case MotionEvent.ACTION_DOWN:
					startX = event.getX();
					startY = event.getY();
					break;
					
				case MotionEvent.ACTION_UP:
					offsetX = event.getX()-startX;
					offsetY = event.getY()-startY;
					
					if (Math.abs(offsetX)>Math.abs(offsetY)) {
						if (offsetX>5) {
							//System.out.println("向右移动");
							swipeRight();
						} else if(offsetX<-5){
							//System.out.println("向左移动");
							swipeLeft();
						}
					}else {
						if (offsetY>5) {
							//System.out.println("向下移动");
							swipeDown();
						} else if(offsetY<-5){
							//System.out.println("向上移动");
							swipeUp();
						}
					}
					break;
				
				}
				
				return true;
			}
		});
	}
	
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		//卡片的宽度和高度
		int cardWidth = (Math.min(w, h)-10)/4;
		addCards(cardWidth,cardWidth);
		
	}
	
	private void addCards(int cardWidth,int cardHeight){
		//设置卡片对象
		Card c;
		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				//获得卡片内容 
				c = new Card(getContext());
				//设置卡片数字/
				c.setNum(2);
				//将卡片添加到视图中
				addView(c, cardWidth, cardHeight);
				//
				cardsMap[x][y] = c;
			}
		}
	}
	
	
	/**
	 * 向右移动
	 * */
	private void swipeRight(){
		
	}
	
	/**
	 * 向左移动
	 * */
	private void swipeLeft(){
		
	}
	
	/**
	 * 向下移动
	 * */
	private void swipeDown(){
		
	}
	/**
	 * 向上移动
	 * */
	private void swipeUp(){
		
	}
	//初始卡片数组
	private Card[][] cardsMap = new Card[4][4];
	
}
