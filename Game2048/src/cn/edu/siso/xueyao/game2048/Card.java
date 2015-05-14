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
		//���뷽ʽ��
		lable.setGravity(Gravity.CENTER);
		//������ɫ
		lable.setBackgroundColor(0x33ffffff);
		//����������Ļ
		LayoutParams lp = new LayoutParams(-1,-1);
		//���ñ߾�
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
	 * �жϿ�Ƭ�Ƿ����
	 * */
	public boolean equals(Card o) {
		// TODO Auto-generated method stub
		return getNum()==o.getNum();
	}

	private TextView lable;
	
}
