package com.cdf.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cdf.dao.entity.Username;

@Aspect
public class AuthenticationInterceptor {

	@Pointcut("execution(* com.cdf.web.controller.LoginController.*Param*(..)) ")
	public void validateUser() {
	}

	/**
	 * 
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("com.cdf.web.interceptor.AuthenticationInterceptor.validateUser()")
	public Object redirectToNoUser(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Inside Aspect - redirectToNoUser");

		ServletRequestAttributes currentRequestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		HttpServletRequest request = currentRequestAttributes.getRequest();
		HttpSession session = request.getSession(true);

		if (session != null) {
			Username user = (Username) session.getAttribute("sessionUsername");

			if (user == null) {

				System.out.println("There's no user in session: "
						+ session.getId());
				
				//ModelAndView mav = new ModelAndView();
				//mav.setViewName("no_user");
				
				return "no_user";

			}
		}

		return pjp.proceed();
	}

}
