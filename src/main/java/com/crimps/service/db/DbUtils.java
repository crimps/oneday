package com.crimps.service.db;

import com.crimps.ui.MainUI;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.*;

/**
 * Sqlite数据库服务
 *
 * @author crimps
 * @create 2017-10-19 10:13
 **/
public class DbUtils {
    private final String DB_CLASS_NAME = "org.sqlite.JDBC";
    private final String DB_URL = "jdbc:sqlite:" + MainUI.rootPath + "/resources/sqlite/oneday.db";
    private Connection connection;

    public DbUtils() {
        try {
            Class.forName(DB_CLASS_NAME);
            connection = DriverManager.getConnection(DB_URL);
            connection.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭数据库连接
     */
    public void close() {
        try {
            if (null != connection) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("SQLException in close Connection " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 执行查询sql语句
     * @param sqlStr sql语句
     * @return 查询结果
     */
    public List<Object> executeSelectSql(String sqlStr, Class<?> classType) {
        List<Object> resultList = new ArrayList<Object>();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlStr);
            while (resultSet.next()) {
                List<Field> fieldList = Arrays.asList(classType.getDeclaredFields());
                Object object = classType.newInstance();
                for (Field field : fieldList) {
                    String name = StringUtils.capitalize(field.getName());
                    Method method = classType.getMethod("set" + name, String.class);
                    method.invoke(object, resultSet.getString(field.getName()));
                }
                resultList.add(object);
            }
        } catch (Exception e) {
            System.out.println("SQLException in exectueSql " + e.getMessage());
            System.out.println(sqlStr);
            e.printStackTrace();
        }finally {
            try {
                if (null != resultSet) {
                    resultSet.close();
                }
                if (null != statement) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("SQLException in exectueSql finally :" + e.getMessage());
                e.printStackTrace();
            }
            return resultList;
        }
    }

    /**
     * 执行插入/更新语句
     * @param sqlStr 插入/更新语句
     * @return 1:操作成功;2:未操作任何数据;-1:操作失败
     */
    public int executeUpdateSql(String sqlStr) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            return statement.executeUpdate(sqlStr);
        } catch (SQLException e) {
            System.out.println("SQLException in executeUpdateSql :" + e.getMessage());
            e.printStackTrace();
            return -1;
        }finally {
            try {
                if (null != statement) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("SQLException in executeUpdateSql finally :" + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
