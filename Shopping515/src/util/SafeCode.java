package util;

import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class SafeCode extends HttpServlet {

	private static final String CHARARRAY[] = {"0", "1", "2", "3", "4", "5",
		"6", "7", "8","9","a", "b", "c", "d", "e", "f", "g", "h", "i", 
		"j", "k", "l", "m", "n", "o", "p","q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

	private String getRandChar(int randNumber){

		return CHARARRAY[randNumber];
	}
	private Color getRandColor(int fc,int bc){
		Random random = new Random();
		if(fc > 255)
			fc = 255;
		if(bc > 255)
			bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);}
		
	

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	 public void doPost(HttpServletRequest request,
             HttpServletResponse response) throws
ServletException, IOException {

		response.setContentType("image/jpeg");//设置响应内容类型
		response.setHeader("Pragma", "No-cache");//和上行代码作用相同
		response.setHeader("Cache-Control", "no-cache");//Cache-Control指定请求和响应遵循的缓存机制,no-cache指示请求或响应消息不能缓存
		
		
		response.setDateHeader("Expires", 0);//Expires实体报头域给出响应过期的日期和时间,0为不要缓存页面
		 //HttpSession session = request.getSession();
		 
		int width=60;//图片宽度
		int height=20;//图片高度
		BufferedImage  image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);//定义图片
		
		Graphics g=image.getGraphics();//得到图片背景
		Random random=new Random();
		g.setColor(getRandColor(200,250));//自定义颜色
		g.fillRect(0, 0, width, height);//使用自定义颜色填充图片背景
		g.setFont(new Font("Arial",0,19));//设置图片中文本字体
		//g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		g.setColor(getRandColor(160,200));//
		String sRand="";
		for(int i=0;i<4;i++){
			String rand=getRandChar(random.nextInt(36));
			sRand=sRand+rand;//将所得字符拼接到随即字符串中
			g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));//设置字符随机颜色
			g.drawString(rand, 13*i+6, 16);//将文本放入图像中
			
			
		}
		 //session.setAttribute("rand", sRand);
		request.getSession().setAttribute("rand", sRand);//将随机字符串放入session中
		g.dispose();//将图像做成对象
		
        //ServletOutputStream responseOutputStream = response.getOutputStream();
        // 输出图象到页面
       //ImageIO.write(image, "JPEG", responseOutputStream);

        //以下关闭输入流！
        //responseOutputStream.flush();
        //responseOutputStream.close();

		
		javax.servlet.ServletOutputStream imageOut=response.getOutputStream();
		
		JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(imageOut);
		encoder.encode(image);//将图片放入响应中
		
		
	}

	  public void doGet(HttpServletRequest request,
               HttpServletResponse response) throws ServletException,
  IOException {
		 
		  this.doPost(request, response);
}

/** Handles the HTTP <code>POST</code> method.
* @param request servlet request
* @param response servlet response
*/



	
	public void init() throws ServletException {
		// Put your code here
	}

}