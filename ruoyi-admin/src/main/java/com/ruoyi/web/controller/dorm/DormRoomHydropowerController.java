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
import com.ruoyi.hydropower.domain.DormRoomHydropower;
import com.ruoyi.hydropower.service.IDormRoomHydropowerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 房间水电记录Controller
 * 
 * @author qqq
 * @date 2022-05-03
 */
@RestController
@RequestMapping("/feemanage/hydropower")
public class DormRoomHydropowerController extends BaseController
{
    @Autowired
    private IDormRoomHydropowerService dormRoomHydropowerService;

    /**
     * 查询房间水电记录列表
     */
    @PreAuthorize("@ss.hasPermi('feemanage:hydropower:list')")
    @GetMapping("/list")
    public TableDataInfo list(DormRoomHydropower dormRoomHydropower)
    {
        startPage();
        List<DormRoomHydropower> list = dormRoomHydropowerService.selectDormRoomHydropowerList(dormRoomHydropower);
        return getDataTable(list);
    }

    /**
     * 导出房间水电记录列表
     */
    @PreAuthorize("@ss.hasPermi('feemanage:hydropower:export')")
    @Log(title = "房间水电记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DormRoomHydropower dormRoomHydropower)
    {
        List<DormRoomHydropower> list = dormRoomHydropowerService.selectDormRoomHydropowerList(dormRoomHydropower);
        ExcelUtil<DormRoomHydropower> util = new ExcelUtil<DormRoomHydropower>(DormRoomHydropower.class);
        util.exportExcel(response, list, "房间水电记录数据");
    }

    /**
     * 获取房间水电记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('feemanage:hydropower:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dormRoomHydropowerService.selectDormRoomHydropowerById(id));
    }

    /**
     * 新增房间水电记录
     */
    @PreAuthorize("@ss.hasPermi('feemanage:hydropower:add')")
    @Log(title = "房间水电记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DormRoomHydropower dormRoomHydropower)
    {
        return toAjax(dormRoomHydropowerService.insertDormRoomHydropower(dormRoomHydropower));
    }

    /**
     * 修改房间水电记录
     */
    @PreAuthorize("@ss.hasPermi('feemanage:hydropower:edit')")
    @Log(title = "房间水电记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DormRoomHydropower dormRoomHydropower)
    {
        return toAjax(dormRoomHydropowerService.updateDormRoomHydropower(dormRoomHydropower));
    }

    /**
     * 删除房间水电记录
     */
    @PreAuthorize("@ss.hasPermi('feemanage:hydropower:remove')")
    @Log(title = "房间水电记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dormRoomHydropowerService.deleteDormRoomHydropowerByIds(ids));
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<DormRoomHydropower> util = new ExcelUtil<DormRoomHydropower>(DormRoomHydropower.class);
        util.importTemplateExcel(response, "房间水电数据");
    }

    @Log(title = "房间水电信息管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('feemanage:hydropower:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<DormRoomHydropower> util = new ExcelUtil<DormRoomHydropower>(DormRoomHydropower.class);
        List<DormRoomHydropower> dormRoomHydropower = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = dormRoomHydropowerService.importDormRoomHydropower(dormRoomHydropower, updateSupport, operName);
        return AjaxResult.success(message);
    }
}
