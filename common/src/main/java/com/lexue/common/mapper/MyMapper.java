package com.lexue.common.mapper;


import com.lexue.common.model.Page;
import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;
import java.util.List;

/**
 * @author zsl
 * @date 2022-07-04
 */


@SuppressWarnings("unused")
public interface MyMapper<T> extends Mapper<T>, ConditionMapper<T> {

    T getModelById(T t);

    int add(T t);

    int updateById(T t);

    List<T> getList(Page page, T t);

    List<T> getList();

    List<T> getListByWhere(T t, Page page);

    int getCount(T t);

    boolean existsById(T t);
}