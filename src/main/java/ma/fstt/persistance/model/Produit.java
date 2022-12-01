package ma.fstt.persistance.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="produit")
public class Produit  {
	
		@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long Id;
	   private String Nompro;
	   private String description;
	   private int qtestock;
	   private float price;
	   
	   private String codeimg;
	   
	


	public Produit(Long id, String nompro, String description, int qtestock, float price, String codeimg) {
		super();
		Id = id;
		Nompro = nompro;
		this.description = description;
		this.qtestock = qtestock;
		this.price = price;
		this.codeimg = codeimg;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNompro() {
		return Nompro;
	}

	public void setNompro(String nompro) {
		Nompro = nompro;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQtestock() {
		return qtestock;
	}

	public void setQtestock(int qtestock) {
		this.qtestock = qtestock;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getCodeimg() {
		return codeimg;
	}

	public void setCodeimg(String codeimg) {
		this.codeimg = codeimg;
	}




	public Produit(String nompro, String description, int qtestock, float price, String codeimg) {
		super();
		Nompro = nompro;
		this.description = description;
		this.qtestock = qtestock;
		this.price = price;
		this.codeimg = codeimg;
	}

	public Produit() {
		super();
	}

}

