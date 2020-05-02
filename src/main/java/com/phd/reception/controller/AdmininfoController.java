package com.phd.reception.controller;



import com.baomidou.mybatisplus.extension.api.ApiController;
import com.phd.reception.service.AdmininfoService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * (Admininfo)表控制层
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:46:07
 */
@Controller
public class AdmininfoController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private AdmininfoService admininfoService;


}