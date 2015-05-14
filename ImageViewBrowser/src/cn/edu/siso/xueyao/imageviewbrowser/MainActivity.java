package cn.edu.siso.xueyao.imageviewbrowser;
/*
 * 
 * 图片浏览器*/
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
		//定义查看下一张的监听器
		nextButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bigView.setImageResource(images[++currentImg%images.length]);
			}
		});
		//定义改变图片透明度的方法
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
				//改变图片的透明度
				bigView.setAlpha(alpha);
			}
		};
		//为两个按钮添加监听器
		plusButton.setOnClickListener(listener);
		minusButton.setOnClickListener(listener);
		
		//定义触摸监听器
		bigView.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				BitmapDrawable bitmapDrawable = (BitmapDrawable)bigView.getDrawable();
				//获取第一个图片显示框中的位图
				Bitmap bitmap = bitmapDrawable.getBitmap();
				//bitmap图片实际大小与第一个ImageView 的缩放比例
				 double scale = bitmap.getWidth()/320.0;
				 //获取需要显示的图片的开始点
				 int x = (int)(event.getX()*scale);
				 int y = (int)(event.getY()*scale);
				 if (x+120>bitmap.getWidth()) {
					x = bitmap.getWidth()-120;
					
				}
				 if (y+120>bitmap.getHeight()) {
					y= bitmap.getHeight()-120;
				}
				 //显示图片的指定区域
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
