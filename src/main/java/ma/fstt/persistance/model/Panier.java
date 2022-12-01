package ma.fstt.persistance.model;


import java.io.Serializable;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name="panier")
public class Panier    {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String nomp;
private String image;
private int qtep;
private float prixtotal;


@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="userId")
private User user;

		
private Long iduser;

 public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public String getNomp() {
	return nomp;
}

public void setNomp(String nomp) {
	this.nomp = nomp;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}

public int getQtep() {
	return qtep;
}

public void setQtep(int qtep) {
	this.qtep = qtep;
}

public float getPrixtotal() {
	return prixtotal;
}

public void setPrixtotal(float prixtotal) {
	this.prixtotal = prixtotal;
}




	public Panier(String nomp, String image, int qtep, float prixtotal, Long userid) {
	super();
	this.nomp = nomp;
	this.image = image;
	this.qtep = qtep;
	this.prixtotal = prixtotal;
	this.iduser = userid;
}

	public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}



	public Long getIduser() {
	return iduser;
}

public void setIduser(Long iduser) {
	this.iduser = iduser;
}

	public Panier() {
		super();
	}
	
	

	/*public void addItem(Produit produit) {
		      String code = produit.getCodeimg();
		   //   int quantity = produit.getQuantity();

		      for (Produit i : items) {
		         if (i.getCodeimg().equals(code)) {
		            // already exists
		          //  i.setQuantity(quantity);
		            return;
		         }
		      }

		      items.add(produit);
		   }
	   
	   public void removeItem(Produit produit) {
		      String code = produit.getCodeimg();
		      for (int i = 0; i < items.size(); i++) {
		         if (items.get(i).getCodeimg().equals(code)) {
		            items.remove(i);
		            return;
		         }
		      }
		   }
	   
	   
	   
	   
	public Panier(List<Produit> items, User user) {
		super();
		this.items = items;
		this.user = user;
	}

	public void setItems(List<Produit> items) {
		this.items = items;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
*/
}
