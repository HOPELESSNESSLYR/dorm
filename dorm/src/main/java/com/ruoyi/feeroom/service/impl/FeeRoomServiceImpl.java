package com.ruoyi.feeroom.service.impl;

import java.util.List;

import com.ruoyi.DormBed.service.IDormBedService;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.feeconfig.service.impl.FeeConfigServiceImpl;
import com.ruoyi.feefloor.domain.FeeFloor;
import com.ruoyi.room.domain.DormRoominfor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.feeroom.mapper.FeeRoomMapper;
import com.ruoyi.feeroom.domain.FeeRoom;
import com.ruoyi.feeroom.service.IFeeRoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Validator;

/**
 * 房间费用Service业务层处理
 * 
 * @author lyr
 * @date 2025-07-01
 */
@Service
public class FeeRoomServiceImpl implements IFeeRoomService 
{
    private static final Logger log = LoggerFactory.getLogger(FeeConfigServiceImpl.class);
    @Autowired
    protected Validator validator;
    @Autowired
    private FeeRoomMapper feeRoomMapper;

    @Autowired
    private IFeeRoomService feeRoomService;
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

    @Override
    public String importFeeRoom(List<FeeRoom> feeRoomList, boolean updateSupport, String operName)
    {
            if (StringUtils.isNull(feeRoomList) || feeRoomList.size() == 0)
            {
                throw new ServiceException("导入房间费用数据不能为空！");
            }
            int successNum = 0;
            int failureNum = 0;
            StringBuilder successMsg = new StringBuilder();
            StringBuilder failureMsg = new StringBuilder();
            for (FeeRoom feeroom : feeRoomList)
            {
                try
                {
                    if (updateSupport==false)
                    {
                        BeanValidators.validateWithException(validator, feeroom);

                        feeroom.setCreateBy(operName);
                        this.insertFeeRoom(feeroom);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、区域编号 " + feeroom.getAreaNumber()+ "、房间号 " + feeroom.getRoomNumber() + " 导入成功");
                    }
                    else if (updateSupport)
                    {
                        BeanValidators.validateWithException(validator, feeroom);
                        feeroom.setUpdateBy(operName);
                        this.updateFeeRoom(feeroom);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、区域编号 " + feeroom.getAreaNumber()+ "、房间号 " + feeroom.getRoomNumber() + " 更新成功");
                    }
                    else
                    {
                        failureNum++;
                        failureMsg.append("<br/>" + failureNum + "、区域编号 " + feeroom.getAreaNumber()+ "、房间号 " + feeroom.getRoomNumber() + " 导入失败");
                    }
                }
                catch (Exception e)
                {
                    failureNum++;
                    String msg = "<br/>" + failureNum + "、区域编号 " + feeroom.getAreaNumber() + "、房间号 " + feeroom.getRoomNumber()+ " 导入失败：";
                    failureMsg.append(msg + e.getMessage());
                    log.error(msg, e);
                }
            }
            if (failureNum > 0)
            {
                failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
                throw new ServiceException(failureMsg.toString());
            }
            else
            {
                successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
            }
            return successMsg.toString();
        }

    /**
     * 批量修改房间信息
     * @param ids 需要修改的ID数组
     */
    @Override
    public int batchUpdate(Long[] ids,FeeRoom feeRoom)
    {
        if (ids == null || ids.length == 0)
        {
            throw new ServiceException("未选择要更新的房间");
        }

        int rows = 0;
        for (Long id : ids)
        {
            FeeRoom currentRoom = feeRoomMapper.selectFeeRoomByRoomfeeId(id);
            if (currentRoom == null) {
                continue;
            }
//            feeRoom.setRoomfeeId(id);
            currentRoom.setStartdate(feeRoom.getStartdate());
            currentRoom.setEnddate(feeRoom.getEnddate());

            rows += feeRoomMapper.updateFeeRoom(currentRoom);
        }
        return rows;
    }

}
