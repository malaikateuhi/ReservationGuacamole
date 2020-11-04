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
                machine.numMachine=((String)rowData.get("numma")); 
	            machine.setEtat(((String)rowData.get("etatm")));
               lstmachine.add(machine);
       }
		return lstmachine;
	}
	  
}