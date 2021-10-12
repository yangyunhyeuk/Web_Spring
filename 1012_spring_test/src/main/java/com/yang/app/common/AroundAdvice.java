package com.yang.app.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


/*aop를 지원하는 컨테이너의 특성을 사용하겠다. aspect를 보고 위빙처리가 일어난다. 
aspect == 위빙 처리의 대상 == 포인트컷과 어드바이스의 결합
포인트컷은 common에 묶어서 쓰고, aspect 처리가 될 예정이라고 명시해줘야한다. 
존재를 파악하고 있어야 걸어두는 것이라고 할 수 있다. 
포인트컷과 어드바이스의 결합 == aspect
component는 해당 클래스가 언제쓰이게 되는지 파악이 어려워 스프링컨테이너가 관리를 편하게 하기 위해서 service 를 명시해 준것이다. */

@Service
@Aspect
public class AroundAdvice {
	
	@Around("PointCutCommon.allPointcut()")
	public Object printLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("★★★★== [매번 실행 소요시간 출력 AroundAdvice 입장] ==★★★★");
		System.out.println("메서드명: "+pjp.getSignature().getName());
		StopWatch sw=new StopWatch();
		
		sw.start();
		
		Object obj = pjp.proceed();
		
		sw.stop();
		
		System.out.println("소요시간: "+sw.getTotalTimeMillis());
		System.out.println("★★★★== [매번 실행 소요시간 출력 AroundAdvice 퇴장] ==★★★★");
		return obj;
	}
}
