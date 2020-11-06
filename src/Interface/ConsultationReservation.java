package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Dao.EtudiantDao;
import GestionReservations.Reservation;
import GestionUtilisateurs.Etudiant;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

public class ConsultationReservation extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	//private BackgroundPanel bgp;
	protected JList listReser;
	protected JLabel lblNom3;
	protected String id3;
	protected ArrayList<Reservation> lstReser = new ArrayList();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultationReservation frame = new ConsultationReservation();
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
	public ConsultationReservation() {
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
		setTitle("Consultation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Bonjour,");
		
		lblNom3 = new JLabel("...");
		
		JButton btnAnnulerReser = new JButton("Annuler la r\u00E9servation");
		btnAnnulerReser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAnnulerReserAction(e);
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Liste des R\u00E9servations");
		
		JButton btnRetour = new JButton("Retour");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		listReser = new JList();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(btnAnnulerReser)
							.addPreferredGap(ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
							.addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
							.addGap(43))
						.addComponent(listReser, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNom3, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblNom3))
					.addGap(22)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(listReser, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAnnulerReser)
						.addComponent(btnRetour))
					.addGap(27))
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
	 * fonction du bouton Annuler une reservation
	 * @param evt
	 */
	public void btnAnnulerReserAction(ActionEvent evt) {
		
		EtudiantDao ed = new EtudiantDao();
		if(ed.annulerReservation(ed.infoReserver(new Etudiant(this.id3)).get(this.listReser.getSelectedIndex()))) {
			JOptionPane.showMessageDialog(null, "Annulation r\u00E9ussie");
		}else {
			JOptionPane.showMessageDialog(null, "Annulation \u00E9chec");
		}
		dispose();
	}
}
