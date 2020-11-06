package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.EtudiantDao;
import GestionReservations.Reservation;
import GestionSallesMachines.Machine;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RechercheMachineDispo extends JFrame {

	protected JLabel lblNom2;
	public String id2;
	private JPanel contentPane;
	protected JLabel lblHeure;
	protected JLabel lblJour;
	protected JLabel lblNumSalle;
	protected JLabel lblNumMa;
	public JLabel lblNumSeance;
	public JLabel lblSeance;
	public JLabel lblCours;
	public JLabel lblNomCours;
	public JLabel lblAvoirCours;
	public int creneauSuite = 6;
	//private BackgroundPanel bgp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechercheMachineDispo frame = new RechercheMachineDispo();
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
	public RechercheMachineDispo() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 557, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblbonjour = new JLabel("Bonjour,");
		
		lblNom2 = new JLabel("...");
		
		JLabel lblNewLabel = new JLabel("Nous vous proposons une machine et sa salle");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_1 = new JLabel("Jour");
		
		lblJour = new JLabel("...");
		
		JLabel lblNewLabel_2 = new JLabel("Heure");
		
		lblHeure = new JLabel("...");
		
		JLabel lblNewLabel_3 = new JLabel("Salle");
		
		lblNumSalle = new JLabel("...");
		
		JLabel lblNewLabel_4 = new JLabel("Machine");
		
		lblNumMa = new JLabel("...");
		
		lblAvoirCours = new JLabel("Vous avez cours selon votre EDT");
		lblAvoirCours.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblSeance = new JLabel("S\u00E9ance");
		
		lblNumSeance = new JLabel("...");
		
		lblCours = new JLabel("Cours");
		
		lblNomCours = new JLabel("...");
		
		JButton btnReserver = new JButton("R\u00E9server");
		btnReserver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReserverAction(e);
			}
		});
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnDeconn = new JButton("D\u00E9connexion");
		btnDeconn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
        		Connexion conn = new Connexion();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(312, Short.MAX_VALUE)
					.addComponent(lblbonjour, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNom2, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addGap(36))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(58)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
							.addGap(34)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNumSalle, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblJour, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
							.addGap(33)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblHeure, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNumMa, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))))
						.addComponent(lblAvoirCours, GroupLayout.PREFERRED_SIZE, 439, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblSeance, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
									.addGap(34)
									.addComponent(lblNumSeance, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
									.addGap(46)
									.addComponent(lblCours, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnReserver, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addGap(55)
									.addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNomCours, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDeconn, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblbonjour)
						.addComponent(lblNom2))
					.addGap(48)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblJour)
						.addComponent(lblNewLabel_2)
						.addComponent(lblHeure))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNumSalle)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNumMa))
					.addGap(30)
					.addComponent(lblAvoirCours)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSeance)
						.addComponent(lblNumSeance)
						.addComponent(lblCours)
						.addComponent(lblNomCours))
					.addGap(39)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnReserver)
						.addComponent(btnRetour)
						.addComponent(btnDeconn))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	public void setCreneauSuite(int creneauSuite) {
		this.creneauSuite = creneauSuite;
	}

	/**
	 * 
	 * @param evt
	 */
	public void btnReserverAction(ActionEvent evt) {
		EtudiantDao ed1 = new EtudiantDao();
		//calculer le creneau
		if(this.lblNumMa.getText() != "..." && this.lblNumSalle.getText() != "..." && this.creneauSuite!= 6) {
			String heureDeb = null;
			String heureFin = null;
			if(this.creneauSuite == 0) {
				heureDeb = "08:00";
				heureFin = "09:30";
			}
			else if(this.creneauSuite == 1) {
				heureDeb = "09:30";
				heureFin = "11:00";
			}
			else if(this.creneauSuite == 2) {
				heureDeb = "11:00";
				heureFin = "12:30";
			}
			else if(this.creneauSuite == 3) {
				heureDeb = "14:00";
				heureFin = "15:30";
			}
			else if(this.creneauSuite == 4) {
				heureDeb = "15:30";
				heureFin = "17:00";
			}
			else if(this.creneauSuite == 5) {
				heureDeb = "17:00";
				heureFin = "18:30";
			}
			
			//creer une nouvelle reservation
			Reservation reser = new Reservation(new Machine(this.lblNumMa.getText()),this.id2,this.lblJour.getText(),heureDeb,heureFin,"Réservée",this.creneauSuite);
			//reserve ok?
			if(ed1.prendreReservation(reser)) {
				dispose();
				JOptionPane.showMessageDialog(null, "R\u00E9servation r\u00E9ussie");
			}
			else {
				JOptionPane.showMessageDialog(null, "R\u00E9servation \u00E9chec");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Veuillez choisir un cr\u00E9neau");	
		}
	}
}
