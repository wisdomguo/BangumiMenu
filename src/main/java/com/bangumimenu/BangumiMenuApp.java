package com.bangumimenu;

import com.bangumimenu.gui.MainWindow;

import javax.swing.SwingUtilities;

/**
 * Bangumi Menu 应用程序入口点
 */
public class BangumiMenuApp {
    
    public static void main(String[] args) {
        // 启动GUI应用程序
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
}