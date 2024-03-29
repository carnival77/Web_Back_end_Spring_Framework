package myspring.aop.xml;
import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		//타겟 메서드의 signature 정보
		String signatureString = joinPoint.getSignature().toShortString();		
		System.out.println(signatureString + " 시작");
		
		// 타겟 메서드의 argument 정보
		for (Object arg : joinPoint.getArgs()) {
			System.out.println(signatureString + "아규먼트 : " + arg);
		}
		//타겟의 메서드가 호출되기 전의 시간 
		long start = System.currentTimeMillis();	
		
		try {
			//new Object[] {new String("dooly")}
			//타겟의 메서드 호출
			Object result = joinPoint.proceed();
			// 아래가 아닌, 위처럼 명시해줘야 한다.
//			Object result = new Object();
			return result;
		} finally {
			//타겟의 메서드가 호출된 후의 시간
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " 종료");
			System.out.println(signatureString + " 실행 시간 : " + 
			   (finish - start) + " ms");
		}
	}
}
