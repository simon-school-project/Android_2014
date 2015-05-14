package cn.edu.siso.xueyao.optionmenu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
//		return super.onOptionsItemSelected(item);
		
		TextView labe1 = (TextView)findViewById(R.id.labe1);
			
			switch (item.getItemId()) {
			case R.id.main_menu_0:
				labe1.setText("打印，菜单ID："+item.getItemId());
				return true;
			case R.id.main_menu_1:
				labe1.setText("新建，菜单ID："+item.getItemId());
				return true;
			case R.id.main_menu_2:
				labe1.setText("邮件，菜单ID："+item.getItemId());
				return true;
			case R.id.main_menu_3:
				labe1.setText("设置，菜单ID："+item.getItemId());
				return true;
			case R.id.main_menu_4:
				labe1.setText("订阅，菜单ID："+item.getItemId());
				return true;
			default:
				return false;
			}

	}
	
	
	
}
