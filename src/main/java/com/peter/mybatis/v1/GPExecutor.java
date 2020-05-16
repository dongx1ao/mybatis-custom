package com.peter.mybatis.v1;

import com.peter.mybatis.v1.mapper.Blog;

import java.sql.*;

public class GPExecutor {
    public <T> T query(String sql,Object paramater){
        Connection conn = null;
        Statement stmt = null;
        Blog blog = new Blog();
        try {
            //注册JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");

            //打开连接
            DriverManager.getConnection("jdbc:mysql://192.168.1.21:3306/gp-mybatis","root","123456");

            //执行查询
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(String.format(sql, paramater));

            //获取结果集
            while(rs.next()){
                Integer bid = rs.getInt("bid");
                String name = rs.getString("name");
                Integer authorId = rs.getInt("author_id");
                blog.setAuthorId(authorId);
                blog.setBid(bid);
                blog.setName(name);
            }
            System.out.println(blog);

            rs.close();
            stmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        return (T)blog;
    }

}
