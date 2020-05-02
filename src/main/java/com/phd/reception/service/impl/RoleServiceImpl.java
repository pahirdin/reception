package com.phd.reception.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phd.reception.entity.Role;
import com.phd.reception.mapper.RoleMapper;
import com.phd.reception.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * 角色表(Role)表服务实现类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}