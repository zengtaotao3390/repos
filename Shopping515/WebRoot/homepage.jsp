<%@ page language="java" import="java.util.*" import="domain.*" import="java.sql.*" pageEncoding="GBK"%>

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
<form id="form1" name="form1" method="post" action="goods.do?flag=0">
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
    <td width="52%"><span class="STYLE2"> <a href=account.do?flag=2>我的订单 </a> |  我的51网  |  往期团购  |  手机版下载  |  邮件订阅  |  收藏本站  | <a href="help/Untitled-1.html"> 在线帮助 </a></span></td>
  </tr>
  <tr>
    <td width="27%" height="87">&nbsp;</td>
    <td width="21%"" align="center" ></td>
    <td>
       <input type="text" name="keyword" size="30"/>
	    
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
            <td><table width="100%" border="0" cellspacing="10" cellpadding="20">
             <%
	   List<Goods> list=new ArrayList<Goods>();
      list=(List)request.getAttribute("findAll");
     
      int n = list.size()/2;
        
      if((list.size()%2)!=0){
       n+=1;
      }
	   %>
            <%for(int j=0;j<n;j++){ %>
              <tr>
                        <% 
        int a=j*2;
             int b=a+2;
        for(int i=a;i<b;i++){ %>
                <td>
                <p> <a href=goods.do?flag=2&goodsId=<%=list.get(i).getId() %>>
          <img src="<%=list.get(i).getPic() %>" width="380" height="238" /></a></p>
         
                  <p class="STYLE14"><%=list.get(i).getGoodsname() %> </p>
                  <p class="STYLE16"><%=list.get(i).getIntroduction() %></p>
                <p class="STYLE14"><font color=red size=4>￥<%=list.get(i).getPrice()*list.get(i).getDiscount()/1 %></font>价值￥<%=list.get(i).getPrice() %>
              <a href=goods.do?flag=2&goodsId=<%=list.get(i).getId() %>>去看看</a></p>
              </td>
              <%} %>
              </tr>
              <%} %>
              <tr>
              
                <td colspan="2"><div align="right"><span class="STYLE16">
          <%int currentePage=(Integer)request.getAttribute("currentePage");
    int maxPage=(Integer)request.getAttribute("pageinfo");
  if(currentePage==1){%> 
     当前<%=currentePage%>页  
  <a href=goods.do?flag=0&currentePage=<%=currentePage+1 %>>下一页&gt</a>
<a href=goods.do?flag=0&currentePage=<%=maxPage %>>尾页</a>
   <%}else if(currentePage==maxPage){ %>  
       当前<%=currentePage%>页   
       <a href=goods.do?flag=0&currentePage=1>首页</a>
    <a href=goods.do?flag=0&currentePage=<%=currentePage-1 %>>&lt上一页</a>

<%}else {%>
<a href=goods.do?flag=0&currentePage=1>首页</a>
 <a href=goods.do?flag=0&currentePage=<%=currentePage-1 %>>&lt上一页</a>

    当前<%=currentePage%>页  
<a href=goods.do?flag=0&currentePage=<%=currentePage+1 %>>下一页&gt</a>
<a href=goods.do?flag=0&currentePage=<%=maxPage %>>尾页</a>
<%} %>

      共有<%=maxPage%>页
       <input type="text" size="4" name="currentePage"/>
        <input type="submit" name="Submit1"/>
        
          </span></div>
              </td>
              </tr>
              
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
  <tr >
    <td ><div ><p><img src="pic/food2.jpg" width="196" height="145" /></p>
        <p><strong>36元金
          福山单人自助午餐</strong></p>
    </div></td>
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
</form>
<script type="text/javascript">
        function tosubmit1()
        {
        var keyword=new String();
        //keyword=document.submitform.keyword.value;
       // keyword = document.getElementsByName("keyword")[0];
        //var f = document.getElementById("form1");
        //f.action="goods.do?flag=3&"+keyword;
        //f.submit();
        keyword = document.form1.keyword.value;
        document.form1.action="goods.do?flag=3&"+keyword;
        document.form1.submit();
        }
        </script> 

</body>
</html>
