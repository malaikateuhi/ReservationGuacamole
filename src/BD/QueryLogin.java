package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import GestionUtilisateurs.*;


public class QueryLogin {
	public QueryLogin() {
		
	}
	public Etudiant loginEtu(Connection con,Utilisateur user)throws Exception{
		Etudiant resUser = null;
		String sql = "select * from etudiant where ide=? and passworde=?";

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, user.getIdentifiant());
		pstmt.setString(2, user.getMdp());
		ResultSet rs=pstmt.executeQuery();
		if (rs.next()) {
		
				resUser=new Etudiant();
				resUser.setIdentifiant(rs.getString("ide"));
				resUser.setMdp(rs.getString("passworde"));
			
		}
		return resUser;
	}
	public Enseignant loginEn(Connection con,Utilisateur user)throws Exception{
		Enseignant resUser = null;
		String sql = "select * from enseignant where iden=? and passworden=?";

		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getIdentifiant());
		pstmt.setString(2, user.getMdp());
		ResultSet rs=pstmt.executeQuery();
		if (rs.next()) {
		
				resUser=new Enseignant();
				resUser.setIdentifiant(rs.getString("iden"));
				resUser.setMdp(rs.getString("passworden"));
			
		}
		return resUser;
	}
	public Admin loginAdmin(Connection con,Utilisateur user)throws Exception{
		Admin resUser=null;
		String sql = "select * from admin where ida=? and passworda=?";
		
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, user.getIdentifiant());
		pstmt.setString(2, user.getMdp());
		ResultSet rs=pstmt.executeQuery();
		if (rs.next()) {
			
				resUser=new Admin();
				resUser.setIdentifiant(rs.getString("ida"));
				resUser.setMdp(rs.getString("passworda"));
		}
		
		return resUser;
	}

}
