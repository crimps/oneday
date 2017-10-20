package com.crimps.ui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
    private int TEXT_FIELD_WIDTH = 30;

    /**
     * 密码框高度
     */
    private int TEXT_FIELD_HEIGHT = 30;

    private String password;
    private JTextField oneTextField;
    private JTextField twoTextField;
    private JTextField threeTextField;
    private JTextField fourTextField;
    private JLabel tipLabel;

    public PasswordPanel(String password) {
        this.password = password;
        this.setLayout(new BorderLayout());
        JPanel centerPanel = new JPanel();
        init();
        centerPanel.add(oneTextField);
        centerPanel.add(twoTextField);
        centerPanel.add(threeTextField);
        centerPanel.add(fourTextField);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(tipLabel, BorderLayout.SOUTH);
    }

    /**
     * 初始化密码输入框
     */
    private void init() {
        initOneTextField();
        initTwoTextField();
        initThreeTextField();
        initFourTextField();
        initTipLabel();
    }

    private void initTipLabel() {
        tipLabel = new JLabel(getString("PasswordPanel.tip_pwd_error"));
    }

    /**
     * 初始化第一位密码输入框
     */
    private void initOneTextField() {
        oneTextField = new JTextField();
        oneTextField.setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT));
        oneTextField.grabFocus();
        oneTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                twoTextField.grabFocus();
            }

            public void removeUpdate(DocumentEvent e) {

            }

            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

    /**
     * 初始化第二位密码输入框
     */
    private void initTwoTextField() {
        twoTextField = new JTextField();
        twoTextField.setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT));
        twoTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                threeTextField.grabFocus();
            }

            public void removeUpdate(DocumentEvent e) {
                oneTextField.grabFocus();
            }

            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

    /**
     * 初始化第三位密码输入框
     */
    private void initThreeTextField() {
        threeTextField = new JTextField();
        threeTextField.setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT));
        threeTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                fourTextField.grabFocus();
            }

            public void removeUpdate(DocumentEvent e) {
                twoTextField.grabFocus();
            }

            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

    /**
     * 初始化第四位密码输入框
     */
    private void initFourTextField() {
        fourTextField = new JTextField();
        fourTextField.setPreferredSize(new Dimension(TEXT_FIELD_WIDTH, TEXT_FIELD_HEIGHT));
        fourTextField.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {

            }

            public void removeUpdate(DocumentEvent e) {
                threeTextField.grabFocus();
            }

            public void changedUpdate(DocumentEvent e) {

            }
        });
    }
}
