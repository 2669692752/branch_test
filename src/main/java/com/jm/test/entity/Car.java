package com.jm.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 车辆表
 * </p>
 *
 * @author yx
 * @since 2019-07-05
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
public class Car {

    private static final long serialVersionUID = 1L;

    @TableId(value = "car_id", type = IdType.AUTO)
    private Integer carId;

    /**
     * 名称
     */
    private String carName;

    /**
     * 车牌
     */
    private String carLicence;

    private LocalDateTime addtime;


}
