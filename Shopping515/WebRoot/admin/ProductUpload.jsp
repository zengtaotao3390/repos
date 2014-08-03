<%@ page language="java" import= "java.util.*" pageEncoding="UTF-8"%>

<%
int goodsId = Integer.parseInt(request.getParameter("goodsId"));
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>index.html</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">

    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->

  </head>

  <body>
  
   <form name="uploadform" id="uploadform" method="POST" action="UpLoadFile.do?flag=0" ENCTYPE="multipart/form-data">
		<table height="50">
		
		</table>
		
		
        <table border="1" width="450" cellpadding="4" cellspacing="2" bordercolor="#9BD7FF" align="center" >

        <tr><td width="100%" colspan="2">

                       请选择要上传的图片：

        </td></tr>

        <tr><td width="100%" colspan="2">

                        <input name="picture" size="40" type="file">
		<input name="goodsId" type="hidden" value="<%=goodsId %>">
        </td>

        </table >

        <br/><br/>

        <table align="center">

        <tr><td align="center"><input name="upload" type="button" value="开始上传" onclick = "tosubmit()"></td></tr>

       </table>
  
    
</form>
<script type="text/javascript">
	function tosubmit(){
		var form = document.getElementById("uploadform");
		if(form.picture.value == ""){
			alert("请选择上传图片！");
			return;
		}
		form.action = "../UpLoadFile.do?flag=0&goodsId=<%=goodsId %>";
		form.submit();
		parent.main.location.reload();
	}


</script>

  </body>
</html>
