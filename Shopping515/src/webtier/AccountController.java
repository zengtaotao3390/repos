package webtier;

import java.awt.Color;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import org.jfree.chart.axis.AxisSpace;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.servlet.ServletUtilities;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;

import util.CodeCreator;

import dao.AccountDAO;
import dao.AccountgoodsDAO;
import dao.GoodsDAO;
import dao.ShoppingcartDAO;
import domain.Account;
import domain.Accountgoods;
import domain.Goods;
import domain.Shoppingcard;
import domain.Userinfo;

public class AccountController extends HttpServlet {

	private AccountDAO adao=new AccountDAO();
	private AccountgoodsDAO agdao=new AccountgoodsDAO();
	private GoodsDAO gdao = new GoodsDAO(); 
	public AccountController() {
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
        int flag=Integer.parseInt(request.getParameter("flag"));
        switch(flag){
        case 0:getAccount(request,response);break;
        case 1:saveAccount(request,response);break;
        case 2:findAllAccount(request,response);break;
        case 3:changeExecute(request,response);break;
        case 4:deleteAccount(request,response);break;
        case 5:findDetailAccount(request,response);break;
        case 6:findSingleAccount(request,response);break;
        case 7:changeExecuteBusiness(request,response);break;
        case 8:accountReport(request, response);break;
        }
		
	}

	
	public void init() throws ServletException {
		// Put your code here
	}
	public void getAccount(HttpServletRequest request,HttpServletResponse response){
		try{
			Userinfo user=(Userinfo)request.getSession().getAttribute("userinfo");
			request.setAttribute("accountcode", new CodeCreator().createAccountcode(user.getId()));
			RequestDispatcher rd=request.getRequestDispatcher("account.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void saveAccount(HttpServletRequest request,HttpServletResponse response){
		try{
			//List<Shoppingcard> list=(List<Shoppingcard>)request.getSession().getAttribute("allCartGoods");
			Shoppingcard sc = (Shoppingcard)request.getSession().getAttribute("sc");
			Userinfo user=(Userinfo)request.getSession().getAttribute("userinfo");
			if(user==null){
				 JOptionPane.showMessageDialog( 
							null,"�㻹û�е�¼������е�¼��");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				return;
			}
			String accountcode = new CodeCreator().createAccountcode(user.getId());
			//String accountcode=new String(request.getParameter("accountcode").getBytes("ISO8859-1"),"GBK");
			String tel=new String(request.getParameter("tel").getBytes("ISO8859-1"),"GBK");
			
			String email=new String(request.getParameter("email").getBytes("ISO8859-1"),"GBK");
		    Account a=new Account();
		    
		    a.setUserid(user.getId());
		    
		    a.setAccountcode(accountcode);
		    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH-mm");
		    String d=sdf.format(new Date()).toString();
		    a.setAccountdate(new Date());
		    a.setTel(tel);
		    a.setExecute(0);
		    a.setEmail(email);
		    a.setGoodsId(sc.getGoodsId());
		    a.setNum(sc.getNumber());
		    if(adao.save(a)){
		    	    Goods goods =gdao.findById(sc.getGoodsId());
		    		Accountgoods ag=new Accountgoods();
		    		ag.setGoodsId(sc.getGoodsId());
		    		ag.setNum(sc.getNumber());
		    		ag.setAccountcode(a.getAccountcode());
		    		if(!agdao.save(ag)){
		    			JOptionPane.showMessageDialog(null, "����Ʒ��"+ sc.getGoodsName()+" �¶�������");
		    			RequestDispatcher rd=request.getRequestDispatcher("cart.do?flag=0");
		    			rd.forward(request, response);
		    		}
		    	
		    	//scdao.deleteAllCart(user.getId());
		    	//request.getSession().removeAttribute("userinfo");
		    	RequestDispatcher rd=request.getRequestDispatcher("account.do?flag=2");
		    	rd.forward(request, response);
		    	
		    }else{
		    	JOptionPane.showMessageDialog(null, "�¶�������");
		    	RequestDispatcher rd=request.getRequestDispatcher("cart.do?flag=0");
    			rd.forward(request, response);
		    }
		
		
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void findAllAccount(HttpServletRequest request,HttpServletResponse response){
		try{
			Userinfo user=(Userinfo)request.getSession().getAttribute("userinfo");
			if(user==null){
				 JOptionPane.showMessageDialog( 
							null,"�㻹û�е�¼������е�¼��");
				RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				return;
			}
			int userId=user.getId();
			String currpage=request.getParameter("currentePage");
			int currentePage=1;
			if(currpage!=null){
				currentePage=Integer.parseInt(currpage);
			}
			if(currentePage>adao.pageSize(userId)){
				currentePage=adao.pageSize(userId);
			}
			
			if(currentePage<1){
				currentePage=1;
			}
			
			List<Account> allAccounts=adao.findByUserId(userId,currentePage);
			
			request.setAttribute("currentePage", currentePage);
			request.setAttribute("pageinfo", adao.pageSize(userId));
			request.getSession().setAttribute("allAccounts", allAccounts);
			RequestDispatcher rd=request.getRequestDispatcher("myAccounts.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void changeExecute(HttpServletRequest request,HttpServletResponse response){
		try{
			int accountId = Integer.parseInt(request.getParameter("id"));
	        boolean changeExecute = adao.changeExecute(accountId);
	        Account account = adao.findById(accountId);
	        Goods goods = gdao.findById(account.getGoodsId());
	        Shoppingcard sc = (Shoppingcard)request.getSession().getAttribute("sc");
	        if(changeExecute){
	        gdao.changeNum(goods, sc);
			RequestDispatcher rd=request.getRequestDispatcher("accountOver.jsp");
			rd.forward(request, response);
	        }else{
	        	JOptionPane.showMessageDialog(null, "������?�����¸��");
	        	RequestDispatcher rd=request.getRequestDispatcher("account.do?flag=2");
				rd.forward(request, response);
	        }
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void deleteAccount(HttpServletRequest request,HttpServletResponse response){
		try{
			adao.deleteAccount(Integer.parseInt(request.getParameter("id")));
			RequestDispatcher rd=request.getRequestDispatcher("account.do?flag=2");
			rd.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void findDetailAccount(HttpServletRequest request,HttpServletResponse response){
		try{
			int accountId = Integer.parseInt(request.getParameter("id"));
			Account account = adao.findById(accountId);
			
			Goods goods = gdao.findById(account.getGoodsId());
			request.setAttribute("account", account);
			request.setAttribute("goods", goods);
			
			RequestDispatcher rd = request.getRequestDispatcher("accountDetail.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void findSingleAccount(HttpServletRequest request,HttpServletResponse response){
		try{
			String accountcode = new String(request.getParameter("accountcode"));
			
			Account account = adao.findByAccountcode(accountcode);
			
			Goods goods = gdao.findById(account.getGoodsId());
			request.setAttribute("account", account);
			request.setAttribute("goods", goods);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("business.jsp");
			rd.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void changeExecuteBusiness(HttpServletRequest request,HttpServletResponse response){
		try{
			
	        adao.changeExecuteBusiness(Integer.parseInt(request.getParameter("id")));
	       JOptionPane.showMessageDialog(null, "ʹ�óɹ���");
			RequestDispatcher rd=request.getRequestDispatcher("paymentOver.jsp");
			rd.forward(request, response);
	       
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void accountReport(HttpServletRequest request, HttpServletResponse response){
		try{
			List<Account> list2013 = new ArrayList<Account>();
			list2013 = adao.findAllAccount("2013");
			int one3 = 0 ,two3 = 0 ,three3 = 0 ,four3 = 0, five3 = 0, sex3 = 0, seven3 = 0, eight3 = 0, nine3 = 0, ten3 = 0, eleven3 = 0, twive3 = 0;//2013年的月份
			for(Account a: list2013){
				int i = a.getAccountdate().getMonth();
				
				switch(i){
				case 0: one3++; break;
				case 1: two3++; break;
				case 2: three3++; break;
				case 3: four3++; break;
				case 4: five3++; break;
				case 5: sex3++; break;
				case 6: seven3++; break;
				case 7: eight3++; break;
				case 8: nine3++; break;
				case 9: ten3++; break;
				case 10: eleven3++; break;
				case 11: twive3++; break;
				}
			}
			List<Account> list2014 = new ArrayList<Account>();
			list2014 = adao.findAllAccount("2014");
			int one4 = 0 ,two4 = 0 ,three4 = 0 ,four4 = 0, five4 = 0, sex4 = 0, seven4 = 0, eight4 = 0, nine4 = 0, ten4 = 0, eleven4 = 0, twive4 = 0;//2014年的月份
			for(Account a: list2014){
				int i = a.getAccountdate().getMonth();
				
				switch(i){
				case 0: one4++; break;
				case 1: two4++; break;
				case 2: three4++; break;
				case 3: four4++; break;
				case 4: five4++; break;
				case 5: sex4++; break;
				case 6: seven4++; break;
				case 7: eight4++; break;
				case 8: nine4++; break;
				case 9: ten4++; break;
				case 10: eleven4++; break;
				case 11: twive4++; break;
				}
			}
			StandardChartTheme standardChartTheme=new StandardChartTheme("CN");         //设置标题字体         
			standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));         //设置图例的字体        
			standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));         //设置轴向的字体         
			standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));         //应用主题样式         
			ChartFactory.setChartTheme(standardChartTheme); 
			
		TimeSeries timeSeries = new TimeSeries("订单量", Month.class);
		

		// 时间曲线数据集合

		TimeSeriesCollection lineDataset = new TimeSeriesCollection();

		// 构造数据集合

		timeSeries.add(new Month(1, 2013), one3);

		timeSeries.add(new Month(2, 2013), two3);
		
		timeSeries.add(new Month(3, 2013), three3);

		timeSeries.add(new Month(4, 2013), four3);

		timeSeries.add(new Month(5, 2013), five3);

		timeSeries.add(new Month(6, 2013), sex3);

		timeSeries.add(new Month(7, 2013), seven3);

		timeSeries.add(new Month(8, 2013), eight3);

		timeSeries.add(new Month(9, 2013), nine3);

		timeSeries.add(new Month(10, 2013), ten3);

		timeSeries.add(new Month(11, 2013), eleven3);

		timeSeries.add(new Month(12, 2013), twive3);
		
		timeSeries.add(new Month(1, 2014), one4);

		timeSeries.add(new Month(2, 2014), two4);
		
		timeSeries.add(new Month(3, 2014), three4);

		timeSeries.add(new Month(4, 2014), four4);

		timeSeries.add(new Month(5, 2014), five4);

		timeSeries.add(new Month(6, 2014), sex4);

		timeSeries.add(new Month(7, 2014), seven4);

		timeSeries.add(new Month(8, 2014), eight4);

		timeSeries.add(new Month(9, 2014), nine4);

		timeSeries.add(new Month(10, 2014), ten4);

		timeSeries.add(new Month(11, 2014), eleven4);

		timeSeries.add(new Month(12, 2014), twive4);
		
		
		lineDataset.addSeries(timeSeries);

		JFreeChart chart = ChartFactory.createTimeSeriesChart("", "date", "订单量", lineDataset, true, true, true);

		//增加标题

		chart.setTitle(new TextTitle("订单统计", new Font("隶书", Font.ITALIC, 15)));

		chart.setAntiAlias(true);

		XYPlot plot = (XYPlot) chart.getPlot();

		plot.setAxisOffset(new RectangleInsets(10,10,10,10));//图片区与坐标轴的距离

		plot.setOutlinePaint(Color.PINK);

		plot.setInsets(new RectangleInsets(15,15,15,15));//坐标轴与最外延的距离

		// plot.setOrientation(PlotOrientation.HORIZONTAL);//图形的方向，包括坐标轴。

		AxisSpace as = new AxisSpace();

		as.setLeft(25);

		as.setRight(25);

		plot.setFixedRangeAxisSpace(as);

		chart.setPadding(new RectangleInsets(5,5,5,5));

		chart.setNotify(true);

		// 设置曲线是否显示数据点

		XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer)plot.getRenderer();

		xylineandshaperenderer.setBaseShapesVisible(true);

		// 设置曲线显示各数据点的值

		XYItemRenderer xyitem = plot.getRenderer();

		xyitem.setBaseItemLabelsVisible(true);

		xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.INSIDE10, TextAnchor.BASELINE_LEFT));

		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());

		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 14));

		plot.setRenderer(xyitem);
		 //ServletUtilities是面向web开发的工具类，返回一个字符串文件名,文件名自动生成，生成好的图片会自动放在服务器（tomcat）的临时文件下（temp
		 String filename = ServletUtilities.saveChartAsPNG(chart, 700, 400, null, request.getSession());

		 String url = request.getContextPath() + "/DisplayChart?filename=" + filename;
		    //根据文件名去临时目录下寻找该图片，这里的/DisplayChart路径要与配置文件里用户自定义的<url-pattern>一致
		 request.setAttribute("url", url);
		request.getRequestDispatcher("admin/accountReport.jsp").forward(request, response);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
}
