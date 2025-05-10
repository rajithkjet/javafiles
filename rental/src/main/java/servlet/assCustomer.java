package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.customer;
import services.customerService;


@WebServlet("/assCustomer")
public class assCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public assCustomer() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		customer cus= new customer();
		cus.setName(request.getParameter("name"));
		cus.setEmail(request.getParameter("email"));
		cus.setPassword(request.getParameter("password"));
		cus.setAge(Integer.parseInt(request.getParameter("age")));
		
		customerService service=new customerService();
		service.regCustomer(cus);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("homepage.jsp");
		
		dispatcher.forward(request, response);
	}

}
