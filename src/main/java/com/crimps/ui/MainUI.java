package com.crimps.ui;

import com.crimps.service.db.DbUtils;

import javax.swing.*;
import java.awt.*;

/**
 * oneday主界面
 *
 * @author crimps
 * @create 2017-10-19 10:13
 **/
public class MainUI extends JFrame {

    /**
     * 是否锁定：true:锁定;false:已解锁
     */
    private boolean isLock = true;

    public DbUtils dbUtils;
    private JPanel mainUIPanel;
    private PasswordPanel passwordPanel;
    private LoadingDataPanel loadingDataPanel;

    public MainUI() {
        mainUIPanel = new JPanel();
        mainUIPanel.setLayout(new BorderLayout());
        loadingDataPanel = new LoadingDataPanel();
        mainUIPanel.add(loadingDataPanel, BorderLayout.CENTER);
        this.setSize(300, 200);
        Thread initThread = new Thread(){
            @Override
            public void run() {
                init();
            }
        };
        initThread.start();
        this.getContentPane().add(mainUIPanel);
    }

    private void init() {
        try {
            Thread.sleep(3000);
            initPanel();
            initDB();
            //初始化完成后加载面板
            mainUIPanel.removeAll();
            mainUIPanel.add(passwordPanel);
            mainUIPanel.updateUI();
        } catch (Exception e) {

        }
    }

    /**
     * 初始化数据
     */
    private void initDB() {
        dbUtils = new DbUtils();
    }

    /**
     * 初始化面板
     */
    private void initPanel() {

        passwordPanel = new PasswordPanel();
    }
}
