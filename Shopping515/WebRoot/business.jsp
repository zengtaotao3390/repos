<%@ page language="java" import="java.util.*" import="java.sql.*" import="domain.*" import="dao.*" pageEncoding="GBK"%>


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

<form name="submitform" id="form2" method="post" action="account.do?flag=6">
  <tr>
    <td width="15%" >&nbsp;</td>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="5">
 
  
   <tr class="STYLE2">
  <%
  
      Account account = new Account();
      account = (Account)request.getAttribute("account");
      Goods goods = new Goods();
      goods = (Goods)request.getAttribute("goods");
   %>
    <td colspan="2"><span class="STYLE2">��ӭ����51�Ź�����
 </span></td>
    
    
    <td width="52%"><span class="STYLE2"><a href=account.do?flag=2>�ҵĶ��� </a>  |  �ҵ�51��  |  �����Ź�  |  �ֻ�������  |  �ʼ�����  |  �ղر�վ</span></td>
  </tr>
  <tr>
    <td width="27%" height="87">&nbsp;</td>
    <td width="21%"" align="center" ></td>
    <td>
      
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
          <tr valign="top">
            <td><table width="100%" border="0" cellspacing="10" cellpadding="0">
            <tr>
	  <td colspan="4"><p class="STYLE14">
	���!<%if(account==null){
            %>�ö����ʺŲ����ڣ����������� :
            <input type="text" name="accountcode" />
            <input type="submit" name="Submit1" value="�ύ" />
        <%}else{ %>���ʵ�:
   </p>
   </td>
   </tr>
    <tr>
	  <td colspan="4"><p class="STYLE14"></p>
	    <p class="STYLE3">
	    <input type="text" name="accountcode" />
            <input type="submit" name="Submit1" value="��������" class="STYLE14" />
	  ��ʾ����</p>
	    </td>
	  </tr>
	   <tr valign="top">
	  <td colspan="4" ><table width="100%" border="1" cellspacing="1" cellpadding="1">
        <tr bgcolor="#CCCCCC" class="STYLE14">
          <td><div align="center" class="STYLE7">��Ʒ</div></td>
          <td class="STYLE7"><div align="center">����</div></td>
          <td><div align="center" class="STYLE7">�ܽ��</div></td>
          <td><div align="center" class="STYLE7">����ʱ��</div></td>
          <td class="STYLE7"><div align="center">����״̬</div></td>
          <td class="STYLE7"><div align="center">����</div></td>
        </tr>
        
    <tr class="STYLE16">
          <td align="center"><img src="<%=goods.getPic() %>" width="90" height="70" />&nbsp;<%=goods.getGoodsname() %></td>
          <td align="center"><%=account.getNum() %></td>
          <td align="center"><%=account.getNum()*goods.getPrice() %></td>
          <td align="center">2013-09-01</td>
          <td align="center">
          <%if(account.getExecute()==0){
             out.print("δ�������ʹ��");
          }else if(account.getExecute()==1){
             out.print("�Ѹ������ʹ��");
          }else{
             out.print("��ʹ�ã�������ʹ��");
          }
           %>
          
          </td>
          <td align="center">
          <% if(account.getExecute()==1){%>
          <a href=account.do?flag=7&id=<%=account.getId() %>  onClick="return exit();">ʹ��</a>
          <%}else{ %>
          ����ʹ��
          <%} %>

</td>
        </tr>
    <% }%>
           
            </table></td>
            <td valign="top"><table width="100%" border="1" cellspacing="0" cellpadding="5">
  <tr>
    <td>��ʳ��</td>
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


 <script type="text/javascript">
   
   function exit(){
    var result = confirm("��ȷ��Ҫʹ�ö�����")
    if (result) {
    
    }else {
     return false;

}
   
   } 
   
    
    </script>
   
    
    
    </form>
</body>
</html>
