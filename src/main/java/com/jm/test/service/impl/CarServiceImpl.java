package com.jm.test.service.impl;

import com.jm.test.entity.Car;
import com.jm.test.mapper.CarMapper;
import com.jm.test.service.ICarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 车辆表 服务实现类
 * </p>
 *
 * @author yx
 * @since 2019-07-05
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements ICarService {

}
