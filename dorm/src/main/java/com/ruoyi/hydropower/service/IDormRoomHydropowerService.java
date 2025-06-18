package com.ruoyi.hydropower.service;

import java.util.List;
import com.ruoyi.hydropower.domain.DormRoomHydropower;
import com.ruoyi.livepeople.domain.DormLivepeople;

/**
 * 房间水电记录Service接口
 * 
 * @author qqq
 * @date 2022-05-03
 */
public interface IDormRoomHydropowerService 
{
    /**
     * 查询房间水电记录
     * 
     * @param id 房间水电记录主键
     * @return 房间水电记录
     */
    public DormRoomHydropower selectDormRoomHydropowerById(Long id);

    /**
     * 查询房间水电记录列表
     * 
     * @param dormRoomHydropower 房间水电记录
     * @return 房间水电记录集合
     */
    public List<DormRoomHydropower> selectDormRoomHydropowerList(DormRoomHydropower dormRoomHydropower);

    /**
     * 新增房间水电记录
     * 
     * @param dormRoomHydropower 房间水电记录
     * @return 结果
     */
    public int insertDormRoomHydropower(DormRoomHydropower dormRoomHydropower);

    /**
     * 修改房间水电记录
     * 
     * @param dormRoomHydropower 房间水电记录
     * @return 结果
     */
    public int updateDormRoomHydropower(DormRoomHydropower dormRoomHydropower);

    /**
     * 批量删除房间水电记录
     * 
     * @param ids 需要删除的房间水电记录主键集合
     * @return 结果
     */
    public int deleteDormRoomHydropowerByIds(Long[] ids);

    /**
     * 删除房间水电记录信息
     * 
     * @param id 房间水电记录主键
     * @return 结果
     */
    public int deleteDormRoomHydropowerById(Long id);
    /**
     * 导入房间水电信息数据
     *
     * @param dormRoomHydropowerList 房间水电信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importDormRoomHydropower(List<DormRoomHydropower> dormRoomHydropowerList, Boolean isUpdateSupport, String operName);
}
