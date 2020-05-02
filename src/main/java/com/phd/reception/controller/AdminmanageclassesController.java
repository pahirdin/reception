package com.phd.reception.controller;



import com.baomidou.mybatisplus.extension.api.ApiController;
import com.phd.reception.service.AdminmanageclassesService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * 辅导员管理班级表(Adminmanageclasses)表控制层
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Controller
public class AdminmanageclassesController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private AdminmanageclassesService adminmanageclassesService;

}