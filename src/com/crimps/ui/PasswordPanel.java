package com.crimps.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

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

    private String password;
    private StringBuffer inPassword = new StringBuffer("");
    private java.util.List<JPasswordField> passwordFieldList;
    private JLabel tipLabel;
    private MainUI mainUI;

    public PasswordPanel(final MainUI mainUI, final String password) {
        this.password = password;
        this.mainUI = mainUI;
        this.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel();
        init();
        for (JPasswordField passwordField : passwordFieldList) {
            centerPanel.add(passwordField);
        }
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(tipLabel, BorderLayout.SOUTH);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                tipLabel.setText("");
                inPassword.append(e.getKeyChar());
                passwordFieldList.get(inPassword.length() - 1).setText(" ");
                if (inPassword.length() == password.length()) {
                    if (password.equals(inPassword.toString())) {
                        mainUI.getMainUI().loadFunctionPanel();
                    } else {
                        inPassword.setLength(0);
                        tipLabel.setText(getString("PasswordPanel.tip_pwd_error"));
                        for (JPasswordField passwordField : passwordFieldList) {
                            passwordField.setText("");
                        }
                    }
                }

            }
        });
    }

    /**
     * 初始化密码输入框
     */
    private void init() {
        passwordFieldList = new ArrayList<>();
        for (int i = 0; i < password.length(); i++) {
            JPasswordField passwordField = new JPasswordField();
            passwordField.setFocusable(false);
            passwordField.setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT));
            passwordFieldList.add(passwordField);
        }
        tipLabel = new JLabel();
    }
}
