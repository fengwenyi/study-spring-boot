package com.fengwenyi.studyspringbootjsonview.vo;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Builder;
import lombok.Data;

/**
 * @author Erwin Feng
 * @since 2021-01-12
 */
@Data
public class UserResponseVo {

    public interface SimpleView {}
    public interface DetailView extends SimpleView {}

    @JsonView(SimpleView.class)
    private String id;

    @JsonView(SimpleView.class)
    private String name;

    @JsonView(DetailView.class)
    private Integer age;

    @JsonView(DetailView.class)
    private String gender;
}
