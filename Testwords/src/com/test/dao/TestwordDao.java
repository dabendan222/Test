package com.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.test.entity.WordsEntity;

public class TestwordDao extends DBconnection{
	Connection con = getconnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	/**
	 * @param user
	 * ≤È—Ø∆¡±Œ¥ ª„
	 */
	public List<WordsEntity> selectAll(){
		List<WordsEntity> list = new ArrayList<WordsEntity>();
		try {
			ps = con.prepareStatement("SELECT WORDS_CONTENT FROM WORDS");
			rs = ps.executeQuery();
			while(rs.next()){
				WordsEntity we = new WordsEntity();
				we.setWords_content(rs.getString(1));
				list.add(we);
			}
		} catch (Exception e) {
		} finally{
			closeStatement(ps);
			closeResultSet(rs);
			closeConnection(con);
		}
		return list;
	}
	public static void main(String[] args) {
		TestwordDao t = new TestwordDao();
		List<WordsEntity> list = t.selectAll();
		for(WordsEntity wordsEntity:list){
			System.out.println(wordsEntity.getWords_content()+"\t");
		}
	}
}
