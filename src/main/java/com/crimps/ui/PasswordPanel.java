package com.crimps.ui;

import javax.swing.*;
import java.awt.*;

/**
 * 解锁界面
 *
 * @author crimps
 * @create 2017-10-19 10:13
 **/
public class PasswordPanel extends BasePanel {

    /**
     * 密码框宽度
     */
    private final int TEXT_FIELD_WIDTH = 30;

    /**
     * 密码框高度
     */
    private final int TEXT_FIELD_HEIGHT = 30;

    /**
     * 密码
     */
    private String password;

    /**
     * 输入的密码
     */
    private StringBuffer inPassword = new StringBuffer("");

    /**
     * 密码是否正确提示图标
     */
    private JLabel tipLabel;

    /**
     * 密码输入框
     */
    private JPasswordField passwordField;

    /**
     * 确认按键
     */
    private JButton optButton;

    /**
     * 应用名称图标
     */
    private JLabel appNameLable;

    /**
     * 主界面
     */
    private MainUI mainUI;

    public PasswordPanel(final MainUI mainUI, final String password) {
        this.password = password;
        this.mainUI = mainUI;
        this.setLayout(new BorderLayout());
        //北面板:密码是否正确提示图标
        JPanel northPanel = new JPanel();
        tipLabel = new JLabel("密码输入");
        northPanel.add(tipLabel);
        this.add(northPanel, BorderLayout.NORTH);
        //中心面板:密码输入框和确认按键
        JPanel centerPanel = new JPanel();
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT));
        optButton = new JButton("确认");
        centerPanel.add(passwordField);
        centerPanel.add(optButton);
        this.add(centerPanel, BorderLayout.CENTER);
        //南面板:应用名称图标
        JPanel southPanel = new JPanel();
        appNameLable = new JLabel("one day");
        southPanel.add(appNameLable);
        this.add(southPanel, BorderLayout.SOUTH);
    }
}
