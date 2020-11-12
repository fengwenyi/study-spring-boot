package com.fengwenyi.springboot.logback;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import java.util.Objects;

import static com.fengwenyi.springboot.logback.ProjectContext.CONTEXT_KEY;

/**
 * @author Erwin Feng
 * @since 2020-11-12
 */
public class FeignClientInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        try {
            ProjectContext projectContext = ProjectContext.getContext();
            if (Objects.nonNull(projectContext)) {
                requestTemplate.header(CONTEXT_KEY, projectContext.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
