package com.test.service;

import java.util.List;
import java.util.Scanner;

import com.test.dao.TestwordDao;
import com.test.entity.MessageEntity;
import com.test.entity.WordsEntity;

public class TestwordService {
	public boolean testWords(MessageEntity me){
		boolean flag = false;
		TestwordDao td = new TestwordDao();
		String mes_con =me.getMessage_content();
		List<WordsEntity> list = td.selectAll();
		for(WordsEntity wet:list){
			if(mes_con.indexOf(wet.getWords_content()) != -1){
				flag = false;
				System.out.println("¡Ù—‘ ß∞‹£∫”–Ω˚÷π¥ ª„"+wet.getWords_content());
				break;
			}
		}	
		return flag;
	}
	public static void main(String[] args) {
		System.out.println("--------------testWords (UserEntity user)------------");
		MessageEntity me = new MessageEntity();
		Scanner sc = new Scanner(System.in);
	 	me.setFrom_id(11);
	 	System.out.println("¡Ù—‘ƒ⁄»›");
	 	me.setMessage_content(sc.next());
	 	System.out.println("to id");
	 	me.setTo_id(sc.nextInt());
	 	TestwordService t = new TestwordService();
	 	t.testWords(me);
	}
}
