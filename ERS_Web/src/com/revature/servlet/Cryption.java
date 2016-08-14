package com.revature.servlet;

public class Cryption {
	private static final int KEY1 = 5;
	private static final int KEY2 = 5;
	
	public String encrypt(String passwd){
		return pEncrypt(passwd);
	}
	public String decrypt(String cryption){
		return pDecrypt(cryption);
	}
	private String pEncrypt(String passwd) {
		char temp;
		char[] split = passwd.toCharArray();
		passwd = "";
		for(int i=0;i<KEY2;i++){
			temp = (char)(Math.random()*126);
			passwd += ""+temp;
		}
		for(char c:split){
			c+=KEY1;
			passwd += c;
		}
		for(int i=0;i<KEY2;i++){
			temp = (char)(Math.random()*126);
			passwd += ""+temp;
		}
		return passwd;
	}
	private String pDecrypt(String cryption){
		int temp = cryption.length();
		char[] split = cryption.toCharArray();
		cryption = "";
		for(int i=KEY2;i<(temp-KEY2);i++){
			split[i]-=KEY1;
			cryption += split[i];
		}
		return cryption;
	}
}
