package main;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.jdbc.CallableStatement;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import main.Conn;
//Cette frame permet d'éditer les bulletins de salaire des As Mat
public class Principale extends JFrame {

	private JPanel contentPane;
	private JTextField NbHeureGarde;
	private JTextField NbRepas;
	private JTextField VolHeureSupp;
	private JTextField FraisEntretiens;
	private JTextField FraisTransport;
	private JTextField MontantPrEnCharge;
	private double SalaireH = 9.43;
	private JLabel Resultat;
	private JTextField TxtTaux;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principale frame = new Principale("1");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param string 
	 */
	public Principale(String id_nurse) {
		//requête pour le choix du bulletin de salaire par l'identifiant
		String sql2 = "CALL Select_salaire_nurse(?)";
		List<String> resultat = new ArrayList<String>();
		try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex) {
            // handle the error
        }
        Connection conn = null;
        try {
            conn =
               DriverManager.getConnection("jdbc:mysql://localhost/fripouille?" +
                                           "user=root&password=root");
            
            CallableStatement callableStatement = (CallableStatement) conn.prepareCall(sql2);
            callableStatement.setInt(1, Integer.parseInt(id_nurse));
            
            
            
            callableStatement.execute();
            ResultSet resultSet;
            resultSet = callableStatement.getResultSet();
            while(resultSet.next()) {
                String tempResultat = "";
                for (int i = 1; i <= 7; i++) {
                    String tempVariable = resultSet.getString(i);
                    if(tempVariable != null) {
                        tempResultat += tempVariable+";";
                    }

                }
                resultat.add(tempResultat);
            }

            conn.close();
        } catch (SQLException ex) {
        	
        }
        String[] tempResult = resultat.toArray(new String[0]); //Permet de transformer la liste java en tableau
        String[] splitTemp = tempResult[0].split(";"); //Recupere la premier ligne du tableau et divise les colonnes dans un tableau
		setTitle("Bulettins de salaires");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RAM:");
		lblNewLabel.setBounds(476, 11, 110, 52);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre d'heures de garde hebdomadaire:");
		lblNewLabel_1.setBounds(0, 81, 438, 31);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		NbHeureGarde = new JTextField(splitTemp[0]);
		NbHeureGarde.setBounds(442, 81, 196, 31);
		NbHeureGarde.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(NbHeureGarde);
		NbHeureGarde.setColumns(10);
		
		
		JLabel lblNewLabel_2 = new JLabel("Nombre de repas:");
		lblNewLabel_2.setBounds(0, 123, 438, 31);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_2);
		
		NbRepas = new JTextField(splitTemp[1]);
		NbRepas.setBounds(442, 123, 196, 31);
		NbRepas.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(NbRepas);
		NbRepas.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Volume d'heures supplémentaires:");
		lblNewLabel_3.setBounds(0, 165, 438, 31);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_3);
		
		VolHeureSupp = new JTextField(splitTemp[2]);
		VolHeureSupp.setBounds(442, 165, 196, 31);
		VolHeureSupp.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(VolHeureSupp);
		VolHeureSupp.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Frais d'entretiens:");
		lblNewLabel_4.setBounds(0, 207, 438, 31);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_4);
		
		FraisEntretiens = new JTextField(splitTemp[3]);
		FraisEntretiens.setBounds(442, 207, 196, 31);
		FraisEntretiens.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(FraisEntretiens);
		FraisEntretiens.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Frais de transport:");
		lblNewLabel_5.setBounds(0, 249, 438, 31);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_5);
		
		FraisTransport = new JTextField(splitTemp[4]);
		FraisTransport.setBounds(442, 249, 196, 31);
		FraisTransport.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(FraisTransport);
		FraisTransport.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Montant de prise en charge par la CAF:");
		lblNewLabel_6.setBounds(0, 291, 438, 31);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_6);
		
		MontantPrEnCharge = new JTextField(splitTemp[5]);
		MontantPrEnCharge.setBounds(442, 291, 196, 31);
		MontantPrEnCharge.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(MontantPrEnCharge);
		MontantPrEnCharge.setColumns(10);
		
		Resultat = new JLabel("Résultat");
		Resultat.setBounds(476, 420, 117, 37);
		Resultat.setHorizontalAlignment(SwingConstants.CENTER);
		Resultat.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(Resultat);
		
		JButton Valider = new JButton("Valider");
		Valider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String HeureGarde = NbHeureGarde.getText();
				double result1 = Double.parseDouble(HeureGarde);
				double TauxHoraire = Double.parseDouble(TxtTaux.getText());
				String Repas = NbRepas.getText();
				double result2 = Double.parseDouble(Repas);
				String HeureSupp = VolHeureSupp.getText();
				double result3 = Double.parseDouble(HeureSupp);
				String Entretien = FraisEntretiens.getText();
				double result4 = Double.parseDouble(Entretien);
				String Transport = FraisTransport.getText();
				double result5 = Double.parseDouble(Transport);
				String PriseEnCharge = MontantPrEnCharge.getText();
				double result6 = Double.parseDouble(PriseEnCharge);
				Double R1 = (result1*TauxHoraire);
				Double R2 = 4.33 * result2;
				Double R3 = 11.93 * result3;
				Double R4 = result4;
				Double R5 = result5;
				Double R6 = result6;
				Double resultatFinal = (R1 + R2 + R3 + R4 + R5 - R6);
				Resultat.setText(String.valueOf(resultatFinal));
				//requête d'édition du bulletin de salaire
				String sql = "CALL Update_salaire_nurse(?,?,?,?,?,?,?,?,?)";
				try {
		            // The newInstance() call is a work around for some
		            // broken Java implementations

		            Class.forName("com.mysql.cj.jdbc.Driver");
		        } catch (Exception ex) {
		            // handle the error
		        }
		        Connection conn = null;
		        try {
		            conn =
		               DriverManager.getConnection("jdbc:mysql://localhost/fripouille?" +
		                                           "user=root&password=root");
		            
		            PreparedStatement preparedStatement = conn.prepareStatement(sql);
		            preparedStatement.setDouble(1, result1);
		            preparedStatement.setDouble(2, result2);
		            preparedStatement.setDouble(3, result3);
		            preparedStatement.setDouble(4, result4);
		            preparedStatement.setDouble(5, result5);
		            preparedStatement.setDouble(6, result6);
		            preparedStatement.setDouble(7, TauxHoraire);
		            preparedStatement.setDouble(8, resultatFinal);
		            preparedStatement.setInt(9, 1);
		            
		            preparedStatement.executeUpdate();
		            conn.close();
		        } catch (SQLException ex) {
		        	
		        }
		        int delay = 10000;
		        Timer timer = new Timer( delay, new ActionListener(){
		          @Override
		          public void actionPerformed( ActionEvent e ){
		        	  dispose();
		          }
		        });
		        timer.setRepeats(false);
		        timer.start();

			}
		});
		Valider.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Valider.setBounds(460, 375, 142, 37);
		contentPane.add(Valider);
		
		JLabel LblTauxHoraire = new JLabel("Taux Horaire:");
		LblTauxHoraire.setFont(new Font("Tahoma", Font.BOLD, 20));
		LblTauxHoraire.setBounds(305, 333, 196, 23);
		contentPane.add(LblTauxHoraire);
		
		TxtTaux = new JTextField(splitTemp[6]);
		TxtTaux.setFont(new Font("Tahoma", Font.BOLD, 20));
		TxtTaux.setBounds(442, 333, 196, 31);
		contentPane.add(TxtTaux);
		TxtTaux.setColumns(10);
		
	}
}
