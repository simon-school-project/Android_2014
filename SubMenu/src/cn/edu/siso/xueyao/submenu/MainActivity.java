package cn.edu.siso.xueyao.submenu;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.view.Menu;
import android.view.SubMenu;

public class MainActivity extends Activity {
	
	final static int MENU_00 = Menu.FIRST;
	final static int MENU_01 = Menu.FIRST+1;
	final static int SUBMENU_00_0 = Menu.FIRST+2;
	final static int SUBMENU_01_0 = Menu.FIRST+3;
	final static int SUBMENU_01_1 = Menu.FIRST+4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
    		SubMenu sub1 = (SubMenu)menu.addSubMenu(0, MENU_00, 0, "����");
    				sub1.add(0, SUBMENU_00_0, 0, "��ӡ");
    				
    		SubMenu sub2 = (SubMenu)menu.addSubMenu(0, MENU_01, 0, "�½�");
    				sub2.add(0, SUBMENU_01_0, 0, "�ʼ�");
    				sub2.add(0, SUBMENU_01_1, 0, "����");
    		return true;
    }
    
}
