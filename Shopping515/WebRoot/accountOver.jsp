<%@ page language="java" import="java.util.*" pageEncoding="GBK" import="domain.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>51�Ź�</title>
<style type="text/css">
<!--
#fonts{FILTER:  alpha(opacity=100,finishiopacity=0,style=1) 
     shadow(color=#FFE4E1,direction=135)}
img{float:top}
.STYLE2 {color: #333333}
BODY {
	BACKGROUND: #efe8e8; FONT-SIZE: 12px
}

.bh {
	PADDING-BOTTOM: 0px; LINE-HEIGHT: 0; TEXT-INDENT: -999px; MARGIN: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; DISPLAY: block; FONT-SIZE: 0px; OVERFLOW: hidden; PADDING-TOP: 0px
}
H2 {
	PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-LEFT: 0px; PADDING-RIGHT: 0px; PADDING-TOP: 0px
}
.STYLE6 {
	font-size: 14px;
	font-weight: bold;
	font-family: Arial, Helvetica, sans-serif;
	color: #FFFFFF;
}
.STYLE4 {color: #D66811 }
.STYLE8 {font-size: 18px}
.STYLE11 {color: #666666}
.STYLE13 {
	font-size: 14;
	color: #333333;
}
.STYLE14 {
	font-size: 16px;
	font-weight: bold;
	color: #000000;
}
.STYLE16 {color: #333333; font-size: 16px;}
.STYLE17 {
	font-size: 16px;
	font-weight: bold;
}
.STYLE18 {
	font-size: 14px;
	color: #333333;
}
.STYLE22 {
	font-size: 14px;
	color: #666666;
}
-->
</style>


</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0" >
  <tr>
    <td width="15%" >&nbsp;</td>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="5">
  <tr class="STYLE2">
  
   <%
  Userinfo user=(Userinfo)request.getSession().getAttribute("userinfo");
    
   %>
    <td colspan="2"><span class="STYLE2">��ӭ����51�Ź�����
  <%if(user!=null){
     out.print(user.getUsername());%><a href="user.do?flag=6">�˳�</a>
     <% 
  }else{ %>  
    �� <a href="login.jsp">����¼��</a> | <a href="regist.jsp">��ע�᡿</a> <%} %></span></td>
    
    
    <td width="52%"><span class="STYLE2"><a href=account.do?flag=2>�ҵĶ��� </a>  |  �ҵ�51��  |  �����Ź�  |  �ֻ�������  |  �ʼ�����  |  �ղر�վ</span></td>
  </tr>
  <tr>
    <td width="27%" height="87">&nbsp;</td>
    <td width="21%"" align="center" ></td>
    <td></td>
  </tr>
</table></td>
    <td width="15%">&nbsp;</td>
  </tr>
  <tr bgcolor="#D66811">
    <td width="" height="52" ></td>
    <td class="STYLE6"><h4><span class="STYLE8"><a href="index.jsp">51������ҳ</a></span> <span class="STYLE4">|</span><span class="STYLE8"> �Ź���ѡ</span><span class="STYLE4">|</span> <span class="STYLE8">��ʳ</span><span class="STYLE4">|</span><span class="STYLE8"> ����</span></h4></td>
    <td width=""></td>
  </tr>
  <tr>
    <td height="126">&nbsp;</td>
    <td><table width="100%" border="0" cellspacing="5">
      <tr>
        <td><iframe src="pic/flv.html" scrolling="no" marginwidth="0" framespacing="0" marginheight="0" frameborder="0" width="100%" style="width: 1054px;height:100px;border: none;margin-top:0px;margin-left:0px;border:0px;"></iframe></td>
      </tr>
      <tr>
        <td><table width="100%" border="1" cellspacing="0" cellpadding="10">
          <tr>
            <td> <span class="STYLE11">���� | ��� ���� ����</span></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="10" cellpadding="0">
            
            
            <tr class="STYLE16">
	   <td colspan="4" align="center">
	    <div align="center">����ɹ�</div>
	    <span id="time" style="background:red">5</span>���Ӻ��Զ���ת���������ת��������������
    <script type="text/javascript">
      function delayURL(url){
    
     var delay = document.getElementById("time").innerHTML;
     
     if(delay > 0){
        delay--;
        document.getElementById("time").innerHTML = delay; 
     }else{
        window.top.location.href = url;
     
       }
     setTimeout("delayURL('" + url + "')", 1000);
    }
 
      </script>   
   <script type="text/javascript">
   delayURL("account.do?flag=2");
   </script>
    <div align="center"><a href="account.do?flag=2"> �����ҵĶ���</a></div>
	  
	  </td>
	  </tr>
            
            </table></td>
            <td valign="top"><table width="100%" border="1" cellspacing="0" cellpadding="5">
  
</table>
</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
    <td >&nbsp;</td>
  </tr>
  <tr>
    <td height="195">&nbsp;</td>
    <td> <div align="center" class="STYLE22">2014-�� 51tuan.com ��ICP֤100702�� ������������110108000829�� Ӫҵִ��</div></td>
    <td>&nbsp;</td>
  </tr>
</table>
</body>
</html>
