package me.loveyous.xueyao.weather;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.util.Xml;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private EditText address;
	private TextView content;
	private Button search;
	
	final String DEBUG_TAG = "weather";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		address = (EditText)findViewById(R.id.address);
		content = (TextView)findViewById(R.id.content);
		content.setMovementMethod(ScrollingMovementMethod.getInstance());
		search = (Button)findViewById(R.id.search);
		
		search.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				connect();
			}

			
		});
	}

	private void connect() {
		// TODO Auto-generated method stub
		
		String httpUrl = "http://flash.weather.com.cn/wmaps/xml/"+address.getText().toString()+".xml";
		String resultDate = "";
		
		URL url = null;
		
		try {
			url = new URL(httpUrl);
			GetXmlToLocat(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.e(DEBUG_TAG, "MalformedURLException");  		
			}
		
		if (url != null) {
			try {
				HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
				InputStreamReader in = new InputStreamReader(urlConnection.getInputStream());
				BufferedReader buffer = new BufferedReader(in);
				String inputLine = null;
				
				while (((inputLine=buffer.readLine())!=null)) {
					resultDate += inputLine +"\n";
					
				}
				in.close();
				urlConnection.disconnect();
				
				if (resultDate !=null) {
					content.setText("");
					weatherInfoXmlPullParser(resultDate);
				}else {
					content.setText("��ȡ������ΪNULL");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
				Log.e(DEBUG_TAG, "IOException");
			}
			
		}else {
			 Log.e(DEBUG_TAG, "Url NULL");  
		}
	}

	/**
	 * @param resultDate
	 */
	public void weatherInfoXmlPullParser(String buffer){  
        
        XmlPullParser xmlParser = Xml.newPullParser();//���XmlPullParser������     
          
        ByteArrayInputStream tInputStringStream = null;  
        if (buffer != null && !buffer.trim().equals(""))  
        {  
           tInputStringStream = new ByteArrayInputStream(buffer.getBytes());  
        }  
        else  
        {  
            return ;  
        }  
      
        try   
        {  
            //�õ��ļ����������ñ��뷽ʽ  
            //InputStream inputStream=mContext.getResources().getAssets().open(fileName);  
            //xmlParser.setInput(inputStream, "utf-8");  
            xmlParser.setInput(tInputStringStream, "UTF-8");  
              
            //��ý��������¼���������п�ʼ�ĵ��������ĵ�����ʼ��ǩ��������ǩ���ı��ȵ��¼���  
            int evtType=xmlParser.getEventType();  
               
            while(evtType!=XmlPullParser.END_DOCUMENT)//һֱѭ����ֱ���ĵ�����     
            {   
                switch(evtType)  
                {   
                case XmlPullParser.START_TAG:  
                    String tag = xmlParser.getName();   
                    //�����city��ǩ��ʼ����˵����Ҫʵ����������  
                    if (tag.equalsIgnoreCase("city"))   
                    {   
                        weatherInfo info = new weatherInfo();   
                        //ȡ����ǩ�е�һЩ����ֵ  
                        info.setCityWeatherInfo(xmlParser);  
                        content.append(info.getCityWeatherInfo()+"\n");  
                    }  
                    break;  
                   
                case XmlPullParser.END_TAG:  
                    //��ǩ����                     
                default:break;  
                }  
                //���xmlû�н������򵼺�����һ���ڵ�  
                evtType=xmlParser.next();  
            }  
        }   
        catch (XmlPullParserException e) {  
             // TODO Auto-generated catch block  
             e.printStackTrace();  
        }  
        catch (IOException e1) {  
             // TODO Auto-generated catch block  
             e1.printStackTrace();  
        }   
    }  

	/**
	 * @param url
	 */
	private void GetXmlToLocat(URL url) {
		// TODO Auto-generated method stub
		try {
			InputStream is = url.openStream();
			OutputStream os = openFileOutput("weatherdata.xml", MODE_PRIVATE);
			byte [] buff = new byte[1024];
			int hasRead = 0;
			while ((hasRead=is.read(buff))>0) {
				os.write(buff,0,hasRead);
			}
			
			is.close();
			os.flush();
			os.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
