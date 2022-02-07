package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDao;

/**
 * Servlet implementation class ServletCRUD
 */
@WebServlet("/ServletCRUD")
public class ServletCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private Integer teste = 0;
	private UserDao userDao; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCRUD() {
        super();
        this.userDao = new UserDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		String option = request.getParameter("option");
		if (option == null) {
			option = "qualquer coisa";
		}
		switch(option) {
			case ("insertForm"):
				showInsertUser(request, response);
			break;
			case ("updateForm"):
				showUpdateUser(request, response);
			break;
			case ("update"):
				updateUser(request, response);
			break;
			case ("delete"):
				deleteUser(request, response);
			break;
			case ("insert"):
				insertUser(request, response);
			break;
			default:
				selectAllUsers(request, response);
		}
	}
	
	private void showInsertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
	private void showUpdateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer id = Integer.parseInt(request.getParameter("id"));
		User u = this.userDao.buscarUser(id);
		request.setAttribute("user", u);
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}
	
	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//String nomeBack = tomate.getParameter("nome"); // ERRO
		String nomeBack = request.getParameter("nome");
		String paisBack = request.getParameter("pais");
		String emailBack = request.getParameter("email");
		String telefoneBack = request.getParameter("telefone");
		if ((paisBack != null) && (nomeBack != null) && (emailBack != null) && (telefoneBack != null)) {
			if (!nomeBack.equals("")){
				User user1 = new User(nomeBack, paisBack, emailBack, telefoneBack);
				this.userDao.addUser(user1);
			}
		}
		response.sendRedirect("ServletCRUD");
	}
	
	private void selectAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//System.out.println(this.cont.selectAll());
		request.setAttribute("listUser", this.userDao.getListUser());
		request.getRequestDispatcher("listTable.jsp").forward(request, response);
	}
	
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idBack = request.getParameter("id");
		if (idBack != null) {
			Integer id = Integer.parseInt(idBack);
			this.userDao.removeUser(id);
		}
		response.sendRedirect("ServletCRUD");
	}
	
	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		User user1 = new User("Raphael", "Brasil", "raphael@rd.com.br");
//		user1.setNome("João");
//		user1.setId(2);
//		this.cont.update(user1);
		//String nomeBack = request.getParameter("nome"); // ERRO
		String nomeBack = request.getParameter("nome");
		String paisBack = request.getParameter("pais");
		String emailBack = request.getParameter("email");
		String telefoneBack = request.getParameter("telefone");
		String idBack = request.getParameter("id");
		if ((paisBack != null) && (nomeBack != null) && (emailBack != null) && (telefoneBack != null) && (idBack != null)) {
			if (!nomeBack.equals("")){
				Integer id = Integer.parseInt(idBack);
				User user1 = new User(nomeBack, paisBack, emailBack, telefoneBack);
				user1.setId(id);
				this.userDao.updateUser(user1);
			}
		}
		response.sendRedirect("ServletCRUD");
	}
	

	}


