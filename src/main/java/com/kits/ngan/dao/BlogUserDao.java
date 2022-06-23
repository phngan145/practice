package com.kits.ngan.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kits.ngan.entity.BlogUser;


public class BlogUserDao implements BlogDao<BlogUser>{
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void connect() {
		conn = MySqlConnector.getPreparedConnection();		
	}
	private void closed() {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * @param id - Primary Key : Unique
	 */
	@Override
	public BlogUser findOne(int id) {
		connect();
		try {
			pstmt = conn.prepareStatement(
					"select * from blog_user where user_id=?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				BlogUser user = new BlogUser();
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closed();
		}
		return null;
	}

	@Override
	public List<BlogUser> findAll() {
		connect();
		try {
			pstmt = conn.prepareStatement("select * from blog_user");
			rs = pstmt.executeQuery();
			List<BlogUser> list = new ArrayList<BlogUser>();
			while(rs.next()) {
				BlogUser user = new BlogUser();
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closed();
		}
		return null;
	}

	@Override
	public List<BlogUser> find(BlogUser arg) {
		connect();
		try {
			pstmt = conn.prepareStatement("select * from blog_user where name=? or email=?");
			pstmt.setString(1, arg.getName());
			pstmt.setString(2, arg.getEmail());
			rs = pstmt.executeQuery();
			List<BlogUser> list = new ArrayList<BlogUser>();
			while(rs.next()) {
				BlogUser user = new BlogUser();
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				list.add(user);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closed();
		}
		return null;
	}

	@Override
	public int insert(BlogUser arg) {
		connect();
		try {
			pstmt = conn.prepareStatement("insert into blog_user (name, email) values (?,?)");
			pstmt.setString(1, arg.getName());
			pstmt.setString(2, arg.getEmail());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closed();
		}
		return 0;
	}

	@Override
	public void update(BlogUser arg) {
		connect();
		try {
			pstmt = conn.prepareStatement("update blog_user set name=?, email=? where user_id=?");
			pstmt.setString(1, arg.getName());
			pstmt.setString(2, arg.getEmail());
			pstmt.setInt(3, arg.getUserId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closed();
		}
		
	}

	@Override
	public void delete(int id) {
		connect();
		try {
			pstmt = conn.prepareStatement("delete from blog_user where user_id=?");
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closed();
		}
		
	}
	
	

}