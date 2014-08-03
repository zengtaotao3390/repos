<%@ page language="java" import="java.util.*" import="domain.*" import="java.lang.Math" pageEncoding="UTF-8"%>


<html>
	<head>
		<title>会员列表</title>

		<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
		<meta name="keywords"
			content="Discuz!,Board,Comsenz,forums,bulletin board,">
		<meta name="description" content="金尚商城会员列表">
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
	<%
		List<Goods> goods = (List)request.getAttribute("findAll");
	 %>
<form action="goods.do?flag=4" name="form1" id="form1" method="post" target="main" onsubmit="return tosubmit1()">
		<table style="table-layout: fixed;" align="center" border="0"
			cellpadding="0" cellspacing="0" width="97%">
			<tbody>
				<tr>
					<td class="nav" align="left" nowrap="nowrap" width="90%">
						&nbsp;产品管理 &#187; 产品列表
					</td>
					<td align="right" width="10%">
						&nbsp;
						
					</td>
				</tr>
			</tbody>
		</table>
		<br>
		
		<center><a href="admin/ProductAdd.jsp" target="detail" onclick="frameCtrl('20,50%,*')">添加新产品</a></center>
		
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
												<tr class="smalltxt" bgcolor="#f3f6fa">
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td height="3"><br></td>
								</tr>
							</tbody>
						</table>
					</td>
				</tr>
			</tbody>
		</table>

				
		<table class="tableborder" align="center" cellpadding="4"
			cellspacing="1" width="97%">
			<tbody>
				<tr class="header">
					
					<td align="center" width="9%">
						产品ID
					</td>
					<td align="center" width="9%">
						产品名称
					</td>
					<td align="center" width="30%">
						产品描述
					</td>
					<td align="center" width="9%">
						是否上传图片
					</td>
					<td align="center" width="10%">
						<a href="goods.do?flag=9&field=price" target="main">市场价格</a>
					</td>
					<td align="center" width="10%">
						<a href="goods.do?flag=9&field=discount" target="main">产品折扣</a>
					</td>
					
					<td align="center" width="10%">
						<a href="goods.do?flag=9&field=num" target="main">购买人数</a>
					</td>
					<td align="center">
						处理
					</td>
				</tr>

				<%
					for (int i = 0; i < goods.size(); i++) {
						Goods g = goods.get(i);
				%>

				<tr>
					<td class="altbg1" align="center" nowrap="nowrap">
						<%=g.getId()%>
					</td>
					<td class="altbg2" align="center">
						<%=g.getGoodsname()%>
					</td>
					<td class="altbg1" align="center">
						<%=g.getIntroduction()%>
					</td>
					
					<td class="altbg2" align="center">
					<%if(g.getPic() != null){ %>
						<a href="javascript:void(0)" onclick="showPic('<%=g.getPic() %>')">有</a>
						<%}else{ %>
						无<%} %>
					</td>
					<td class="altbg1" align="center">
						<%=g.getPrice()%>
					</td>
					<td class="altbg2" align="center">
						<%=(float)Math.round(g.getDiscount()*100)/10%>
					</td>
					<td class="altbg1" align="center">
						<%=g.getNum()%>
					</td>
					<td class="altbg2" align="center">
						<!--<a href="goods.do?flag=5&id=<%=g.getId() %>" onclick="return confirm('真的要删除?')">删除 </a>-->
						<a href="javascript:void(0);" onclick="deleteGoods(<%=g.getId() %>)">删除</a>
						
						&nbsp;&nbsp;
						<a href="goods.do?flag=7&id=<%=g.getId() %>" target="detail" onclick="frameCtrl('20,50%,*')" >修改</a>
						&nbsp;&nbsp;
						
						<a href="admin/ProductUpload.jsp?goodsId=<%=g.getId() %>" target="detail" onclick="frameCtrl('20,50%,*')" >上传</a>
					</td>
				</tr>

				<%
					}
				%>

				<tr>
					
					
					
					<td colspan="8" class="altbg2">
						搜索商品：
						<input type="text" size="10" name="keyword" id="keyword"/>
						
						<input value="提 &nbsp; 交" type="button" onclick="searchProduct()">
						
						&nbsp; &nbsp;
					</td>
					
				</tr>
				
				<tr class="smalltxt" bgcolor="" >
													<td class="header" colspan="8">
														<%
															int currentePage = (Integer) request.getAttribute("currentePage");
															int maxPage = (Integer) request.getAttribute("pageinfo");
															if (currentePage == 1) {
														%>
														当前<%=currentePage%>页
														<a  target="main" href="goods.do?flag=4&currentePage=<%=currentePage + 1 %>">下一页&gt</a>
														<a href="goods.do?flag=4&currentePage=<%=maxPage%>">尾页</a>
														<%
															} else if (currentePage == maxPage) {
														%>
														当前<%=currentePage%>页
														<a target="main" href="goods.do?flag=4&currentePage=1">首页</a>
														<a target="main" href="goods.do?flag=4&currentePage=<%=currentePage - 1%>">&lt上一页</a>

														<%
															} else {
														%>
														<a target="main" href="goods.do?flag=4&currentePage=1">首页</a>
														<a href="goods.do?flag=4&currentePage=<%=currentePage - 1 %>" >&lt上一页</a>

														当前<%=currentePage%>页
														<a target="main" href="goods.do?flag=4&currentePage=<%=currentePage + 1%>">下一页&gt</a>
														<a target="main" href="goods.do?flag=4&currentePage=<%=maxPage%>">尾页</a>
														<%
															}
														%>

														共有<%=maxPage%>页&nbsp;第
														<input type="text" size="4" name="currentePage" id="currentePage" />页
														<input type="submit" name="button1" value="确定" "/>
														
													</td>
													
												</tr>
											
			</tbody>
			
		</table>
			</form>
			
		<script type="text/javascript">
		   function tosubmit1(){
		 
		   var form = document.getElementById("form1");
		  
		   var currentePage = document.getElementById("currentePage").value;
		   var Regx = /^[0-9]*$/;
			if (Regx.test(currentePage))
			{
			return true;
			}
			else
			{
			alert("请输入正确数字！");
			return false;
			} 
		   if(currentePage == ""){
		   	alert("请输入查询页数！");
		   	return false;
		   }
		  
		}
		
		function frameCtrl(para){
			parent.parent.content.rows=para;
		}
		
		function deleteGoods(goodsId){
			confirm("真的要删除！");
			var form = document.getElementById("form1");
			form.action = "goods.do?flag=5&id=" + goodsId ;
			form.submit();
			parent.main.location.reload();
		}
		function searchProduct(){
			var form = document.getElementById("form1");
			var keyword = document.getElementById("keyword").value;
			
			if(keyword == ""){
				alert("请输入查询内容");
				return;
			}
			form.action = "goods.do?flag=11";
			form.submit();
		}
		
 		function showPic(a){
 			
 			var strReturnValue = window.showModalDialog("admin/showPic.jsp",a,"dialogHeight=300px;dialogWidth=400px;dialogLeft=400px;dialogTop=200px");
 		}
		
		</script>
	</body>
</html>
