package com.yang.app.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCutCommon {
	// ���� �޼���
	// �����̽��� ����Ʈ���� "�ĺ�"�ϱ����� �ۼ�
	// ������ �ۼ����ʿ�xxx. {}�ٵ���� �������
	@Pointcut("execution(* model..*Impl.get*(..))")
	public void getPointcut() {
	}

	@Pointcut("execution(* model..*Impl.*(..))")
	public void allPointcut() {
	}
	
}
