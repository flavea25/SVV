package webserver;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import exceptions.InvalidPathException;

public class WebServerGUI {

	private JFrame frame = new JFrame("WebServerGUI");
	JLabel statusLabel;
	private JLabel portLabel;
	private JLabel ipLabel;
	private JLabel pathLabel;
	private JButton btnStart;
	private JButton btnStop;
	private JButton btnMaintenance;
	private JButton btnChangePort;
	private JButton btnChangePath;
	private JTextField portText;
	private JTextField pathText;
	
	public void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebServerGUI window = new WebServerGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public WebServerGUI() {
		initialize();
	}

	private void initialize() {
		frame.setBounds(100, 100, 649, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		btnStart = new JButton("START");
		btnStart.setBackground(Color.GREEN);
		btnStart.setBounds(44, 299, 97, 42);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					WebServer.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnStart);
		
		btnStop = new JButton("STOP");
		btnStop.setBackground(Color.RED);
		btnStop.setBounds(181, 299, 97, 42);
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WebServer.stopServer();
			}
		});
		frame.getContentPane().add(btnStop);
		
		btnMaintenance = new JButton("MAINTENANCE");
		btnMaintenance.setBackground(Color.ORANGE);
		btnMaintenance.setBounds(462, 299, 124, 42);
		btnMaintenance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					WebServer.maintenance();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnMaintenance);
		
		statusLabel = new JLabel("Status: " + WebServer.STATUS.toString());
		statusLabel.setBounds(54, 59, 134, 16);
		frame.getContentPane().add(statusLabel);
		
		portLabel = new JLabel("Port: ");
		portLabel.setBounds(54, 106, 71, 16);
		frame.getContentPane().add(portLabel);
		
		ipLabel = new JLabel("IP: localhost (127.0.0.1)");
		ipLabel.setBounds(54, 153, 158, 16);
		frame.getContentPane().add(ipLabel);
		
		portText = new JTextField(WebServer.getPort());
		portText.setHorizontalAlignment(SwingConstants.CENTER);
		portText.setBounds(92, 106, 69, 16);
		portText.setBackground(Color.WHITE);
		frame.getContentPane().add(portText);
		
		btnChangePort = new JButton("Save");
		btnChangePort.setBackground(SystemColor.activeCaption);
		btnChangePort.setBounds(173, 106, 88, 16);
		btnChangePort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					WebServer.setPort(Integer.parseInt(portText.getText()));
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnChangePort);
		
		pathLabel = new JLabel("Path: ");
		pathLabel.setBounds(54, 196, 56, 16);
		frame.getContentPane().add(pathLabel);
		
		pathText = new JTextField(WebServer.getPath());
		pathText.setHorizontalAlignment(SwingConstants.CENTER);
		pathText.setBackground(Color.WHITE);
		pathText.setBounds(92, 196, 391, 16);
		frame.getContentPane().add(pathText);
		
		btnChangePath = new JButton("Save");
		btnChangePath.setBackground(SystemColor.activeCaption);
		btnChangePath.setBounds(495, 196, 88, 16);
		btnChangePath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					WebServer.setPath(pathText.getText());
				} catch (InvalidPathException e1) {
					e1.printStackTrace();
				}
			}
		});
		frame.getContentPane().add(btnChangePath);
	}

}
