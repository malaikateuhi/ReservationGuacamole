package Interface;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

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
import javax.swing.UIManager;
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
import java.util.Enumeration;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class Connexion extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JPasswordField passwordField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
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
	 * Preparer les boutons, les labels, les zones de saisie,etc.
	 */
	public Connexion() {
		
		//changer la police
		Font font = new Font("Tahoma", Font.PLAIN,14);
		Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if(value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key,font);
			}
		}
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
		
		JLabel lblNewLabel = new JLabel("Bienvenue!");
		
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
							.addGap(91)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(txtId, GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addGap(177)
									.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addContainerGap()
									.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addGap(12))
								.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
									.addGap(160)
									.addComponent(btnValider, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
							.addGap(6)
							.addComponent(rdbtnNewRadioButton_2, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(17, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(177)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(229, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(28)
					.addComponent(lblNewLabel)
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addComponent(lblNewLabel_3)
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnNewRadioButton_2)
						.addComponent(rdbtnNewRadioButton_1)
						.addComponent(rdbtnNewRadioButton))
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
	
	/**
	 * fonction du bouton Valider, pour gerer la connexion
	 * @param evt
	 */
	public void login(ActionEvent evt) {
		String id = this.txtId.getText();
		String mdp = new String(String.valueOf(this.passwordField.getPassword()));
		EtudiantDao ed = new EtudiantDao();
		EnseignantDao end = new EnseignantDao();
		AdminDao ad = new AdminDao();

		if(typeUtilisateur == 0) {
			JOptionPane.showMessageDialog(null, "Veuillez choisir votre rôle!");
		}
		
		if(StringUtil.isEmpty(txtId.getText()) || StringUtil.isEmpty(String.valueOf(passwordField.getPassword()))) {
			JOptionPane.showMessageDialog(null, "L'identifiant ou le mot de passe ne peut pas \u00EAtre vide!");
		}else {
			
			
			if(ed.login(id, mdp) != null && this.typeUtilisateur == 1) {

				dispose();
				ConnexionReussieEtu pageReussieEtu = new ConnexionReussieEtu();
				pageReussieEtu.setVisible(true);
				pageReussieEtu.lblNom.setText(ed.login(id, mdp).getNom()+" "+ed.login(id, mdp).getPrenom());
				pageReussieEtu.id = this.txtId.getText();
			}
			else if(end.login(id, mdp) != null && this.typeUtilisateur == 2){
				//page de l'enseignant
				dispose();
				creerPageConnexionReussieEns(id,mdp);
			}			

			else if(ad.login(id, mdp) != null && this.typeUtilisateur == 3) {
				//page de l'admin
//				dispose();
//				ConnexionReussieAd pageConnexionReussieAd = new ConnexionReussieAd();
//				pageConnexionReussieAd.lblNomAd.setText(this.txtId.getText());
			}
			else {
				JOptionPane.showMessageDialog(null,"Votre identifiant ou mot de passe semble incorrect");
				txtId.setText("");
				passwordField.setText("");
			}
		}
	}

	/**
	 * preparer l'affichage de la page suivante
	 * @param id1
	 * @param mdp1
	 */
	protected void creerPageConnexionReussieEns(String id1,String mdp1) {
		EnseignantDao end = new EnseignantDao();
		ConnexionReussieEns pageReussieEtu = new ConnexionReussieEns();
		pageReussieEtu.setVisible(true);
		pageReussieEtu.idEns = id1;
		pageReussieEtu.mdp = mdp1;
		pageReussieEtu.lblNomEns.setText(end.login(id1, mdp1).getNom()+" "+end.login(id1, mdp1).getPrenom());					
		
		ArrayList<String> lstLigne = new ArrayList();
        HashMap<TempsDeSeance,Seance> hm = new HashMap();
		for(TempsDeSeance temps : end.donnerCours(new Enseignant(id1))) {
				
			String lignea= ""; 
			lignea = lignea + temps.getJour()+","+temps.getHeureDeb()+"-"+temps.getHeureFin();
			System.out.println("oooo"+temps.getJour());
			for(Seance s : temps.getHmSeanceSalle().keySet()) {
				System.out.println("seance"+s);
				//lstSeance.add(s);
				String ligneb =","+s.getNomCours()+","+s.getNumSeance()+","+temps.getHmSeanceSalle().get(s).getNomSalle();
				lstLigne.add(lignea+ligneb);
				pageReussieEtu.hm.put(temps,s);
			}
			
	   }
		DefaultListModel listModel = new DefaultListModel();
		int i = 0;
		for(String str : lstLigne) {
			
			listModel.add(i, str);
			i++;	
		}
		pageReussieEtu.list.setModel(listModel);
		
	}
	

}

