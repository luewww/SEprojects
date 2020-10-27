package com.lifegame.casegenerator;

import java.io.*;
import java.util.Random;


public class initCase {
	 /**
     * 生成文件数量
     */
    public static final int FILE_NUM=2;

    public static void main(String[] args) {

        for (int i = 0; i < FILE_NUM; i++) {

            createCaseFile();
            System.out.println("成功生成一个case文件");

        }

    }

    /**
     * 创建测试案例
     */
    private static void createCaseFile() {

        Random random = new Random();
        int rows = 1 + random.nextInt(100);
        int cols = 1 + random.nextInt(100);
        int duration = 200;

        File file = new File(cols + "_"+ rows + ".txt");
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(new FileWriter(file));
            StringBuilder sb = new StringBuilder(cols + " " + rows + " " + duration);
            writer.write(sb.append("\n").toString());

            //开始逐行初始化
            for (int y = 0; y < rows; y++) {
                sb = new StringBuilder();
                for (int x = 0; x < cols; x++) {

                    if (random.nextInt(3) % 3 == 0) {
                        sb.append("1 ");
                    } else {
                        sb.append("0 ");
                    }
                }
                sb.deleteCharAt(sb.length()-1).append("\n");
                writer.write(sb.toString());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }
}
