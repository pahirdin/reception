package com.phd.reception.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.phd.reception.entity.Leave;
import com.phd.reception.service.LeaveService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 请假条表(Leave)表控制层
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Controller
public class LeaveController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private LeaveService leaveService;


}