package classes.dao;

import db.DB;


public class DaoFactory {

	public static ChaleDao createChaleDao() {		
		 return new ChaleDaoImpl(DB.getConnection());
	}
	
	public static ClienteDao createClienteDao() {		
		 return new ClienteDaoImpl(DB.getConnection());
	}
	
	public static HospedagemDao createHospedagemDao() {		
		 return new HospedagemDaoImpl(DB.getConnection());
	}
	 
	
}
