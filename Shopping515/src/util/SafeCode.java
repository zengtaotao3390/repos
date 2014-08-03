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

		response.setContentType("image/jpeg");//������Ӧ��������
		response.setHeader("Pragma", "No-cache");//�����д���������ͬ
		response.setHeader("Cache-Control", "no-cache");//Cache-Controlָ���������Ӧ��ѭ�Ļ������,no-cacheָʾ�������Ӧ��Ϣ���ܻ���
		
		
		response.setDateHeader("Expires", 0);//Expiresʵ�屨ͷ�������Ӧ���ڵ����ں�ʱ��,0Ϊ��Ҫ����ҳ��
		 //HttpSession session = request.getSession();
		 
		int width=60;//ͼƬ���
		int height=20;//ͼƬ�߶�
		BufferedImage  image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);//����ͼƬ
		
		Graphics g=image.getGraphics();//�õ�ͼƬ����
		Random random=new Random();
		g.setColor(getRandColor(200,250));//�Զ�����ɫ
		g.fillRect(0, 0, width, height);//ʹ���Զ�����ɫ���ͼƬ����
		g.setFont(new Font("Arial",0,19));//����ͼƬ���ı�����
		//g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		g.setColor(getRandColor(160,200));//
		String sRand="";
		for(int i=0;i<4;i++){
			String rand=getRandChar(random.nextInt(36));
			sRand=sRand+rand;//�������ַ�ƴ�ӵ��漴�ַ�����
			g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));//�����ַ������ɫ
			g.drawString(rand, 13*i+6, 16);//���ı�����ͼ����
			
			
		}
		 //session.setAttribute("rand", sRand);
		request.getSession().setAttribute("rand", sRand);//������ַ�������session��
		g.dispose();//��ͼ�����ɶ���
		
        //ServletOutputStream responseOutputStream = response.getOutputStream();
        // ���ͼ��ҳ��
       //ImageIO.write(image, "JPEG", responseOutputStream);

        //���¹ر���������
        //responseOutputStream.flush();
        //responseOutputStream.close();

		
		javax.servlet.ServletOutputStream imageOut=response.getOutputStream();
		
		JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(imageOut);
		encoder.encode(image);//��ͼƬ������Ӧ��
		
		
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