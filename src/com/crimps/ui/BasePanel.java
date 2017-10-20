package com.crimps.ui;

import javax.swing.*;
import java.io.*;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * 基本面板
 *
 * @author crimps
 * @create 2017-10-20 10:20
 **/
public class BasePanel extends JPanel {

    private static ResourceBundle resourceBundle = null;
    private static BufferedInputStream inputStream;
    static {
        String proFilePath = MainUI.rootPath + File.separator + "resources/i18/i18_CN.properties";
        try {
            inputStream = new BufferedInputStream(new FileInputStream(proFilePath));
            resourceBundle = new PropertyResourceBundle(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取字符串
     * @param key 标识
     * @return 对应字符串
     */
    public String getString(String key) {
        String value = "nada";
        try {
            value = resourceBundle.getString(key);
        } catch (Exception e) {
            System.out.println("java.util.MissingResourceException: Couldn't find value for: " + key);
        }
        return value;
    }
}
