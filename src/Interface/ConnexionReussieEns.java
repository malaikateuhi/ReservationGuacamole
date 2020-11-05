package Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ConnexionReussieEns extends JFrame {

	private JPanel contentPane;
	protected JLabel lblNomEns;
	protected String idEns;
	protected JTable tableSeance;
	
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
		
		  String [] header={"Date","Heure","N°séance","Cours"};
	        String [][] data={{"akash","20"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"}};


	        DefaultTableModel model = new DefaultTableModel(data,header);

	        tableSeance= new JTable(model);

        //tableSeance= new JTable();

        tableSeance.setPreferredScrollableViewportSize(new Dimension(450,63));
        tableSeance.setFillsViewportHeight(true);

        JScrollPane js=new JScrollPane(tableSeance);
        js.setVisible(true);
        
        JLabel lblBonjour = new JLabel("Bonjour,");
        lblNomEns = new JLabel("...");
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addComponent(js, GroupLayout.PREFERRED_SIZE, 498, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(29, Short.MAX_VALUE))
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap(342, Short.MAX_VALUE)
        			.addComponent(lblBonjour, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblNomEns, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblBonjour)
        				.addComponent(lblNomEns))
        			.addPreferredGap(ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
        			.addComponent(js, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(141))
        );
        contentPane.setLayout(gl_contentPane);
	}
}
