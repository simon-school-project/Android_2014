package cn.edu.siso.xueyao.tabdemo;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		TabHost tabHost = getTabHost();
		//第一种方法	
//		LayoutInflater.from(this).inflate(R.layout.tab1, tabHost.getTabContentView(), true);
//		LayoutInflater.from(this).inflate(R.layout.tab2, tabHost.getTabContentView(), true);
//		LayoutInflater.from(this).inflate(R.layout.tab3, tabHost.getTabContentView(), true);
//		
//		tabHost.addTab(tabHost.newTabSpec("TAB1").setIndicator("线性布局").setContent(R.id.layout01));
//		tabHost.addTab(tabHost.newTabSpec("TAB2").setIndicator("绝对布局").setContent(R.id.layout02));
//		tabHost.addTab(tabHost.newTabSpec("TAB3").setIndicator("相对布局").setContent(R.id.layout03));

		tabHost.addTab(tabHost.newTabSpec("TAB1").setIndicator("线性布局").setContent(new Intent().setClass(this, Tab1Activity.class)));
		tabHost.addTab(tabHost.newTabSpec("TAB2").setIndicator("绝对布局").setContent(new Intent().setClass(this, Tab2Activity.class)));
		tabHost.addTab(tabHost.newTabSpec("TAB3").setIndicator("相对布局").setContent(new Intent().setClass(this, Tab3Activity.class)));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
