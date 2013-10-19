package com.example.inclass4;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Currency;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;




import android.util.Log;


public class ThisUtils {
	static int flag = 0;
	
static class mySAXParser extends DefaultHandler{
		static ArrayList<Data> thisData;
		static Data onedata = null;
		static Data finaldata = new Data();
		static Data parseData(InputStream xml) throws IOException, SAXException, XmlPullParserException{
			
			XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
			parser.setInput(xml,"UTF-8");
			finaldata.setName("xxx");
			finaldata.setPrice("0.0");
			
		    int event = parser.getEventType();
		    while (event != XmlPullParser.END_DOCUMENT){
		    	
		    	switch(event){
		    	
		    	case XmlPullParser.START_TAG:
		    		if(parser.getName().equals("entry")){
		    			onedata = new Data();
		    		}
		    		else if(parser.getName().equals("im:name")){
		    			onedata.setName(parser.nextText().trim());
		    	    }
		    	    else if(parser.getName().equals("im:price")){
		    			    onedata.setPrice(parser.nextText().trim());
		    		}else if(parser.getName().equals("im:image")){
		    			if(parser.getAttributeValue(null, "height") != null ){ 
		    			    onedata.setImageUrl(parser.nextText().trim());
		    			    flag = 1;
		    			}
		    		}
		    		break;
		    	case XmlPullParser.END_TAG:
		    		if(onedata != null && flag == 1){
		    			//Log.d("Mrunal", "End Tag  = " + " name = " + onedata.getName() + " price " + onedata.getPrice() + " imageurl = " + onedata.getImageUrl());
		    			Log.d("Mrunal" , "get Prics = " + onedata.getPrice());
		    			//Log.d("Mrunal" , "get Prics = " + Double.parseDouble(onedata.getPrice() ));
		    			flag = 0;
		    			try {
		    			Double p1 = Double.parseDouble(onedata.getPrice() );
		    			Double p2 = Double.parseDouble(finaldata.getPrice());
		    			if(p1 > p2){
			    			finaldata.setName(onedata.getName());
			    			finaldata.setPrice(onedata.getPrice());
			    			finaldata.setImageUrl(onedata.getImageUrl());
		    			}
		    			}catch (NumberFormatException e){
		    				Log.d("Mrunal","Numebr format exception");
		    			}
		    		}
		    		break;
		    	default:
		    		break;
		    	}	
		    	event = parser.next();
		}
			return finaldata;
}
}
}
