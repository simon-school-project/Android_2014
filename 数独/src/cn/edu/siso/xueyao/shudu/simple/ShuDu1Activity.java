package cn.edu.siso.xueyao.shudu.simple;


import android.app.Activity;
import android.os.Bundle;

public class ShuDu1Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        setContentView(new MyView(this));
    }
}