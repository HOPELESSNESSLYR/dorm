package com.ruoyi.feeroom.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.feeroom.mapper.FeeRoomMapper;
import com.ruoyi.feeroom.domain.FeeRoom;
import com.ruoyi.feeroom.service.IFeeRoomService;

/**
 * 房间费用Service业务层处理
 * 
 * @author lyr
 * @date 2025-07-01
 */
@Service
public class FeeRoomServiceImpl implements IFeeRoomService 
{
    @Autowired
    private FeeRoomMapper feeRoomMapper;

    /**
     * 查询房间费用
     * 
     * @param roomfeeId 房间费用主键
     * @return 房间费用
     */
    @Override
    public FeeRoom selectFeeRoomByRoomfeeId(Long roomfeeId)
    {
        return feeRoomMapper.selectFeeRoomByRoomfeeId(roomfeeId);
    }

    /**
     * 查询房间费用列表
     * 
     * @param feeRoom 房间费用
     * @return 房间费用
     */
    @Override
    public List<FeeRoom> selectFeeRoomList(FeeRoom feeRoom)
    {
        return feeRoomMapper.selectFeeRoomList(feeRoom);
    }

    /**
     * 新增房间费用
     * 
     * @param feeRoom 房间费用
     * @return 结果
     */
    @Override
    public int insertFeeRoom(FeeRoom feeRoom)
    {
        return feeRoomMapper.insertFeeRoom(feeRoom);
    }

    /**
     * 修改房间费用
     * 
     * @param feeRoom 房间费用
     * @return 结果
     */
    @Override
    public int updateFeeRoom(FeeRoom feeRoom)
    {
        return feeRoomMapper.updateFeeRoom(feeRoom);
    }

    /**
     * 批量删除房间费用
     * 
     * @param roomfeeIds 需要删除的房间费用主键
     * @return 结果
     */
    @Override
    public int deleteFeeRoomByRoomfeeIds(Long[] roomfeeIds)
    {
        return feeRoomMapper.deleteFeeRoomByRoomfeeIds(roomfeeIds);
    }

    /**
     * 删除房间费用信息
     * 
     * @param roomfeeId 房间费用主键
     * @return 结果
     */
    @Override
    public int deleteFeeRoomByRoomfeeId(Long roomfeeId)
    {
        return feeRoomMapper.deleteFeeRoomByRoomfeeId(roomfeeId);
    }
}
