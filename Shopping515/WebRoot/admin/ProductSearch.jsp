<%@ page language="java" import="java.util.*" import="domain.*" import="java.lang.Math" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		

		<title>My JSP 'ProductSearch.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	
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
	
<script type="text/javascript">

</script>
	</head>

	<body>
		<center>
			简单搜索
			<form name="simple" id="form1" action="../goods.do?flag=11" method="post" onsubmit="return check()">
				<input type="text" size="10" name="keyword" />
				搜索
				<input value="提 &nbsp; 交" type="submit">
			
			<br>
			<!--<form name="complex" action="ComplexSearchResult.jsp" method="post" onsubmit="return check()">
				-->
				<table width="750" align="center" border="1" class="tableborder" >
					<tr>
						<td colspan="2" align="center" bgColor="#4D76B3">
							高级搜索
						</td>
					</tr>
					
					<tr>
						<td bgColor="#4D76B3">
							产品名：
						</td>
						<td class="altbg1">
							<input type=text name="goodsname" size="15" maxlength="12" class="altbg1">
						</td>
					</tr>
					<tr>
						<td bgColor="#4D76B3">
							市场价格:
						</td>
						<td class="altbg1">
							From:
							<input type=text name="lowPrice" size="15" maxlength="12">
							To
							<input type=text name="highPrice" size="15" maxlength="12">
						</td>
					</tr>
					<tr>
						<td bgColor="#4D76B3">
							折扣:
						</td>
						<td class="altbg1">
							From:
							<input type=text name="lowDiscount" size="15" maxlength="12">
							To
							<input type=text name="highDiscount" size="15" maxlength="12">
						</td>
					</tr>
					

					<tr>
						<td></td>
						<td class="altbg1">
							<input type="button" onclick="tosubmit1()" value="提交">
							<input type="reset" value="重置">
						</td>
					</tr>

				</table>
			</form>
		</center>
		
		<script type="text/javascript">
		
		function check(){
			
				if(document.simple.keyword.value == ""){
					alert("请输入查询内容");
					return false;
				}else{
					return true;
				}
			}
		
			function tosubmit1(){
				var form1 = document.getElementById("form1");
				
				if(form1.goodsname.value == ""){
					alert("请输入查询商品名！");
					return;
				}
				if(form1.lowPrice.value == "" || form1.highPrice.value == ""){
					alert("请输入查询价格！");
					return；
				}
				var Regx = /^[0-9]+\.{0,1}[0-9]{0,2}$/;
				if (Regx.test(form1.lowPrice.value)){
					
				}else{
					alert("请输入正确的查询价格！");
					return;
				}
				if (Regx.test(form1.highPrice.value)){
					
				}else{
					alert("请输入正确的查询价格！");
					return;
				}
				if(form1.lowDiscount.value == "" || form1.highDiscount.value == ""){
					alert("请输入折扣");
					return;
				}
				if (Regx.test(form1.lowDiscount.value)){
					
				}else{
					alert("请输入正确的查询折扣！");
					return;
				}
				if (Regx.test(form1.highPrice.value)){
					
				}else{
					alert("请输入正确的查询折扣！");
					return;
				}
				form1.action = "../goods.do?flag=12";
				form1.submit();
			
			}
			
		
		</script>
	</body>
</html>
