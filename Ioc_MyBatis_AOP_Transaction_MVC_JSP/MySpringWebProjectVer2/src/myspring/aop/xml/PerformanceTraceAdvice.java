package myspring.aop.xml;
import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		//Ÿ�� �޼����� signature ����
		String signatureString = joinPoint.getSignature().toShortString();		
		System.out.println(signatureString + " ����");
		
		// Ÿ�� �޼����� argument ����
		for (Object arg : joinPoint.getArgs()) {
			System.out.println(signatureString + "�ƱԸ�Ʈ : " + arg);
		}
		//Ÿ���� �޼��尡 ȣ��Ǳ� ���� �ð� 
		long start = System.currentTimeMillis();	
		
		try {
			//new Object[] {new String("dooly")}
			//Ÿ���� �޼��� ȣ��
			Object result = joinPoint.proceed();
			// �Ʒ��� �ƴ�, ��ó�� �������� �Ѵ�.
//			Object result = new Object();
			return result;
		} finally {
			//Ÿ���� �޼��尡 ȣ��� ���� �ð�
			long finish = System.currentTimeMillis();
			System.out.println(signatureString + " ����");
			System.out.println(signatureString + " ���� �ð� : " + 
			   (finish - start) + " ms");
		}
	}
}
