package com.qiubai.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseDate {
	public String DateToString(Date date){
		
		String pattern = "yyyy-MM-dd hh:mm:ss";
		
		String strParse = new SimpleDateFormat(pattern).format(date);
		
		return strParse;
		
	}
}
