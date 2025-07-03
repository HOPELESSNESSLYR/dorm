package com.ruoyi.feefloor.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.feefloor.mapper.FeeFloorMapper;
import com.ruoyi.feefloor.domain.FeeFloor;
import com.ruoyi.feefloor.service.IFeeFloorService;

/**
 * 楼层费用Service业务层处理
 * 
 * @author lyr
 * @date 2025-07-01
 */
@Service
public class FeeFloorServiceImpl implements IFeeFloorService 
{
    @Autowired
    private FeeFloorMapper feeFloorMapper;

    /**
     * 查询楼层费用
     * 
     * @param floorfeeId 楼层费用主键
     * @return 楼层费用
     */
    @Override
    public FeeFloor selectFeeFloorByFloorfeeId(Long floorfeeId)
    {
        return feeFloorMapper.selectFeeFloorByFloorfeeId(floorfeeId);
    }

    /**
     * 查询楼层费用列表
     * 
     * @param feeFloor 楼层费用
     * @return 楼层费用
     */
    @Override
    public List<FeeFloor> selectFeeFloorList(FeeFloor feeFloor)
    {
        return feeFloorMapper.selectFeeFloorList(feeFloor);
    }

    /**
     * 新增楼层费用
     * 
     * @param feeFloor 楼层费用
     * @return 结果
     */
    @Override
    public int insertFeeFloor(FeeFloor feeFloor)
    {
        return feeFloorMapper.insertFeeFloor(feeFloor);
    }

    /**
     * 修改楼层费用
     * 
     * @param feeFloor 楼层费用
     * @return 结果
     */
    @Override
    public int updateFeeFloor(FeeFloor feeFloor)
    {
        return feeFloorMapper.updateFeeFloor(feeFloor);
    }

    /**
     * 批量删除楼层费用
     * 
     * @param floorfeeIds 需要删除的楼层费用主键
     * @return 结果
     */
    @Override
    public int deleteFeeFloorByFloorfeeIds(Long[] floorfeeIds)
    {
        return feeFloorMapper.deleteFeeFloorByFloorfeeIds(floorfeeIds);
    }

    /**
     * 删除楼层费用信息
     * 
     * @param floorfeeId 楼层费用主键
     * @return 结果
     */
    @Override
    public int deleteFeeFloorByFloorfeeId(Long floorfeeId)
    {
        return feeFloorMapper.deleteFeeFloorByFloorfeeId(floorfeeId);
    }
}
