package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RechercherMachineDispo extends JFrame {

	private JPanel contentPane;
	public JLabel lblId2;
	private BackgroundPanel bgp;
	
	public JLabel lblHeure;
	public JLabel lblJour;
	public 	JLabel lblNumSalle;
	public JLabel lblNumMa;
	public JLabel lblNumSeance;
	public JLabel lblSeance;
	public JLabel lblCours;
	public JLabel lblNomCours;
	public JLabel lblAvoirCours;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Bonjour,");
		
		lblId2 = new JLabel("...");
		
		JLabel lblNewLabel_1 = new JLabel("Salle:");
		
		JLabel lblNewLabel_2 = new JLabel("Nous vous proposons une salle et une machine:");
		
		lblNumSalle = new JLabel("...");
		
		JLabel lblNewLabel_4 = new JLabel("Machine:");
		
		lblNumMa = new JLabel("...");
		
		JLabel lblNewLabel_3 = new JLabel("Jour:");
		
		lblJour = new JLabel("...");
		
		JLabel lblLabel_4 = new JLabel("Heure:");
		
		lblHeure = new JLabel("...");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(262, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblId2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(44))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(65)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblJour, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNumSalle, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblLabel_4, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNumMa, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblHeure, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblId2))
					.addGap(22)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblJour)
						.addComponent(lblLabel_4)
						.addComponent(lblHeure))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumSalle)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNumMa))
					.addContainerGap(141, Short.MAX_VALUE))
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
        GroupLayout gl_bgp = new GroupLayout(bgp);
        gl_bgp.setHorizontalGroup(
        	gl_bgp.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_bgp.createSequentialGroup()
        			.addGap(70)
        			.addGroup(gl_bgp.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblAvoirCours, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
        				.addGroup(gl_bgp.createSequentialGroup()
        					.addComponent(lblCours)
        					.addContainerGap())
        				.addGroup(gl_bgp.createParallelGroup(Alignment.LEADING)
        					.addGroup(Alignment.TRAILING, gl_bgp.createSequentialGroup()
        						.addComponent(btnReserver, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
        						.addComponent(btnRetour, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
        						.addGap(72))
        					.addGroup(gl_bgp.createSequentialGroup()
        						.addComponent(lblSeance, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
        						.addGap(33)
        						.addGroup(gl_bgp.createParallelGroup(Alignment.LEADING)
        							.addComponent(lblNumSeance, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
        							.addComponent(lblNomCours, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
        						.addContainerGap(106, Short.MAX_VALUE)))))
        );
        gl_bgp.setVerticalGroup(
        	gl_bgp.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_bgp.createSequentialGroup()
        			.addContainerGap(135, Short.MAX_VALUE)
        			.addComponent(lblAvoirCours)
        			.addGap(18)
        			.addGroup(gl_bgp.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNumSeance)
        				.addComponent(lblSeance))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_bgp.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblCours)
        				.addComponent(lblNomCours))
        			.addGap(18)
        			.addGroup(gl_bgp.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnRetour)
        				.addComponent(btnReserver))
        			.addGap(55))
        );
        bgp.setLayout(gl_bgp);
	}

	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
