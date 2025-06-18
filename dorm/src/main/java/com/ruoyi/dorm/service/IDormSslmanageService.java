package com.ruoyi.dorm.service;

import java.util.List;
import com.ruoyi.dorm.domain.DormSslmanage;

/**
 * 宿舍楼信息Service接口
 * 
 * @author qqq
 * @date 2022-04-07
 */
public interface IDormSslmanageService 
{
    /**
     * 查询宿舍楼信息
     * 
     * @param id 宿舍楼信息主键
     * @return 宿舍楼信息
     */
    public DormSslmanage selectDormSslmanageById(Long id);

    /**
     * 查询宿舍楼信息列表
     * 
     * @param dormSslmanage 宿舍楼信息
     * @return 宿舍楼信息集合
     */
    public List<DormSslmanage> selectDormSslmanageList(DormSslmanage dormSslmanage);

    /**
     * 新增宿舍楼信息
     * 
     * @param dormSslmanage 宿舍楼信息
     * @return 结果
     */
    public int insertDormSslmanage(DormSslmanage dormSslmanage);

    /**
     * 修改宿舍楼信息
     * 
     * @param dormSslmanage 宿舍楼信息
     * @return 结果
     */
    public int updateDormSslmanage(DormSslmanage dormSslmanage);

    /**
     * 批量删除宿舍楼信息
     * 
     * @param ids 需要删除的宿舍楼信息主键集合
     * @return 结果
     */
    public int deleteDormSslmanageByIds(Long[] ids);

    /**
     * 删除宿舍楼信息信息
     * 
     * @param id 宿舍楼信息主键
     * @return 结果
     */
    public int deleteDormSslmanageById(Long id);
}
