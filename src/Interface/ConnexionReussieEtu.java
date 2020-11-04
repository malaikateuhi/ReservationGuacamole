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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class ConnexionReussieEtu extends JFrame {

	private JPanel contentPane;
	public static JLabel lblId;
	private JTextField txtDate;
	private int creneau = 4;
	private String date ;
	
	private BackgroundPanel bgp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnexionReussieEtu frame = new ConnexionReussieEtu();
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
	public ConnexionReussieEtu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblId = new JLabel("...");
		
		JLabel lblNewLabel = new JLabel("Bonjour,");
		
		JLabel lblNewLabel_1 = new JLabel("Saisir la date");
		
		txtDate = new JTextField();
		txtDate.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Choisir un cr\u00E9neau");
		
		JComboBox comboBoxCreneau = new JComboBox();
		comboBoxCreneau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				creneau = comboBoxCreneau.getSelectedIndex();
			}
		});
		comboBoxCreneau.setModel(new DefaultComboBoxModel(new String[] {"09:30-11:00", "11:00-12:30", "14:00-15:30", "15:30-17:00"}));
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//
				btnAction(e);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Consulter mes r\u00E9servations");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(165)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(251)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnNewButton_1)
							.addGap(61)))
					.addContainerGap(81, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
					.addGap(89)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBoxCreneau, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
					.addGap(54))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblId))
					.addGap(30)
					.addComponent(btnNewButton_1)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxCreneau, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(18))
		);
		contentPane.setLayout(gl_contentPane);
		
		//font
		contentPane.setOpaque(false);
		bgp=new BackgroundPanel(new ImageIcon(".//img.jpg")); 
	    bgp.setBounds(0, 0, this.getSize().width, this.getSize().height);  
        contentPane.add(bgp);
	}

	protected void btnAction(ActionEvent evt) {
		// TODO Auto-generated method stub
		RechercherMachineDispo pageRecherche = new RechercherMachineDispo();
		pageRecherche.setVisible(true);
		pageRecherche.lblId2.setText(this.lblId.getText());
		
		date = this.txtDate.getText();
				}

	
}
