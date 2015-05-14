package cn.edu.siso.xueyao.file;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.content.Context;

public class FileService {

	private Context context;
	public FileService(Context context) {
		super();
		this.context = context;
	}
	public void save(String filename, String content) throws Exception {
		// TODO Auto-generated method stub
		
		
		
			FileOutputStream outStream = context.openFileOutput(filename,Context.MODE_PRIVATE );
		
			outStream.write(content.getBytes());
			outStream.close();
	}
	
	public String read(String filename) throws Exception {
		
		FileInputStream inStream = context.openFileInput(filename);
		ByteArrayOutputStream outsStream = new ByteArrayOutputStream();
		byte [] buffer = new byte[1024];
		int len =0;
		while((len=inStream.read(buffer)) !=-1){
			outsStream.write(buffer,0,len);
		}
		
		byte [] data = outsStream.toByteArray(); 
		return new String(data);
		
	}

}
