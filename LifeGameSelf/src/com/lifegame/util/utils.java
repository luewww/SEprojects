package com.lifegame.util;

import com.lifegame.model.cellMatrix;

import java.io.*;


public class utils {

	public static cellMatrix initMatrixFromFile(String path) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String line = reader.readLine();
            String[] array = line.split(" ");
            int col = Integer.parseInt(array[0]);
            int row = Integer.parseInt(array[1]);
            int gap = Integer.parseInt(array[2]);
            int[][] matrix = new int[row][col];
            for (int i = 0; i < row; i++) {
                line = reader.readLine();
                array = line.split(" ");
                for (int j = 0; j < array.length; j++) {
                    matrix[i][j] = Integer.parseInt(array[j]);
                }
            }
            
            cellMatrix cellMatrix = new cellMatrix(col, row, gap, matrix);
            return cellMatrix;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
