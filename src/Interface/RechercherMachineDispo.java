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
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RechercherMachineDispo extends JFrame {

	private JPanel contentPane;
	protected JLabel lblNom2;
	protected String id2;
	private BackgroundPanel bgp;
	
	public JLabel lblHeure;
	public JLabel lblJour;
	public JLabel lblNumSalle;
	public JLabel lblNumMa;
	public JLabel lblNumSeance;
	public JLabel lblSeance;
	public JLabel lblCours;
	public JLabel lblNomCours;
	public JLabel lblAvoirCours;
	public int creneauSuite = 4;
	
	public void setCreneauSuite(int cre) {
		this.creneauSuite = cre;
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RechercherMachineDispo frame = new RechercherMachineDispo();
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
	public RechercherMachineDispo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Bonjour,");
		
		lblNom2 = new JLabel("...");
		
		JLabel lblNewLabel_2 = new JLabel("Nous vous proposons une salle et une machine:");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(386, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNom2, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(65)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(200, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNom2))
					.addGap(22)
					.addComponent(lblNewLabel_2)
					.addContainerGap(306, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		//font
		contentPane.setOpaque(false);
		bgp=new BackgroundPanel(new ImageIcon(".//img.jpg")); 
	    bgp.setBounds(0, 0, this.getSize().width, this.getSize().height);  
        contentPane.add(bgp);
        
        lblCours = new JLabel("Nom de cours");
        
        lblNomCours = new JLabel("...");
        
        lblSeance = new JLabel("Num\u00E9ro de s\u00E9ance");
        
        lblNumSeance = new JLabel("...");
        
        lblAvoirCours = new JLabel("Vous avez cours selon votre EDT :");
        
        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        	}
        });
        
        JButton btnReserver = new JButton("R\u00E9server");
        btnReserver.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnReserverAction(e);
        	}
        });
        
        JLabel lblNewLabel_1 = new JLabel("Salle:");
        
        JLabel lblNewLabel_3 = new JLabel("Jour:");
        
        lblNumSalle = new JLabel("...");
        
        lblJour = new JLabel("...");
        
        lblNumMa = new JLabel("...");
        
        JLabel lblNewLabel_4 = new JLabel("Machine:");
        
        JLabel lblLabel_4 = new JLabel("Heure:");
        
        lblHeure = new JLabel("...");
        GroupLayout gl_bgp = new GroupLayout(bgp);
        gl_bgp.setHorizontalGroup(
        	gl_bgp.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_bgp.createSequentialGroup()
        			.addGap(70)
        			.addGroup(gl_bgp.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_bgp.createSequentialGroup()
        					.addGroup(gl_bgp.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_bgp.createSequentialGroup()
        							.addComponent(lblCours)
        							.addPreferredGap(ComponentPlacement.RELATED, 261, GroupLayout.PREFERRED_SIZE))
        						.addGroup(Alignment.TRAILING, gl_bgp.createSequentialGroup()
        							.addGap(158)
        							.addComponent(lblNomCours, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)))
        					.addContainerGap())
        				.addGroup(gl_bgp.createSequentialGroup()
        					.addComponent(lblSeance, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
        					.addGap(33)
        					.addComponent(lblNumSeance, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
        					.addContainerGap())
        				.addGroup(gl_bgp.createParallelGroup(Alignment.LEADING)
        					.addGroup(gl_bgp.createSequentialGroup()
        						.addComponent(lblAvoirCours, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
        						.addContainerGap())
        					.addGroup(Alignment.TRAILING, gl_bgp.createSequentialGroup()
        						.addComponent(btnReserver, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
        						.addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
        						.addGap(72))
        					.addGroup(gl_bgp.createSequentialGroup()
        						.addGroup(gl_bgp.createParallelGroup(Alignment.LEADING)
        							.addGroup(gl_bgp.createSequentialGroup()
        								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(lblNumSalle, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
        								.addGap(18)
        								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
        							.addGroup(gl_bgp.createSequentialGroup()
        								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(lblJour, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(lblLabel_4, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
        						.addGap(31)
        						.addGroup(gl_bgp.createParallelGroup(Alignment.LEADING)
        							.addComponent(lblHeure, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
        							.addComponent(lblNumMa, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE))
        						.addGap(181)))))
        );
        gl_bgp.setVerticalGroup(
        	gl_bgp.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_bgp.createSequentialGroup()
        			.addContainerGap(91, Short.MAX_VALUE)
        			.addGroup(gl_bgp.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_3)
        				.addComponent(lblJour)
        				.addComponent(lblLabel_4)
        				.addComponent(lblHeure))
        			.addGap(18)
        			.addGroup(gl_bgp.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_1)
        				.addComponent(lblNumSalle)
        				.addComponent(lblNumMa)
        				.addComponent(lblNewLabel_4))
        			.addGap(31)
        			.addComponent(lblAvoirCours)
        			.addGap(26)
        			.addGroup(gl_bgp.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNumSeance)
        				.addComponent(lblSeance))
        			.addGap(30)
        			.addGroup(gl_bgp.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCours)
        				.addComponent(lblNomCours))
        			.addGap(66)
        			.addGroup(gl_bgp.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnRetour)
        				.addComponent(btnReserver))
        			.addGap(55))
        );
        bgp.setLayout(gl_bgp);
	}

	public void btnReserverAction(ActionEvent evt) {
		EtudiantDao ed1 = new EtudiantDao();
		//calculer le creneau
		if(this.lblNumMa.getText() != "..." && this.lblNumSalle.getText() != "..." && this.creneauSuite!= 4) {
			String heureDeb = null;
			String heureFin = null;
			if(this.creneauSuite == 0) {
				heureDeb = "09:30";
				heureFin = "11:30";
			}
			else if(this.creneauSuite == 1) {
				heureDeb = "11:00";
				heureFin = "12:30";
			}
			else if(this.creneauSuite == 2) {
				heureDeb = "14:00";
				heureFin = "15:30";
			}
			else if(this.creneauSuite == 3) {
				heureDeb = "15:30";
				heureFin = "17:00";
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
				System.out.println("-----"+reser.getHeureDeb());
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Veuillez choisir un cr\u00E9neau");
			
		}
		
		
	}

	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
