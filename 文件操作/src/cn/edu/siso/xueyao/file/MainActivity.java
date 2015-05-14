package cn.edu.siso.xueyao.file;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText etName, etContent;
	private Button btSave;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etName = (EditText)findViewById(R.id.etName);
		etContent = (EditText)findViewById(R.id.etContent);
		btSave = (Button)findViewById(R.id.btSave);
		
		btSave.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String filename = 	etName.getText().toString();
				String content = etContent.getText().toString();
			
				FileService service = new FileService(getApplicationContext());
				try {
					service.save(filename,content);
					Toast.makeText(getApplicationContext(), "添加成功", 1000).show();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					Toast.makeText(getApplicationContext(), "添加失败", 1000).show();

					e.printStackTrace();
				}
				
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
