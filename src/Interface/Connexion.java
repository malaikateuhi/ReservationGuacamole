package Interface;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BD.QueryLogin;
import BD.StringUtil;
import Dao.AdminDao;
import Dao.EnseignantDao;
import Dao.EtudiantDao;
import GestionReservations.Reservation;
import GestionReservations.Seance;
import GestionReservations.TempsDeSeance;
import GestionSallesMachines.Salle;
import GestionUtilisateurs.*;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Connexion extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private QueryLogin queryLogin = new QueryLogin();
	protected int typeUtilisateur = 0; //1-->etu, 2-->enseignant, 3-->admin 
	//private BackgroundPanel bgp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion frame = new Connexion();
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
	public Connexion() {
		setTitle("Connexion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Bienvenue");
		
		JLabel lblNewLabel_1 = new JLabel("Identifiant");
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe");
		
		txtId = new JTextField();
		txtId.setColumns(10);
		
		passwordField = new JPasswordField();
		
		JLabel lblNewLabel_3 = new JLabel("Vous \u00EAtes");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Etudiant");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeUtilisateur = 1;
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Enseignant");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeUtilisateur = 2;
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Responsable de formation");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				typeUtilisateur = 3;
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_2);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(164)
							.addComponent(lblNewLabel))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(91)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(txtId, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(177)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addContainerGap()
									.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addGap(160)
									.addComponent(btnValider, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
							.addGap(6)
							.addComponent(rdbtnNewRadioButton_2, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNewLabel)
					.addGap(29)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(26)
							.addComponent(lblNewLabel_3))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(51)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnNewRadioButton_2)
								.addComponent(rdbtnNewRadioButton_1)
								.addComponent(rdbtnNewRadioButton))))
					.addGap(27)
					.addComponent(btnValider)
					.addContainerGap(48, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		//font
//		panel.setOpaque(false);
//		bgp=new BackgroundPanel(new ImageIcon(".//img.jpg")); 
//	    bgp.setBounds(0, 0, this.getSize().width, this.getSize().height);  
//        contentPane.add(bgp);
	}
	
	public void login(ActionEvent evt) {
		String id = this.txtId.getText();
		String mdp=new String(String.valueOf(this.passwordField.getPassword()));
		EtudiantDao ed = new EtudiantDao();
		EnseignantDao end = new EnseignantDao();
		AdminDao ad = new AdminDao();
//		Utilisateur user = null;
		if(typeUtilisateur == 0) {
			JOptionPane.showMessageDialog(null, "Veuillez choisir votre rôle!");
		}
		//else if(typeUtilisateur == 1) {
//			user = new Etudiant(id,mdp);
//		}else if(typeUtilisateur == 2) {
//			user = new Enseignant(id,mdp);
//		}else {
//			user = new Admin(id,mdp);
//		}
		
		if(StringUtil.isEmpty(txtId.getText()) || StringUtil.isEmpty(String.valueOf(passwordField.getPassword()))) {
			JOptionPane.showMessageDialog(null, "L'identifiant ou le mot de passe ne peut pas \u00EAtre vide!");
		}else {
			
			
			if(ed.login(id, mdp) != null && this.typeUtilisateur == 1) {
				//System.out.println(usercurrent.getNumeroIdent());
				dispose();
				ConnexionReussieEtu cre = new ConnexionReussieEtu();
				cre.setVisible(true);
				//cre.lblId.setText(this.txtId.getText());
				cre.lblNom.setText(ed.login(id, mdp).getNom()+" "+ed.login(id, mdp).getPrenom());
				cre.id = this.txtId.getText();
			}
			else if(end.login(id, mdp) != null && this.typeUtilisateur == 2){
				//page de l'enseignant
				dispose();
				ConnexionReussieEns cren = new ConnexionReussieEns();
				cren.setVisible(true);
				cren.idEns = this.txtId.getText();
				cren.lblNomEns.setText(end.login(id, mdp).getNom()+" "+end.login(id, mdp).getPrenom());
							
				
				String [] header={"Date","Heure","N°séance","Cours"};
		        String [][] data={{"akash","20","s","ff"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"}};
				

		        DefaultTableModel model = new DefaultTableModel(data,header);

		        ArrayList<Seance> lstSeance = new ArrayList<Seance>();
		        ArrayList<Salle> lstSalle = new ArrayList<Salle>();
		        
				for(TempsDeSeance temps : end.donnerCours(new Enseignant(this.txtId.getText()))) {
					
					for(Seance s : temps.getHmSeanceSalle().keySet()) {
						lstSeance.add(s);
					}
					for(Salle salle : temps.getHmSeanceSalle().values()) {
						lstSalle.add(salle);
					}
//					pageConsultation.lstReser.add(reser);
				}
				cren.tableSeance= new JTable(model);
	
			}
			else if(ad.login(id, mdp) != null && this.typeUtilisateur == 3) {
				//page de l'admin
			}
			else {
				JOptionPane.showMessageDialog(null,"Votre identifiant ou mot de passe semble incorrect");
				txtId.setText("");
				passwordField.setText("");
			}
		}
	} 
}

