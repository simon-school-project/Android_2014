package cn.edu.siso.xueyao.imageviewbrowser;
/*
 * 
 * ͼƬ�����*/
import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
 int [] images = new int[]{
		 R.drawable.lijiang,
		 R.drawable.qiao,
		 R.drawable.shuangta,
		 R.drawable.shui,
		 R.drawable.xiangbi,
 };
 int currentImg = 2;
 private int alpha = 255;
 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final Button plusButton = (Button)findViewById(R.id.plus);
		final Button minusButton = (Button)findViewById(R.id.minus);
		final ImageView bigView = (ImageView)findViewById(R.id.big);
		final ImageView smallView = (ImageView)findViewById(R.id.small);
		Button nextButton = (Button)findViewById(R.id.next);
		//����鿴��һ�ŵļ�����
		nextButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bigView.setImageResource(images[++currentImg%images.length]);
			}
		});
		//����ı�ͼƬ͸���ȵķ���
		OnClickListener listener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (v==plusButton) {
					alpha +=20;
				}
				if (v==minusButton) {
					alpha -=20;
				}
				if (alpha>=255) {
					alpha =255;
				}
				if (alpha<=0) {
					alpha =0;
					
				}
				//�ı�ͼƬ��͸����
				bigView.setAlpha(alpha);
			}
		};
		//Ϊ������ť��Ӽ�����
		plusButton.setOnClickListener(listener);
		minusButton.setOnClickListener(listener);
		
		//���崥��������
		bigView.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				BitmapDrawable bitmapDrawable = (BitmapDrawable)bigView.getDrawable();
				//��ȡ��һ��ͼƬ��ʾ���е�λͼ
				Bitmap bitmap = bitmapDrawable.getBitmap();
				//bitmapͼƬʵ�ʴ�С���һ��ImageView �����ű���
				 double scale = bitmap.getWidth()/320.0;
				 //��ȡ��Ҫ��ʾ��ͼƬ�Ŀ�ʼ��
				 int x = (int)(event.getX()*scale);
				 int y = (int)(event.getY()*scale);
				 if (x+120>bitmap.getWidth()) {
					x = bitmap.getWidth()-120;
					
				}
				 if (y+120>bitmap.getHeight()) {
					y= bitmap.getHeight()-120;
				}
				 //��ʾͼƬ��ָ������
				 smallView.setImageBitmap(Bitmap.createBitmap(bitmap,x,y,120,120));
				 smallView.setAlpha(alpha);
				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
