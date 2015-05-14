package me.loveyous.xueyao.listactivity;

import android.os.Bundle;
import android.app.ListActivity;
import android.widget.ArrayAdapter;

/*
 * 基于ListActivity实现列表
 * ---------------------------------------------
 * 
 * 此程序的Activity继承ListActivity无须界面布局文件
 * 
 * 
 * */
public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		//字符串数组增加"孙悟空","猪八戒","唐僧"
		String [] arr = {"孙悟空","猪八戒","唐僧"};
		
		//数组适配器的建立
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_multiple_choice, arr);
		
		//绑定适配器
		setListAdapter(adapter);
	}

	

}
