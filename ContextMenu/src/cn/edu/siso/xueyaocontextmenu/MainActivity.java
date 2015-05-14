package cn.edu.siso.xueyaocontextmenu;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView textView = null;
	final static int  CONTENT_MENU_1 = Menu.FIRST;
	final static int  CONTENT_MENU_2 = Menu.FIRST+1;
	final static int  CONTENT_MENU_3 = Menu.FIRST+2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      textView = (TextView)findViewById(R.id.textView1);
        registerForContextMenu(textView);
        }

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		//super.onCreateContextMenu(menu, v, menuInfo);
		
			menu.setHeaderTitle("��ݲ˵�����");
			menu.add(0, CONTENT_MENU_1, 0, "�˵�����1");
			menu.add(0, CONTENT_MENU_2, 1, "�˵�����2");
			menu.add(0, CONTENT_MENU_3, 2, "�˵�����3");
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
			switch (item.getItemId()) {
			case CONTENT_MENU_1:
				textView.setText("�˵�����1");
				break;
			case CONTENT_MENU_2:
				textView.setText("�˵�����2");
				break;
			case CONTENT_MENU_3:
				textView.setText("�˵�����3");
				break;
			default:
				break;
			}
		return false;
		// TODO Auto-generated method stub
		//return super.onContextItemSelected(item);
	}
		
	
    
    
}
