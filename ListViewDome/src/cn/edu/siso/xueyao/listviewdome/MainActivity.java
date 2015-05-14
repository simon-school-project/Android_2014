package cn.edu.siso.xueyao.listviewdome;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView  = (ListView)findViewById(R.id.listView1);
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        TextView textView2 = (TextView)findViewById(R.id.textView2);
        ImageView tImageView = (ImageView)findViewById(R.id.imageView1);
        
        
        ArrayList<HashMap<String, Object>> list1 = new ArrayList<HashMap<String,Object>>();
        
        HashMap<String,Object> list2 =new HashMap<String, Object>();
        list2.put("name", "Ñ¦Ò¢");
        list2.put("number", "120119043");
        list2.put("image", R.drawable.stone);
        list1.add(list2);
        
        			list2 = new  HashMap<String, Object>();
        			list2.put("name" ,"Ðì³¬");
        	        list2.put("number", "12011902");
        	        list2.put("image", R.drawable.xc);
        	        list1.add(list2);
        	        
        	        list2 = new  HashMap<String, Object>();
        	        list2.put("name", "ÉòÁú»ª");
        	        list2.put("number", "120119035");
        	        list2.put("image", R.drawable.slh);
        	        list1.add(list2);
        	        
        	       SimpleAdapter adapter  = new SimpleAdapter(this, list1, R.layout.item,
        	    		   new String[]{"name","number","image"}, 
        	    		   new int []{R.id.textView1,R.id.textView2,R.id.imageView1});
        	       listView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
