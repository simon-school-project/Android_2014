package me.loveyous.xueyao.listactivity;

import android.os.Bundle;
import android.app.ListActivity;
import android.widget.ArrayAdapter;

/*
 * ����ListActivityʵ���б�
 * ---------------------------------------------
 * 
 * �˳����Activity�̳�ListActivity������沼���ļ�
 * 
 * 
 * */
public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		//�ַ�����������"�����","��˽�","��ɮ"
		String [] arr = {"�����","��˽�","��ɮ"};
		
		//�����������Ľ���
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_multiple_choice, arr);
		
		//��������
		setListAdapter(adapter);
	}

	

}
