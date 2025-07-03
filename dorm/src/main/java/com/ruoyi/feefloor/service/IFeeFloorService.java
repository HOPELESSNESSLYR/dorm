package com.ruoyi.feefloor.service;

import java.util.List;
import com.ruoyi.feefloor.domain.FeeFloor;

/**
 * 楼层费用Service接口
 * 
 * @author lyr
 * @date 2025-07-01
 */
public interface IFeeFloorService 
{
    /**
     * 查询楼层费用
     * 
     * @param floorfeeId 楼层费用主键
     * @return 楼层费用
     */
    public FeeFloor selectFeeFloorByFloorfeeId(Long floorfeeId);

    /**
     * 查询楼层费用列表
     * 
     * @param feeFloor 楼层费用
     * @return 楼层费用集合
     */
    public List<FeeFloor> selectFeeFloorList(FeeFloor feeFloor);

    /**
     * 新增楼层费用
     * 
     * @param feeFloor 楼层费用
     * @return 结果
     */
    public int insertFeeFloor(FeeFloor feeFloor);

    /**
     * 修改楼层费用
     * 
     * @param feeFloor 楼层费用
     * @return 结果
     */
    public int updateFeeFloor(FeeFloor feeFloor);

    /**
     * 批量删除楼层费用
     * 
     * @param floorfeeIds 需要删除的楼层费用主键集合
     * @return 结果
     */
    public int deleteFeeFloorByFloorfeeIds(Long[] floorfeeIds);

    /**
     * 删除楼层费用信息
     * 
     * @param floorfeeId 楼层费用主键
     * @return 结果
     */
    public int deleteFeeFloorByFloorfeeId(Long floorfeeId);
}
