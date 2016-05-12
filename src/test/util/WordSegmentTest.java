package test.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import jeasy.analysis.MMAnalyzer;

public class WordSegmentTest {
	public static void main(String args[]){
		MMAnalyzer analyzer=new MMAnalyzer();
		String text="ϰ��ƽͬ־�����簲ȫ����Ϣ��������̸����ָ��������ռ����������ڹ�ͬ�ľ����԰��"
				+ "�������������԰����������ҵ����Ҫ���壬��Ҫ����չ��ҲҪ�����Ρ���������ҵ���������֮�У�"
				+ "����ֻ���������Ρ��������Σ���Ҫ��������Ρ��������Ρ��ҹ���������ҵ�ڿ��ٷ�չ�����У�"
				+ "�е��˺ܶ�������Σ������˴�����ṱ�ף���Ҳ��һЩ��ҵֻ�˷�չ���������Σ������ڷ�չ�к�����������һ�棬"
				+ "���²������⡣����������һЩ�������¼���͹������ǿ��������ҵ���������ʶ�Ľ�����";
		
		LinkedHashMap<String,Integer> statisticTab=new LinkedHashMap<String,Integer>();
		
		try{
			/*
			 * split the result into string array.
			 */
			String[] words=analyzer.segment(text, "|").split("|");
			for(String str:words){
				if(!statisticTab.containsKey(str)){
					statisticTab.put(str, 1);
				}else{
					statisticTab.put(str, statisticTab.get(str)+1);
				}
			}
			
			Iterator<Entry<String,Integer>> it=statisticTab.entrySet().iterator();
			while(it.hasNext()){
				Entry<String,Integer> entry=it.next();
				System.out.println(entry.getKey()+" "+entry.getValue());
			}
			
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
