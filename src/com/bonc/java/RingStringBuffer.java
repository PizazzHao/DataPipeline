package com.bonc.java;

//import javax.annotation.concurrent.ThreadSafe;

//@ThreadSafe
public class RingStringBuffer {
	private Integer size;

	private StringBuffer sb = new StringBuffer();;

	/**
	 * Constructor.
	 * @param size Initial size of the StringBuffer.
	 */
	public RingStringBuffer(int size){
		this.size = size;

	}


	/**
	 * Put input string to the buffer.
	 * @param input input string.
	 */
	public void put(String input){

		//获取要添加字符串的长度
		int inputLength = input.length();

		//得到总长度
		int totalLength = inputLength+sb.length();

		//判断
		if(totalLength>size){
			size += size;

		}
		sb.append(input);


	}


	/**
	 * Return the string with length from buffer.
	 *
	 * @param length the length of result string.
	 * @return the result string.
	 * @throws Exception 
	 */
	public String get(int length) throws Exception{

		//判断get的长度是否大于字符缓冲区的长度
		if(length>sb.length()){

			throw new Exception();

		}else{

			//获取到要get的字符串
			String getstring = sb.substring(0, length);

			//获取没有get的字符串
			String substring = sb.substring(length, sb.length());

			//清空sb缓冲区
			sb.delete(0, sb.length());

			//将get到的字符添加到缓冲区
			sb.append(substring);

			return getstring;

		}
	}


	/**
	 * @return return the size of the buffer.
	 */
	public int size(){

		return size;

	}
}
