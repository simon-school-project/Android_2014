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

public class LoginService {
	//�����û������ҵ�񷽷�
	public static  boolean saveUserInfo(Context context,String username,String password){
		try {
			
			//File file = new File("/data/data/me.loveyous.login/info.txt");
			File file = new File("/sdcard/info.txt" );
			FileOutputStream fos  = new FileOutputStream(file);
			try {
				fos.write((username+"##"+password).getBytes());
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public static Map<String ,String> getSavedUserInfo(Context context){
		File file = new File("/sdcardinfo.txt");
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


