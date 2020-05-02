package com.phd.reception.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.phd.reception.entity.Studentinfo;
import com.phd.reception.service.StudentinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Studentinfo)表控制层
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Controller
public class StudentinfoController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private StudentinfoService studentinfoService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param studentinfo 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Studentinfo> page, Studentinfo studentinfo) {
        return success(this.studentinfoService.page(page, new QueryWrapper<>(studentinfo)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.studentinfoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param studentinfo 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Studentinfo studentinfo) {
        return success(this.studentinfoService.save(studentinfo));
    }

    /**
     * 修改数据
     *
     * @param studentinfo 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Studentinfo studentinfo) {
        return success(this.studentinfoService.updateById(studentinfo));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.studentinfoService.removeByIds(idList));
    }
}