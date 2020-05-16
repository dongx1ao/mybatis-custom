package com.peter.mybatis.v2.executor;

import java.util.HashMap;
import java.util.Map;

/**
 * 带缓存的执行器，用于装饰基本执行器
 */
public class CachingExecutor implements Executor{

    private Executor delegate;
    private static final Map<Integer,Object> cache = new HashMap<Integer, Object>();

    public CachingExecutor(Executor delegate) {
        this.delegate = delegate;
    }

    @Override
    public <T> T query(String statement, Object[] parameter, Class pojo) {
        return null;
    }
}
