<%@ page language="java" import="java.util.*" import="domain.*" pageEncoding="GBK"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>无标题文档</title>
<style type="text/css">
<!--
.STYLE1 {font-size: 18px}
.STYLE3 {
	font-size: 18px;
	font-weight: bold;
	font-family: "宋体";
}
.STYLE4 {font-family: "宋体"}
.STYLE5 {font-family: "宋体"; font-size: 14px; }
.STYLE6 {font-family: "宋体"; font-size: 18px; }
-->
</style>
</head>

<body bgcolor="#CCCCCC">
<%Userinfo user=(Userinfo)request.getSession().getAttribute("userinfo"); %>
  <form action="account.do?flag=1" method="post" name="form1" >
<table width="80%" border="0" align="center" cellpadding="0" cellspacing="5" bgcolor="#FFFFFF">
  <tr>
    <td width="85%"><img src="pic/log.jpg" width="183" height="50" /></td>
    <td><div align="right"><img src="pic/cgr.jpg" width="102" height="44" /></div></td>
  </tr>
  <tr >
    <td colspan="2"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr bgcolor="#CCCCCC" height="50">
        <td colspan="4" align="left"><div  class="STYLE8"><span class="STYLE1"><a href="index.html">晨光首页</a>|<a href="news.html">晨光新闻</a>|<a href="goods.html">产品中心</a>|<a href="we.html">联系我们</a></span></div>        </td>
      </tr>
	  <tr>
	  <td colspan="4"><img src="pic/pic01.jpg" width="100%" height="165" /></td>
	  </tr>
	   <tr>
	  <td colspan="4"><p class="STYLE3">我的订单</p>
	    <p class="STYLE3"><img src="pic/bg_navi.gif" width="100%" height="1" /></p></td>
	  </tr>
	   <tr>
	  <td colspan="4"><table width="100%" border="0" cellspacing="3" cellpadding="3">
	  
	  
	  
        <tr>
          <td align="right">订单号：</td>
          <td><input type="text" name="accountcode" readonly value="<%=request.getAttribute("accountcode") %>"/></td>
        </tr>
        <tr>
          <td align="right">用户名：</td>
          <td> <input type="text" name="username" readonly value="<%=user.getUsername() %>"/></td>
        </tr>
        <tr>
          <td align="right">真实姓名：</td>
          <td><input type="text" name="realname" readonly value="<%=user.getRealname() %>"/></td>
        </tr>
        <tr>
          <td align="right">Email:</td>
          <td><input type="text" name="email" readonly value="<%=user.getEmail() %>"/></td>
        </tr>
        <tr>
          <td align="right">用户地址：</td>
          <td> <input type="text" name="address" /></td>
        </tr>
        <tr>
          <td align="right">邮编：</td>
          <td> <input type="text" name="postcode" /></td>
        </tr>
        <tr>
          <td align="right">联系电话：</td>
          <td>  <input type="text" name="tel" readonly value="<%=user.getTel() %>"/></td>
        </tr>
        <tr>
          <td colspan="2" align="left"><label>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" name="submit1" value="结账" onclick="return check()"/> <a href=cart.do?flag=0>返回</a>
          </label></td>
          </tr>
      </table></td>
	  </tr>
	  </table></td></tr></table>
	   </form>
	   
	   
  <script type="text/javascript">
   function check(){
  if(document.form1.address.value == "")
  {
     window.alert("请输入用户地址");
     return false;
  }
  if(document.form1.postcode.value == "")
  {
     window.alert("请输入邮编");
     return false;
  }
  
  return true;
  }
  </script>
</body>
</html>
