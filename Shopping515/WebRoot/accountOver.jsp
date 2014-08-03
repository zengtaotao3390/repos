<%@ page language="java" import="java.util.*" pageEncoding="GBK" import="domain.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>51团购</title>
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
    <td colspan="2"><span class="STYLE2">欢迎来到51团购网！
  <%if(user!=null){
     out.print(user.getUsername());%><a href="user.do?flag=6">退出</a>
     <% 
  }else{ %>  
    请 <a href="login.jsp">【登录】</a> | <a href="regist.jsp">【注册】</a> <%} %></span></td>
    
    
    <td width="52%"><span class="STYLE2"><a href=account.do?flag=2>我的订单 </a>  |  我的51网  |  往期团购  |  手机版下载  |  邮件订阅  |  收藏本站</span></td>
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
    <td class="STYLE6"><h4><span class="STYLE8"><a href="index.jsp">51窝窝首页</a></span> <span class="STYLE4">|</span><span class="STYLE8"> 团购精选</span><span class="STYLE4">|</span> <span class="STYLE8">美食</span><span class="STYLE4">|</span><span class="STYLE8"> 网购</span></h4></td>
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
            <td> <span class="STYLE11">热门 | 火锅 坩埚 炒菜</span></td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="10" cellpadding="0">
            
            
            <tr class="STYLE16">
	   <td colspan="4" align="center">
	    <div align="center">付款成功</div>
	    <span id="time" style="background:red">5</span>秒钟后自动跳转，如果不跳转，请点击下面链接
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
    <div align="center"><a href="account.do?flag=2"> 返回我的订单</a></div>
	  
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
    <td> <div align="center" class="STYLE22">2014-？ 51tuan.com 京ICP证100702号 京公海网安备110108000829号 营业执照</div></td>
    <td>&nbsp;</td>
  </tr>
</table>
</body>
</html>
