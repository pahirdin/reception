package com.phd.reception.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.phd.reception.entity.Leavepicture;
import com.phd.reception.mapper.LeavepictureMapper;
import com.phd.reception.service.LeavepictureService;
import org.springframework.stereotype.Service;

/**
 * 请假图片表(Leavepicture)表服务实现类
 *
 * @author pahaied@asiainfo.com
 * @since 2020-05-01 16:48:31
 */
@Service("leavepictureService")
public class LeavepictureServiceImpl extends ServiceImpl<LeavepictureMapper, Leavepicture> implements LeavepictureService {

}