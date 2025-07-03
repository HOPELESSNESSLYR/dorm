package com.ruoyi.feeperson.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.feeperson.mapper.FeePersonMapper;
import com.ruoyi.feeperson.domain.FeePerson;
import com.ruoyi.feeperson.service.IFeePersonService;

/**
 * 个人费用Service业务层处理
 * 
 * @author lyr
 * @date 2025-07-01
 */
@Service
public class FeePersonServiceImpl implements IFeePersonService 
{
    @Autowired
    private FeePersonMapper feePersonMapper;

    /**
     * 查询个人费用
     * 
     * @param feepersonId 个人费用主键
     * @return 个人费用
     */
    @Override
    public FeePerson selectFeePersonByFeepersonId(Long feepersonId)
    {
        return feePersonMapper.selectFeePersonByFeepersonId(feepersonId);
    }

    /**
     * 查询个人费用列表
     * 
     * @param feePerson 个人费用
     * @return 个人费用
     */
    @Override
    public List<FeePerson> selectFeePersonList(FeePerson feePerson)
    {
        return feePersonMapper.selectFeePersonList(feePerson);
    }

    /**
     * 新增个人费用
     * 
     * @param feePerson 个人费用
     * @return 结果
     */
    @Override
    public int insertFeePerson(FeePerson feePerson)
    {
        return feePersonMapper.insertFeePerson(feePerson);
    }

    /**
     * 修改个人费用
     * 
     * @param feePerson 个人费用
     * @return 结果
     */
    @Override
    public int updateFeePerson(FeePerson feePerson)
    {
        return feePersonMapper.updateFeePerson(feePerson);
    }

    /**
     * 批量删除个人费用
     * 
     * @param feepersonIds 需要删除的个人费用主键
     * @return 结果
     */
    @Override
    public int deleteFeePersonByFeepersonIds(Long[] feepersonIds)
    {
        return feePersonMapper.deleteFeePersonByFeepersonIds(feepersonIds);
    }

    /**
     * 删除个人费用信息
     * 
     * @param feepersonId 个人费用主键
     * @return 结果
     */
    @Override
    public int deleteFeePersonByFeepersonId(Long feepersonId)
    {
        return feePersonMapper.deleteFeePersonByFeepersonId(feepersonId);
    }
}
