package cn.edu.siso.xueyao.listeviewdemo;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final TextView textView = (TextView)findViewById(R.id.textView1);
		ListView tListView = (ListView)findViewById(R.id.listView1);
		List<String>list = new ArrayList<String>();
		list.add("ListView子项1");
		list.add("ListView子项2");
		list.add("ListView子项3");
		ArrayAdapter< String>adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list);
		tListView.setAdapter(adapter);
		
		AdapterView.OnItemClickListener lClickListener = new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				String msg = "父 view:"+arg0.toString()+"\n"+"子 View:"+arg1.toString()
						+"\n"+"位置："+String.valueOf(arg2)+",ID:"+String.valueOf(arg3);
			textView.setText(msg);
			}
		};
		tListView.setOnItemClickListener(lClickListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
