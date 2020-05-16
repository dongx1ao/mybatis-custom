package com.peter.mybatis.v1;

public class GPSqlSession {
    private GPConfiguration configuration;

    private GPExecutor executor;

    public GPSqlSession(GPConfiguration configuration, GPExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T selectOne(String statementId, Object paramater) {
        //根据statementId拿到sql
        String sql = GPConfiguration.sqlMapping.getString(statementId);
        if(null != sql && !"".equals(sql)){
            return executor.query(sql,paramater);
        }
        return null;
    }

    public <T> T getMapper(Class clazz){
        return configuration.getMapper(clazz,this);
    }


}
