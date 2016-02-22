package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * Klasa koja predtavlja rezervaciju u restoranu
 * @author Borko Arsovic
 *
 */

@Entity
@Table(name="rezervacija")
public class Rezervcija implements Serializable {

	private static final long serialVersionUID = -5575474153829623758L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rezervacija_id", unique = true, nullable = false)
	private int rezervacija_id;
	

	@Column(name="datum_rezervacije", unique = false, nullable = false)
	private Date datum;

	@Column(name="vremeBoravka", unique = false, nullable = false)
	private int vremeBoravka;
	
	@Column(name="ocenaRezervacije", unique = false, nullable = true)
	private int ocena;
	
	@OneToOne()
	@JoinColumn(name = "restoran_id" ,referencedColumnName="restoran_id", nullable = false)
	public Restoran restoran;
	
	


	
}
