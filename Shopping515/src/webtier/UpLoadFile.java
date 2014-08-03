package webtier;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UpLoadFile extends HttpServlet {
	private GoodsDAO  gdao = new GoodsDAO();
	/**
	 * Constructor of the object.
	 */
	public UpLoadFile() {
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
		int flag = Integer.parseInt(request.getParameter("flag"));
		
		switch(flag){
		case 0:uploadFile(request, response); break;
		
		}
		
	}
	public void uploadFile(HttpServletRequest request, HttpServletResponse response){
		 PrintWriter out = null;
		 //得到当前商品的id
		 int id = Integer.parseInt(request.getParameter("goodsId"));
		  response.setCharacterEncoding("UTF-8");
		  //实例化文件工厂
		        FileItemFactory factory = new DiskFileItemFactory();
		        //配置上传组件ServletFileUpload  
		        ServletFileUpload upload = new ServletFileUpload(factory);  
		        //解决头文件中文乱码问题
		        upload.setHeaderEncoding("utf-8");
		        try {
		         out = response.getWriter();
		           //从request得到所有上传域的列表   
		            List<FileItem> list = upload.parseRequest(request); 
		            
		            for (FileItem item : list) {
		             //isFormField判断一个item类对象封装的是一个普通的表单字段还是文件表单字段。
		              // 如果item不是文件域，则做出如下处理：（文本域）
		                if (!item.isFormField()) {
		                 
		                    //上传文件域的Name 因为用的是ie所以是全路径 如果是firefox 或者 chrome则是文件名
		                    String fileName = item.getName();
		                    //截取本地文件名
		                    int localIndex = fileName.lastIndexOf("\\") + 1;
		                    //System.out.println(fileName);
		                    //System.out.println(localIndex);
		                    
		                    String localName = fileName.substring(localIndex);
		                    // System.out.println(local);
		                    //截取扩展名
		                    //int idx = fileName.lastIndexOf(".");   
		                    //String extension = fileName.substring(idx);  
		                    
		                    //获取文件名
		                    //String name = new Date().getTime() + extension;
		                    
		                    //得到文件夹的物理路径
		                    String path = this.getServletContext().getRealPath("\\pic");   
		                    
		                   //创建一个File
		                    

		                    File file = new File(path + "\\" + localName); 
		                    FileOutputStream o = new FileOutputStream(file);
		                    InputStream in = item.getInputStream();
		                    //封装好的，可以直接用于写入文件
		                    //item.write(file);
		                   try {   
		                    	
		                     byte b[] = new byte[1024];
		                        int n;
		                        while ((n = in.read(b)) != -1) {
		                            o.write(b, 0, n);
		                        }
		                        String dataName = "pic/" + localName;
		                        if(gdao.updatePic(dataName, id)){
		                        JOptionPane.showMessageDialog(null, "上传成功！");
		                       // request.getRequestDispatcher("goods.do?flag=4").forward(request, response);
		                        }
		                    } catch (Exception e) {   
		                        e.printStackTrace();   
		                    }finally{
		                    	o.close();
		                    	in.close();
//		                     LoadProcessServlet.isEnd = true;
		                    }
		                }   
		            }
		        } catch (Exception e) {   
		            e.printStackTrace();   
		        } 
		        
		        
		        
	}
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
