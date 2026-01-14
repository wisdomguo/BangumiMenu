package com.bangumimenu.gui;

import com.bangumimenu.config.AppConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Git配置对话框
 */
public class GitConfigDialog extends JDialog {
    private JTextField remoteUrlField;
    private JCheckBox autoSyncOnStartupCheckbox;
    private JCheckBox autoSyncOnExitCheckbox;
    private JButton okButton;
    private JButton cancelButton;
    
    public GitConfigDialog(Frame parent) {
        super(parent, "Git配置", true);
        initializeComponents();
        loadCurrentConfig();
        setupLayout();
        setupEventHandlers();
        
        setSize(400, 200);
        setLocationRelativeTo(parent);
    }
    
    private void initializeComponents() {
        remoteUrlField = new JTextField(30);
        autoSyncOnStartupCheckbox = new JCheckBox("启动时自动同步");
        autoSyncOnExitCheckbox = new JCheckBox("退出时自动同步");
        okButton = new JButton("确定");
        cancelButton = new JButton("取消");
        
        // 设置默认选中状态
        autoSyncOnStartupCheckbox.setSelected(AppConfig.getBooleanProperty("git.auto.sync.on.startup", true));
        autoSyncOnExitCheckbox.setSelected(AppConfig.getBooleanProperty("git.auto.sync.on.exit", false));
    }
    
    private void loadCurrentConfig() {
        String remoteUrl = AppConfig.getProperty("git.remote.url", "");
        remoteUrlField.setText(remoteUrl);
    }
    
    private void setupLayout() {
        setLayout(new BorderLayout());
        
        // 配置面板
        JPanel configPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        // 远程仓库URL
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.WEST;
        configPanel.add(new JLabel("远程仓库URL:"), gbc);
        gbc.gridx = 1; gbc.weightx = 1.0; gbc.fill = GridBagConstraints.HORIZONTAL;
        configPanel.add(remoteUrlField, gbc);
        
        // 自动同步选项
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2; gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        configPanel.add(autoSyncOnStartupCheckbox, gbc);
        
        gbc.gridy = 2;
        configPanel.add(autoSyncOnExitCheckbox, gbc);
        
        // 按钮面板
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        
        add(configPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void setupEventHandlers() {
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveConfig();
                dispose();
            }
        });
        
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    
    private void saveConfig() {
        // 保存配置到系统属性或配置文件（这里简化处理，实际应用中应保存到配置文件）
        System.setProperty("git.remote.url", remoteUrlField.getText());
        System.setProperty("git.auto.sync.on.startup", String.valueOf(autoSyncOnStartupCheckbox.isSelected()));
        System.setProperty("git.auto.sync.on.exit", String.valueOf(autoSyncOnExitCheckbox.isSelected()));
    }
}