package com.peter.mybatis.v1;

import com.peter.mybatis.v1.mapper.BlogMapper;

public class MyBatisBoot {
    public static void main(String[] args) {
        GPSqlSession sqlSession =  new GPSqlSession(new GPConfiguration(),new GPExecutor());
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        blogMapper.selectBlogById(1);

    }
}
