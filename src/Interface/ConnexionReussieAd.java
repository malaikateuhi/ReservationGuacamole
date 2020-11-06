package Interface;

import controleur.Controleur;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuItem;

public class ConnexionReussieAd extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
                    
    private javax.swing.JButton btnModifier;
    private javax.swing.JButton btnRegler;
    private javax.swing.JButton btnSupprimer;
    private javax.swing.JComboBox<String> cbGroupes;
    private javax.swing.JComboBox<String> cbSalles;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jListMachines;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable tableComptes;
    private javax.swing.JTable tableReclamations;
    
	private Object [][] donneesReclam;
	private Object [][] donneesComptes;
	private String[] machines;
	private String[] salles;
	

    private Controleur control;
    private JMenuItem deconnecterMenuItem;
	
    public ConnexionReussieAd() {
        control = new Controleur();
    	loadData();
        initComponents();
    	this.setSize(600, 450);
    	this.setVisible(true);
    	setTitle("Interface Admin");
    }
    
    private void loadData() {
    	donneesReclam = control.consulterReclamations();
    	donneesComptes = control.consulterComptes();
    	machines = control.consulterMachines();
    	salles = control.consulterSalles();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableReclamations = new javax.swing.JTable();
        btnRegler = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnSupprimer = new javax.swing.JButton();
        btnModifier = new javax.swing.JButton();
        cbSalles = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListMachines = new javax.swing.JList<String>();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cbGroupes = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableComptes = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuBar1.setBackground(Color.WHITE);
        jMenu1 = new javax.swing.JMenu();
        jMenu1.setBackground(new Color(255, 255, 255));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loadReclamations();
        jScrollPane1.setViewportView(tableReclamations);
        if (tableReclamations.getColumnModel().getColumnCount() > 0) {
            tableReclamations.getColumnModel().getColumn(0).setResizable(false);
            tableReclamations.getColumnModel().getColumn(1).setResizable(false);
            tableReclamations.getColumnModel().getColumn(2).setResizable(false);
            tableReclamations.getColumnModel().getColumn(3).setResizable(false);
        }

        btnRegler.setText("Terminer");
        btnRegler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReglerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(26)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(28, Short.MAX_VALUE))
        		.addGroup(Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        			.addContainerGap(212, Short.MAX_VALUE)
        			.addComponent(btnRegler)
        			.addGap(205))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(btnRegler)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1.setLayout(jPanel1Layout);

        jTabbedPane2.addTab("Reclamations", jPanel1);

        btnSupprimer.setText("Supprimer");
        btnSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerActionPerformed(evt);
            }
        });

        btnModifier.setText("Modifier");

        cbSalles.setModel(new javax.swing.DefaultComboBoxModel<>(salles));

        cbSalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSallesActionPerformed(evt);
            }
        });

        jListMachines.setModel(new javax.swing.AbstractListModel<String>() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

            public int getSize() { return machines.length; }
            public String getElementAt(int i) { return machines[i]; }

        });
        jScrollPane2.setViewportView(jListMachines);

        jLabel2.setText("Salle");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addGap(76)
        			.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        					.addComponent(jLabel2)
        					.addGap(26)
        					.addComponent(cbSalles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(70))
        				.addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(btnSupprimer)
        						.addComponent(btnModifier))
        					.addGap(87))))
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel2Layout.createSequentialGroup()
        			.addContainerGap(41, Short.MAX_VALUE)
        			.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
        				.addGroup(jPanel2Layout.createSequentialGroup()
        					.addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(cbSalles, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel2))
        					.addGap(55)
        					.addComponent(btnModifier)
        					.addGap(18)
        					.addComponent(btnSupprimer)))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2.setLayout(jPanel2Layout);

        jTabbedPane2.addTab("Postes", jPanel2);

        jTabbedPane3.addTab("Gestion des machines", jTabbedPane2);


        cbGroupes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M2IPMTD1", "M2IPMTD2"}));

        jLabel1.setText("Groupe");

        loadComptes();

        jScrollPane3.setViewportView(tableComptes);
        if (tableComptes.getColumnModel().getColumnCount() > 0) {
            tableComptes.getColumnModel().getColumn(0).setResizable(false);
            tableComptes.getColumnModel().getColumn(1).setResizable(false);
        }

        jButton1.setText("Supprimer");

        jButton2.setText("Modifier");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addGap(64)
        					.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE))
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addGap(80)
        					.addComponent(jLabel1)
        					.addGap(18)
        					.addComponent(cbGroupes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jButton1)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jButton2)))
        			.addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addGap(18)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jButton2)
        				.addComponent(jButton1)
        				.addComponent(cbGroupes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel1))
        			.addGap(18)
        			.addComponent(jScrollPane3, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel3.setLayout(jPanel3Layout);

        jTabbedPane3.addTab("Gestion des comptes etudiants", jPanel3);

        jMenu1.setText("Menu");
        
        jMenuBar1.add(jMenu1);
        
        deconnecterMenuItem = new JMenuItem("Deconnexion");

        deconnecterMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenu1.add(deconnecterMenuItem);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addGap(19)
        			.addComponent(jTabbedPane3, GroupLayout.PREFERRED_SIZE, 559, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(jTabbedPane3, GroupLayout.PREFERRED_SIZE, 375, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        //pack();

    }// </editor-fold>               
    
    /**
     * Charger les reclamations depuis BD
     * 
     */
    private void loadReclamations() {
    	loadData();
    	DefaultTableModel modelReclam = new javax.swing.table.DefaultTableModel(
                donneesReclam,
                new String [] {
                    "Date", "Debut", "Fin", "Salle", "Poste"
                }
            ) {
                /**
    			 * 
    			 */
    			private static final long serialVersionUID = 1L;
    			boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            };
         tableReclamations.setModel(modelReclam);
    }
    
    /**
     * Vider le tableau de reclamations
     * 
     */
    private void clearReclamations() {
    	DefaultTableModel modelReclam = new javax.swing.table.DefaultTableModel(
                null,
                new String [] {
                    "Date", "Debut", "Fin", "Salle", "Poste"
                }
            ) {
                /**
    			 * 
    			 */
    			private static final long serialVersionUID = 1L;
    			boolean[] canEdit = new boolean [] {
                    false, false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            };
         tableReclamations.setModel(modelReclam);
    }
    
    private void loadComptes() {
    	loadData();
    	tableComptes.setModel(new javax.swing.table.DefaultTableModel(
                donneesComptes,
                new String [] {
                    "NumEtudiant", "Nom", "Prenom"
                }
            ) {
                /**
    			 * 
    			 */
    			private static final long serialVersionUID = 1L;
    			boolean[] canEdit = new boolean [] {
                    false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
    }
    
    private void clearComptes() {
    	tableComptes.setModel(new javax.swing.table.DefaultTableModel(
                null,
                new String [] {
                    "NumEtudiant", "Nom", "Prenom"
                }
            ) {
                /**
    			 * 
    			 */
    			private static final long serialVersionUID = 1L;
    			boolean[] canEdit = new boolean [] {
                    false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
    }

    private void btnSupprimerActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void btnReglerActionPerformed(java.awt.event.ActionEvent evt) {     
    	int row = tableReclamations.getSelectedRow();    	
    	String jour = (String) tableReclamations.getValueAt(row, 0);
    	String heureDeb = (String) tableReclamations.getValueAt(row, 1);
    	String heureFin = (String) tableReclamations.getValueAt(row, 2);
    	String numSalle = (String) tableReclamations.getValueAt(row, 3);
    	String numMachine = (String) tableReclamations.getValueAt(row, 4);

        this.control.traiterReclamation(numSalle, numMachine, jour, heureDeb, heureFin);  
        clearReclamations();
        loadReclamations();
        
    }                                        


    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {                                       
        dispose();
        Connexion co = new Connexion();
        co.setVisible(true);
    }                                      

    private void cbSallesActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        


                  
}

