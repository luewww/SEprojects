package com.lifegame.Test;
import org.junit.Assert;
import org.junit.Test;

import com.lifegame.model.cellMatrix;

//棋盘类测试
public class cellMatrixTest {

//细胞分布矩阵初始化
int[][]mat={
		{0, 1, 0}, 
		{1, 1, 0}, 
		{0, 0, 1}
	};

//棋盘对象初始化
private cellMatrix cellmatrix=new cellMatrix(3, 3, 20, mat);


	//活细胞探测方法测试
	@Test
	public void testFindNumAround() throws Exception{
		//预期活细胞的数量情况
		int[][]res= {{3, 2, 2}, {2, 3, 3}, {2, 3, 1}};

		//依次比对得到的活细胞数和预期数量
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++) {
				//利用断言式进行异常反馈
				Assert.assertEquals(cellmatrix.findNumAround(i, j), res[i][j]);
			}

	}

	
	//演化方法测试
	@Test
	public void testTransform() {
		//演化一次的预期细胞分布情况
		int[][] expected= {
				{1, 1, 0}, 
				{1, 1, 1}, 
				{0, 1, 0}
		};
		
		//进行演化
		cellmatrix.transform();
		
		//利用断言式比对预期结果和实际结果
		Assert.assertArrayEquals(expected, cellmatrix.getMatrix());
		
	}
	
	

}
