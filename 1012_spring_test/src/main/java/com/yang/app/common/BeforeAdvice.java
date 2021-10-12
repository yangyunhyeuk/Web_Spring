package com.yang.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice {

	@Before("PointCutCommon.getPointcut()")
	public void printLog() {
		System.out.println("�ڡڡڡ�[get �޼��� ���� �� BeforeAdvice] ������ ����� ���۵˴ϴ�..�ڡڡڡ�");
	}

}
