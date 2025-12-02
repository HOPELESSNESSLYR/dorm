package com.ruoyi.kanban.service;

import java.util.List;
import com.ruoyi.kanban.domain.KanBan;

/**
 * kbService接口
 * 
 * @author yara
 * @date 2025-11-18
 */
public interface IKanBanService 
{
    /**
     * 查询kb
     * 
     * @param kbid kb主键
     * @return kb
     */
    public KanBan selectKanBanByKbid(Long kbid);

    /**
     * 查询kb列表
     * 
     * @param kanBan kb
     * @return kb集合
     */
    public List<KanBan> selectKanBanList(KanBan kanBan);

    /**
     * 新增kb
     * 
     * @param kanBan kb
     * @return 结果
     */
    public int insertKanBan(KanBan kanBan);

    /**
     * 修改kb
     * 
     * @param kanBan kb
     * @return 结果
     */
    public int updateKanBan(KanBan kanBan);

    /**
     * 批量删除kb
     * 
     * @param kbids 需要删除的kb主键集合
     * @return 结果
     */
    public int deleteKanBanByKbids(Long[] kbids);

    /**
     * 删除kb信息
     * 
     * @param kbid kb主键
     * @return 结果
     */
    public int deleteKanBanByKbid(Long kbid);
}
