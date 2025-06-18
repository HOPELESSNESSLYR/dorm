package com.ruoyi.wardrobe.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.tune.domain.DormStayRetreatTune;
import com.ruoyi.wardrobe.domain.DormWardrobe;

/**
 * 柜子信息Service接口
 * 
 * @author qqq
 * @date 2022-05-03
 */
public interface IDormWardrobeService 
{
    /**
     * 查询柜子信息
     * 
     * @param id 柜子信息主键
     * @return 柜子信息
     */
    public DormWardrobe selectDormWardrobeById(Long id);

    /**
     * 查询柜子信息列表
     * 
     * @param dormWardrobe 柜子信息
     * @return 柜子信息集合
     */
    public List<DormWardrobe> selectDormWardrobeList(DormWardrobe dormWardrobe);

    /**
     * 新增柜子信息
     * 
     * @param dormWardrobe 柜子信息
     * @return 结果
     */
    public int insertDormWardrobe(DormWardrobe dormWardrobe);

    /**
     * 修改柜子信息
     * 
     * @param dormWardrobe 柜子信息
     * @return 结果
     */
    public int updateDormWardrobe(DormWardrobe dormWardrobe);

    /**
     * 批量删除柜子信息
     * 
     * @param ids 需要删除的柜子信息主键集合
     * @return 结果
     */
    public int deleteDormWardrobeByIds(Long[] ids);

    /**
     * 删除柜子信息信息
     * 
     * @param id 柜子信息主键
     * @return 结果
     */
    public int deleteDormWardrobeById(Long id);

    /**
     * 导入柜子信息数据
     *
     * @param dormWardrobeList 柜子信息数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    public String importDormWardrobe(List<DormWardrobe> dormWardrobeList, Boolean isUpdateSupport, String operName);

    public DormWardrobe selectDormWardrobeBymap(Map<String, String> wmap);

    public DormWardrobe selectDormWardrobeByJobnumber(String jobnumber);
}
