package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.CallableStatement;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//Cette Frame permet de choisir quel bulletin de salaire éditer
public class Choix_bulletin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Choix_bulletin frame = new Choix_bulletin();
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
	public Choix_bulletin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1017, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Choisir le bulletin de salaire:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_7.setBounds(294, 34, 432, 31);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Id de l'assistante maternnelle:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_8.setBounds(344, 138, 321, 31);
		contentPane.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBounds(423, 180, 178, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCharger = new JButton("Charger");
		btnCharger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(textField.getText());
				dispose();
				Principale frame = new Principale(textField.getText());
				frame.setVisible(true);

			}
		});
		btnCharger.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCharger.setBounds(423, 280, 178, 33);
		contentPane.add(btnCharger);
	}
	}