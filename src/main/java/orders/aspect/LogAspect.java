package orders.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

@Component
@Aspect
public class LogAspect {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GaugeService gaugeService;

    @Autowired
    private CounterService counterService;

    @Autowired(required = false)
    HttpServletRequest request;

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping) ||" +
            "@annotation(org.springframework.web.bind.annotation.PostMapping) ||" +
            "@annotation(org.springframework.web.bind.annotation.DeleteMapping) ||" +
            "@annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void allResources() {
    }

    @Before("allResources()")
    public void apiRequestLog(JoinPoint joinPoint) {

        counterService.increment("meter." + joinPoint.getSignature().getName().toLowerCase());

        log.info("\n\n");
        log.info("----------------------------------------------------------");
        log.info("Entering in Method :  " + joinPoint.getSignature().getName());
        log.info("Class Name :  " + joinPoint.getSignature().getDeclaringTypeName());
        log.info("Arguments :  " + Arrays.toString(joinPoint.getArgs()).toString());
        argumentToString(joinPoint.getArgs());
        log.info("Target class : " + joinPoint.getTarget().getClass().getName());

        if (null != request) {
            log.info("Start Header Section of request ");
            log.info("Method Type : " + request.getMethod());
            Enumeration headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = (String) headerNames.nextElement();
                String headerValue = request.getHeader(headerName);
                log.info("Header Name: " + headerName + " Header Value : " + headerValue);
            }
            log.info("Request Path info :" + request.getServletPath());
            log.info("End Header Section of request");
        }
    }

    private void argumentToString(Object[] args) {

        ObjectMapper mapper = new ObjectMapper();
        Arrays.stream(args).forEach(argument -> {
            try {
                log.info("Content of the argument: " + mapper.writeValueAsString(argument));
            } catch (JsonProcessingException e) {
                log.info("Impossible to log " + args[0]);
            }
        });
    }
}
