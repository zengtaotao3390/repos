package webtier;

import java.awt.Color;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.DefaultCategoryDataset;

import domain.Account;
import domain.Userinfo;
import dao.UserInfoDAO;
import util.SafeCode;

public class UserController extends HttpServlet {

	UserInfoDAO udao = new UserInfoDAO();
	/**
	 * Constructor of the object.
	 */
	public UserController() {
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
		//loginOut(request,response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int flag=new Integer(request.getParameter("flag"));
		switch(flag){
		case 1:findByUserName(request, response);break;
		case 2:deleteUser(request,response);break;
		case 3:findAllUsers(request,response);break;
		case 4:addUser(request,response);break;
		case 5:login(request,response);break;
		case 6:loginOut(request,response);break;
		case 7:sameName(request,response);break;
		case 8:loginReport(request, response);break;
		}

		
	}
	public void sameName(HttpServletRequest request, HttpServletResponse response){
		try{
			UserInfoDAO udao = new UserInfoDAO();
			Userinfo u = new Userinfo();
			request.setCharacterEncoding("utf-8");
			String name = request.getParameter("name")==null ? "0"
					: request.getParameter("name").trim();
			u.setUsername(name);
			String msg = "";
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			if(udao.sameName(u)) {
				msg = "1";
			}else{
				msg = "0";
			}
			out.write(msg);
			out.flush(); //强制输出缓冲区数据
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void findByUserName(HttpServletRequest request, HttpServletResponse response){
		try{
			List<Userinfo> list = new ArrayList<Userinfo>();
			String keyword = new String(request.getParameter("keyword").getBytes("ISO8859-1"),"GBK");
			list = udao.findByUserName(keyword);
			request.setAttribute("list", list);
		    RequestDispatcher rd = request.getRequestDispatcher("SearchUserName.jsp");
		    rd.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public boolean deleteUser(HttpServletRequest request, HttpServletResponse response){
		try{
			
			int userId = Integer.parseInt(request.getParameter("id"));
			udao.deleteUser(userId);
			RequestDispatcher rd = request.getRequestDispatcher("user.do?flag=3");
			rd.forward(request, response);
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public void findAllUsers(HttpServletRequest request, HttpServletResponse response){
		try{
			String currPage = request.getParameter("currentePage");
			int currentePage = 1;
			
			if(currPage != null&&currPage != ""){
				currentePage = Integer.parseInt(currPage);
			}
			
			if(currentePage > udao.pageSize()){
				currentePage = udao.pageSize();
			}
			
			if(currentePage < 1){	
				currentePage = 1;
			}
			
			List<Userinfo> list = udao.findAllUsers(currentePage);
			request.setAttribute("list", list);
			request.setAttribute("currentePage", currentePage);
			request.setAttribute("pageinfo", udao.pageSize());
			
			RequestDispatcher rd = request.getRequestDispatcher("UserList.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void login(HttpServletRequest request, HttpServletResponse response){//�ɹ���¼�ķ���
		try{
			Userinfo u = new Userinfo();
			u.setUsername(new String(request.getParameter("name").getBytes("ISO8859-1"),"GBK"));
			u.setPassword(new String(request.getParameter("password").getBytes("ISO8859-1"),"GBK"));
			if(!request.getParameter("safecode").equals(request.getSession().getAttribute("rand"))){
				//request.setAttribute("errors", "��֤����� ");//�ж���֤��
				JOptionPane.showMessageDialog( 
						null,"��֤�����,�����µ�¼��");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
			}else{
				   UserInfoDAO a=new UserInfoDAO();
				   Userinfo user=a.login(u);
				   if(user!=null){//��¼�ɹ�
					   request.getSession().setAttribute("userinfo", user);
					   //response.sendRedirect("goods.do?flag=0");
					   JOptionPane.showMessageDialog( 
								null,"��¼�ɹ�,��ӭ����51�Ź���");
					  RequestDispatcher rd=request.getRequestDispatcher("goods.do?flag=0");
					  rd.forward(request, response);
					   //response.sendRedirect("index.jsp");

				   }else{
					   //request.setAttribute("errors", "�û�����������");
					   JOptionPane.showMessageDialog( 
								null,"�û�����������,�����µ�¼��");
					   RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
					   rd.forward(request, response);

				   }		
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
    public void loginOut(HttpServletRequest request,HttpServletResponse response){
    	try{
    		request.getSession().removeAttribute("userinfo");
    		response.sendRedirect("index.jsp");
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
	public void addUser(HttpServletRequest request,HttpServletResponse response){
		try{
			   Userinfo u = new Userinfo();
			   u.setPassword(new String(request.getParameter("password").getBytes("ISO8859-1"),"GBK"));
			   u.setUsername(new String(request.getParameter("name").getBytes("ISO8859-1"),"GBK"));
			   u.setTel(new String(request.getParameter("tel").getBytes("ISO8859-1"),"GBK"));
			   u.setSex( new Integer(request.getParameter("sex")));
			   u.setEmail(new String(request.getParameter("email").getBytes("ISO8859-1"),"GBK"));
			   u.setRealname(new String(request.getParameter("realname").getBytes("ISO8859-1"),"GBK"));
				if(!request.getParameter("safecode").equals(request.getSession().getAttribute("rand"))){
					//request.setAttribute("errors", "��֤����� ");//�ж���֤��
					JOptionPane.showMessageDialog( 
							null,"��֤�����,������ע�ᣡ");	 
				RequestDispatcher rd=request.getRequestDispatcher("regist.jsp");
				rd.forward(request, response);
				

				}else{
					
					   UserInfoDAO a=new UserInfoDAO();
					   if(a.sameName(u)){
						      JOptionPane.showMessageDialog( 
										null,"���û���Ҳ����,������ע�ᣡ");
						   RequestDispatcher rd=request.getRequestDispatcher("regist.jsp");
						   rd.forward(request, response);

					   }else{
					       a.addUser(u);//ע��
					       request.getSession().setAttribute("userinfo", u);
						   JOptionPane.showMessageDialog( 
									null,"ע��ɹ�����ӭ������");
 		                   RequestDispatcher rd=request.getRequestDispatcher("goods.do?flag=0");
						   rd.forward(request, response);
						  


					   }}		
				}catch(Exception e){
			e.printStackTrace();
		}
	}
    
	public void loginReport(HttpServletRequest request, HttpServletResponse response){
		try{
		List<Userinfo> list = new ArrayList<Userinfo>();
		list = udao.findAllUser();
		StandardChartTheme standardChartTheme=new StandardChartTheme("CN");         //设置标题字体         
    	standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));         //设置图例的字体        
    	standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));         //设置轴向的字体         
    	standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));         //应用主题样式         
    	ChartFactory.setChartTheme(standardChartTheme); 
    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    	 for(Userinfo user:list){
    			dataset.addValue(user.getTimes(), "a", user.getUsername());
    	 }
         JFreeChart chart=ChartFactory.createBarChart3D("用户登录次数统计图", "用户名", "登录次数", dataset, PlotOrientation.VERTICAL, true, true, true);
         CategoryPlot plot = chart.getCategoryPlot();
         BarRenderer3D renderer = new org.jfree.chart.renderer.category.BarRenderer3D();   
         renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
         renderer.setItemLabelFont(new Font("黑体", Font.BOLD, 20));// 12号黑体加粗   
         renderer.setItemLabelPaint(Color.black);// 字体为黑色   
         renderer.setItemLabelsVisible(true);   
         plot.setRenderer(renderer);// 使用我们设计的效果   
        /* ChartFrame  frame=new ChartFrame ("水果产量图 ",chart,true);
         frame.pack();
         frame.setVisible(true);*/
         
         OutputStream os = new FileOutputStream("G:/workplace/Shopping515/WebRoot/images/company.jpeg");//图片是文件格式的，故要用到FileOutputStream用来输出。
         ChartUtilities.writeChartAsJPEG(os, chart, 1000, 800);
         //使用一个面向application的工具类，将chart转换成JPEG格式的图片。第3个参数是宽度，第4个参数是高度。
         
         os.close();//关闭输出流
         request.getRequestDispatcher("admin/UserLoginReport.jsp").forward(request, response);

	}catch(Exception e){
		e.printStackTrace();
	}
	}
	public void init() throws ServletException {
		// Put your code here
	}

}
