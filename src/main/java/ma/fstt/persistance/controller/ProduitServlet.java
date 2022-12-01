package ma.fstt.persistance.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.fstt.persistance.manager.DBProduit;
import ma.fstt.persistance.model.Produit;



/**
 * Servlet implementation class ProduitServlet
 */
@WebServlet(name = "produits", urlPatterns = {"/Pro","/Pro/produits/*"})
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitServlet() {
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

	      if (requestURI.endsWith("/Pro")) {
	         url = displayProducts(request, response);
	      } else if (requestURI.matches("/ecommerce-jpamvc/Pro/produits/formpro")) {
		         url ="/New_pro.jsp";
		      }else if (requestURI.endsWith("/removepro")) {
		    	  System.out.println("eeeeee");
			         url = removeproduct(request, response);
		      }
		     
	      getServletContext().getRequestDispatcher(url).forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String requestURI = request.getRequestURI();
	      String url = "/cart/cart.jsp";

	      if (requestURI.endsWith("/addpro")) {
	         url = addproduct(request, response);
	         System.out.println(url);
	         response.sendRedirect(request.getContextPath() + "/Pro");
	      }  else if (requestURI.endsWith("/updateItem")) {
	         url = updateproduct(request, response);
	      }else if (requestURI.endsWith("/admin")) {
	    	   url = displayProducts(request, response);
		         System.out.println(url);

			      getServletContext().getRequestDispatcher(url).forward(request, response);	
	      } else if (requestURI.endsWith("/displayPayment")) {
	         url = "/cart/payment.jsp";
		    getServletContext().getRequestDispatcher(url).forward(request, response);	

	      }

	      
	      
	
	
	
	
	
	}
	   private String displayProducts(HttpServletRequest request,
	           HttpServletResponse response) {

	      List<Produit> products = DBProduit.selectProducts();
	      HttpSession session = request.getSession();
	      session.setAttribute("products", products);
	      if((Long)session.getAttribute("iduser")!= null) {
	if(	   (long) session.getAttribute("iduser")==6) {
    return "/Tableproduit.jsp";

}}
	      
	      
	      return "/Products.jsp";
	   }
	   
	   
	   private String addproduct(HttpServletRequest request, HttpServletResponse response) {
		     HttpSession session = request.getSession();

		   String nom = request.getParameter("name");
		      int qtestock = Integer.parseInt(request.getParameter("qtestock"));
		      String description = request.getParameter("description");
		      float price = Float.parseFloat(request.getParameter("price"));
		      String codeimg = request.getParameter("codeimg");

		      Produit  produit= new Produit (nom,  description,  qtestock,  price,  codeimg);
		   DBProduit.insert(produit);
		   System.out.println(produit.getNompro());
		   return "/Pro";
	   }
	   
	   private String removeproduct(HttpServletRequest request, HttpServletResponse response) {
		   String requestURI = request.getRequestURI();
		     String[] tokens = requestURI.split("/");
		     String productCode = tokens[tokens.length - 2];
		     Long idpro=Long.valueOf(productCode);
		//   int id = Integer.parseInt(request.getParameter("id"));

		   DBProduit.delete(idpro);
		   return "/Pro";
	   }
	   private String updateproduct(HttpServletRequest request, HttpServletResponse response) {
		      int id = Integer.parseInt(request.getParameter("id"));

		  // DBProduit.delete(id);
		   return "/Products.jsp";
	   }
	 /*  private String showProduct(HttpServletRequest request,
	           HttpServletResponse response) {

	      // Retrieve the product code
	      String requestURI = request.getRequestURI();
	      String[] tokens = requestURI.split("/");
	      String productCode = tokens[tokens.length - 1];

	      // Retrieve the product from the database and set it as a session attribute
	      Produit product = DBProduit.selectProduct(productCode);
	      HttpSession session = request.getSession();
	      session.setAttribute("product", product);

	      return "/single_product.jsp";
	   }*/


}