package com.wujun.boot.common;

/**
 * @author wujun
 * @description
 * @date 19/4/18.
 */
public class ApplicationResourceName {

	private static String[] whiteResources = {
            "/swagger**",
            "/configuration/**",
            "/druid/**",
            "/v2/api-docs/**",
            "/webjars/**",
            "/error"
    };
	
	public static String[] whiteResources(){
		return whiteResources;
	}
}
