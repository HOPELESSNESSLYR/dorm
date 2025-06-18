package com.ruoyi.web.controller.dorm;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.tune.domain.DormStayRetreatTune;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.livepeople.domain.DormLivepeople;
import com.ruoyi.livepeople.service.IDormLivepeopleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 人员信息Controller
 * 
 * @author qqq
 * @date 2022-04-14
 */
@RestController
@RequestMapping("/livepeople/livepeople")
public class DormLivepeopleController extends BaseController
{
    @Autowired
    private IDormLivepeopleService dormLivepeopleService;

    /**
     * 查询人员信息列表
     */
    @PreAuthorize("@ss.hasPermi('livepeople:livepeople:list')")
    @GetMapping("/list")
    public TableDataInfo list(DormLivepeople dormLivepeople)
    {
        startPage();
        List<DormLivepeople> list = dormLivepeopleService.selectDormLivepeopleList(dormLivepeople);
        return getDataTable(list);
    }

    /**
     * 查询已住人员信息列表
     */
    @PreAuthorize("@ss.hasPermi('livepeople:livepeople:list')")
    @GetMapping("/list2")
    public TableDataInfo list2(DormLivepeople dormLivepeople)
    {
        startPage();
        List<DormLivepeople> list = dormLivepeopleService.selectDormLivepeopleList2(dormLivepeople);
        return getDataTable(list);
    }

    /**
     * 导出人员信息列表
     */
    @PreAuthorize("@ss.hasPermi('livepeople:livepeople:export')")
    @Log(title = "人员信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DormLivepeople dormLivepeople)
    {
        List<DormLivepeople> list = dormLivepeopleService.selectDormLivepeopleList(dormLivepeople);
        ExcelUtil<DormLivepeople> util = new ExcelUtil<DormLivepeople>(DormLivepeople.class);
        util.exportExcel(response, list, "人员信息数据");
    }

    /**
     * 获取人员信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('livepeople:livepeople:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dormLivepeopleService.selectDormLivepeopleById(id));
    }

    /**
     * 新增人员信息
     */
    @PreAuthorize("@ss.hasPermi('livepeople:livepeople:add')")
    @Log(title = "人员信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DormLivepeople dormLivepeople)
    {
        return toAjax(dormLivepeopleService.insertDormLivepeople(dormLivepeople));
    }

    /**
     * 修改人员信息
     */
    @PreAuthorize("@ss.hasPermi('livepeople:livepeople:edit')")
    @Log(title = "人员信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DormLivepeople dormLivepeople)
    {
        return toAjax(dormLivepeopleService.updateDormLivepeople(dormLivepeople));
    }

    /**
     * 删除人员信息
     */
    @PreAuthorize("@ss.hasPermi('livepeople:livepeople:remove')")
    @Log(title = "人员信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dormLivepeopleService.deleteDormLivepeopleByIds(ids));
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<DormLivepeople> util = new ExcelUtil<DormLivepeople>(DormLivepeople.class);
        util.importTemplateExcel(response, "住客数据");
    }

    @Log(title = "住客信息管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('livepeople:livepeople:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<DormLivepeople> util = new ExcelUtil<DormLivepeople>(DormLivepeople.class);
        List<DormLivepeople> dormLivepeople = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = dormLivepeopleService.importDormLivepeople(dormLivepeople, updateSupport, operName);
        return AjaxResult.success(message);
    }

}
