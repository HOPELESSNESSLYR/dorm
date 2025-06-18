package com.ruoyi.room.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.room.domain.DormRoominfor;

/**
 * 房间信息Service接口
 * 
 * @author qqq
 * @date 2022-04-13
 */
public interface IDormRoominforService 
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
     * 批量删除房间信息
     * 
     * @param ids 需要删除的房间信息主键集合
     * @return 结果
     */
    public int deleteDormRoominforByIds(Long[] ids);

    /**
     * 删除房间信息
     * 
     * @param id 房间信息主键
     * @return 结果
     */
    public int deleteDormRoominforById(Long id);

    /**
     * 导入房间信息数据
     *
     * @param dormRoominforList 房间信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importDormRoominfor(List<DormRoominfor> dormRoominforList, Boolean isUpdateSupport, String operName);
    /**
     * 查询宿舍楼名称
     * */
    public List<Map<String,Object>> selectFloorName();
    /**
     * 查询宿舍楼层
     * */
    public List<Integer> selectFloor();
    /**
     * 查询房间号
     * */
    public List<String> selectRoomNumber();
    /**
     * 查询已入住人员
     * */
    public List<Map<String,Object>> selectlivingpeopleBydormRoominfor(DormRoominfor dormRoominfor);

    public DormRoominfor selectDormRoominforBymap(Map<String, String> map);

    /**
     * 批量修改房间信息
     *
     * @param ids 需要修改的房间ID数组
     * @param dormRoominfor 包含roomSex、roomType的房间信息
     * @return 结果
     */
    public int batchUpdate(Long[] ids, DormRoominfor dormRoominfor);
}
