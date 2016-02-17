package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Borko Arsovic
 *
 */

@Entity
@Table(name = "prijateljstvo")
public class Prijateljstvo {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "prijateljstvo_id", unique = true, nullable = false)
	private int prijateljstvo_id;

	@ManyToOne
	@JoinColumn( name = "prijatelj1_id",referencedColumnName = "user_id", nullable = false)
	private Gost gost;
	
	@ManyToOne
	@JoinColumn( name = "prijatelj2_id",referencedColumnName = "user_id", nullable = false)
	private Gost prijatelj2;

	public int getPrijateljstvo_id() {
		return prijateljstvo_id;
	}

	public void setPrijateljstvo_id(int prijateljstvo_id) {
		this.prijateljstvo_id = prijateljstvo_id;
	}

	
	public Gost getGost() {
		return gost;
	}

	public void setGost(Gost gost) {
		this.gost = gost;
	}

	public Gost getPrijatelj2() {
		return prijatelj2;
	}

	public void setPrijatelj2(Gost prijatelj2) {
		this.prijatelj2 = prijatelj2;
	}
	
	
	
	
	

}
