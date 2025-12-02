package com.ruoyi.kanban.mapper;

import java.util.List;
import com.ruoyi.kanban.domain.KanBan;

/**
 * kbMapper接口
 * 
 * @author yara
 * @date 2025-11-18
 */
public interface KanBanMapper 
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
     * 删除kb
     * 
     * @param kbid kb主键
     * @return 结果
     */
    public int deleteKanBanByKbid(Long kbid);

    /**
     * 批量删除kb
     * 
     * @param kbids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKanBanByKbids(Long[] kbids);
}
