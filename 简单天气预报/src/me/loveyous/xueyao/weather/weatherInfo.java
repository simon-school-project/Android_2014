/**
 * 
 */
package me.loveyous.xueyao.weather;

/**
 * @author ѦҢ
 *2014-5-15
 * 
 */

import org.xmlpull.v1.XmlPullParser;

public class weatherInfo{  
          
            static String cityname = "����";  
            static String stateDetailed ="����ת����";  
            static String tem1 ="28";   
            static String tem2 ="22";   
            static String temNow ="25";  
            static String windState="΢��";  
            static String windDir="����";  
            static String windPower="2��";  
            static String humidity="63%";  
            static String time="10:30";  
              
            public void setCityWeatherInfo(XmlPullParser xmlParser)  
            {  
                cityname = xmlParser.getAttributeValue(null, "cityname");  
                stateDetailed = xmlParser.getAttributeValue(null, "stateDetailed");  
                tem1 = xmlParser.getAttributeValue(null, "tem1");  
                tem2 = xmlParser.getAttributeValue(null, "tem2");  
                temNow = xmlParser.getAttributeValue(null, "temNow");  
                windState = xmlParser.getAttributeValue(null, "windState");  
                windDir = xmlParser.getAttributeValue(null, "windDir");  
                windPower = xmlParser.getAttributeValue(null, "windPower");  
                humidity = xmlParser.getAttributeValue(null, "humidity");  
                time = xmlParser.getAttributeValue(null, "time");  
            }  
              
            public String getCityWeatherInfo()  
            {  
                String info = "���ڳ��У�"+cityname + "\n"  
                    +"���������"+stateDetailed + ", ʪ�ȣ�" +humidity + "\n"  
                    +"�������£�"+temNow + "��C, "+"��ͣ�"+tem2 + "��C, "+"��ߣ�"+tem1 + "��C\n"  
                    +"���飺"+windState +", ����"+windDir + ", ������"+windPower + "\n"                  
                    +"����ʱ�䣺"+time + "\n";  
                return info;  
            }  
      
    }  