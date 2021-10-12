package com.yang.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {

	@Before("PointCutCommon.getPointcut()")
	public void printLog() {
		System.out.println("★★★★[get 메서드 실행 전 BeforeAdvice] 데이터 출력이 시작됩니다..★★★★");
	}

}
