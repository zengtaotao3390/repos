package webtier;

import java.awt.Color;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.DefaultCategoryDataset;

import dao.GoodsDAO;
import dao.ShoppingcartDAO;

import domain.Goods;
import domain.Shoppingcard;

import domain.Userinfo;

public class GoodsController extends HttpServlet {

	private GoodsDAO gdao=new GoodsDAO();
	private int price = 0;         //判断价格是升序还是降序  %2判断
	private int discount = 0;       //判断折扣是升序还是降序  %2判断
	private int num = 0;            //判断购买人数是升序还是降序  %2判断
	
	private ShoppingcartDAO scdao=new ShoppingcartDAO();
	public GoodsController() {
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
		case 0:findAllGoods(request, response);break;
		case 1:add(request, response);break;
		case 2:findById(request, response);break;
		case 3:findSearchGoods(request, response);break;
		case 4:adminFindAllGoods(request, response);break;
		case 5:adminDeleteGoods(request, response);break;
		case 6:adminAddGoods(request, response);break;
		case 7:findByIdToModify(request, response);break;
		case 8:goodsModify(request, response);break;
		case 9:findByField(request, response);break;
		case 10:pageOrderProduct(request, response);break;
		case 11:simpleSearch(request, response); break;
		case 12:complexSearch(request, response);break;
		case 13:goodsSellReport(request, response);break;
		}
	}


	public void init() throws ServletException {
		// Put your code here
	}

	public void findAllGoods(HttpServletRequest request,HttpServletResponse response){
		try{
			request.setAttribute("pageinfo", gdao.pageSize());
			String currpage=request.getParameter("currentePage");
			int currentePage=1;
			if(currpage!=null&&currpage!=""){
				currentePage=Integer.parseInt(currpage);
			}
			if(currentePage>gdao.pageSize()){
				currentePage=gdao.pageSize();
			}
			if(currentePage<1){
				currentePage=1;
			}
			
			List<Goods> list=new ArrayList<Goods>();
			list=gdao.findAllGoods(currentePage);
			//System.out.print(list.size());
			request.setAttribute("currentePage", currentePage);
			request.setAttribute("findAll", list);
			
			RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");
			rd.forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	public void add(HttpServletRequest request,HttpServletResponse response){
		try {
			Userinfo user=(Userinfo)request.getSession().getAttribute("userinfo");
			if(user == null){
				 JOptionPane.showMessageDialog( 
							null,"�㻹û�е�¼������е�¼��");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				return;
			}
			   int goodsId=Integer.parseInt(request.getParameter("goodsId"));
			   int userId=user.getId();
			   //Goods goods=scdao.finById("goodsId");
				   Goods goods=gdao.findById(goodsId);
				   Shoppingcard sc=new Shoppingcard();
				  
				   sc.setGoodsName(goods.getGoodsname());
				   sc.setPrice(goods.getPrice());
				   sc.setGoodsId(goodsId);
				   sc.setNumber(1);
				   sc.setDiscount(goods.getDiscount());
				   sc.setUserId(user.getId());
				   request.getSession().setAttribute("sc",sc);
				   RequestDispatcher rd=request.getRequestDispatcher("selectSC.jsp");
					
						rd.forward(request, response);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	
	}
	
	public void findById(HttpServletRequest request,HttpServletResponse response){
		try{
			int id = Integer.parseInt(request.getParameter("goodsId"));
			Goods goods = gdao.findById(id);
			request.setAttribute("goods", goods);
			RequestDispatcher rd = request.getRequestDispatcher("goodsDetails.jsp");
			rd.forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void findSearchGoods(HttpServletRequest request, HttpServletResponse response){
		try{
			String keyword = new String(request.getParameter("keyword").getBytes("ISO8859-1"), "GBK");
			request.setAttribute("pageinfo", gdao.pageSearchSize(keyword));
			String currpage=request.getParameter("currentePage");
			
			int currentePage=1;
			if(currpage!=null&&currpage!=""){
				currentePage=Integer.parseInt(currpage);
			}
			if(currentePage>gdao.pageSearchSize(keyword)){
				currentePage=gdao.pageSearchSize(keyword);
			}
			if(currentePage<1){
				currentePage=1;
			}
			
			List<Goods> list=new ArrayList<Goods>();
			list=gdao.findAllSearchGoods(currentePage, keyword);
			//System.out.print(list.size());
			
			request.setAttribute("currentePage", currentePage);
			request.setAttribute("findSearchAll", list);
			request.setAttribute("keyword", keyword);
			
			RequestDispatcher rd=request.getRequestDispatcher("goodsSearchResult.jsp");
			rd.forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void adminFindAllGoods(HttpServletRequest request, HttpServletResponse response){
		try{
			
			request.setAttribute("pageinfo", gdao.pageSize());
			String currpage = request.getParameter("currentePage");
			int currentePage = 1;
			if(currpage != null && currpage !=""){
				currentePage = Integer.parseInt(currpage);
			}
			if(currentePage > gdao.pageSize()){
				currentePage = gdao.pageSize();
			}
			if(currentePage < 1){
				currentePage = 1;
			}
			List<Goods> list = new ArrayList<Goods>();
			list = gdao.findAllGoods(currentePage);
			request.setAttribute("currentePage", currentePage);
			request.setAttribute("findAll", list);
			request.getRequestDispatcher("admin/ProductList.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void adminDeleteGoods(HttpServletRequest request, HttpServletResponse response){
		try{
			int id = Integer.parseInt(request.getParameter("id"));
			gdao.adminDeleteGoods(id);
			//request.getRequestDispatcher("goods.do?flag=4").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void adminAddGoods(HttpServletRequest request, HttpServletResponse response){
		Goods g = new Goods();
		try {
			g.setGoodsname(new String(request.getParameter("goodsName").getBytes("ISO8859-1"),"UTF-8"));
			g.setPrice(Float.parseFloat(request.getParameter("goodsPrice")));
			g.setDiscount(Float.parseFloat(request.getParameter("goodsDiscount")));
			g.setIntroduction(new String(request.getParameter("goodsIntroduction").getBytes("ISO8859-1"),"UTF-8"));
			gdao.adminAddGoods(g);
	} catch (UnsupportedEncodingException e) {
	
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	public void findByIdToModify(HttpServletRequest request,HttpServletResponse response){
		try{
			int id = Integer.parseInt(request.getParameter("id"));
			Goods goods = gdao.findById(id);
			request.setAttribute("goods", goods);
			RequestDispatcher rd = request.getRequestDispatcher("admin/ProductModify.jsp");
			rd.forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void goodsModify(HttpServletRequest request, HttpServletResponse response){
		Goods g = new Goods();
		try {
			g.setId(Integer.parseInt(request.getParameter("goodsId")));
			g.setGoodsname(new String(request.getParameter("goodsName").getBytes("ISO8859-1"),"UTF-8"));
			g.setPrice(Float.parseFloat(request.getParameter("goodsPrice")));
			g.setDiscount(Float.parseFloat(request.getParameter("goodsDiscount")));
			g.setIntroduction(new String(request.getParameter("goodsIntroduction").getBytes("ISO8859-1"),"UTF-8"));
			gdao.goodsModify(g);
			
	} catch (UnsupportedEncodingException e) {
	
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void findByField(HttpServletRequest request, HttpServletResponse response){
try{
			
			request.setAttribute("pageinfo", gdao.pageSize());
			String currpage = request.getParameter("currentePage");
			//记录按排序的字段
			String field = request.getParameter("field");
			
			int currentePage = 1;
			//分页，计算当前页面
			/*if(currpage != null && currpage !=""){
				currentePage = Integer.parseInt(currpage);
			}
			if(currentePage > gdao.pageSize()){
				currentePage = gdao.pageSize();
			}
			if(currentePage < 1){
				currentePage = 1;
			}*/
			List<Goods> list = new ArrayList<Goods>();
			//判断按价格排序
			if(field.equals("price")){
				price++;
				if(price % 2 == 1){
					list = gdao.findAllGoods(currentePage, "asc", field );
				}else{
					list = gdao.findAllGoods(currentePage, "desc", field);
				}
			}
			//判断按折扣排序
			if(field.equals("discount")){
				discount++;
				if(discount % 2 == 1){
					list = gdao.findAllGoods(currentePage, "asc", field );
				}else{
					list = gdao.findAllGoods(currentePage, "desc", field);
				}
			}
			//判断按人数排序
			if(field.equals("num")){
				num++;
				if(num % 2 == 1){
					list = gdao.findAllGoods(currentePage, "asc", field );
				}else{
					list = gdao.findAllGoods(currentePage, "desc", field);
				}
			}
			request.getSession().setAttribute("field", field);
			request.setAttribute("currentePage", currentePage);
			request.setAttribute("findAll", list);
			request.getRequestDispatcher("admin/OrderProductList.jsp").forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void pageOrderProduct(HttpServletRequest request, HttpServletResponse response){
		try{
		request.setAttribute("pageinfo", gdao.pageSize());
		String currpage = request.getParameter("currentePage");
		//记录按排序的字段
		String field = (String)request.getSession().getAttribute("field");
		
		int currentePage = 1;
		
		if(currpage != null && currpage !=""){
			currentePage = Integer.parseInt(currpage);
		}
		if(currentePage > gdao.pageSize()){
			currentePage = gdao.pageSize();
		}
		if(currentePage < 1){
			currentePage = 1;
		}
		List<Goods> list = new ArrayList<Goods>();
		//判断按价格排序
		if(field.equals("price")){
			if(price % 2 == 1){
				list = gdao.findAllGoods(currentePage, "asc", field );
			}else{
				list = gdao.findAllGoods(currentePage, "desc", field);
			}
		}
		//判断按折扣排序
		if(field.equals("discount")){
			if(discount % 2 == 1){
				list = gdao.findAllGoods(currentePage, "asc", field );
			}else{
				list = gdao.findAllGoods(currentePage, "desc", field);
			}
		}
		//判断按人数排序
		if(field.equals("num")){
			if(num % 2 == 1){
				list = gdao.findAllGoods(currentePage, "asc", field );
			}else{
				list = gdao.findAllGoods(currentePage, "desc", field);
			}
		}
		request.getSession().setAttribute("field", field);
		request.setAttribute("currentePage", currentePage);
		request.setAttribute("findAll", list);
		request.getRequestDispatcher("admin/OrderProductList.jsp").forward(request, response);
	}catch(Exception e){
	
		e.printStackTrace();
	}
}
	
	public void simpleSearch(HttpServletRequest request, HttpServletResponse response){
		try{
			String keyword = new String(request.getParameter("keyword").getBytes("ISO8859-1"),"UTF-8");
			List<Goods> list = new ArrayList<Goods>();
			list = gdao.simpleSearch(keyword);
			request.setAttribute("findAll", list);
			request.getRequestDispatcher("admin/SimpleSearchProduct.jsp").forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void complexSearch(HttpServletRequest request, HttpServletResponse response){
		try{
			String goodsname = new String(request.getParameter("goodsname").getBytes("ISO8859-1"), "UTF-8");
			float lowPrice = Float.parseFloat(request.getParameter("lowPrice"));
			float highPrice = Float.parseFloat(request.getParameter("highPrice"));
			float lowDiscount = Float.parseFloat(request.getParameter("lowDiscount"));
			float highDiscount = Float.parseFloat(request.getParameter("highDiscount"));
			//String GoodsIntroduction = new String(request.getParameter("goodsIntroduction").getBytes("ISO8859-1"), "UTF-8");
			List<Goods> list = new ArrayList<Goods>();
			list = gdao.complexSearch(goodsname, lowPrice, highPrice, lowDiscount, highDiscount);
			request.setAttribute("findAll", list);
			request.getRequestDispatcher("admin/SimpleSearchProduct.jsp").forward(request, response);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void goodsSellReport(HttpServletRequest request, HttpServletResponse response){
		try{
			List<Goods> list = new ArrayList<Goods>();
			list = gdao.findAllGoods();
			StandardChartTheme standardChartTheme=new StandardChartTheme("CN");         //设置标题字体         
	    	standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));         //设置图例的字体        
	    	standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));         //设置轴向的字体         
	    	standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));         //应用主题样式         
	    	ChartFactory.setChartTheme(standardChartTheme); 
	    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    	 for(Goods g:list){
	    			dataset.addValue(g.getNum(), "a", g.getGoodsname());
	    	 }
	         JFreeChart chart=ChartFactory.createBarChart3D("商品销量统计", "商品名", "销售量", dataset, PlotOrientation.HORIZONTAL, true, true, true);
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
	         
	         OutputStream os = new FileOutputStream("G:/workplace/Shopping515/WebRoot/images/goodsReport.jpeg");//图片是文件格式的，故要用到FileOutputStream用来输出。
	         ChartUtilities.writeChartAsJPEG(os, chart, 1000, 800);
	         //使用一个面向application的工具类，将chart转换成JPEG格式的图片。第3个参数是宽度，第4个参数是高度。
	         
	         os.close();//关闭输出流
	         request.getRequestDispatcher("admin/goodsReport.jsp").forward(request, response);

		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
}