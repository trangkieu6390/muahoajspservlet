package controller;

import java.io.IOException;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Hoa;

/**
 * Servlet implementation class MuaHoaController
 */
@WebServlet("/MuaHoaController")
public class MuaHoaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Hoa> listHoa = new ArrayList<Hoa>(); 
	    /**
     * @see HttpServlet#HttpServlet()
     */
    public MuaHoaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/muahoa.jsp");
		rd.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		boolean check = true;
		int idHoa = Integer.parseInt(request.getParameter("idhoa"));
		
		
		int soLuong = Integer.parseInt(request.getParameter("soluong"));
		String tenHoa = request.getParameter("tenhoa");
		int giaBan = Integer.parseInt(request.getParameter("gia"));
		
		Hoa objHoa = new Hoa(idHoa, tenHoa, soLuong, giaBan);
		
		if (listHoa.size() > 0) {
			for (Hoa itemHoa : listHoa) {
				if(itemHoa.getIdHoa() == idHoa) {
					itemHoa.setSoLuong(soLuong + itemHoa.getSoLuong());
					check = true;
				} else {
					check = false;
				}
			}
		}
		 if (check == false || listHoa.size() == 0) {
			listHoa.add(objHoa);
			//e chạy xem nào
		}
		 session.setAttribute("listHoa", listHoa);
		response.sendRedirect(request.getContextPath()+"/basket.jsp");
		
		//hphaanf update ở đâu e

	}

}
