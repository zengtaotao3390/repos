<%@ page language="java" import="java.util.*" import="java.sql.*" import="domain.*" pageEncoding="GBK"%>


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
<form name="submitform" id="form2" method="post" action="cart.do?flag=1">
<table width="100%" border="0" cellspacing="0" cellpadding="0" >
  <tr>
    <td width="15%" >&nbsp;</td>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="5">
  <tr class="STYLE2">
  <%
  Userinfo user=(Userinfo)request.getSession().getAttribute("userinfo");
  Shoppingcard sc = (Shoppingcard)request.getSession().getAttribute("sc");
     
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
    <td>
          <input type="text" name="keyword" size="8"/>
	    
         <input type="button" name="Submit1" value="搜食品" onclick="tosubmit1()"/>
    </td>
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
	  <td colspan="4"><p class="STYLE14">
	你好!你的订单如下：
      
      
   </p>
   </td>
   </tr>
	   
	   <tr>
	  <td colspan="4"><table width="100%" border="0" cellspacing="10" cellpadding="1">
        <tr bgcolor="#CCCCCC" class="STYLE14">
          <td><div align="center" class="STYLE7">商品名称</div></td>
          <td class="STYLE7"><div align="center">价格</div></td>
          <td><div align="center" class="STYLE7">51价</div></td>
          <td><div align="center" class="STYLE7">数量</div></td>
          <td><div align="center" class="STYLE7">总价</div></td>
          
        </tr>
        <%
        float num = 0;
          num = sc.getPrice()*sc.getDiscount();
          num = sc.getPrice() - num;        
         %>
   
        <tr class="STYLE16">
  <td align="center"><%=sc.getGoodsName()%></td>
          <td align="center"><%=sc.getPrice() %></td>
          <td align="center"><%=num %></td>
          <td align="center"><input type="text" value="<%=sc.getNumber() %>" name="num" /><input type="submit" name="Submit" value="修改数量" /> </td>
          <td align="center"><%=sc.getNumber()*sc.getPrice() %></td>
        </tr>
         <tr bgcolor="#CCCCCC" class="STYLE14">
          <td><div align="center" class="STYLE7">电话</div></td>
          <td class="STYLE7"><div align="center">email</div></td>
          
          
        </tr>
		<tr class="STYLE16">
       <td align="center">电话：<input type="text" value="<%=user.getTel()%>" name="tel"/></td>
          
           <td align="center">emial：<input type="text" value="<%=user.getEmail() %>" name="email"/></td>
       
           
           <td colspan="3" align="right"> <input type="button" name="Submit1" value="确认" onclick="tosubmit1()"/></td>
        
         
            </table></td>
            
            <td valign="top"><table width="100%" border="1" cellspacing="0" cellpadding="5">
  <tr>
    <td>美食榜单</td>
  </tr>
  <tr>
    <td><p><img src="pic/food1.jpg" width="193" height="145"  /></p>
      <p>
        <span class="STYLE13"><strong>49元好伦</strong></span><span class="STYLE13"><strong>哥</strong></span><span class="STYLE13"><strong>单</strong></span>
        <span class="STYLE13"><strong>人</strong></span><strong>自</strong><strong>助晚餐</strong></p></td>
  </tr>
  
 
  <tr>
    <td><p><img src="pic/food5.jpg" width="210" height="145" /></p>
      <p><strong>德克士小资单人餐</strong></p></td>
  </tr>
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
</form>

	   <script type="text/javascript">
    function tosubmit1()
    {
       var tel=new String();
       var email=new String();
       tel=document.submitform.tel.value;
       email=document.submitform.email.value;
       document.submitform.action="account.do?flag=1&"+tel+"&"+email;
       document.submitform.submit();
    }
    
    </script>
</body>
</html>
