package com.revature.validation;

public class CreditCardCheck {
	
	public static boolean isValid(String cardNum) {
		if(cardNum == null) {
			return false;
		}
		if(cardNum.length()<14 || cardNum.length()>19) {
			return false;
		}
		
		StringBuilder strBuild = new StringBuilder(cardNum).reverse();
		
		int checkDigit = Character.getNumericValue(strBuild.charAt(0));
		strBuild = strBuild.deleteCharAt(0);
		
		int sum = 0;
		
		String str = strBuild.toString();
		
		for(int i=0 ; i<str.length() ; i++) {
			if((i+1)%2 == 0) {
				sum += doubleDigit(Character.getNumericValue(str.charAt(i)));
			}
			else {
				sum += Character.getNumericValue(str.charAt(i));
			}
		}
		String sumStr = String.valueOf(sum);
		int finalDigit = 10 - Character.getNumericValue(sumStr.charAt(sumStr.length()-1));
		
		if(finalDigit == checkDigit) {
			return true;
		}
		
		return false;
	}
	
	public static int doubleDigit(int val) {
		int prod = val*2;
		if(prod<=9) {
			return prod;
		}
		else {
			String[] digits = String.valueOf(prod).split("");
			return Integer.valueOf(digits[0]) + Integer.valueOf(digits[1]);
		}
	}

}
