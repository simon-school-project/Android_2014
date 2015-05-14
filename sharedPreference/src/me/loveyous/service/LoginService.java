package me.loveyous.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.xml.sax.InputSource;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class LoginService {
	//保存用户密码的业务方法
	public static  void saveUserInfo(Context context,String username,String password){
	SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
		Editor editor=sp.edit();
		editor.putString("username", username);
		editor.putString("password", password);
		editor.commit();
	}
	
	public static Map<String ,String> getSavedUserInfo(Context context){
		File file = new File(context.getFilesDir(),"info.txt");
		try {
			FileInputStream fis = new  FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String str = br.readLine();
			
			String [] infos = str.split("##");
			Map<String, String> map = new HashMap<String, String>();
			map.put("username", infos[0]);
			map.put("password", infos[1]);
			return map;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}


