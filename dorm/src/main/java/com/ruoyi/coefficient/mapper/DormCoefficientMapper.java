package com.ruoyi.coefficient.mapper;

import java.util.List;
import com.ruoyi.coefficient.domain.DormCoefficient;

/**
 * 每人天公摊费用Mapper接口
 * 
 * @author qqq
 * @date 2022-05-03
 */
public interface DormCoefficientMapper 
{
    /**
     * 查询每人天公摊费用
     * 
     * @param id 每人天公摊费用主键
     * @return 每人天公摊费用
     */
    public DormCoefficient selectDormCoefficientById(Long id);

    /**
     * 查询每人天公摊费用列表
     * 
     * @param dormCoefficient 每人天公摊费用
     * @return 每人天公摊费用集合
     */
    public List<DormCoefficient> selectDormCoefficientList(DormCoefficient dormCoefficient);

    /**
     * 新增每人天公摊费用
     * 
     * @param dormCoefficient 每人天公摊费用
     * @return 结果
     */
    public int insertDormCoefficient(DormCoefficient dormCoefficient);

    /**
     * 修改每人天公摊费用
     * 
     * @param dormCoefficient 每人天公摊费用
     * @return 结果
     */
    public int updateDormCoefficient(DormCoefficient dormCoefficient);

    /**
     * 删除每人天公摊费用
     * 
     * @param id 每人天公摊费用主键
     * @return 结果
     */
    public int deleteDormCoefficientById(Long id);

    /**
     * 批量删除每人天公摊费用
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDormCoefficientByIds(Long[] ids);
}
