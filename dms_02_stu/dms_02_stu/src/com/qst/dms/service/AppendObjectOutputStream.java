package com.qst.dms.service;

import java.io.*;


	public class AppendObjectOutputStream extends ObjectOutputStream {

		public static  File file = null;   //总觉的在这里把这个file定义成公有静态不好，

		                                    //但是这个变量必须在构造之前被初始化。只好这么办了

		public AppendObjectOutputStream(File file) throws IOException {

			super(new FileOutputStream(file,true));

		}

			public AppendObjectOutputStream(FileOutputStream fos) throws IOException {

			super(fos);

		}
		



		public AppendObjectOutputStream(OutputStream out) throws IOException {
			super(out);
			// TODO Auto-generated constructor stub
		}


		public void writeStreamHeader() throws IOException {

					

			//System.out.println("重写的方法执行了");

			if (file != null) {

				System.out.println("file.length()="+file.length());

				if (file.length() == 0) {

				//System.out.println("文件存在但为空！！！");

					super.writeStreamHeader();

				} else {

					//System.out.println("文件不为空");  //当文件不为空时，空实现

				}

			} else {

				//System.out.println("文件不存在");

				super.writeStreamHeader();

			}

		}

	}


