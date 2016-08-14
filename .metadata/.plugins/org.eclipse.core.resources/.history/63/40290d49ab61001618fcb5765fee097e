package org.ims.IMS_WEB;

import org.hibernate.Session;

public class IMSDAO {
	private Session session;
	
	public IMSDAO() {
		super();
	}
	
	public IMSDAO(Session session) {
		super();
		this.session = session;
	}
	
	public void create(Object obj){
		session.save(obj);
	}
}
