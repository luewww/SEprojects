package com.lifegame.Test;

import org.junit.Assert;
import org.junit.Test;

import com.lifegame.util.utils;
import com.lifegame.model.cellMatrix;


public class utilsTest {
	//�����ʼ��
	private static utils autil=new utils();
	//���̳�ʼ���Ĳ����ļ�·��
	String path="E:\\Java\\SElab\\LifeGameSelf\\case_0.txt";

	
	//�ļ���ʼ�����̵ķ�������
	@Test
	public void testInitMatrixFromFile() {
		//Ԥ��ϸ���ֲ����
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
		//���ļ���ʼ������
		cellMatrix cm=autil.initMatrixFromFile(path);
		
		//���ö���ʽ�ж����������Ƿ���Ԥ��һ��
		Assert.assertEquals(10, cm.getCol());
		Assert.assertEquals(10, cm.getRow());
		Assert.assertEquals(200, cm.getGap());
		Assert.assertArrayEquals(exdata, cm.getMatrix());

		
		//��·����ȡ���̲���
		Assert.assertEquals(null, autil.initMatrixFromFile(""));
		
		

	}

}
