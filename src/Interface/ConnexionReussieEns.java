package Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dao.EnseignantDao;
import GestionReservations.Reservation;
import GestionReservations.Seance;
import GestionReservations.TempsDeSeance;
import GestionUtilisateurs.Enseignant;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConnexionReussieEns extends JFrame {

	private JPanel contentPane;
	protected JLabel lblNomEns;
	protected String idEns;
	protected String[][] dataTab;
	protected JList list;
	protected LinkedHashMap<TempsDeSeance,Seance> hm= new LinkedHashMap<TempsDeSeance, Seance>();
	private Seance seanceAAnuuler = null;
	private TempsDeSeance tempsSeAAnnuler = null;
	protected String mdp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnexionReussieEns frame = new ConnexionReussieEns();
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
	public ConnexionReussieEns() {
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
        JLabel lblBonjour = new JLabel("Bonjour,");
        lblNomEns = new JLabel("...");
        
        list = new JList();
        
        JButton btnAnnulerSeance = new JButton("Annuler la s\u00E9ance");
        btnAnnulerSeance.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnAnnulerAction(e);
        	}
        });
        
        JButton btnDeconn = new JButton("D\u00E9connexion");
        btnDeconn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		Connexion conn = new Connexion();
        		conn.setVisible(true);
        		dispose();
        	}
        });
        
        JButton btnConsulter = new JButton("Consulter ");
        btnConsulter.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnConsulterAction(e);
        	}
        });
        
        JButton btnActualiser = new JButton("Actualiser");
        btnActualiser.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnActualiserAction(e);
        	}
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addContainerGap(342, Short.MAX_VALUE)
        					.addComponent(lblBonjour, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblNomEns, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(26)
        					.addComponent(list, GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)))
        			.addContainerGap())
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap(40, Short.MAX_VALUE)
        			.addComponent(btnConsulter, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
        			.addGap(28)
        			.addComponent(btnAnnulerSeance, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(btnDeconn, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
        			.addGap(20))
        		.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
        			.addGap(216)
        			.addComponent(btnActualiser, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(216, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblBonjour)
        				.addComponent(lblNomEns))
        			.addGap(60)
        			.addComponent(list, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
        			.addGap(30)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnDeconn)
        				.addComponent(btnConsulter)
        				.addComponent(btnAnnulerSeance))
        			.addGap(30)
        			.addComponent(btnActualiser)
        			.addContainerGap(29, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
	}
	
	/**
	 * fonction du bouton Annuler une seance
	 * @param evt
	 */
	protected void btnAnnulerAction(ActionEvent evt) {
		recupererDonnees();
		EnseignantDao end = new EnseignantDao();
		
		if(end.annulerSeance(this.seanceAAnuuler, this.tempsSeAAnnuler)) {
			JOptionPane.showMessageDialog(null, "Annulation r\u00E9ussie");
		}
		else {
			JOptionPane.showMessageDialog(null, "Annulation \u00E9chec");
		}
		
	}
	
	/**
	 *recuperer les donnees utiles de JList 
	 */
	protected void recupererDonnees() {
		int i = 0,j = 0;
		//obtenir l'indice de la ligne dans JList que l'utilisateur a choisi
		int itemSelect = this.list.getSelectedIndex();
		String item = String.valueOf(this.list.getSelectedValue());
		if(item != null) {
			
			for(TempsDeSeance t : hm.keySet()) {
				if( i == itemSelect) {
					this.tempsSeAAnnuler = t;
					break;
				}else {
					i++;	
				}	
			}
			for(Seance s : hm.values()) {
				if( j == itemSelect) {
					this.seanceAAnuuler = s;
					break;
				}else {
					j++;
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Veuillez choisir une ligne");
			
		}
	
	}
	/**
	 * fontion du bouton Consulter en selectionnant une ligne de seance
	 * @param evt
	 */
	protected void btnConsulterAction(ActionEvent evt) {
		EnseignantDao end = new EnseignantDao();
		int i = 0,j = 0;
		//obtenir l'indice de la ligne dans JList que l'utilisateur a choisi
		int itemSelect = this.list.getSelectedIndex();
		String item = String.valueOf(this.list.getSelectedValue());
		if(item != null && itemSelect != -1) {
			ConsultationSeanceReserEns pageConsulterEns = new ConsultationSeanceReserEns();
			pageConsulterEns.setVisible(true);
			pageConsulterEns.lblDetailSeance.setText(item);
			pageConsulterEns.lblNomEn2.setText(this.lblNomEns.getText());
			
			for(TempsDeSeance t : hm.keySet()) {
				if( i == itemSelect) {
					this.tempsSeAAnnuler = t;
					break;
				}else {
					i++;	
				}	
			}
			for(Seance s : hm.values()) {
				if( j == itemSelect) {
					this.seanceAAnuuler = s;
					break;
				}else {
					j++;
				}
			}
			//receperer les donnees dans JList
			DefaultListModel listModel = new DefaultListModel();
			int q = 0;
			for(Reservation reser : end.reservationsSeance(this.seanceAAnuuler,this.tempsSeAAnnuler)) {
				String detail = "Machine : "+reser.getMachine().getNumMachine()+"\t N° Etu: "+reser.getIdee();
				listModel.add(i, detail);
				q++;	
			}
			System.out.println(end.reservationsSeance(this.seanceAAnuuler,this.tempsSeAAnnuler).get(0));
			pageConsulterEns.list.setModel(listModel);
		}
		else {
			JOptionPane.showMessageDialog(null, "Veuillez choisir une ligne");
		}
	}
	
	/**
	 * fontion du bouton Actualiser, pour renouvler la JList
	 * @param evt
	 */
	public void btnActualiserAction(ActionEvent evt) {
		dispose();
		Connexion conn = new Connexion();
		conn.creerPageConnexionReussieEns(this.idEns,this.mdp);
		
	}
}
