package webtier;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import dao.ShoppingcartDAO;
import domain.Shoppingcard;
import domain.Userinfo;

public class CartController extends HttpServlet {
	private ShoppingcartDAO scdao= new ShoppingcartDAO();

	/**
	 * Constructor of the object.
	 */
	public CartController() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int flag=new Integer(request.getParameter("flag"));
		switch(flag){
		case 0:findAllCartGoods(request,response);break;
		case 1:changeNum(request,response);break;
		case 2:deleteAllCart(request,response);break;
		case 3:deleteCart(request,response);break;
		
		}
                         
	
	}

	
	public void init() throws ServletException {
		// Put your code here
	}
	public void findAllCartGoods(HttpServletRequest request, HttpServletResponse response){
			try{
				Userinfo user=(Userinfo)request.getSession().getAttribute("userinfo");
				int userId=user.getId();
				String currpage=request.getParameter("currentePage");
				int currentePage=1;
				if(currpage!=null){
					currentePage=Integer.parseInt(currpage);
				}
				if(currentePage<1){
					currentePage=1;
				}
				if(currentePage>scdao.pageSize(userId)){
					currentePage=scdao.pageSize(userId);
				}
				List<Shoppingcard> allCartGoods=scdao.findByUserId(userId,currentePage);
				request.setAttribute("currentePage", currentePage);
				request.setAttribute("pageinfo", scdao.pageSize(userId));
				
				request.getSession().setAttribute("allCartGoods", allCartGoods);
				RequestDispatcher rd=request.getRequestDispatcher("selectSC.jsp");
				rd.forward(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	public void deleteCart(HttpServletRequest request,HttpServletResponse response){
		try{
			scdao.deleteCart(Integer.parseInt(request.getParameter("id")));
			RequestDispatcher rd=request.getRequestDispatcher("goods.do?flag=0");
			rd.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void deleteAllCart(HttpServletRequest request,HttpServletResponse response){
		try{
			scdao.deleteAllCart(Integer.parseInt(request.getParameter("userId")));
			 JOptionPane.showMessageDialog( 
						null,"你的购物车已经成功清空！");

			RequestDispatcher rd=request.getRequestDispatcher("goods.do?flag=0");
			rd.forward(request, response);

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void changeNum(HttpServletRequest request,HttpServletResponse response){
		
			
			Shoppingcard sc = (Shoppingcard)request.getSession().getAttribute("sc");
			//int number=Integer.parseInt(request.getParameter("number"));
			//int id=Integer.parseInt(request.getParameter("id"));
			int number = Integer.parseInt(request.getParameter("num"));
			
			sc.setNumber(number);
			request.getSession().setAttribute("sc", sc);
			
			try {
				response.sendRedirect("selectSC.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 JOptionPane.showMessageDialog( 
						null,"商品数量修改成功！");
			//RequestDispatcher rd=request.getRequestDispatcher("cart.do?flag=0");
			//rd.forward(request, response);
		
		
		
	}
	
}
