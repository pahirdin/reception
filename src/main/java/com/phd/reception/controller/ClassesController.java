package com.phd.reception.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.phd.reception.entity.Classes;
import com.phd.reception.service.ClassesService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 班级表(Classes)表控制层
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Controller
public class ClassesController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ClassesService classesService;


}