package com.lifegame.model;

import java.util.Arrays;

public class cellMatrix {

//列
private int col;

//行
private int row;

//间隔时间 ms
private int gap;

//矩阵
private int[][] matrix;

public cellMatrix() {
		super();
		// TODO Auto-generated constructor stub
	}

public cellMatrix(int col, int row, int gap, int[][] matrix) {
	super();
	this.col = col;
	this.row = row;
	this.gap = gap;
	this.matrix = matrix;
}

public int findNumAround(int x, int y) {
	int num=0;
	
	//左上
	if(x!=0 && y!=0)
		num+=matrix[x-1][y-1];
	
	//上
	if(x!=0)
		num+=matrix[x-1][y];
	
	//右上
	if(x!=0 && y!=col-1)
		num+=matrix[x-1][y+1];
	
	//左
	if(y!=0)
		num+=matrix[x][y-1];
	
	//右
	if(y!=col-1)
		num+=matrix[x][y+1];
	
	//左下
	if(x!=row-1 && y!=0)
		num+=matrix[x+1][y-1];
	
	//下
	if(x!=row-1)
		num+=matrix[x+1][y];
	
	//右下
	if(x!=row-1 && y!=col-1)
		num+=matrix[x+1][y+1];
	
	return num;
}


public void transform() {
	int[][] nextMatrix = new int[row][col];
	
	for(int i=0;i<row;i++)
		for(int j=0;j<col;j++)
		{
			 nextMatrix[i][j]=0;
			 int nearNum = findNumAround(i, j);
			 if(nearNum==3)
				 nextMatrix[i][j]=1;
			 else if(nearNum==2)
				 nextMatrix[i][j]=matrix[i][j];
		}
	matrix=nextMatrix;
	
	
}
public int getCol() {
	return col;
}


public void setCol(int col) {
	this.col = col;
}


public int getRow() {
	return row;
}


public void setRow(int row) {
	this.row = row;
}


public int getGap() {
	return gap;
}


public void setGap(int gap) {
	this.gap = gap;
}


public int[][] getMatrix() {
	return matrix;
}


public void setMatrix(int[][] matrix) {
	this.matrix = matrix;
}


@Override
public String toString() {
	StringBuilder sb= new StringBuilder();
	
	for(int i=0; i<matrix.length; i++)
		sb.append(Arrays.toString(matrix[i])+"\n");
	
	return sb.toString();
}

public void clear() {
	this.col = 0;
	this.row = 0;
	this.gap = 0;
}

}
