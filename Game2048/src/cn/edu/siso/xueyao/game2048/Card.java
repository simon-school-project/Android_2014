package cn.edu.siso.xueyao.game2048;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Card extends FrameLayout {

public Card(Context context) {
		super(context);
		lable = new TextView(getContext());
		lable.setTextSize(32);
		//对齐方式置
		lable.setGravity(Gravity.CENTER);
		//背景颜色
		lable.setBackgroundColor(0x33ffffff);
		//充满整个屏幕
		LayoutParams lp = new LayoutParams(-1,-1);
		//设置边距
		lp.setMargins(10, 10, 0, 0);
		//
		addView(lable,lp);
		//
		setNum(0);
	}

	
	
	private int num = 0;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		lable.setText(num+"");
		
	}
	
	
	
	/**
	 * 判断卡片是否相等
	 * */
	public boolean equals(Card o) {
		// TODO Auto-generated method stub
		return getNum()==o.getNum();
	}

	private TextView lable;
	
}
