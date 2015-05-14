package cn.edu.siso.xueyao.pull;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;

import android.util.Xml;

public class PersonService {

	public static List<Person> getPersons(InputStream xml)throws Exception{
		//XmlPullParser pullParser = XmlPullParserFactory.newInstance().newPullParser();
		List<Person> persons = null;
		
		Person person = null;
		XmlPullParser pullParser = Xml.newPullParser();
		 pullParser.setInput(xml, "UTF-8");
		int event= pullParser.getEventType();
		while (event!=XmlPullParser.END_DOCUMENT ) {

			switch (event) {
			case XmlPullParser.START_DOCUMENT:
				persons = new ArrayList<Person>();
				break;
	
			case XmlPullParser.START_TAG:
				if("person".equals(pullParser.getName())){
					int id= new Integer(pullParser.getAttributeValue(0));	
					person = new Person();
					person.setId(id);
				}
				
				if ("name".equals(pullParser.getName())) {
					String name =pullParser.nextText();
					person.setName(name);
				}
				
				if ("age".equals(pullParser.getName())) {
					int age= new Integer(pullParser.nextText());	
					person.setAge(age);
				}
				break;
				
				case XmlPullParser.END_TAG:
					if("person".equals(pullParser.getName())){
						int id= new Integer(pullParser.getName());	
						persons.add(person);
						person=null;
					}
					break;
			}
			
			event =	pullParser.next();
		}
		return persons;
		
	}
}
