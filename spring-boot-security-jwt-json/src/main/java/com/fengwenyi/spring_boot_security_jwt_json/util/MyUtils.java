package com.fengwenyi.spring_boot_security_jwt_json.util;

import com.alibaba.fastjson.JSON;
import com.fengwenyi.api_result.helper.ResultHelper;
import com.fengwenyi.api_result.model.ResultModel;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/12/25
 */
public class MyUtils {

    public static void renderError(HttpServletResponse response, String message) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ResultModel<Map<String, String>> resultModel = ResultHelper.error(message);
        String str = JSON.toJSONString(resultModel);
        out.write(str);
        out.flush();
        out.close();
    }

}
