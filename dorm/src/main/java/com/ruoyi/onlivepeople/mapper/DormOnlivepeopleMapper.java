package com.ruoyi.onlivepeople.mapper;

import java.util.List;
import com.ruoyi.onlivepeople.domain.DormOnlivepeople;

/**
 * 登记入住人员Mapper接口
 * 
 * @author qqq
 * @date 2022-04-13
 */
public interface DormOnlivepeopleMapper 
{
    /**
     * 查询登记入住人员
     * 
     * @param id 登记入住人员主键
     * @return 登记入住人员
     */
    public DormOnlivepeople selectDormOnlivepeopleById(Long id);

    /**
     * 根据身份证查询登记入住人员
     *
     * @param IDnumber 登记入住人员身份证
     * @return 登记入住人员
     */
    public DormOnlivepeople selectDormOnlivepeopleByIDnumber(String IDnumber);

    /**
     * 查询登记入住人员列表
     * 
     * @param dormOnlivepeople 登记入住人员
     * @return 登记入住人员集合
     */
    public List<DormOnlivepeople> selectDormOnlivepeopleList(DormOnlivepeople dormOnlivepeople);

    /**
     * 新增登记入住人员
     * 
     * @param dormOnlivepeople 登记入住人员
     * @return 结果
     */
    public int insertDormOnlivepeople(DormOnlivepeople dormOnlivepeople);

    /**
     * 修改登记入住人员
     * 
     * @param dormOnlivepeople 登记入住人员
     * @return 结果
     */
    public int updateDormOnlivepeople(DormOnlivepeople dormOnlivepeople);

    /**
     * 删除登记入住人员
     * 
     * @param id 登记入住人员主键
     * @return 结果
     */
    public int deleteDormOnlivepeopleById(Long id);

    /**
     * 批量删除登记入住人员
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDormOnlivepeopleByIds(Long[] ids);
}
