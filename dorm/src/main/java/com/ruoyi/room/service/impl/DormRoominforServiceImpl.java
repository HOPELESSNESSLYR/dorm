package com.ruoyi.room.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.DormBed.domain.DormBed;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanValidators;
import com.ruoyi.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
import com.ruoyi.room.mapper.DormRoominforMapper;
import com.ruoyi.room.domain.DormRoominfor;
import com.ruoyi.room.service.IDormRoominforService;

import javax.validation.Validator;

import static com.ruoyi.framework.datasource.DynamicDataSourceContextHolder.log;

/**
 * 房间信息Service业务层处理
 * 
 * @author qqq
 * @date 2022-04-13
 */
@Service
public class DormRoominforServiceImpl implements IDormRoominforService 
{
    @Autowired
    private DormRoominforMapper dormRoominforMapper;
    @Autowired
    private ISysConfigService configService;
    @Autowired
    protected Validator validator;
    /**
     * 查询房间信息
     * 
     * @param id 房间信息主键
     * @return 房间信息
     */
    @Override
    public DormRoominfor selectDormRoominforById(Long id)
    {
        return dormRoominforMapper.selectDormRoominforById(id);
    }



    /**
     * 查询房间信息列表
     * 
     * @param dormRoominfor 房间信息
     * @return 房间信息
     */
    @Override
    public List<DormRoominfor> selectDormRoominforList(DormRoominfor dormRoominfor)
    {
        return dormRoominforMapper.selectDormRoominforList(dormRoominfor);
    }

    /**
     * 新增房间信息
     * 
     * @param dormRoominfor 房间信息
     * @return 结果
     */
    @Override
    public int insertDormRoominfor(DormRoominfor dormRoominfor)
    {
        return dormRoominforMapper.insertDormRoominfor(dormRoominfor);
    }

    /**
     * 修改房间信息
     * 
     * @param dormRoominfor 房间信息
     * @return 结果
     */
    @Override
    public int updateDormRoominfor(DormRoominfor dormRoominfor)
    {
        return dormRoominforMapper.updateDormRoominfor(dormRoominfor);
    }

    /**
     * 批量删除房间信息
     * 
     * @param ids 需要删除的房间信息主键
     * @return 结果
     */
    @Override
    public int deleteDormRoominforByIds(Long[] ids)
    {
        return dormRoominforMapper.deleteDormRoominforByIds(ids);
    }

    /**
     * 删除房间信息
     * 
     * @param id 房间信息主键
     * @return 结果
     */
    @Override
    public int deleteDormRoominforById(Long id)
    {
        return dormRoominforMapper.deleteDormRoominforById(id);
    }

    /**
     * 查询宿舍楼名称
     *
     */
    @Override
    public List<Map<String,Object>> selectFloorName ()
    {
        return dormRoominforMapper.selectFloorName();
    }
    /**
     * 查询宿舍楼层
     *
     */
    @Override
    public List<Integer> selectFloor ()
    {
        return dormRoominforMapper.selectFloor();
    }
    /**
     * 查询房间号
     *
     */
    @Override
    public List<String> selectRoomNumber ()
    {
        return dormRoominforMapper.selectRoomNumber();
    }
    /**
     * 查询已入住人员
     * */
    @Override
    public List<Map<String,Object>> selectlivingpeopleBydormRoominfor(DormRoominfor dormRoominfor){
        return dormRoominforMapper.selectlivingpeopleBydormRoominfor(dormRoominfor);
    };
    @Override
    public DormRoominfor selectDormRoominforBymap(Map<String, String> map){return dormRoominforMapper.selectDormRoominforBymap(map);}
    /**
     * 批量修改房间信息
     * 
     * @param ids 需要修改的房间ID数组
     * @param dormRoominfor 包含roomSex、roomType的房间信息
     * @return 更新成功的记录数
     */
    @Override
    public int batchUpdate(Long[] ids, DormRoominfor dormRoominfor) 
    {
        if (ids == null || ids.length == 0) 
        {
            throw new ServiceException("未选择要更新的房间");
        }
        
        // 创建更新对象
        DormRoominfor updateRoom = new DormRoominfor();
        updateRoom.setRoomSex(dormRoominfor.getRoomSex());
        updateRoom.setRoomType(dormRoominfor.getRoomType());
        
        int rows = 0;
        for (Long id : ids) 
        {
            updateRoom.setId(id);
            rows += dormRoominforMapper.updateDormRoominfor(updateRoom);
        }
        return rows;
    }

    /**
     * 导入房间信息数据
     *
     * @param dormRoominforList 房间信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importDormRoominfor(List<DormRoominfor> dormRoominforList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(dormRoominforList) || dormRoominforList.size() == 0)
        {
            throw new ServiceException("导入房间信息数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (DormRoominfor roominfor : dormRoominforList)
        {
            try
            {

                if (isUpdateSupport==false)
                {
                    BeanValidators.validateWithException(validator, roominfor);

                    roominfor.setCreateBy(operName);
                    this.insertDormRoominfor(roominfor);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、房间号 " + roominfor.getRoomNumber() + " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    BeanValidators.validateWithException(validator, roominfor);
                    roominfor.setUpdateBy(operName);
                    this.updateDormRoominfor(roominfor);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、房间号 " + roominfor.getRoomNumber() + " 更新成功");
                }
                else
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、房间号 " + roominfor.getRoomNumber() + " 导入失败");
                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + roominfor.getRoomNumber() + " 导入失败：";
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
}
