package com.ruoyi.feeroom.mapper;

import java.util.List;
import com.ruoyi.feeroom.domain.FeeRoom;

/**
 * 房间费用Mapper接口
 * 
 * @author lyr
 * @date 2025-07-01
 */
public interface FeeRoomMapper 
{
    /**
     * 查询房间费用
     * 
     * @param roomfeeId 房间费用主键
     * @return 房间费用
     */
    public FeeRoom selectFeeRoomByRoomfeeId(Long roomfeeId);

    /**
     * 查询房间费用列表
     * 
     * @param feeRoom 房间费用
     * @return 房间费用集合
     */
    public List<FeeRoom> selectFeeRoomList(FeeRoom feeRoom);

    /**
     * 新增房间费用
     * 
     * @param feeRoom 房间费用
     * @return 结果
     */
    public int insertFeeRoom(FeeRoom feeRoom);

    /**
     * 修改房间费用
     * 
     * @param feeRoom 房间费用
     * @return 结果
     */
    public int updateFeeRoom(FeeRoom feeRoom);

    /**
     * 删除房间费用
     * 
     * @param roomfeeId 房间费用主键
     * @return 结果
     */
    public int deleteFeeRoomByRoomfeeId(Long roomfeeId);

    /**
     * 批量删除房间费用
     * 
     * @param roomfeeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFeeRoomByRoomfeeIds(Long[] roomfeeIds);

    int updatesFeeRoom(FeeRoom feeRoom);
}
