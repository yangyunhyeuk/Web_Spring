package com.yang.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


/*aop�� �����ϴ� �����̳��� Ư���� ����ϰڴ�. aspect�� ���� ����ó���� �Ͼ��. 
aspect == ���� ó���� ��� == ����Ʈ�ư� �����̽��� ����
����Ʈ���� common�� ��� ����, aspect ó���� �� �����̶�� ���������Ѵ�. 
���縦 �ľ��ϰ� �־�� �ɾ�δ� ���̶�� �� �� �ִ�. 
����Ʈ�ư� �����̽��� ���� == aspect
component�� �ش� Ŭ������ �������̰� �Ǵ��� �ľ��� ����� �����������̳ʰ� ������ ���ϰ� �ϱ� ���ؼ� service �� ����� �ذ��̴�. */

@Service
@Aspect
public class AroundAdvice {
	
	@Around("PointCutCommon.allPointcut()")
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("�ڡڡڡ�== [�Ź� ���� �ҿ�ð� ��� AroundAdvice ����] ==�ڡڡڡ�");
		System.out.println("�޼����: "+pjp.getSignature().getName());
		StopWatch sw=new StopWatch();
		
		sw.start();
		
		Object obj = pjp.proceed();
		
		sw.stop();
		
		System.out.println("�ҿ�ð�: "+sw.getTotalTimeMillis());
		System.out.println("�ڡڡڡ�== [�Ź� ���� �ҿ�ð� ��� AroundAdvice ����] ==�ڡڡڡ�");
		return obj;
	}
}
