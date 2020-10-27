package com.qst.dms.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JCheckBoxMenuItem;


public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Q-DMS客户端");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		JMenu menuOperate = new JMenu("操作");
		menuBar.add(menuOperate);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("匹配数据");
		menuOperate.add(chckbxmntmNewCheckItem);
		JMenuItem menuItem = new JMenuItem("采集数据");
		menuOperate.add(menuItem);
		JMenuItem menuItem_1 = new JMenuItem("保存数据");
		menuOperate.add(menuItem_1);
		JMenuItem menuItem2 = new JMenuItem("发送数据");
		menuOperate.add(menuItem2);
		JMenuItem menuItem3 = new JMenuItem("显示数据");
		menuOperate.add(menuItem3);
		
		JMenu menuOperate2 = new JMenu("帮助");
		menuBar.add(menuOperate2);

		//menuBar.add(menuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 586, 33);
		contentPane.add(toolBar);
		this.setSize(600, 450);
		
		JButton Input = new JButton("*采集数据");
		toolBar.add(Input);
		Input.setFont(new Font("黑体", Font.PLAIN, 15));
		
		JButton Mlog = new JButton("*匹配日志数据");
		toolBar.add(Mlog);
		Mlog.setFont(new Font("黑体", Font.PLAIN, 15));
		
		JButton Mtran = new JButton("*匹配物流数据");
		toolBar.add(Mtran);
		Mtran.setFont(new Font("黑体", Font.PLAIN, 15));
		
		JButton Save = new JButton("*保存数据");
		Save.setFont(new Font("黑体", Font.PLAIN, 15));
		toolBar.add(Save);
		
		JButton Send = new JButton("*发送数据");
		Send.setFont(new Font("黑体", Font.PLAIN, 15));
		toolBar.add(Send);
		
		JButton Display = new JButton("*显示数据");
		Display.setFont(new Font("黑体", Font.PLAIN, 15));
		toolBar.add(Display);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("日志");
		tabbedPane.setBounds(0, 28, 40, 23);
		contentPane.add(tabbedPane);
		
		JLabel label = new JLabel("日志");
		tabbedPane.addTab("日志", null, label, null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(38, 28, 43, 23);
		contentPane.add(tabbedPane_1);
		
		JLabel label_1 = new JLabel("物流");
		tabbedPane_1.addTab("物流", null, label_1, null);
	}
	

}