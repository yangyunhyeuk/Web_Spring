package com.yang.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCutCommon {
	// 참조 메서드
	// 어드바이스가 포인트컷을 "식별"하기위해 작성
	// 로직은 작성할필요xxx. {}바디블럭이 비어있음
	@Pointcut("execution(* model..*Impl.get*(..))")
	public void getPointcut() {
	}

	@Pointcut("execution(* model..*Impl.*(..))")
	public void allPointcut() {
	}
	
}
