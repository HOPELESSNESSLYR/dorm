package com.ruoyi.livepeople.mapper;

import java.util.List;
import com.ruoyi.livepeople.domain.DormLivepeople;

/**
 * 人员信息Mapper接口
 * 
 * @author qqq
 * @date 2022-04-14
 */
public interface DormLivepeopleMapper 
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
     * 删除人员信息
     * 
     * @param id 人员信息主键
     * @return 结果
     */
    public int deleteDormLivepeopleById(Long id);

    /**
     * 批量删除人员信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDormLivepeopleByIds(Long[] ids);


    public DormLivepeople selectDormLivepeopleByIDnumber(String iDnumber);
    /**
     * 查询已住人员信息列表
     *
     * @param dormLivepeople 人员信息
     * @return 人员信息集合
     */
    public List<DormLivepeople> selectDormLivepeopleList2(DormLivepeople dormLivepeople);

    public List<DormLivepeople> selectDormLivepeopleListByIDnumber(String iDnumber);

    public List<DormLivepeople> selectDormLivepeopleList3();
}
