package com.ruoyi.livepeople.service;

import java.util.List;
import com.ruoyi.livepeople.domain.DormLivepeople;
import com.ruoyi.room.domain.DormRoominfor;

/**
 * 人员信息Service接口
 * 
 * @author qqq
 * @date 2022-04-14
 */
public interface IDormLivepeopleService 
{
    /**
     * 查询人员信息
     * 
     * @param id 人员信息主键
     * @return 人员信息
     */
    public DormLivepeople selectDormLivepeopleById(Long id);

    /**
     * 查询人员信息列表
     * 
     * @param dormLivepeople 人员信息
     * @return 人员信息集合
     */
    public List<DormLivepeople> selectDormLivepeopleList(DormLivepeople dormLivepeople);

    /**
     * 新增人员信息
     * 
     * @param dormLivepeople 人员信息
     * @return 结果
     */
    public int insertDormLivepeople(DormLivepeople dormLivepeople);

    /**
     * 修改人员信息
     * 
     * @param dormLivepeople 人员信息
     * @return 结果
     */
    public int updateDormLivepeople(DormLivepeople dormLivepeople);

    /**
     * 批量删除人员信息
     * 
     * @param ids 需要删除的人员信息主键集合
     * @return 结果
     */
    public int deleteDormLivepeopleByIds(Long[] ids);

    /**
     * 删除人员信息信息
     * 
     * @param id 人员信息主键
     * @return 结果
     */
    public int deleteDormLivepeopleById(Long id);

    /**
     * 导入人员信息数据
     *
     * @param dormLivepeopleList 人员信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importDormLivepeople(List<DormLivepeople> dormLivepeopleList, Boolean isUpdateSupport, String operName);

    public DormLivepeople selectDormLivepeopleByIDnumber(String iDnumber);
    public List<DormLivepeople> selectDormLivepeopleListByIDnumber(String iDnumber);
    /**
     * 查询已住人员信息列表
     *
     * @param dormLivepeople 人员信息
     * @return 人员信息集合
     */
    public List<DormLivepeople> selectDormLivepeopleList2(DormLivepeople dormLivepeople);

    public List<DormLivepeople> selectDormLivepeopleList3();
}
