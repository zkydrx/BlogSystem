package com.duan.blogos.service.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created on 2018/9/24.
 *
 * @author DuanJiaNing
 */
@Data
public class BlogLabelRela implements Serializable {

    private Long id;

    private Long blogId;

    private Long labelId;

    private Date insertTime;

}
