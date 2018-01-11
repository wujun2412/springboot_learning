package com.wujun.responses;

/**
 * @author wujun
 * @description
 * @date 18/1/11.
 */
public class Response {
    private Response(){};

    private static Response response = new Response();

    public static Response success(){
        return response;
    }

}
