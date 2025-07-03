package com.ruoyi.feeperson.mapper;

import java.util.List;
import com.ruoyi.feeperson.domain.FeePerson;

/**
 * 个人费用Mapper接口
 * 
 * @author lyr
 * @date 2025-07-01
 */
public interface FeePersonMapper 
{
    /**
     * 查询个人费用
     * 
     * @param feepersonId 个人费用主键
     * @return 个人费用
     */
    public FeePerson selectFeePersonByFeepersonId(Long feepersonId);

    /**
     * 查询个人费用列表
     * 
     * @param feePerson 个人费用
     * @return 个人费用集合
     */
    public List<FeePerson> selectFeePersonList(FeePerson feePerson);

    /**
     * 新增个人费用
     * 
     * @param feePerson 个人费用
     * @return 结果
     */
    public int insertFeePerson(FeePerson feePerson);

    /**
     * 修改个人费用
     * 
     * @param feePerson 个人费用
     * @return 结果
     */
    public int updateFeePerson(FeePerson feePerson);

    /**
     * 删除个人费用
     * 
     * @param feepersonId 个人费用主键
     * @return 结果
     */
    public int deleteFeePersonByFeepersonId(Long feepersonId);

    /**
     * 批量删除个人费用
     * 
     * @param feepersonIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFeePersonByFeepersonIds(Long[] feepersonIds);
}
