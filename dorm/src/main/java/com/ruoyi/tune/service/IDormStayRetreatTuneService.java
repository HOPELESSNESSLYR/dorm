package com.ruoyi.tune.service;

import java.util.List;

import com.ruoyi.room.domain.DormRoominfor;
import com.ruoyi.tune.domain.DormStayRetreatTune;

/**
 * 入住调宿退宿申请Service接口
 * 
 * @author qqq
 * @date 2022-04-14
 */
public interface IDormStayRetreatTuneService 
{
    /**
     * 查询入住调宿退宿申请
     * 
     * @param id 入住调宿退宿申请主键
     * @return 入住调宿退宿申请
     */
    public DormStayRetreatTune selectDormStayRetreatTuneById(Long id);

    /**
     * 查询入住调宿退宿申请列表
     * 
     * @param dormStayRetreatTune 入住调宿退宿申请
     * @return 入住调宿退宿申请集合
     */
    public List<DormStayRetreatTune> selectDormStayRetreatTuneList(DormStayRetreatTune dormStayRetreatTune);

    /**
     * 新增入住调宿退宿申请
     * 
     * @param dormStayRetreatTune 入住调宿退宿申请
     * @return 结果
     */
    public int insertDormStayRetreatTune(DormStayRetreatTune dormStayRetreatTune);

    /**
     * 修改入住调宿退宿申请
     * 
     * @param dormStayRetreatTune 入住调宿退宿申请
     * @return 结果
     */
    public int updateDormStayRetreatTune(DormStayRetreatTune dormStayRetreatTune);

    /**
     * 批量删除入住调宿退宿申请
     * 
     * @param ids 需要删除的入住调宿退宿申请主键集合
     * @return 结果
     */
    public int deleteDormStayRetreatTuneByIds(Long[] ids);

    /**
     * 删除入住调宿退宿申请信息
     * 
     * @param id 入住调宿退宿申请主键
     * @return 结果
     */
    public int deleteDormStayRetreatTuneById(Long id);

    /**
     * 导入房间信息数据
     *
     * @param dormStayRetreatTuneList 房间信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importDormStayRetreatTune(List<DormStayRetreatTune> dormStayRetreatTuneList, Boolean isUpdateSupport, String operName);

    /**
     * 根据身份证号码查询流转信息
     */
    public List<DormStayRetreatTune> selectDormStayRetreatTuneByIDnumber(String IDnumbwer);
}
