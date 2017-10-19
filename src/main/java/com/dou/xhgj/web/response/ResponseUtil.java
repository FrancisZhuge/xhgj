package com.dou.xhgj.web.response;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author: Francis Zhuge
 * @Description:
 * @Date: Created in 2017/10/16, 14:37
 * @Modified By:
 * @Email: franciszhuge@163.com
 */
public class ResponseUtil {
    /**
     * 服务器错误返回模板
     * @return
     */
    public static String responseServerError(){
        AjaxBody ajaxBody = new AjaxBody();
        ajaxBody.setCode(ResponseCode.F_SERVER_ERROR);
        return ajaxBody.toString();
    }

    /**
     * 服务器正常返回数据
     * @param data
     * @return
     */
    public static String responseOkWithData(JSONObject data){
        AjaxBody ajaxBody = new AjaxBody();
        ajaxBody.setCode(ResponseCode.S_OK);
        ajaxBody.setData(data);
        return ajaxBody.toString();
    }

    /**
     * 参数错误返回模板
     * @return
     */
    public static String responseIllegalArgus(){
        AjaxBody ajaxBody = new AjaxBody();
        ajaxBody.setCode(ResponseCode.F_ILLEGAL_ARGUS);
        return ajaxBody.toString();
    }

    /**
     * 带有一个error的错误返回
     * @param error
     * @return
     */
    public static String responseServerError(String error){
        AjaxBody ajaxBody = new AjaxBody();
        ajaxBody.setCode(ResponseCode.F_SERVER_ERROR);
        ajaxBody.setError(error);
        return ajaxBody.toString();
    }

    /**
     * 服务器正常
     * @return
     */
    public static String responseOk(){
        AjaxBody ajaxBody = new AjaxBody();
        ajaxBody.setCode(ResponseCode.S_OK);
        return ajaxBody.toString();
    }

    /**
     * 参数错误返回模板
     * @return
     */
    public static String responseIllegalArgus(String error){
        AjaxBody ajaxBody = new AjaxBody();
        ajaxBody.setCode(ResponseCode.F_ILLEGAL_ARGUS);
        ajaxBody.setError(error);
        return ajaxBody.toString();
    }
}
