<%@ page language="java" import="java.util.*" import="java.sql.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


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

<script type="text/javascript">
  
      var xmlHttp;
  
      /**
       * ����xhr����
       */
      function createXMLHttpRequest() {
      
          if(window.XMLHttpRequest) {
              xmlHttp = new XMLHttpRequest();
          }else {
              xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
          }
      }
      
      /**
       * ��������
       */
      function sendRequest() {
          var name = document.getElementById("name").value;
          createXMLHttpRequest();
          //��������
          xmlHttp.open("post", "<%=basePath %>user.do?flag=7", true);
          //����HTTPͷ, ���÷������ݸ�ʽ
          xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
          //���ûص�����, ָ������״̬֮�󴥷�����
          xmlHttp.onreadystatechange=callback;
          //��������
          xmlHttp.send("name="+name);
      }
      
      /**
       * �ص�����, ����������
       */
      function callback() {
          
          //�ж������Ƿ����
          if(xmlHttp.readyState==4) {
              //�ж��Ƿ�ɹ���������
              if(xmlHttp.status==200) {
                   var msg = xmlHttp.responseText;
                   var mdiv = document.getElementById("usermsg");
                   if(msg=="1") {
                       mdiv.innerHTML = "<font color='red'>username exists</font>";
                   }else {
                   mdiv.innerHTML = "<font color='green'>congratulations! you can use this username!</font>";
                   }
              }
          }
      }
  
  </script>




</head>

<body>
<form id="form1" name="form1" method="post" onsubmit = "return userCheck()" action=user.do?flag=4>
<table width="100%" border="0" cellspacing="0" cellpadding="0" >
  <tr>
    <td width="15%" >&nbsp;</td>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="5">
  <tr class="STYLE2">
    <td colspan="2"><span class="STYLE2">��ӭ����51�Ź������� <a href="login.jsp">����¼��</a> | <a href="regist.jsp">��ע�᡿</a> </span></td>
    <td width="52%"><span class="STYLE2"><a href=account.do?flag=2>�ҵĶ��� </a>  |  �ҵ�51��  |  �����Ź�  |  �ֻ�������  |  �ʼ�����  |  �ղر�վ</span></td>
  </tr>
  <tr>
    <td width="27%" height="87">&nbsp;</td>
    <td width="21%"" align="center" ></td>
    <td>
          <input type="text" name="keyword" size="8"/>
	    
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
            <td ><table width="100%" border="0" cellspacing="20" cellpadding="0" >
              
               <tr align="center">
        <td colspan="">
		<div  class="STYLE14">�û�ע��</div></td>
        </tr>
      <tr class="STYLE16" align="center">
        <td>�� �� ����</td>
        <td align="left"><input type="text" name="name" id="name" size="30" onblur="sendRequest()" />*<span id="usermsg"></span></td>
      </tr>
      <tr class="STYLE16" align="center">
        <td>��ʵ������</td>
        <td align="left"><input type="text" name="realname" id="realname" size="30" />*</td>
      </tr>
      <tr class="STYLE16" align="center">
        <td> ��  �룺</td>
        <td align="left"><input type="password" name="password" id="password" size="30" />*</td>
      </tr>
      <tr class="STYLE16" align="center">
        <td>ȷ�����룺</td>
        <td align="left"><input type="password" name="repassword" id="repassword" size="30" />*</td>
      </tr>
      <tr class="STYLE16" align="center">
        <td>�� ��</td>
        <td align="left">
            <input name= "sex" type="radio" name="radio" id="sex" value="1" 

checked = "checked"/>
          ��
          <input name="sex" type="radio" name="radio" id="sex" value="0" />
          Ů </td>
      </tr>
      <tr class="STYLE16" align="center">
        <td>�绰��</td>
        <td align="left"><input type="text" name="tel" id="tel" size="30" /></td>
      </tr >
      <tr class="STYLE16" align="center">
        <td>�� �䣺</td>
        <td align="left"><input type="text" name="email" id="email" size="30" /></td>
      </tr>
      <tr class="STYLE16" align="center">
        <td>��֤�룺</td>
        <td align="left"><input type="text" name="safecode" size="8"size="30" /><img src="safecode1" 

id="safecode1"/></td>
      </tr>
      <tr class="STYLE16">
        <td colspan="" align="left">
          </td><td>
            <input type="submit" name="Submit" value="ע��" /> ��*Ϊ����
            
        
        </td>
        </tr>
      
    </table></td>
    </tr>
              
            </table></td>
            <td valign="top"><table width="100%" border="1" cellspacing="0" cellpadding="5">
  <tr>
    <td>��ʳ��</td>
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
   function userCheck(){
  if(document.form1.name.value == "")
  {
     window.alert("�������û�����");
     return false;
  }
  if(document.form1.realname.value == "")
   {
    window.alert("��������ʵ������");
     return false;
  }
  if(document.form1.password.value == "")
   {
    window.alert("���������룡");
     return false;
  }
  if(document.form1.repassword.value == "")
   {
    window.alert("������ȷ�����룡");
     return false;
  }
  
  return true;
  }
  </script>

</body>
</html>
