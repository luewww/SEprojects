package com.qst.dms.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.qst.dms.entity.User;
import com.qst.dms.service.UserService;
import com.qst.dms.ui.RegistFrame_given;
import com.qst.dms.ui.MainFrametest2;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;


public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public static String usern;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		
	  
		setTitle("登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel label = new JLabel("用户名：");
		label.setFont(new Font("宋体", Font.PLAIN, 17));
		label.setBounds(69, 42, 79, 49);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(163, 57, 147, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("密 码 ：");
		label_1.setFont(new Font("宋体", Font.PLAIN, 17));
		label_1.setBounds(69, 101, 98, 28);
		panel.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(163, 106, 147, 21);
		panel.add(passwordField);
		
		JButton button = new JButton("登录");
		button.setBounds(28, 178, 93, 28);
		panel.add(button);
		button.addActionListener(new LoginListener());
		
		JButton btnNewButton = new JButton("重置");
		btnNewButton.setBounds(163, 178, 93, 26);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ResetListener());
		
		
		JButton button_1 = new JButton("注册");
		button_1.setBounds(295, 178, 93, 28);
		panel.add(button_1);
		button_1.addActionListener(new RegisterListener());

	}
	
		//登录
		private class LoginListener implements ActionListener {
			// 重写actionPerFormed()方法，事件处理方法
			public void actionPerformed(ActionEvent e) {
				// 实例化用户业务类对象
				UserService userService = new UserService();
				User user = null;
				// 获取用户输入的数据
				String userName = textField.getText().trim();
				String password = new String(passwordField.getPassword());
				
			    user=userService.findUserByName(userName);
			    
			    if(user==null)
			    	JOptionPane.showMessageDialog(null,"该用户未注册！","错误提示",JOptionPane.ERROR_MESSAGE);
			    else if(password.equals(user.getPassword()))
			    	{
			    		JOptionPane.showMessageDialog(null,"登录成功！","成功提示",JOptionPane.PLAIN_MESSAGE);
			    		new MainFrametest2(userName);
			    		
			    		
			    	}
			    else
			    	JOptionPane.showMessageDialog(null,"密码错误！","错误提示",JOptionPane.ERROR_MESSAGE);
			   
			}
		}
		//重置
		public class ResetListener implements ActionListener {
			// 重写actionPerFormed()方法，重置组件内容事件处理方法
			public void actionPerformed(ActionEvent e) {
				// 清空姓名、密码、确认密码内容
				textField.setText("");
				passwordField.setText("");

			}
		}
		
		//注册
		private class RegisterListener implements ActionListener {
			// 重写actionPerFormed()方法，事件处理方法
			public void actionPerformed(ActionEvent e) {
				new RegistFrame_given();
			}
		}


}



