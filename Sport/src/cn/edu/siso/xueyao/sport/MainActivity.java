/*嵌入123   薛尧*/
package cn.edu.siso.xueyao.sport;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.TextureView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //控件的引用
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        TextView textView2 = (TextView)findViewById(R.id.textView2);
        TextView textView3 = (TextView)findViewById(R.id.textView3);
        RadioButton radioButton1 = (RadioButton)findViewById(R.id.radioButton1);
        RadioButton radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
        RadioButton radioButton3 = (RadioButton)findViewById(R.id.radioButton3);
        CheckBox checkBox1 = (CheckBox)findViewById(R.id.checkBox1);
        CheckBox checkBox2 = (CheckBox)findViewById(R.id.checkBox2);
        CheckBox checkBox3 = (CheckBox)findViewById(R.id.checkBox3);
        CheckBox checkBox4 = (CheckBox)findViewById(R.id.checkBox4);
        CheckBox checkBox5 = (CheckBox)findViewById(R.id.checkBox5);
       final TextView textView4 = (TextView)findViewById(R.id.textView4);
       
       //RadioButton按钮控件的监听器
        RadioButton.OnClickListener rClickListener= new RadioButton.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.radioButton1:
					Toast.makeText(MainActivity.this,"你选择教师", 1000).show();//提示
					textView4.setText("  你选择的职务是教师");
					break;
				case R.id.radioButton2:
					Toast.makeText(MainActivity.this,"你选择学生", 1000).show();
					textView4.setText("  你选择的职务是学生");
					break;
				case R.id.radioButton3:
					Toast.makeText(MainActivity.this,"你选择家长", 1000).show();
					textView4.setText("  你选择的职务是家长");
					break;
				default:
					break;
				}
			}
        	
        };
        CheckBox.OnClickListener clickListener = new CheckBox.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.checkBox1:
					Toast.makeText(MainActivity.this,"你选择游泳", 1000).show();
					break;
				case R.id.checkBox2:
					Toast.makeText(MainActivity.this,"你选择跳远", 1000).show();
					break;
				case R.id.checkBox3:
					Toast.makeText(MainActivity.this,"你选择跑步", 1000).show();
					break;
				case R.id.checkBox4:
					Toast.makeText(MainActivity.this,"你选择篮球", 1000).show();
					break;
				case R.id.checkBox5:
					Toast.makeText(MainActivity.this,"你选择排球", 1000).show();
					break;
				default:
					break;
				}
			}
        	
        };
        
        //定义各个控件的监听器
        radioButton1.setOnClickListener(rClickListener);
        radioButton2.setOnClickListener(rClickListener);
        radioButton3.setOnClickListener(rClickListener);

        checkBox1.setOnClickListener(clickListener);
        checkBox2.setOnClickListener(clickListener);
        checkBox3.setOnClickListener(clickListener);
        checkBox4.setOnClickListener(clickListener);
        checkBox5.setOnClickListener(clickListener);

        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
