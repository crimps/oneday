package com.crimps;

import com.crimps.ui.MainUI;
import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import java.awt.*;

/**
 * 入口函数
 *
 * @author crimps
 * @create 2017-10-19 10:13
 **/
public class Main {

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainUI mainUI = new MainUI();
                mainUI.setVisible(true);
            }
        });
    }
}
