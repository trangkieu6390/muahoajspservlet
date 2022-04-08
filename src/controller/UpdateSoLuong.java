package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Hoa;

/**
 * Servlet implementation class UpdateSoLuong
 */
@WebServlet("/UpdateSoLuong")
public class UpdateSoLuong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSoLuong() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		ArrayList<Hoa> listHoa = (ArrayList<Hoa>)session.getAttribute("listHoa");
		
		String action = request.getParameter("action");

		int idHoa = Integer.parseInt(request.getParameter("id"));
		int soLuong = Integer.parseInt(request.getParameter("soluong"));
		//còn phần xóa?
		if(request.getParameter("action")!=null) {
			if(action.equals("Update")) {
				for (Hoa hoa : listHoa) {
					if (hoa.getIdHoa() == idHoa) {
						if(soLuong > 0) {
							hoa.setSoLuong(soLuong);
						}else{
							String error = "Số lượng phải lớn > 0 ";
							request.setAttribute("error", error);
							RequestDispatcher rd = request.getRequestDispatcher("/basket.jsp");
							rd.forward(request, response);
						}
					}
				}
				
				
			}else if(action.equals("Delete")) {
				listHoa.remove(idHoa-1);//-1 nghĩa là sao e dạ là do vngf for chạy từ 0 ấy thầy, còn id hoa từu 1 ạ
				//e ko lưu id hoa đúng ko dạ thầy
				
				//bài tạm ok rồi. Có time thì check thêm nhé. E có thẻe học bài mới dạ thầy
			}
		}
		session.setAttribute("listHoa", listHoa);
		response.sendRedirect(request.getContextPath()+"/basket.jsp");
	}

	
}
