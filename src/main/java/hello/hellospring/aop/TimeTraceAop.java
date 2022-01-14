package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect//aop 어노테이션
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))") //범위조정
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{

        long start = System.currentTimeMillis();
        System.out.println("시작: " + start);

        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("끝: " + joinPoint.toString() + " " + timeMs + "ms");

        }


    }

}
