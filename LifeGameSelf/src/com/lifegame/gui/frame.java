package com.lifegame.gui;

import com.lifegame.Test.*;
import com.lifegame.model.cellMatrix;
import com.lifegame.util.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.*;


@SuppressWarnings("serial")
public class frame extends JFrame {

    private JButton openFileBtn = new JButton("选择文件");
    private JButton startGameBtn = new JButton("开始游戏");
    private JLabel durationPromtLabel = new JLabel("动画间隔设置(ms为单位)");
    private JTextField durationTextField = new JTextField();
    
    // 游戏是否开始的标志
    private boolean isStart = false;

    // 游戏结束的标志
    private boolean stop = false;

    private cellMatrix cellMatrix;
    private JPanel buttonPanel = new JPanel(new GridLayout(2, 2));
    private JPanel gridPanel = new JPanel();

    private JTextField[][] textMatrix;


    //动画默认间隔200ms
    private static final int DEFAULT_DURATION = 200;

    //动画间隔
    private int duration = DEFAULT_DURATION;

    public frame() {
        setTitle("生命游戏");
        openFileBtn.addActionListener(new OpenFileActioner());
        startGameBtn.addActionListener(new StartGameActioner());

        buttonPanel.add(openFileBtn);
        buttonPanel.add(startGameBtn);
        buttonPanel.add(durationPromtLabel);
        buttonPanel.add(durationTextField);
        buttonPanel.setBackground(Color.WHITE);

        getContentPane().add("North", buttonPanel);

        this.setSize(1000, 1200);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private class OpenFileActioner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fcDlg = new JFileChooser(".");
            fcDlg.setDialogTitle("请选择初始配置文件");
            int returnVal = fcDlg.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {

                isStart = false;
                stop = true;
                startGameBtn.setText("开始游戏");

                String filepath = fcDlg.getSelectedFile().getPath();
                cellMatrix = utils.initMatrixFromFile(filepath);
                initGridLayout();
                showMatrix();
                gridPanel.updateUI();
            }
        }


    }

    private void showMatrix() {

        int[][] matrix = cellMatrix.getMatrix();
        int row = matrix.length;
        int col = matrix[0].length;
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                if (matrix[y][x] == 1) {
                    textMatrix[y][x].setBackground(Color.BLACK);
                } else {
                    textMatrix[y][x].setBackground(Color.WHITE);
                }
            }
        }
    }

    //创建显示的gridlayout布局
    private void initGridLayout() {
        int row = cellMatrix.getRow();
        int col = cellMatrix.getCol();
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(row, col));
        textMatrix = new JTextField[row][col];
        for (int y = 0; y < row; y++) {
            for (int x = 0; x < col; x++) {
                JTextField text = new JTextField();
                textMatrix[y][x] = text;
                gridPanel.add(text);
            }
        }
        add("Center", gridPanel);
    }


    private class StartGameActioner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isStart) {

                //获取时间
                try {
                    duration = Integer.parseInt(durationTextField.getText().trim());
                } catch (NumberFormatException e1) {
                    duration = DEFAULT_DURATION;
                }

                new Thread(new GameControlTask()).start();
                isStart = true;
                stop = false;
                startGameBtn.setText("暂停游戏");
            } else {
                stop = true;
                isStart = false;
                startGameBtn.setText("开始游戏");
            }
        }
    }

    private class GameControlTask implements Runnable {

        @Override
        public void run() {

            while (!stop) {
                cellMatrix.transform();
                showMatrix();

                
                try {
                    TimeUnit.MILLISECONDS.sleep(duration);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

}

