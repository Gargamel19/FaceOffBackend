package se1app.applicationcore.spielercomponent;

import java.io.Serializable;

public class Nummer implements Serializable{

	private static final long serialVersionUID = 1L;

	Integer id;
	
	public Nummer(int id) {
		this.id = id;
	}
	
	public Nummer(Integer id) {
		this.id = id;
	}
	
	public Nummer(String id) {
		this.id = Integer.parseInt(id);
	}
	
	public Integer getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Nummer) {
			obj = (Nummer) obj;
			return ((Nummer) obj).getId().equals(this.getId());
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id.intValue();
		return result;
	}
	
	@Override
	public String toString() {
		return id.toString();
	}
	
}
