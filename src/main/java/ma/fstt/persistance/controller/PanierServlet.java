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
@WebServlet(name = "panier", urlPatterns = {"/panier/*"})
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

	      if (requestURI.matches("/ecommerce-jpamvc/Panier/*")) {
	         url = displayPanier(request, response);
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
	String requestURI = request.getRequestURI();
    String[] tokens = requestURI.split("/");
    String productCode = tokens[tokens.length - 1];

    Produit product = DBProduit.selectProduct(productCode);
    HttpSession session = request.getSession();
    session.setAttribute("product", product);
   List<Produit> products = DBProduit.selectProducts();
   session.setAttribute("products", products);

   return "/Products.jsp";
}


private String addpanier(HttpServletRequest request, HttpServletResponse response) {
	     HttpSession session = request.getSession();
	     String requestURI = request.getRequestURI();
	     String[] tokens = requestURI.split("/");
	     String productCode = tokens[tokens.length - 1];

	     Produit product = DBProduit.selectProduct(productCode);
	    String username= (String) session.getAttribute("username");
	    User user =DBUser.selectuser(username);
	    
	    //Panier panier=new Panier( product.getNompro(),product.getCodeimg(), int qtep, float prixtotal,  user);
	  // DBPanier.insert(panier);
	   return "/Pro";
}

private String removepanier(HttpServletRequest request, HttpServletResponse response) {
	    
	   int id = Integer.parseInt(request.getParameter("id"));

	   DBProduit.delete(id);
	   return "/Products.jsp";
}}

