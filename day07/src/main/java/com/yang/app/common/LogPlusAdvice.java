package com.yang.app.common;

public class LogPlusAdvice {
	public void printPlusLog() {
		System.out.println("업그레이드된 로그");
		// 높은 응집도
		// 변경하고 싶을 때 여기서 멘트가 바꾸면 된다.
	}
}
