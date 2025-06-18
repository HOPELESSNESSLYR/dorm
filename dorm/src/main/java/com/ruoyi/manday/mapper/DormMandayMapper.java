package com.ruoyi.manday.mapper;

import java.util.List;
import com.ruoyi.manday.domain.DormManday;

/**
 * 每月入住天数临时Mapper接口
 * 
 * @author qqq
 * @date 2022-05-03
 */
public interface DormMandayMapper 
{
    /**
     * 查询每月入住天数临时
     * 
     * @param id 每月入住天数临时主键
     * @return 每月入住天数临时
     */
    public DormManday selectDormMandayById(Long id);

    /**
     * 查询每月入住天数临时列表
     * 
     * @param dormManday 每月入住天数临时
     * @return 每月入住天数临时集合
     */
    public List<DormManday> selectDormMandayList(DormManday dormManday);

    /**
     * 新增每月入住天数临时
     * 
     * @param dormManday 每月入住天数临时
     * @return 结果
     */
    public int insertDormManday(DormManday dormManday);

    /**
     * 修改每月入住天数临时
     * 
     * @param dormManday 每月入住天数临时
     * @return 结果
     */
    public int updateDormManday(DormManday dormManday);

    /**
     * 删除每月入住天数临时
     * 
     * @param id 每月入住天数临时主键
     * @return 结果
     */
    public int deleteDormMandayById(Long id);

    /**
     * 批量删除每月入住天数临时
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDormMandayByIds(Long[] ids);
}
