package com.ruoyi.hydropower.mapper;

import java.util.List;
import com.ruoyi.hydropower.domain.DormRoomHydropower;

/**
 * 房间水电记录Mapper接口
 * 
 * @author qqq
 * @date 2022-05-03
 */
public interface DormRoomHydropowerMapper 
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
     * 删除房间水电记录
     * 
     * @param id 房间水电记录主键
     * @return 结果
     */
    public int deleteDormRoomHydropowerById(Long id);

    /**
     * 批量删除房间水电记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDormRoomHydropowerByIds(Long[] ids);
}
