package com.qst.dms.dos;

import java.util.ArrayList;
import java.util.Scanner;

import com.qst.dms.entity.LogRec;
import com.qst.dms.entity.MatchedLogRec;
import com.qst.dms.entity.MatchedTransport;
import com.qst.dms.entity.Transport;
import com.qst.dms.gather.LogRecAnalyse;
import com.qst.dms.gather.TransportAnalyse;
import com.qst.dms.service.LogRecService;
import com.qst.dms.service.TransportService;

public class MenuDriver {
	public static void main(String[] args) {
		// 建立一个从键盘接收数据的扫描器
		Scanner scanner = new Scanner(System.in);

		// 创建一个泛型ArrayList集合存储日志数据
		ArrayList<LogRec> logRecList = new ArrayList<>();
		// 创建一个泛型ArrrayList集合存储物流数据
		ArrayList<Transport> transportList = new ArrayList<>();

		// 创建一个日志业务类
		LogRecService logService = new LogRecService();
		// 创建一个物流业务类
		TransportService tranService = new TransportService();

		// 日志数据匹配集合
		ArrayList<MatchedLogRec> matchedLogs = null;
		// 物流数据匹配集合
		ArrayList<MatchedTransport> matchedTrans = null;

		//try {
			while (true) {
				// 输出菜单界面，待补充 
				System.out.println("****************主菜单****************");
				System.out.println("*1.数据采集"+"\t"+"2.数据匹配*");
				System.out.println("*3.数据记录"+"\t"+"4.数据显示*");
				System.out.println("*5.数据发送"+"\t"+"0.退出应用*");
				System.out.println("**************************************");

				// 提示用户输入要操作的菜单项
				System.out.println("请输入菜单项（0~5）：");

				// 接收键盘输入的选项
				int choice = scanner.nextInt();

				switch (choice) {

				case 1: {
					System.out.println("请输入采集数据类型：1.日志    2.物流");
					// 接收键盘输入的选项
					int type = scanner.nextInt();
					if (type == 1) {
						System.out.println("正在采集日志数据，请输入正确信息，确保数据的正常采集！");
						// 采集日志数据 √
						LogRec log = logService.inputLog();
						// 将采集的日志数据添加到logRecList集合中 √
						logRecList.add(log);
					} else if (type == 2) {
						System.out.println("正在采集物流数据，请输入正确信息，确保数据的正常采集！");
						// 采集物流数据
						Transport tran = tranService.inputTransport();
						// 将采集的物流数据添加到transportList集合中
						transportList.add(tran);
					}
				}
					break;
				case 2: {
					System.out.println("请输入匹配数据类型：1.日志    2.物流");
					// 接收键盘输入的选项
					int type = scanner.nextInt();
					
					if (type == 1) {
						System.out.println("正在日志数据过滤匹配...");
						LogRecAnalyse logAn = new LogRecAnalyse(logRecList);
						//System.out.println("create...");
						
						logAn.doFilter();
						//System.out.println("filter...");

						matchedLogs = logAn.matchData();
						//matchedLogs.addAll(logAn.matchData());
						//System.out.println("match...");
						System.out.println("match"+matchedLogs.size());
						System.out.println("日志数据过滤匹配完成！");
						
					} else if (type == 2) {
						System.out.println("正在物流数据过滤匹配...");
						// 创建物流数据分析对象
						TransportAnalyse transAn = new TransportAnalyse(transportList);
						// 物流数据过滤
						transAn.doFilter();
						// 物流数据分析
						matchedTrans = transAn.matchData();
						//matchedTrans.addAll(transAn.matchData());
						System.out.println("物流数据过滤匹配完成！");
					}
				}
					break;
				case 3:
				{
					//√
					System.out.println("请输入记录数据类型：1.日志    2.物流");
					// 接收键盘输入的选项
					int type = scanner.nextInt();
					
					if (type == 1) {
						System.out.println("数据记录中...");
						//日志数据存入
						logService.saveMatchLog(matchedLogs);
						logService.saveMatchLogToDB(matchedLogs);
						System.out.println("日志数据记录完成！");
						matchedLogs.clear();
						
					} else if (type == 2) {
						System.out.println("数据记录中...");
						// 物流数据存入
						tranService.saveMatchedTransport(matchedTrans);	
						tranService.saveMatchTransportToDB(matchedTrans);
						System.out.println("物流数据记录完成！");
						matchedTrans.clear();
					}
					
					
					break;
				}
				case 4: {
					
					//从日志匹配集合中判断匹配的日志记录，并输出匹配的日志信息 √
					//matchedLogs=logService.readMatchLog();
				
					
						 
						    System.out.println("显示从文件中读取的日志数据：");
						    matchedLogs = logService.readMatchLog();
						 	//System.out.println("read end"+matchedLogs.size());
						 	logService.showMatchLog(matchedLogs);
						 	
						 	if (matchedLogs == null || matchedLogs.size() == 0) 
								System.out.println("文件中匹配的日志记录是0条！");
						 	
						 	System.out.println("显示从数据库中读取的日志数据：");
						    matchedLogs = logService.readMatchedLogFromDB();
						 	logService.showMatchLog(matchedLogs);
						 	if (matchedLogs == null || matchedLogs.size() == 0) 
								System.out.println("数据库中匹配的日志记录是0条！");
						 
					//从物流匹配集合中判断匹配的物流记录
					//matchedTrans=tranService.readMatchedTransport();

						// 输出匹配的物流信息
						System.out.println("显示从文件中读取的物流数据：");
						matchedTrans = tranService.readMatchedTransport();
						//System.out.println("read end"+matchedTrans.size());
						tranService.showMatchTransport(matchedTrans);
						if (matchedTrans == null || matchedTrans.size() == 0) 
							System.out.println("文件中匹配的物流记录是0条！");
						
						System.out.println("显示从数据库中读取的物流数据：");
						matchedTrans = tranService.readMatchedTransportFromDB();
						tranService.showMatchTransport(matchedTrans);
						if (matchedTrans == null || matchedTrans.size() == 0) 
							System.out.println("数据库中匹配的物流记录是0条！");
					
				}
					break;
				case 5:
					System.out.println("数据发送中...");
					break;
				case 0:
					// 应用程序退出
					System.exit(0);
				default:
					System.out.println("请输入正确的菜单项（0~5）！");
				}

			}
		//} catch (Exception e) {
		//	System.out.println("输入的数据不合法！");
		//}
	}
}
