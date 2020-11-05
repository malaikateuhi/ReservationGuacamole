package Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConnexionReussieEn extends JFrame {

	private JPanel contentPane;
	protected JLabel lbNomEn;
	protected String idEn;
	protected JList listSeance;
	private JTable tableSeance;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnexionReussieEn frame = new ConnexionReussieEn();
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
	public ConnexionReussieEn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Bonjour,");
		
		lbNomEn = new JLabel("...");
		
		JLabel lblNewLabel_1 = new JLabel("Mes s\u00E9ances");
		
		listSeance = new JList();
		
//        //column names
//          String[] columnNames = { "Date", "Heure", "N° séance","Cours"};
// 
//          //data 
//          Object[][] data = {
//                  { "Kathy", "Smith", "Snowboarding", new Integer(5) },
//                  { "John", "Doe", "Rowing", new Integer(3), new Boolean(true) },
//                  { "Sue", "Black", "Knitting", new Integer(2) },
//                  { "Jane", "White", "Speed reading", new Integer(20)},
//                  { "Joe", "Brown", "Pool", new Integer(10) } };
//          
          //tableSeance = new JTable(data, columnNames);
          String [] header={"name","age"};
          String [][] data={{"akash","20"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"},{"pankaj","24"}};


          DefaultTableModel model = new DefaultTableModel(data,header);

          tableSeance= new JTable(model);

          tableSeance.setPreferredScrollableViewportSize(new Dimension(450,63));
          tableSeance.setFillsViewportHeight(true);

          JScrollPane js=new JScrollPane(tableSeance);
          js.setVisible(true);
          panel.add(js);
          //add(js);
          
          //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          //getContentPane().add(tableSeance);

          
          
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(312, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lbNomEn, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addGap(23))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(tableSeance, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
						.addComponent(listSeance, GroupLayout.PREFERRED_SIZE, 366, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(54, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lbNomEn))
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addGap(26)
					.addComponent(listSeance, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(tableSeance, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
