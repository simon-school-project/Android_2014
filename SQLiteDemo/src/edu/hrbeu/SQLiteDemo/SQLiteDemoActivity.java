package edu.hrbeu.SQLiteDemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLiteDemoActivity extends Activity {
    /** Called when the activity is first created. */
	private DBAdapter dbAdepter ;
	
	private EditText nameText;
	private EditText ageText;
	private EditText heightText;
	private EditText idEntry;
	
	private TextView labelView;
	private TextView displayView;
	
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        nameText = (EditText)findViewById(R.id.name);
        ageText = (EditText)findViewById(R.id.age);
        heightText = (EditText)findViewById(R.id.height);
        idEntry = (EditText)findViewById(R.id.id_entry);
        
        labelView = (TextView)findViewById(R.id.label);
        displayView = (TextView)findViewById(R.id.display);
        
        
        
        Button addButton = (Button)findViewById(R.id.add);
        Button queryAllButton = (Button)findViewById(R.id.query_all);      
        Button clearButton = (Button)findViewById(R.id.clear);
        Button deleteAllButton = (Button)findViewById(R.id.delete_all);
        
        Button queryButton = (Button)findViewById(R.id.query);
        Button deleteButton = (Button)findViewById(R.id.delete);
        Button updateButton = (Button)findViewById(R.id.update);
        
        
        addButton.setOnClickListener(addButtonListener); 
        queryAllButton.setOnClickListener(queryAllButtonListener);     
        clearButton.setOnClickListener(clearButtonListener);
        deleteAllButton.setOnClickListener(deleteAllButtonListener);      
        
        queryButton.setOnClickListener(queryButtonListener);
        deleteButton.setOnClickListener(deleteButtonListener);
        updateButton.setOnClickListener(updateButtonListener);
        
        dbAdepter = new DBAdapter(this);
        dbAdepter.open();
    }
    
    OnClickListener addButtonListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			People people = new People();
			people.Name = nameText.getText().toString();
			people.Age = Integer.parseInt(ageText.getText().toString());
			people.Height = Float.parseFloat(heightText.getText().toString());
			long colunm = dbAdepter.insert(people);
			if (colunm == -1 ){
				labelView.setText("��ӹ��̴���");
			} else {
				labelView.setText("�ɹ�������ݣ�ID��"+String.valueOf(colunm));	
				
			}
		}	
    };
    
    OnClickListener queryAllButtonListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			People[] peoples = dbAdepter.queryAllData();
			if (peoples == null){
				labelView.setText("���ݿ���û������");
				return;
			}
			labelView.setText("���ݿ⣺");
			String msg = "";
			for (int i = 0 ; i<peoples.length; i++){
				msg += peoples[i].toString()+"\n";
			}
			displayView.setText(msg);
		}
    };
    
    OnClickListener clearButtonListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			displayView.setText("");
		}	
    };
    
    OnClickListener deleteAllButtonListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			dbAdepter.deleteAllData();
			String msg = "����ȫ��ɾ��";
			labelView.setText(msg);
		}	
    };
    
    OnClickListener queryButtonListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			int id = Integer.parseInt(idEntry.getText().toString());
			People[] peoples = dbAdepter.queryOneData(id);
			
			if (peoples == null){
				labelView.setText("���ݿ���û��IDΪ"+String.valueOf(id)+"������");
				return;
			}
			labelView.setText("���ݿ⣺");
			displayView.setText(peoples[0].toString());
		}
    };
    
    OnClickListener deleteButtonListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			long id = Integer.parseInt(idEntry.getText().toString());
			long result = dbAdepter.deleteOneData(id);
			String msg = "ɾ��IDΪ"+idEntry.getText().toString()+"������" + (result>0?"�ɹ�":"ʧ��");
			labelView.setText(msg);
		}	
    };
    
    OnClickListener updateButtonListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			People people = new People();
			people.Name = nameText.getText().toString();
			people.Age = Integer.parseInt(ageText.getText().toString());
			people.Height = Float.parseFloat(heightText.getText().toString());
			long id = Integer.parseInt(idEntry.getText().toString());
			long count = dbAdepter.updateOneData(id, people);
			if (count == -1 ){
				labelView.setText("���´���");
			} else {
				labelView.setText("���³ɹ�����������"+String.valueOf(count)+"��");	
				
			}
		}
    };

}