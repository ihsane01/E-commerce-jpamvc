package ma.fstt.persistance.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.fstt.persistance.manager.DBPanier;
import ma.fstt.persistance.manager.DBProduit;
import ma.fstt.persistance.manager.DBUser;
import ma.fstt.persistance.model.Panier;
import ma.fstt.persistance.model.Produit;
import ma.fstt.persistance.model.User;

/**
 * Servlet implementation class PanierServlet
 */
@WebServlet(name = "paniers", urlPatterns = {"/panier","/panier/*"})
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestURI = request.getRequestURI();
	      String url = "/index.jsp";
	      ///ecommerce-jpamvc/Panier/*
	      if (requestURI.endsWith("/panier")) {
	      url = displayPanier(request, response);
	    	//  url="/panier.jsp";
		         System.out.println(url);

	      } 

	      getServletContext().getRequestDispatcher(url).forward(request, response);	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestURI = request.getRequestURI();
	      String url = "/cart/cart.jsp";

	      if (requestURI.endsWith("/addpanier")) {
	         url = addpanier(request, response);
	         System.out.println(url);
	         response.sendRedirect(request.getContextPath() + "/Pro");
	      } else if (requestURI.endsWith("/removepanier")) {
	         url = removepanier(request, response);
	      }  else if (requestURI.endsWith("/displayUser")) {
	         url = "/cart/new_customer.jsp";
	      } else if (requestURI.endsWith("/displayPayment")) {
	         url = "/cart/payment.jsp";
		    getServletContext().getRequestDispatcher(url).forward(request, response);	

	      }	}


private String displayPanier(HttpServletRequest request,
        HttpServletResponse response) {
    HttpSession session = request.getSession();
    long id= (long) session.getAttribute("iduser");
    
    User user = DBUser.selectuserid(id);
   List<Panier> paniers =DBPanier.selectPaniers(user);
   session.setAttribute("paniers", paniers);

   return "/panier.jsp";
}


private String addpanier(HttpServletRequest request, HttpServletResponse response) {
	     HttpSession session = request.getSession();
	     String requestURI = request.getRequestURI();
	     String[] tokens = requestURI.split("/");
	     String productCode = tokens[tokens.length - 2];
	     int idpro=Integer.parseInt(productCode);
		   int qtep=Integer.parseInt(request.getParameter("qtestock"));
System.out.println(idpro);
System.out.println("dddd");

	     Produit product = DBProduit.selectProduct(idpro);
	    Long id= (long) session.getAttribute("iduser");
	    System.out.println(id);

	    User user =DBUser.selectuserid(id);
	    System.out.println(user.getId());

	    float prixtotal=qtep*product.getPrice();
	   Panier panier=new Panier( product.getNompro(),product.getCodeimg(), qtep,  prixtotal,user.getId());
	   panier.setUser(user);
	  DBPanier.insert(panier);
	   return "/panier.jsp";
}

private String removepanier(HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession();
    String requestURI = request.getRequestURI();

	String[] tokens = requestURI.split("/");
     String panierid = tokens[tokens.length - 1];
	 //   Panier panier =DBPanier.selectPanier(Integer.parseInt(panierid));

	   DBPanier.delete(Integer.parseInt(panierid));
	   return "/Panier.jsp";
}
}

