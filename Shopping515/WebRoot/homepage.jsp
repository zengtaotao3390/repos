<%@ page language="java" import="java.util.*" import="domain.*" import="java.sql.*" pageEncoding="GBK"%>

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
<form id="form1" name="form1" method="post" action="goods.do?flag=0">
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
    <td width="52%"><span class="STYLE2"> <a href=account.do?flag=2>�ҵĶ��� </a> |  �ҵ�51��  |  �����Ź�  |  �ֻ�������  |  �ʼ�����  |  �ղر�վ  | <a href="help/Untitled-1.html"> ���߰��� </a></span></td>
  </tr>
  <tr>
    <td width="27%" height="87">&nbsp;</td>
    <td width="21%"" align="center" ></td>
    <td>
       <input type="text" name="keyword" size="30"/>
	    
         <input type="button" name="Submit1" value="��ʳƷ" onclick="tosubmit1()"/>
    </td>
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
                <p class="STYLE14"><font color=red size=4>��<%=list.get(i).getPrice()*list.get(i).getDiscount()/1 %></font>��ֵ��<%=list.get(i).getPrice() %>
              <a href=goods.do?flag=2&goodsId=<%=list.get(i).getId() %>>ȥ����</a></p>
              </td>
              <%} %>
              </tr>
              <%} %>
              <tr>
              
                <td colspan="2"><div align="right"><span class="STYLE16">
          <%int currentePage=(Integer)request.getAttribute("currentePage");
    int maxPage=(Integer)request.getAttribute("pageinfo");
  if(currentePage==1){%> 
     ��ǰ<%=currentePage%>ҳ  
  <a href=goods.do?flag=0&currentePage=<%=currentePage+1 %>>��һҳ&gt</a>
<a href=goods.do?flag=0&currentePage=<%=maxPage %>>βҳ</a>
   <%}else if(currentePage==maxPage){ %>  
       ��ǰ<%=currentePage%>ҳ   
       <a href=goods.do?flag=0&currentePage=1>��ҳ</a>
    <a href=goods.do?flag=0&currentePage=<%=currentePage-1 %>>&lt��һҳ</a>

<%}else {%>
<a href=goods.do?flag=0&currentePage=1>��ҳ</a>
 <a href=goods.do?flag=0&currentePage=<%=currentePage-1 %>>&lt��һҳ</a>

    ��ǰ<%=currentePage%>ҳ  
<a href=goods.do?flag=0&currentePage=<%=currentePage+1 %>>��һҳ&gt</a>
<a href=goods.do?flag=0&currentePage=<%=maxPage %>>βҳ</a>
<%} %>

      ����<%=maxPage%>ҳ
       <input type="text" size="4" name="currentePage"/>
        <input type="submit" name="Submit1"/>
        
          </span></div>
              </td>
              </tr>
              
            </table></td>
            <td valign="top"><table width="100%" border="1" cellspacing="0" cellpadding="5">
  <tr>
    <td>��ʳ��</td>
  </tr>
  <tr>
    <td><p><img src="pic/food1.jpg" width="193" height="145"  /></p>
      <p>
        <span class="STYLE13"><strong>49Ԫ����</strong></span><span class="STYLE13"><strong>��</strong></span><span class="STYLE13"><strong>��</strong></span>
        <span class="STYLE13"><strong>��</strong></span><strong>��</strong><strong>�����</strong></p></td>
  </tr>
  <tr >
    <td ><div ><p><img src="pic/food2.jpg" width="196" height="145" /></p>
        <p><strong>36Ԫ��
          ��ɽ�����������</strong></p>
    </div></td>
  </tr>
  <tr>
    <td><p><img src="pic/food3.jpg" width="204" height="145" /></p>
      <p><strong>49Ԫ����ɭ�������</strong></p></td>
  </tr>
  <tr>
    <td><p><img src="pic/food4.jpg" width="206" height="145" /></p>
      <p><strong>143Ԫ��ʮһ�Ȼ�������ײ�</strong></p>      </td>
  </tr>
  <tr>
    <td><p><img src="pic/food5.jpg" width="210" height="145" /></p>
      <p><strong>�¿�ʿС�ʵ��˲�</strong></p></td>
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
    <td> <div align="center" class="STYLE22">2014-�� 51tuan.com ��ICP֤100702�� ������������110108000829�� Ӫҵִ��</div></td>
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
