package com.lifegame.Test;

import org.junit.Assert;
import org.junit.Test;

import com.lifegame.util.utils;
import com.lifegame.model.cellMatrix;


public class utilsTest {
	//对象初始化
	private static utils autil=new utils();
	//棋盘初始化的测试文件路径
	String path="E:\\Java\\SElab\\LifeGameSelf\\case_0.txt";

	
	//文件初始化棋盘的方法测试
	@Test
	public void testInitMatrixFromFile() {
		//预期细胞分布情况
		int exdata[][]= {
				{1, 0, 1, 1, 1, 0, 1, 1, 1, 0}, 
				{0, 1, 0, 0, 0, 1, 0, 0, 0, 1}, 
				{0, 0, 0, 1, 0, 0, 0, 1, 0, 0}, 
				{1, 0, 1, 1, 1, 0, 1, 1, 1, 0}, 
				{1, 0, 1, 1, 1, 0, 1, 1, 1, 0}, 
				{0, 1, 0, 0, 0, 1, 0, 0, 0, 1}, 
				{0, 0, 0, 1, 0, 0, 0, 1, 0, 0}, 
				{1, 0, 1, 1, 1, 0, 1, 1, 1, 0}, 
				{1, 0, 1, 1, 1, 0, 1, 1, 1, 0}, 
				{0, 1, 0, 0, 0, 1, 0, 0, 0, 1}
		};
		cellMatrix excm=new cellMatrix(10, 10, 200, exdata);
		//由文件初始化棋盘
		cellMatrix cm=autil.initMatrixFromFile(path);
		
		//利用断言式判断棋盘数据是否与预期一致
		Assert.assertEquals(10, cm.getCol());
		Assert.assertEquals(10, cm.getRow());
		Assert.assertEquals(200, cm.getGap());
		Assert.assertArrayEquals(exdata, cm.getMatrix());

		
		//无路径获取棋盘测试
		Assert.assertEquals(null, autil.initMatrixFromFile(""));
		
		

	}

}
