package com.lifegame.Test;
import org.junit.Assert;
import org.junit.Test;

import com.lifegame.model.cellMatrix;

//���������
public class cellMatrixTest {

//ϸ���ֲ������ʼ��
int[][]mat={
		{0, 1, 0}, 
		{1, 1, 0}, 
		{0, 0, 1}
	};

//���̶����ʼ��
private cellMatrix cellmatrix=new cellMatrix(3, 3, 20, mat);


	//��ϸ��̽�ⷽ������
	@Test
	public void testFindNumAround() throws Exception{
		//Ԥ�ڻ�ϸ�����������
		int[][]res= {{3, 2, 2}, {2, 3, 3}, {2, 3, 1}};

		//���αȶԵõ��Ļ�ϸ������Ԥ������
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++) {
				//���ö���ʽ�����쳣����
				Assert.assertEquals(cellmatrix.findNumAround(i, j), res[i][j]);
			}

	}

	
	//�ݻ���������
	@Test
	public void testTransform() {
		//�ݻ�һ�ε�Ԥ��ϸ���ֲ����
		int[][] expected= {
				{1, 1, 0}, 
				{1, 1, 1}, 
				{0, 1, 0}
		};
		
		//�����ݻ�
		cellmatrix.transform();
		
		//���ö���ʽ�ȶ�Ԥ�ڽ����ʵ�ʽ��
		Assert.assertArrayEquals(expected, cellmatrix.getMatrix());
		
	}
	
	

}
