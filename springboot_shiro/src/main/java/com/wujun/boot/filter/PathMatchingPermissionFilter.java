package com.wujun.boot.filter;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.util.PatternMatcher;
import org.apache.shiro.web.servlet.OncePerRequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class PathMatchingPermissionFilter extends OncePerRequestFilter {
    private static final Logger logger = LoggerFactory.getLogger(PathMatchingPermissionFilter.class);

    protected PatternMatcher pathMatcher = new AntPathMatcher();


    protected SecurityManager securityManager;

    public PathMatchingPermissionFilter(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    @Override
    protected void doFilterInternal(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        /*if (!this.isLoginRequest(request, response)) {
            if (!isLogin(request)) {
            	
            	ServiceApiAuth serviceApiAuth = new ServiceApiAuth.Http(request);
            	if(serviceApiAuth.isOpen()){
            		try {
						if(request instanceof RepeatableBodyReadHttpServletRequestWrapper){
							filterChain.doFilter(request, response);
						}else{
							RepeatableBodyReadHttpServletRequestWrapper r = new RepeatableBodyReadHttpServletRequestWrapper(request);
							filterChain.doFilter(r, servletResponse);
						}
						return;
					}finally {
    					if(response.getStatus() == HttpServletResponse.SC_UNAUTHORIZED){
    						onNotLogin(request, response);
    						return;
    					}
    				}
            	}
            	
                onNotLogin(request, response);
                return;
            }
            Subject subject = SecurityUtils.getSubject();
            if (!hasPermission(request, subject)) {
                onNoPermission(request, response);
                return;
            }
        }*/
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /*protected boolean isLogin(HttpServletRequest request) {
        return AuthUtils.getSessionUser() != null;
    }

    protected boolean hasPermission(HttpServletRequest request, Subject subject) {
        PrincipalCollection principalCollection = subject.getPrincipals();
        Set<String> permissions = sweetAuthorizingRealm.getPermissions(principalCollection);
        Iterator<String> iterator = permissions.iterator();
        Object sessionUser = AuthUtils.getSessionUser();
        String uri = request.getServletPath();
        String method = request.getMethod();
        //此功能要求Shiro过滤器必须在Sweet框架RequestTraceFilter之后
        ProcessContext processContext = null;
        if (this.isLogPerformance()) {
            ThreadLocalProcessTracer tracer = ThreadLocalProcessTracer.get();
            processContext = tracer.join(ProcessContext.Type.URLPermissionFilter, "permission-path-matching");
        }
        boolean hasPermission = false;
        int counter = 0;
        while (iterator.hasNext()) {
            counter++;
            String uriPermission = iterator.next();
            //以"/"开头的才认为是url权限
            if (multiPurposeAuthorizingObjectConverter.isURLPermission(sessionUser, uriPermission)) {

                String urlPermission = uriPermission;
                String methodPermission = "";
                //判断url权限是否含有分隔符“；” 没有代表其拥有所有的方法权限，没有则拥有其添加的方法权限
                boolean hasMethod = uriPermission.contains(PERSMISSION_METHOD_SPLIT);
                if (hasMethod) {
                    urlPermission = uriPermission.split(PERSMISSION_METHOD_SPLIT)[0];
                    methodPermission = uriPermission.split(PERSMISSION_METHOD_SPLIT)[1];
                }
                if (this.pathsMatch(urlPermission, this.multiPurposeAuthorizingObjectConverter.convertURIWhenPathMatching(sessionUser, uri))) {
                    //请求的方法是否具有对应的权限
                    if (methodPermission.contains(method) || !hasMethod) {
                        hasPermission = true;
                        break;
                    }
                }
            }
        }
        if (this.isLogPerformance()) {
            //它不可能为null
            processContext.stop();
            logger.info("匹配用户【" + sessionUser + "】【" + permissions.size() + "】个权限完成, 共匹配【" + counter + "】次, 用时【" + processContext.getCost() + "】");
        }
        return hasPermission;
    }

    protected void onNotLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        disableRequestTraceLog(request);
        APIResponse apiResponse = new APIResponse(APIResponse.USER_NOT_LOGIN, this.shiroAuthService.getLoginUrl());
        String output = jsonSerializer.serialize2JSON(apiResponse);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(output);
    }

    protected void onNoPermission(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        disableRequestTraceLog(request);
        APIResponse apiResponse = new APIResponse(APIResponse.UNAUTHORIZED);
        String output = jsonSerializer.serialize2JSON(apiResponse);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(output);
    }

    protected void disableRequestTraceLog(HttpServletRequest request) {
        ThreadLocalProcessTracer tracer = ThreadLocalProcessTracer.get();
        tracer.disableThisTraceLog();
    }

    protected String getPathWithinApplication(ServletRequest request) {
        return WebUtils.getPathWithinApplication(WebUtils.toHttp(request));
    }

    protected boolean pathsMatch(String path, ServletRequest request) {
        String requestURI = this.getPathWithinApplication(request);
        return this.pathsMatch(path, requestURI);
    }

    protected boolean pathsMatch(String pattern, String path) {
        return this.pathMatcher.matches(pattern, path);
    }

    protected boolean isLoginRequest(ServletRequest request, ServletResponse response) {
        return this.pathsMatch(this.shiroAuthService.getLoginUrl(), request);
    }

    public boolean isLogPerformance() {
        return logPerformance;
    }

    public void setLogPerformance(boolean logPerformance) {
        this.logPerformance = logPerformance;
    }

    //    protected boolean isLoginSubmission(ServletRequest request, ServletResponse response) {
//        return request instanceof HttpServletRequest && WebUtils.toHttp(request).getMethod().equalsIgnoreCase("POST");
//    }*/
}
