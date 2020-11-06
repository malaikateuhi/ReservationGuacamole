package Dao;

import BD.Query;
import static BD.Query.Query;
import static BD.Query.Select;
import static BD.Query.afferentSQL;
import static BD.Query.parameter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import GestionSallesMachines.Machine;
import GestionSallesMachines.Salle;

public class MachineDao {
	public MachineDao() {	
	}	

	ArrayList<Machine> lstmachine;

	/**
	 * Liste des machines d'une salle
	 * @return ArrayList d'objets de type Machine
	 */
	public ArrayList<Machine> machinelibre (Salle salle)
	{
		String sqlmachine = "select * from machine where numsalle=? ";
		Query(); 
		parameter.add(salle.getNomSalle());
		afferentSQL(sqlmachine);
		this.lstmachine = new ArrayList<Machine>();
		List<Object> objs = Select();
		for (int i = 0; i < objs.size(); i++) {
			Map<String, Object> rowData =(Map<String, Object>) objs.get(i);
			Machine machine = new Machine();
			machine.setNumMachine(((String)rowData.get("numma")));
			machine.setSalle(salle);
			lstmachine.add(machine);
		}
		System.out.println(lstmachine);
		return lstmachine;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MachineDao m1 = new MachineDao();	
		Salle s1 =new Salle();
		s1.setNomSalle("M1");	
		m1.machinelibre(s1);

	}
}