package com.bangumimenu.utils;

import javax.swing.*;
import java.awt.*;

/**
 * GUI 工具类
 * 提供常用的 GUI 操作方法
 */
public class GuiUtils {
    
    /**
     * 将组件居中显示
     * @param component 要居中显示的组件
     */
    public static void centerComponent(Component component) {
        if (component instanceof Window) {
            Window window = (Window) component;
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Dimension windowSize = window.getSize();
            
            // 计算居中位置
            int x = (screenSize.width - windowSize.width) / 2;
            int y = (screenSize.height - windowSize.height) / 2;
            
            window.setLocation(x, y);
        }
    }
    
    /**
     * 显示信息对话框
     * @param parent 父组件
     * @param message 消息内容
     * @param title 对话框标题
     */
    public static void showInfoDialog(Component parent, String message, String title) {
        JOptionPane.showMessageDialog(
            parent,
            message,
            title,
            JOptionPane.INFORMATION_MESSAGE
        );
    }
    
    /**
     * 显示错误对话框
     * @param parent 父组件
     * @param message 错误消息
     * @param title 对话框标题
     */
    public static void showErrorDialog(Component parent, String message, String title) {
        JOptionPane.showMessageDialog(
            parent,
            message,
            title,
            JOptionPane.ERROR_MESSAGE
        );
    }
    
    /**
     * 显示确认对话框
     * @param parent 父组件
     * @param message 确认消息
     * @param title 对话框标题
     * @return 用户选择结果
     */
    public static int showConfirmDialog(Component parent, String message, String title) {
        return JOptionPane.showConfirmDialog(
            parent,
            message,
            title,
            JOptionPane.YES_NO_OPTION
        );
    }
    
    /**
     * 设置组件的首选大小
     * @param component 组件
     * @param width 宽度
     * @param height 高度
     */
    public static void setPreferredSize(JComponent component, int width, int height) {
        component.setPreferredSize(new Dimension(width, height));
    }
}