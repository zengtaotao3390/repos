<%@ page language="java" import="java.util.*"  import="domain.*"   pageEncoding="GB18030"%>

<html>
	<head>
		<title>会员列表</title>

		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<meta name="keywords"
			content="Discuz!,Board,Comsenz,forums,bulletin board,">
		<meta name="description" content="51窝窝会员列表">
		<meta name="generator" content="Discuz! 4.0.0RC4 with Templates 4.0.0">
		<meta name="MSSmartTagsPreventParsing" content="TRUE">
		<meta http-equiv="MSThemeCompatible" content="Yes">

		<style type="text/css"><!--
a			{ text-decoration: none; color: #000000 }
a:hover			{ text-decoration: underline }
body			{ scrollbar-base-color: #F3F6FA; scrollbar-arrow-color: #4D76B3; font-size: 12px; background-color: #ffffff }
table			{ font: 12px Verdana,Tahoma; color: #000000 }
input,select,textarea	{ font: 11px Verdana,Tahoma; color: #000000; font-weight: normal; background-color: #F3F6FA }
select			{ font: 11px Verdana,Tahoma; color: #000000; font-weight: normal; background-color: #F3F6FA }
.nav			{ font: 12px Verdana,Tahoma; color: #000000; font-weight: bold }
.nav a			{ color: #000000 }
.header			{ font: 11px Verdana,Tahoma; color: #000000; font-weight: bold; background-image: url("images/green/bg01.gif") }
.header a		{ color: #FFFFFF }
.category		{ font: 11px Verdana,Tahoma; color: #000000; background-color: #EFEFEF }
.tableborder		{ background: #4D76B3; border: 0px solid #4D76B3 } 
.singleborder		{ font-size: 0px; line-height: 0px; padding: 0px; background-color: #F3F6FA }
.smalltxt		{ font: 11px Verdana,Tahoma }
.outertxt		{ font: 12px Verdana,Tahoma; color: #000000 }
.outertxt a		{ color: #000000 }
.bold			{ font-weight: bold }
.altbg1			{ background: #F3F6FA }
.altbg2			{ background: #FFFFFF }
--></style>
		<script language="JavaScript" src="images/common.js"></script>
		<style type="text/css" id="defaultPopStyle">.cPopText { font-family: Tahoma, Verdana; background-color: #FFFFCC; border: 1px #000000 solid; font-size: 12px; padding-right: 4px; padding-left: 4px; height: 20px; padding-top: 2px; padding-bottom: 2px; visibility: hidden; filter: Alpha(Opacity=80)}</style>
	</head>
	<body leftmargin="0" rightmargin="0" topmargin="0"
		onkeydown="if(event.keyCode==27) return false;">
		<div id="popLayer" style="position: absolute; z-index: 1000;"
			class="cPopText"></div>

<form name="form1" id="form1" method="post" action="user.do?flag=3">
		<table style="table-layout: fixed;" align="center" border="0"
			cellpadding="0" cellspacing="0" width="97%">
			<tbody>
			<%
				List<Userinfo> users = (List) request.getAttribute("list");
				
			%>
			
			
				<tr>
					<td class="nav" align="left" nowrap="nowrap" width="90%">
						&nbsp;用户管理 &#187; 会员列表
					</td>
					<td align="right" width="10%">
						&nbsp;
						
					</td>
				</tr>
			</tbody>
		</table>
		<br>
		
		<table align="center" border="0" cellpadding="0" cellspacing="0"
			width="97%">
			<tbody>
		     <%if(users.size()==0){ %>
		     <tr>
		     <td>
		      	<font size="5">没有此用户，请重新搜索！</font>
		     </td>
		     </tr>
		     <%}else{ %>
				<tr>
					<td>
						<table border="0" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<td height="3"></td>
								</tr>
								<tr>
									<td>
										<table class="tableborder" cellpadding="2" cellspacing="1">
											<tbody>
												
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td height="3"></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>

		<input name="formhash" value="93a2a31f" type="hidden">
		<table class="tableborder" align="center" cellpadding="4"
			cellspacing="1" width="97%">
			<tbody>
				<tr class="header">
					<td align="center" width="9%">
						用户名
					</td>
					<td align="center" width="6%">
						UID
					</td>
					<td align="center" width="16%">
						tel
					</td>
					<td align="center" width="20%">
						email
					</td>
					<td align="center" width="20%">
						真实姓名
					</td>
					<td align="center" width="20%">
					    登陆次数
					
					</td>
					<td align="center">
						处理
					</td>
				</tr>

				<%
					for (int i = 0; i < users.size(); i++) {
						Userinfo u = users.get(i);
				%>

				<tr>
					<td class="altbg1" align="center" nowrap="nowrap">
						<%=u.getUsername()%>
					</td>
					<td class="altbg2" align="center">
						<%=u.getId()%>
					</td>
					<td class="altbg1" align="center">
						<%=u.getTel()%>
					</td>
					<td class="altbg2" align="center">
						<%=u.getEmail()%>
					</td>
					<td class="altbg1" align="center">
						<%=u.getRealname()%>
					</td>
					<td class="altbg2" align="center">
						<%=u.getTimes()%>
					</td>
					<td class="altbg1" align="right">
						<a href="user.do?flag=2&id=<%=u.getId()%>" onclick="return confirm('真的要删除?')">删除</a>
					</td>
				</tr>

				<%
					}
				%>

				<%} %>
				<tr>
					<td colspan="5" class="altbg2">
						搜索用户名
						<input size="15" name="keyword" id="keyword" type="text">
						<input value="提 &nbsp; 交" type="button" name="keyword"  onclick="tosubmit1()" >
						&nbsp; &nbsp;
						
					</td>
				</tr>
			</tbody>
		</table>

		<table align="center" border="0" cellpadding="0" cellspacing="0"
			width="97%">
			<tbody>
				<tr>
					<td>
						<table border="0" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<td height="3"></td>
								</tr>
								<tr>
									<td>
										<table class="tableborder" cellpadding="2" cellspacing="1">
											<tbody>
												
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td height="3"></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>
</form>
		<script type="text/javascript">
		   function tosubmit1(){
		  
		   var form = document.getElementById("form1");
		   var keyword = document.getElementById("keyword").value;
		 
		   if(keyword == "" || keyword == null){
		   		alert("请输入查询内容！");
		   		return;
		   }
		   form.action="user.do?flag=1&"+keyword;
		   form.submit();
		}
		</script>
	</body>
</html>
