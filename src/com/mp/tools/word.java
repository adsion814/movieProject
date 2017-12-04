package com.mp.tools;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.mp.bean.SensitiveWord;





public class word {

	public static String strword(String str) throws Exception{
		Set<String> set=new HashSet<String>();
		JDBCUtils jdbc = JDBCUtils.getJDBC();
		String sql = "select word from sensitiveword";
		List<SensitiveWord> list = jdbc.findMoreRefResult(sql, null, SensitiveWord.class);
	   Iterator<SensitiveWord> iterator = list.iterator();
	    set=new HashSet<String>(); 
		while(iterator.hasNext()){
			String a = iterator.next().getWord();
			 set.add(a);
		}
		SensitiveWordOperate swo=new SensitiveWordOperate();
		swo.addSensitiveWordToHashMap(set);
		str=swo.replaceSensitiveWord(str, "*");
		
		return str;
	}
	public static void main(String[] args) throws Exception {
		String str1= "wwww";
		String str2 = strword(str1);
		
	}
}
