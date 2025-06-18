package com.ruoyi.web.controller.dorm;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.livepeople.domain.DormLivepeople;
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
import com.ruoyi.off.domain.DormLeaveOff;
import com.ruoyi.off.service.IDormLeaveOffService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 免扣销假记录Controller
 * 
 * @author qqq
 * @date 2022-05-03
 */
@RestController
@RequestMapping("/feemanage/off")
public class DormLeaveOffController extends BaseController
{
    @Autowired
    private IDormLeaveOffService dormLeaveOffService;

    /**
     * 查询免扣销假记录列表
     */
    @PreAuthorize("@ss.hasPermi('feemanage:off:list')")
    @GetMapping("/list")
    public TableDataInfo list(DormLeaveOff dormLeaveOff)
    {
        startPage();
        List<DormLeaveOff> list = dormLeaveOffService.selectDormLeaveOffList(dormLeaveOff);
        return getDataTable(list);
    }

    /**
     * 导出免扣销假记录列表
     */
    @PreAuthorize("@ss.hasPermi('feemanage:off:export')")
    @Log(title = "免扣销假记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DormLeaveOff dormLeaveOff)
    {
        List<DormLeaveOff> list = dormLeaveOffService.selectDormLeaveOffList(dormLeaveOff);
        ExcelUtil<DormLeaveOff> util = new ExcelUtil<DormLeaveOff>(DormLeaveOff.class);
        util.exportExcel(response, list, "免扣销假记录数据");
    }

    /**
     * 获取免扣销假记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('feemanage:off:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dormLeaveOffService.selectDormLeaveOffById(id));
    }

    /**
     * 新增免扣销假记录
     */
    @PreAuthorize("@ss.hasPermi('feemanage:off:add')")
    @Log(title = "免扣销假记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DormLeaveOff dormLeaveOff)
    {
        return toAjax(dormLeaveOffService.insertDormLeaveOff(dormLeaveOff));
    }

    /**
     * 修改免扣销假记录
     */
    @PreAuthorize("@ss.hasPermi('feemanage:off:edit')")
    @Log(title = "免扣销假记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DormLeaveOff dormLeaveOff)
    {
        return toAjax(dormLeaveOffService.updateDormLeaveOff(dormLeaveOff));
    }

    /**
     * 删除免扣销假记录
     */
    @PreAuthorize("@ss.hasPermi('feemanage:off:remove')")
    @Log(title = "免扣销假记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dormLeaveOffService.deleteDormLeaveOffByIds(ids));
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<DormLeaveOff> util = new ExcelUtil<DormLeaveOff>(DormLeaveOff.class);
        util.importTemplateExcel(response, "免扣销假数据");
    }

    @Log(title = "免扣销假信息管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('feemanage:off:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<DormLeaveOff> util = new ExcelUtil<DormLeaveOff>(DormLeaveOff.class);
        List<DormLeaveOff> dormLeaveOff = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = dormLeaveOffService.importDormLeaveOff(dormLeaveOff, updateSupport, operName);
        return AjaxResult.success(message);
    }
}
