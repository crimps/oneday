package com.crimps.ui;

import com.crimps.service.db.DbUtils;

import javax.swing.*;

/**
 * Sqlite数据库服务
 *
 * @author crimps
 * @create 2017-10-19 10:13
 **/
public class MainUI extends JFrame {
    public MainUI() {
        initDB();
        this.setSize(300, 200);
    }

    private void initDB() {
        DbUtils dbUtils = new DbUtils();
//        dbUtils.test();
    }
}
