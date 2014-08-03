<%@ page language="java" import="java.util.*" import="org.jfree.data.category.CategoryDataset"
import="org.jfree.data.general.DatasetUtilities"
import="org.jfree.chart.JFreeChart"
import="org.jfree.chart.ChartFactory"
import="org.jfree.chart.plot.PlotOrientation"
import="org.jfree.chart.servlet.ServletUtilities"
import="org.jfree.chart.plot.CategoryPlot"
import="java.awt.Color"
import="org.jfree.chart.renderer.category.BarRenderer3D"
import="org.jfree.chart.labels.StandardCategoryItemLabelGenerator"
import="org.jfree.chart.labels.ItemLabelPosition"
import="org.jfree.chart.labels.ItemLabelAnchor"
import="org.jfree.ui.TextAnchor"
import="org.jfree.chart.axis.AxisLocation"
import="org.jfree.chart.axis.CategoryAxis"
 import="org.jfree.chart.axis.ValueAxis"
import="org.jfree.chart.title.TextTitle"
import="java.awt.Font"
 pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>




<%
 double[][] data = new double[][] { { 1310, 256, 860, 720 },
   { 423, 327, 1111, 720 }, { 1111, 333, 600, 1130 },
   { 800, 600, 2300, 440 } };
 String[] rowKeys = { "猪肉", "牛肉", "鸡肉", "鱼肉" };
 String[] columnKeys = { "广州", "深圳", "东莞", "佛山" };
 CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
   rowKeys, columnKeys, data);

 //图表
 //JFreeChart org.jfree.chart.ChartFactory.createBarChart3D(String title, String categoryAxisLabel, 
 //String valueAxisLabel, CategoryDataset dataset, PlotOrientation orientation, boolean legend, 
 //boolean tooltips, boolean urls)
 JFreeChart chart = ChartFactory
   .createBarChart3D("广州肉类销量统计图", "肉类", "销量", dataset,
     PlotOrientation.VERTICAL, true, false, false);
CategoryPlot plot = chart.getCategoryPlot();
 CategoryAxis domainAxis = plot.getDomainAxis();//x轴
 ValueAxis numberaxis = plot.getRangeAxis();//y轴

 //乱码解决开始
 TextTitle textTitle = chart.getTitle();
 textTitle.setFont(new Font("宋体", Font.BOLD, 15));
 domainAxis.setLabelFont(new Font("宋体",Font.BOLD,20));//x轴标题文字
  domainAxis.setTickLabelFont(new Font("黑体",Font.BOLD,10));//x轴坐标上文字
 numberaxis.setLabelFont(new Font("宋体",Font.BOLD,20));//y轴标题文字
 numberaxis.setTickLabelFont(new Font("黑体",Font.BOLD,10));//y轴坐标上文字
 chart.getLegend().setItemFont(new Font("宋体",Font.PLAIN,15));
 //乱码解决结束
 /*每个柱子都加上它的数值*/
 
 //设置网络背景颜色
 plot.setBackgroundPaint(Color.white);
 //设置网格竖线颜色
 plot.setDomainGridlinePaint(Color.pink);
 //设置网络横线颜色
 plot.setRangeGridlinePaint(Color.pink);
 //显示每个柱的数值,并修改该数值的字体属性
 BarRenderer3D renderer = new BarRenderer3D();
 renderer
   .setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
 renderer.setBaseItemLabelsVisible(true);
 //默认的数字显示在柱子中，通过如下两句可调整数字的显示
 renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
   ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
 renderer.setItemLabelAnchorOffset(10D);
 //设置每个地区所包含的平行柱的之间距离
 //renderer.setItemMargin(0.3);
 plot.setRenderer(renderer);
 //设置地区、销量的显示位置
 //将下方的“肉类”放到上方
 plot.setDomainAxisLocation(AxisLocation.TOP_OR_RIGHT);
 //将默认放在左边的“销量”放到右方
 plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);

 String filename = ServletUtilities.saveChartAsPNG(chart, 700, 400,
   null, session);

 String graphURL = request.getContextPath()
   + "/DisplayChart?filename=" + filename;
%>
<%System.out.println(graphURL); %>
<img src="<%=graphURL%>" width=500 height=300 border=0 usemap="#<%=filename %>" />

 


