package com.lexue.common.service;

import com.github.pagehelper.PageHelper;
import com.lexue.common.mapper.MyMapper;
import com.lexue.common.model.Page;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zsl
 * @date 2022-07-04
 */


public class BaseService<T> implements MyMapper<T> {
    @Resource
    private MyMapper<T> mapper;

    @Override
    public T getModelById(T t) {
        return mapper.selectByPrimaryKey(t);

    }

    @Override
    public int add(T t) {
        return mapper.insert(t);

    }

    @Override
    public int updateById(T user) {
        return mapper.updateByPrimaryKey(user);
    }


    /**
     * 查询所有记录
     * @return List
     */
    @Override
    public List<T> getList(Page page, T t) {

        Example example = new Example(t.getClass());
        example.orderBy("ord");
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("deleted","0");
        Integer s = page.getCurrentPageNum();
        PageHelper.startPage(s,page.getPageSize());
        List<T> dataList = mapper.selectByExample(example);
        page.setObjectList(dataList);
        return dataList;
    }

    @Override
    public List<T> getList() {

        List<T> dataList =  mapper.selectAll();
        return dataList;
    }

    @Override
    public List<T> getListByWhere(T t,Page page) {
        PageHelper.startPage(page.getCurrentPageNum(),page.getPageSize());
        return mapper.select(t);
    }



    /**
     * 根据条件查询条数
     * @param t entity
     * @return int
     */
    @Override
    public int getCount(T t) {
        return mapper.selectCount(t);
    }

    @Override
    public boolean existsById(T t) {
        return mapper.existsWithPrimaryKey(t);
    }


    @Override
    public int deleteByPrimaryKey(Object o) {
        return mapper.deleteByPrimaryKey(o);
    }

    @Override
    public int delete(T t) {
        return mapper.delete(t);
    }

    @Override
    public int insert(T t) {
        return mapper.insert(t);
    }

    @Override
    public int insertSelective(T t) {
        return mapper.insertSelective(t);
    }

    @Override
    public boolean existsWithPrimaryKey(Object o) {
        return mapper.existsWithPrimaryKey(o);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public T selectByPrimaryKey(Object o) {
        return mapper.selectByPrimaryKey(o);
    }

    @Override
    public int selectCount(T t) {
        return mapper.selectCount(t);
    }

    @Override
    public List<T> select(T t) {
        return null;
    }

    @Override
    public T selectOne(T t) {
        return null;
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(T t) {
        return 0;
    }

    @Override
    public int deleteByExample(Object o) {
        return 0;
    }

    @Override
    public List<T> selectByExample(Object o) {
        return null;
    }

    @Override
    public int selectCountByExample(Object o) {
        return 0;
    }

    @Override
    public T selectOneByExample(Object o) {
        return null;
    }

    @Override
    public int updateByExample(T t, Object o) {
        return 0;
    }

    @Override
    public int updateByExampleSelective(T t, Object o) {
        return 0;
    }

    @Override
    public List<T> selectByExampleAndRowBounds(Object o, RowBounds rowBounds) {
        return null;
    }

    @Override
    public List<T> selectByRowBounds(T t, RowBounds rowBounds) {
        return null;
    }

    @Override
    public int deleteByCondition(Object o) {
        return 0;
    }

    @Override
    public List<T> selectByCondition(Object o) {
        return null;
    }

    @Override
    public int selectCountByCondition(Object o) {
        return 0;
    }

    @Override
    public int updateByCondition(T t, Object o) {
        return 0;
    }

    @Override
    public int updateByConditionSelective(T t, Object o) {
        return 0;
    }
}