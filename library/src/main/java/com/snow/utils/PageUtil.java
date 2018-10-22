package com.snow.utils;

import com.snow.dao.IUtilsDao;
import com.snow.model.PageEntity;

import javax.annotation.Resource;

public class PageUtil {
	@Resource
	private IUtilsDao utilsDao;
	/**
	 * 传入分页参数数
	 * @param totalRows 总行
	 * @param curPage 查看当前第几页
	 * @param curPageSize 每月显示几条
	 * @return 分页类,PageEntity
	 */
	public static   PageEntity getPage(Integer totalRows,Integer curPage, Integer curPageSize){
		Integer	toalPage=0;//共分多少页
		Integer startRow=0;//从第几条数据开始查询起

		if (totalRows<=0){totalRows=0;}
		if (curPage<=0){curPage=1;}
		if (curPageSize<=0){curPageSize=1;}

		PageEntity page=new PageEntity();
		if(totalRows%curPageSize==0){
			 toalPage=(totalRows/curPageSize);//共分多少页
		}else {
			 toalPage=(totalRows/curPageSize)+1;//共分多少页
		}
		if(toalPage<=curPageSize){toalPage=1;}
		 startRow=(curPage-1)*curPageSize;//从第几条数据开始查询起

			page.setTotalRows(totalRows);//共有多少条记录
			page.setStartRow(startRow);//开始记录位
			page.setCurPageSize(curPageSize);//显示多少条记录
			page.setToalPage(toalPage);//有多少页
			page.setCurPage(curPage);//当前页
			return page;
	}
}
