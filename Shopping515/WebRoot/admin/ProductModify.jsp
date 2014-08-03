<%@ page language="java" import="domain.*"  pageEncoding="UTF-8"%>


	<script type="text/javascript">
	
		parent.main.location.reload();	
	
	</script>


<html><head><title>51团购网</title>

<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<meta name="keywords" content="Discuz!,Board,Comsenz,forums,bulletin board,">
<meta name="description" content="醒客论坛专区  - Discuz! Board">
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
.header			{ font: 11px Verdana,Tahoma; color: #FFFFFF; font-weight: bold; background-image: url("images/green/bg01.gif") }
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
<style type="text/css" id="defaultPopStyle">.cPopText { font-family: Tahoma, Verdana; background-color: #FFFFCC; border: 1px #000000 solid; font-size: 12px; padding-right: 4px; padding-left: 4px; height: 20px; padding-top: 2px; padding-bottom: 2px; visibility: hidden; filter: Alpha(Opacity=80)}</style></head><body leftmargin="0" rightmargin="0" topmargin="0" onkeydown="if(event.keyCode==27) return false;"><div id="popLayer" style="position: absolute; z-index: 1000;" class="cPopText"></div>

<%Goods g = (Goods)request.getAttribute("goods"); %>



<br>
<form method="post" name="formAdd" id="formAdd" action="" onsubmit="">


<table class="tableborder" align="center" cellpadding="4" cellspacing="1" width="97%">
<tbody><tr>
<td colspan="2" class="header">产品修改 - 必填内容</td>
</tr>
<tr>
<td class="altbg1" width="21%">产品名称:
<input type="hidden" name="goodsId" value="<%=g.getId() %>"/>
</td>
<td class="altbg2"><input name="goodsName" size="25" maxlength="25" type="text" value="<%=g.getGoodsname() %>"> 
</tr>

<tr>
<td class="altbg1">市场价格:</td>
<td class="altbg2"><input name="goodsPrice" size="25" type="text" value="<%=g.getPrice() %>"></td>
</tr><tr>
<td class="altbg1">折扣（如五折0.5）:</td>
<td class="altbg2"><input name="goodsDiscount" size="25" type="text" value="<%=(float)Math.round(g.getDiscount()*100)/10 %>"></td>
</tr>

<tr>
<td class="altbg1" valign="top">产品描述:</td>
<td class="altbg2"><textarea name="goodsIntroduction" cols="60" rows="5" id="descr"><%=g.getIntroduction() %> </textarea></td>
</tr>
</tbody></table>
<br>
<center><input name="regsubmit" value="修 &nbsp;改" type="button" onclick="tosubmit()"></center>
</form>

<script language="JavaScript">
function tosubmit(){
var form1 = document.getElementById("formAdd");

if(form1.goodsName.value == ""){
	alert("请输入商品名！");
	return;
}
if(form1.goodsPrice.value == ""){
	alert("请输入商品价格！");
	return;
}
var Regx = /^[0-9]+\.{0,1}[0-9]{0,2}$/;

			if (Regx.test(form1.goodsPrice.value))
			{
			
			}
			else
			{
			alert("请输入正确价格！");
			return false;
			} 
if(form1.goodsDiscount.value == ""){
	alert("请输人商品折扣");
	return;
}
if (Regx.test(form1.goodsDiscount.value))
			{
			
			}
			else
			{
			alert("请输入正确折扣！");
			return false;
			} 

if(form1.goodsIntroduction.value == ""){
	alert("请输入商品简介！");
	return;
}

form1.action = "goods.do?flag=8";

form1.submit();
parent.main.location.reload();

}
</script>

</body></html>