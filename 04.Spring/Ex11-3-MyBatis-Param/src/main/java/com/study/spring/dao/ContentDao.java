package com.study.spring.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.study.spring.dto.ContentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class ContentDao implements IDao{

	// SQL문을 DB에 전달 및 처리 역할
//	private static IDao instance = new IDao();
//	DataSource dataSource = null;
	
	JdbcTemplate template = null;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;	
	}
	
	
	public ContentDao() {
				
	}
//	public static IDao getInstance(){
//		return instance;
//	}


	public ArrayList<ContentDto> listDao() {
		String query = "select * from board order by mId desc";
		ArrayList<ContentDto> dtos =
				(ArrayList<ContentDto>)
				template.query(query, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
		return dtos;
	}
	
	public void writeDao(final String mWriter,final String mContent) {
		System.out.println("writeDao()");
		
		this.template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) 
					throws SQLException {
				String query = "insert into board (mId, mWriter, mContent) values (board_seq.nextval, ?, ?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, mWriter);
				pstmt.setString(2, mContent);
				return pstmt;
			}
			
		});
	}	
	
	public ContentDto viewDao(String strID) {
		System.out.println("viewDao()");
		
		
		String query = "select * from board where mId = " + strID;
		return template.queryForObject(query, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
	}
	
	public void deleteDao(final String mId) { // 조회수 증가(+1)
		System.out.println("deleteDao()");
		
		String query = "delete from board where mId = ?";
		this.template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(mId));	
		
			}
		});	
	}
	
	
	public ContentDto contentView(String strID) {
		upHit(strID);

		String query = "select * from board where mId = " + strID;
			
		return template.queryForObject(query, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
	}
	public void modify(final String bId,final String bName,final String bTitle,final String bContent) {
		String query = "update board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
		template.update(query, new PreparedStatementSetter() {
		
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {	
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bId));
			}	
		});
	}
	public void upHit(final String bId) { // 조회수 증가(+1)
		
		String query = "update board set bHit = bHit + 1 where bId = ?";
		template.update(query, new PreparedStatementSetter() {	
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {	
				
				ps.setInt(1, Integer.parseInt(bId));
				
				
			}
		});
	}
	
	
		
	
	public ContentDto reply_view(String str) {
		
		String query = "select * from board where bId = " + str;
		return template.queryForObject(query, new BeanPropertyRowMapper<ContentDto>(ContentDto.class));
	}
	
	public void reply(final String bId,final String bName,final String bTitle,final String bContent, 
			final String bGroup,final String bStep,final String bIndent) 
	{
		String query = "insert into board "
					+ "(bId, bName, bTitle, bContent, bGroup, bStep, bIndent) "
					+ "values (mvc_board_seq.nextval, ?, ?, ?, ?, ?, ?)";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, bName);
				ps.setString(2, bTitle);
				ps.setString(3, bContent);
				ps.setInt(4, Integer.parseInt(bGroup));
				ps.setInt(5, Integer.parseInt(bStep) + 1);
				ps.setInt(6, Integer.parseInt(bIndent) + 1);
			}
		
		});
	}
	
//	public void replyShape(final String strGroup,final String strStep) {
//			
//		String query = "update board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
//		template.update(query, new PreparedStatementSetter() {
//			
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setInt(1, Integer.parseInt(strGroup));
//				ps.setInt(2, Integer.parseInt(strStep));
//			}
//		});
//	}
//	
//	public BPageInfo articlePage(int curPage) {
//				
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet resultSet = null;
//		
//		int listCount = 10;
//		int pageCount = 10;
//		
//		// 총 게시물 갯수
//		int totalCount = 0;
//		try {
//			con = dataSource.getConnection();
//			
//			String query = "select count(*) as total from mvc_board";
//			pstmt = con.prepareStatement(query);
//			resultSet = pstmt.executeQuery();
//
//			if (resultSet.next()) {
//				totalCount = resultSet.getInt("total");
//			}				
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (resultSet != null) resultSet.close();
//				if (pstmt != null) pstmt.close();
//				if (con != null) con.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		// 총 페이지 수
//		int totalPage = totalCount / listCount;
//		if (totalCount % listCount > 0)
//			totalPage++;
//		
// 	 // 현재 페이지
//		int myCurPage = curPage;
//		if (myCurPage > totalPage)
//			myCurPage = totalPage;
//		if (myCurPage < 1)
//			myCurPage = 1;
//		// 시작 페이지
//		int startPage = ((myCurPage - 1) / pageCount) * pageCount + 1;
//		
//		// 끝 페이지
//		int endPage = startPage + pageCount - 1;
//		if (endPage > totalPage)
//			endPage = totalPage;
//		
//		BPageInfo pinfo = new BPageInfo();
//		pinfo.setTotalCount(totalCount);
//		pinfo.setListCount(listCount);
//		pinfo.setTotalPage(totalPage);
//		pinfo.setCurPage(curPage);
//		pinfo.setPageCount(pageCount);
//		pinfo.setStartPage(startPage);
//		pinfo.setEndPage(endPage);
//
//		return pinfo;
	}