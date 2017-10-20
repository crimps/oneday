package com.crimps.ui;

import com.crimps.service.db.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * oneday主界面
 *
 * @author crimps
 * @create 2017-10-19 10:13
 **/
public class MainUI extends JFrame {

    public static String rootPath;

    /**
     * 是否锁定：true:锁定;false:已解锁
     */
    private boolean isLock = true;

    public DbUtils dbUtils;
    private JPanel mainUIPanel;
    private PasswordPanel passwordPanel;
    private LoadingDataPanel loadingDataPanel;
    private FunctionPanel functionPanel;

    public MainUI getMainUI() {
        return this;
    }

    public MainUI() {
        initPath();
        System.out.println(rootPath);
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
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                dbUtils.close();
            }
        });
    }

    private void init() {
        try {
            Thread.sleep(3000);
            initPanel();
            initDB();
            functionPanel = new FunctionPanel();
            //初始化完成后加载面板
            if (isLock) {
                mainUIPanel.removeAll();
                mainUIPanel.add(passwordPanel);
                mainUIPanel.updateUI();
                passwordPanel.requestFocus();
            } else {
                loadFunctionPanel();
            }

        } catch (Exception e) {

        }
    }

    public void loadFunctionPanel() {
        mainUIPanel.removeAll();
        mainUIPanel.add(functionPanel);
        mainUIPanel.updateUI();
    }

    private void initPath() {
        String path = MainUI.class.getProtectionDomain().getCodeSource().getLocation().getFile();
        try {
            path = URLDecoder.decode(path, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (path.endsWith(".jar")) {
            rootPath = new File(path).getParentFile().getAbsolutePath();
        } else {
            rootPath = path;
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
        passwordPanel = new PasswordPanel(getMainUI(),"123456");
    }
}
