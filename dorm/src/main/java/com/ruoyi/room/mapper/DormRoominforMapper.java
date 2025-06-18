package com.ruoyi.room.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.room.domain.DormRoominfor;

/**
 * 房间信息Mapper接口
 * 
 * @author qqq
 * @date 2022-04-13
 */
public interface DormRoominforMapper 
{
    /**
     * 查询房间信息
     * 
     * @param id 房间信息主键
     * @return 房间信息
     */
    public DormRoominfor selectDormRoominforById(Long id);

    /**
     * 查询房间信息列表
     * 
     * @param dormRoominfor 房间信息
     * @return 房间信息集合
     */
    public List<DormRoominfor> selectDormRoominforList(DormRoominfor dormRoominfor);

    /**
     * 新增房间信息
     * 
     * @param dormRoominfor 房间信息
     * @return 结果
     */
    public int insertDormRoominfor(DormRoominfor dormRoominfor);

    /**
     * 修改房间信息
     * 
     * @param dormRoominfor 房间信息
     * @return 结果
     */
    public int updateDormRoominfor(DormRoominfor dormRoominfor);

    /**
     * 删除房间信息
     * 
     * @param id 房间信息主键
     * @return 结果
     */
    public int deleteDormRoominforById(Long id);

    /**
     * 批量删除房间信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDormRoominforByIds(Long[] ids);

    public List<Map<String, Object>> selectFloorName();
    public List<Integer> selectFloor();
    public List<String> selectRoomNumber();

    public List<Map<String,Object>> selectlivingpeopleBydormRoominfor(DormRoominfor dormRoominfor);

    public DormRoominfor selectDormRoominforBymap(Map<String, String> map);
}
