package org.datacollector.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by 哲帆 on 2018.8.22.
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
