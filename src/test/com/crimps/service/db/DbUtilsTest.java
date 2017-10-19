package com.crimps.service.db;

import com.crimps.entiey.TestEntity;
import org.junit.Test;

import java.sql.ResultSet;
import java.util.List;

import static org.junit.Assert.*;


/**
 * 测试实体
 *
 * @author crimps
 * @create 2017-10-19 14:36
 **/
public class DbUtilsTest {
    private DbUtils dbUtils = new DbUtils();

    @Test
    public void executeSql() {
        String createTableSql = "SELECT id, name FROM hehe where id>5";
        dbUtils.executeSelectSql(createTableSql, TestEntity.class);

        int resutl = dbUtils.executeUpdateSql("INSERT INTO hehe VALUES(\"32432\", '我爱中国32432')");
        System.out.println(resutl);
    }
}