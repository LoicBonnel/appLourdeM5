import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principale frame = new Principale();
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
	public Principale() {
		setTitle("Bulettins de salaires");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RAM:");
		lblNewLabel.setBounds(460, 11, 110, 52);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre d'heures de garde hebdomadaire:");
		lblNewLabel_1.setBounds(0, 81, 438, 31);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_1);
		
		NbHeureGarde = new JTextField();
		NbHeureGarde.setBounds(442, 81, 196, 31);
		NbHeureGarde.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(NbHeureGarde);
		NbHeureGarde.setColumns(10);
		
		
		JLabel lblNewLabel_2 = new JLabel("Nombre de repas:");
		lblNewLabel_2.setBounds(0, 123, 438, 31);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_2);
		
		NbRepas = new JTextField();
		NbRepas.setBounds(442, 123, 196, 31);
		NbRepas.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(NbRepas);
		NbRepas.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Volume d'heures supplémentaires:");
		lblNewLabel_3.setBounds(0, 165, 438, 31);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_3);
		
		VolHeureSupp = new JTextField();
		VolHeureSupp.setBounds(442, 165, 196, 31);
		VolHeureSupp.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(VolHeureSupp);
		VolHeureSupp.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Frais d'entretiens:");
		lblNewLabel_4.setBounds(0, 207, 438, 31);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_4);
		
		FraisEntretiens = new JTextField();
		FraisEntretiens.setBounds(442, 207, 196, 31);
		FraisEntretiens.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(FraisEntretiens);
		FraisEntretiens.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Frais de transport:");
		lblNewLabel_5.setBounds(0, 249, 438, 31);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_5);
		
		FraisTransport = new JTextField();
		FraisTransport.setBounds(442, 249, 196, 31);
		FraisTransport.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(FraisTransport);
		FraisTransport.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Montant de prise en charge par la CAF:");
		lblNewLabel_6.setBounds(0, 291, 438, 31);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(lblNewLabel_6);
		
		MontantPrEnCharge = new JTextField();
		MontantPrEnCharge.setBounds(442, 291, 196, 31);
		MontantPrEnCharge.setFont(new Font("Tahoma", Font.BOLD, 20));
		contentPane.add(MontantPrEnCharge);
		MontantPrEnCharge.setColumns(10);
		
		Resultat = new JLabel("Résultat");
		Resultat.setBounds(479, 385, 117, 37);
		Resultat.setHorizontalAlignment(SwingConstants.CENTER);
		Resultat.setFont(new Font("Tahoma", Font.BOLD, 25));
		contentPane.add(Resultat);
		
		JButton Valider = new JButton("VALIDER✅");
		Valider.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Valider.setBounds(469, 333, 142, 37);
		contentPane.add(Valider);
		
		
	}
}
