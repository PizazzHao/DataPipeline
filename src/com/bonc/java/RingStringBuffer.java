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

		//��ȡҪ����ַ����ĳ���
		int inputLength = input.length();

		//�õ��ܳ���
		int totalLength = inputLength+sb.length();

		//�ж�
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

		//�ж�get�ĳ����Ƿ�����ַ��������ĳ���
		if(length>sb.length()){

			throw new Exception();

		}else{

			//��ȡ��Ҫget���ַ���
			String getstring = sb.substring(0, length);

			//��ȡû��get���ַ���
			String substring = sb.substring(length, sb.length());

			//���sb������
			sb.delete(0, sb.length());

			//��get�����ַ���ӵ�������
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
