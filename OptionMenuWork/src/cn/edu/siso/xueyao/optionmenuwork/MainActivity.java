package cn.edu.siso.xueyao.optionmenuwork;

import android.os.Bundle;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView labe  ;
final static int MENU_04 = Menu.FIRST+4;
final static int MENU_05 = Menu.FIRST+5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.add(0, MENU_04, 4, "身高");
		menu.add(0, MENU_05, 5, "体重");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		labe = (TextView)findViewById(R.id.label);
		switch (item.getItemId()) {
		case R.id.main_menu_01:
		{
			labe.setText("姓名");
			Toast.makeText(this,"姓名",Toast.LENGTH_SHORT).show();
		}
			
			break;
		case R.id.main_menu_02:
		{
			labe.setText("性别");
			Toast.makeText(this,"性别",Toast.LENGTH_SHORT).show();

		}
			break;
		case R.id.main_menu_03:
		{
			labe.setText("年龄");
			Toast.makeText(this,"年龄",Toast.LENGTH_SHORT).show();

		}
			break;	
		case MENU_04:
		{
			labe.setText("身高");
			Toast.makeText(this,"身高",Toast.LENGTH_SHORT).show();

		}
			break;
		case MENU_05:
		{
			labe.setText("体重");
			Toast.makeText(this,"体重",Toast.LENGTH_SHORT).show();

		}
			break;
		default:
			break;
		}
		return false;
	// TODO Auto-generated method stub
		//return super.onOptionsItemSelected(item);
	}

	
	

}
