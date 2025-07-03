package com.ruoyi.feeconfig.service;

import java.util.List;
import com.ruoyi.feeconfig.domain.FeeConfig;

/**
 * 费用配置Service接口
 * 
 * @author lyr
 * @date 2025-07-01
 */
public interface IFeeConfigService 
{
    /**
     * 查询费用配置
     * 
     * @param congifId 费用配置主键
     * @return 费用配置
     */
    public FeeConfig selectFeeConfigByCongifId(Long congifId);

    /**
     * 查询费用配置列表
     * 
     * @param feeConfig 费用配置
     * @return 费用配置集合
     */
    public List<FeeConfig> selectFeeConfigList(FeeConfig feeConfig);

    /**
     * 新增费用配置
     * 
     * @param feeConfig 费用配置
     * @return 结果
     */
    public int insertFeeConfig(FeeConfig feeConfig);

    /**
     * 修改费用配置
     * 
     * @param feeConfig 费用配置
     * @return 结果
     */
    public int updateFeeConfig(FeeConfig feeConfig);

    /**
     * 批量删除费用配置
     * 
     * @param congifIds 需要删除的费用配置主键集合
     * @return 结果
     */
    public int deleteFeeConfigByCongifIds(Long[] congifIds);

    /**
     * 删除费用配置信息
     * 
     * @param congifId 费用配置主键
     * @return 结果
     */
    public int deleteFeeConfigByCongifId(Long congifId);

    public String importFeeConfig(List<FeeConfig> feeConfigList, boolean updateSupport, String operName);
}
