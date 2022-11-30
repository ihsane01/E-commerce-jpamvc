package ma.fstt.persistance.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ma.fstt.persistance.manager.DBUser;
import ma.fstt.persistance.model.User;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet(name = "user", urlPatterns = {"/user/*"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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

	      if (requestURI.matches("/ecommerce-jpamvc/user/formlogin")) {
	         url ="/formlogin.jsp";
	      } else if (requestURI.endsWith("formregister")) {
		         url ="/user/formregister.jsp";
	      }else if (requestURI.endsWith("/logout")) {
	    	   url = logout(request, response);
		         System.out.println(url);

			      getServletContext().getRequestDispatcher(url).forward(request, response);	
	      }}


	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String requestURI = request.getRequestURI();
	      String url = "/cart/cart.jsp";

	    if (requestURI.endsWith("/login")) {
	         url = login(request, response);
	         response.sendRedirect(request.getContextPath() + "/Pro");

	      } else if (requestURI.endsWith("/logout")) {
	    	  
	         url = logout(request, response);
	         System.out.println(url);

		      getServletContext().getRequestDispatcher(url).forward(request, response);	

	      } else if (requestURI.endsWith("/register")) {
	         url = register(request, response);
	         System.out.println(url);
		      getServletContext().getRequestDispatcher(url).forward(request, response);	

	      } 

	      }
	
	   private String register(HttpServletRequest request, HttpServletResponse response) {
		      // retrieve or create a cart
		   String username=request.getParameter("name");

		   String email=request.getParameter("email");
			String password=request.getParameter("password");
			HttpSession session=request.getSession();
		      User  user= new User (username,  email,  password);
			   DBUser.insert(user);
				session.setAttribute("username", username);
				session.setAttribute("iduser", user.getId());

			   
			
		      return "/formlogin.jsp";
		   }
	   private String login (HttpServletRequest request, HttpServletResponse response) {
		      // retrieve or create a cart
		   String username=request.getParameter("name");

		   String email=request.getParameter("email");
			String password=request.getParameter("password");
			HttpSession session=request.getSession();
			  if( DBUser.selectuser(email,password)) {
					session.setAttribute("username", username);
					 return "/Pro";
			  };

			   
			
		      return "erreur.jsp";
		   }
	   
	   private String logout (HttpServletRequest request, HttpServletResponse response) throws IOException {
		      // retrieve or create a cart
		   HttpSession session=request.getSession();
			session.removeAttribute("username");
			PrintWriter out=response.getWriter();
			out.println("<span style='color:red'>You logged out successfully</span>");
		   
	   
return "/formlogin.jsp";
}}