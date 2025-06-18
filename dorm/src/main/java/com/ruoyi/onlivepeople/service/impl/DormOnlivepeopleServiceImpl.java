package com.ruoyi.onlivepeople.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.onlivepeople.mapper.DormOnlivepeopleMapper;
import com.ruoyi.onlivepeople.domain.DormOnlivepeople;
import com.ruoyi.onlivepeople.service.IDormOnlivepeopleService;

/**
 * 登记入住人员Service业务层处理
 * 
 * @author qqq
 * @date 2022-04-13
 */
@Service
public class DormOnlivepeopleServiceImpl implements IDormOnlivepeopleService 
{
    @Autowired
    private DormOnlivepeopleMapper dormOnlivepeopleMapper;

    /**
     * 查询登记入住人员
     * 
     * @param id 登记入住人员主键
     * @return 登记入住人员
     */
    @Override
    public DormOnlivepeople selectDormOnlivepeopleById(Long id)
    {
        return dormOnlivepeopleMapper.selectDormOnlivepeopleById(id);
    }

    /**
     * 根据身份证查询登记入住人员
     *
     * @param IDnumber 登记入住人员身份证
     * @return 登记入住人员
     */
    @Override
    public DormOnlivepeople selectDormOnlivepeopleByIDnumber(String IDnumber)
    {
        return dormOnlivepeopleMapper.selectDormOnlivepeopleByIDnumber(IDnumber);
    }

    /**
     * 查询登记入住人员列表
     * 
     * @param dormOnlivepeople 登记入住人员
     * @return 登记入住人员
     */
    @Override
    public List<DormOnlivepeople> selectDormOnlivepeopleList(DormOnlivepeople dormOnlivepeople)
    {
        return dormOnlivepeopleMapper.selectDormOnlivepeopleList(dormOnlivepeople);
    }

    /**
     * 新增登记入住人员
     * 
     * @param dormOnlivepeople 登记入住人员
     * @return 结果
     */
    @Override
    public int insertDormOnlivepeople(DormOnlivepeople dormOnlivepeople)
    {
        return dormOnlivepeopleMapper.insertDormOnlivepeople(dormOnlivepeople);
    }

    /**
     * 修改登记入住人员
     * 
     * @param dormOnlivepeople 登记入住人员
     * @return 结果
     */
    @Override
    public int updateDormOnlivepeople(DormOnlivepeople dormOnlivepeople)
    {
        return dormOnlivepeopleMapper.updateDormOnlivepeople(dormOnlivepeople);
    }

    /**
     * 批量删除登记入住人员
     * 
     * @param ids 需要删除的登记入住人员主键
     * @return 结果
     */
    @Override
    public int deleteDormOnlivepeopleByIds(Long[] ids)
    {
        return dormOnlivepeopleMapper.deleteDormOnlivepeopleByIds(ids);
    }

    /**
     * 删除登记入住人员信息
     * 
     * @param id 登记入住人员主键
     * @return 结果
     */
    @Override
    public int deleteDormOnlivepeopleById(Long id)
    {
        return dormOnlivepeopleMapper.deleteDormOnlivepeopleById(id);
    }
}
