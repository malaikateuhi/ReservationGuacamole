package Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dao.EnseignantDao;
import GestionReservations.Seance;
import GestionReservations.TempsDeSeance;
import GestionUtilisateurs.Enseignant;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConnexionReussieEns extends JFrame {

	private JPanel contentPane;
	protected JLabel lblNomEns;
	protected String idEns;
	//protected DefaultTableModel modelTab ;
	protected String[][] dataTab;
	protected JList list;
	protected LinkedHashMap<TempsDeSeance,Seance> hm= new LinkedHashMap<TempsDeSeance, Seance>();
	
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
        	}
        });
        
        JButton btnRetour = new JButton("Retour");
        
        JButton btnConsulter = new JButton("Consulter ");
        btnConsulter.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnConsulterAction(e);
        	}
        });
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
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
        		.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
        			.addContainerGap(73, Short.MAX_VALUE)
        			.addComponent(btnConsulter, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
        			.addGap(36)
        			.addComponent(btnAnnulerSeance, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
        			.addGap(61))
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
        				.addComponent(btnRetour)
        				.addComponent(btnAnnulerSeance)
        				.addComponent(btnConsulter))
        			.addContainerGap(82, Short.MAX_VALUE))
        );
        contentPane.setLayout(gl_contentPane);
	}

	protected void btnConsulterAction(ActionEvent evt) {
		EnseignantDao end = new EnseignantDao();
		int i = 0,j = 0;
		//obtenir l'indice de la ligne dans JList que l'utilisateur a choisi
		int itemSelect = this.list.getSelectedIndex();
		
		TempsDeSeance temps= null;
		Seance seance = null;
		
		for(TempsDeSeance t : hm.keySet()) {
			if( i == itemSelect) {
				temps = t;
				break;
			}else {
				i++;	
			}	
		}
		for(Seance s : hm.values()) {
			if( j == itemSelect) {
				seance = s;
				break;
			}else {
				j++;
			}
		}
		end.reservationsSeance(seance,temps);
	}
}
