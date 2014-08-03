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
    <td><form id="soso_form" method="get" action="" >
     
          <input type="text" name="keyword" size="8"/>
	    
         <input type="button" name="Submit1" value="搜食品" onclick="tosubmit1()"/>
     
    </form></td>
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
             <%
      Goods goods = (Goods)request.getAttribute("goods");
   %>
            <tr>
            <td colspan="2">
            
            
             <p class="STYLE14"><%=goods.getGoodsname() %> </p>
                  <p class="STYLE16"><%=goods.getIntroduction() %></p>
            
            </td>
            </tr>
            
              
	   <tr>
	  <td colspan="4"><table width="100%" border="1" cellspacing="1" cellpadding="1">
        <tr>
          <td><div align="center" class="STYLE16"><font color=red size=4>￥<%=goods.getPrice() %> &nbsp;&nbsp;&nbsp;&nbsp;
           <a href=goods.do?flag=1&goodsId=<%=goods.getId() %>><font color=red size=6>团购</font></a>
          </font></div></td>
          <td rowspan="4" class="STYLE7"><div align="center"></div><img src="<%=goods.getPic() %>" width="400" height="400" /></td>
          
        </tr>
       <tr >
          <td><div align="center" class="STYLE16">价值 &nbsp;&nbsp;&nbsp;折扣 &nbsp; &nbsp; &nbsp;节省
          </div></td>
          <td class="STYLE16"><div align="center"></div></td>
          
        </tr>
   
    <tr bgcolor=>
          <td><div align="center" class="STYLE16"><%=goods.getPrice() %> &nbsp;&nbsp;&nbsp;<%=goods.getDiscount()*10 %> &nbsp; &nbsp; &nbsp;<%=goods.getPrice()*goods.getDiscount() %>
          </div></td>
          <td class="STYLE7"><div align="center"></div></td>
          
        </tr>
   
   <tr bgcolor=>
          <td><div align="center" class="STYLE16"><%if(goods.getNum()==0){
          %>
              <font color=red>0</font>人已购买,还差一人可构成团   
         <% }else{%>
            <font color=red><%=goods.getNum() %></font>人已购买,可参团
           
           <%} %>
          </div></td>
          <td class="STYLE16"><div align="center"></div></td>
          
        </tr>
              	<tr>
       <td align="center" class="STYLE14" colspan="2">温馨提示：</td>
          </tr>
          <tr>
           <td align="center" colspan="5" class="STYLE16">
             窝窝券有效期：2013年05月04日-08月25日<br>
             本商品不限购买<br>
              预定电话：023-68206655<br>
             请提前1天致电预约<br>
             请在预定成功后再到店消费，每人每次限约3桌<br>
             谢绝自带酒水，超出规定餐位人数后，按6元/位收取餐位费<br>
             本商品用餐区域为大厅  <br>
             仅限堂食不可外带  <br>
             本商品不享受店内其他优惠，窝窝券不兑换、不找零  <br>
           
           
           </td>
          

        </tr>
      
         
        
        
        
        
            <tr>
           <td align="right" colspan="2" class="STYLE14"><a href=goods.do?flag=0 >返回</a>
           </td>
          

        </tr>
              
              
            </table></td>
            <td valign="top"><table width="100%" border="1" cellspacing="0" cellpadding="5">
  <tr>
    <td>美食榜单</td>
  </tr>
  
   
  <tr>
    <td><p><img src="pic/food3.jpg" width="204" height="145" /></p>
      <p><strong>49元博尔森自助午餐</strong></p></td>
  </tr>
  <tr>
    <td><p><img src="pic/food4.jpg" width="206" height="145" /></p>
      <p><strong>143元六十一度火锅八人套餐</strong></p>      </td>
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
</body>
</html>
