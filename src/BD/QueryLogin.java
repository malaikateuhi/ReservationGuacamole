package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import GestionUtilisateurs.*;


public class QueryLogin {
	public QueryLogin() {
		
	}
	// cette methode permet de trouver les infos de client en fonction de son email et mot de passe
	public Utilisateur login(Connection con,Utilisateur user)throws Exception{
		Utilisateur resUser=null;
		String sql = null;
		if(user instanceof Etudiant) {
			sql="select * from etudiant where ide=? and mdpe=?";
		}
		else if(user instanceof Enseignant) {
			sql="select * from enseignant where iden=? and mdpen=?";
		}
		else {
			sql="select * from admin where ida=? and mdpa=?";
		}
		
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, user.getIdentifiant());
		pstmt.setString(2, user.getMdp());
		ResultSet rs=pstmt.executeQuery();
		if (rs.next()) {
			if(user instanceof Etudiant) {
				resUser=new Etudiant();
				resUser.setIdentifiant(rs.getString("ide"));
				resUser.setMdp(rs.getString("mdpe"));
			}
			else if(user instanceof Enseignant) {
				resUser=new Enseignant();
				resUser.setIdentifiant(rs.getString("iden"));
				resUser.setMdp(rs.getString("mdpen"));
			}
			else {
				resUser=new Admin();
				resUser.setIdentifiant(rs.getString("ida"));
				resUser.setMdp(rs.getString("mdpa"));
			}
		}
		return resUser;
	}
}
