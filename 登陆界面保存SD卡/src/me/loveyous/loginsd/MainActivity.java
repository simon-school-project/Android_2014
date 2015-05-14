package me.loveyous.loginsd;

import java.util.Map;

import me.loveyous.service.LoginService;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
    private EditText etUsername,etPassword;
    private CheckBox checkbox;
    private Button btLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        checkbox = (CheckBox)findViewById(R.id.checkBox1);
        btLogin = (Button)findViewById(R.id.btLogin);
        btLogin.setOnClickListener(this);
        Map<String, String> map =  LoginService.getSavedUserInfo(this);
        if (map!= null) {
			etUsername.setText(map.get("username"));
			etPassword.setText(map.get("password"));
		}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		String username = etUsername.getText().toString().trim();
		String password = etPassword.getText().toString().trim();
		if (TextUtils.isEmpty(username)||TextUtils.isEmpty(password)) {
			Toast.makeText(this, "用户名或者密码不能为空", Toast.LENGTH_LONG).show();
			return;
		} else {
			if (checkbox.isChecked()) {
			 boolean result =LoginService.saveUserInfo(this,username, password);
			 	if (result) {
					Toast.makeText(this, "保存用户信息成功", Toast.LENGTH_SHORT).show();

				}
			} 
			if ("zhangsan".equals(username)&&"123".equals(password)) {
				Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this, "登陆失败，用户名或者密码错误", Toast.LENGTH_SHORT).show();

			}
		}
	}
    
}
