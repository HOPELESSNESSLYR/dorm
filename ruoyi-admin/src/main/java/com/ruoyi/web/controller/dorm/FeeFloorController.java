package com.ruoyi.web.controller.dorm;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.feeconfig.domain.FeeConfig;
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
import com.ruoyi.feefloor.domain.FeeFloor;
import com.ruoyi.feefloor.service.IFeeFloorService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 楼层费用Controller
 * 
 * @author lyr
 * @date 2025-07-01
 */
@RestController
@RequestMapping("/fee/floor")
public class FeeFloorController extends BaseController
{
    @Autowired
    private IFeeFloorService feeFloorService;

    /**
     * 查询楼层费用列表
     */
    @PreAuthorize("@ss.hasPermi('fee:floor:list')")
    @GetMapping("/list")
    public TableDataInfo list(FeeFloor feeFloor)
    {
        startPage();
        List<FeeFloor> list = feeFloorService.selectFeeFloorList(feeFloor);
        return getDataTable(list);
    }

    /**
     * 导出楼层费用列表
     */
    @PreAuthorize("@ss.hasPermi('fee:floor:export')")
    @Log(title = "楼层费用", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FeeFloor feeFloor)
    {
        List<FeeFloor> list = feeFloorService.selectFeeFloorList(feeFloor);
        ExcelUtil<FeeFloor> util = new ExcelUtil<FeeFloor>(FeeFloor.class);
        util.exportExcel(response, list, "楼层费用数据");
    }

    /**
     * 获取楼层费用详细信息
     */
    @PreAuthorize("@ss.hasPermi('fee:floor:query')")
    @GetMapping(value = "/{floorfeeId}")
    public AjaxResult getInfo(@PathVariable("floorfeeId") Long floorfeeId)
    {
        return AjaxResult.success(feeFloorService.selectFeeFloorByFloorfeeId(floorfeeId));
    }

    /**
     * 新增楼层费用
     */
    @PreAuthorize("@ss.hasPermi('fee:floor:add')")
    @Log(title = "楼层费用", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FeeFloor feeFloor)
    {
        return toAjax(feeFloorService.insertFeeFloor(feeFloor));
    }

    /**
     * 修改楼层费用
     */
    @PreAuthorize("@ss.hasPermi('fee:floor:edit')")
    @Log(title = "楼层费用", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FeeFloor feeFloor)
    {
        return toAjax(feeFloorService.updateFeeFloor(feeFloor));
    }

    /**
     * 删除楼层费用
     */
    @PreAuthorize("@ss.hasPermi('fee:floor:remove')")
    @Log(title = "楼层费用", businessType = BusinessType.DELETE)
	@DeleteMapping("/{floorfeeIds}")
    public AjaxResult remove(@PathVariable Long[] floorfeeIds)
    {
        return toAjax(feeFloorService.deleteFeeFloorByFloorfeeIds(floorfeeIds));
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<FeeFloor> util = new ExcelUtil<FeeFloor>(FeeFloor.class);
        util.importTemplateExcel(response, "楼层费用数据");
    }
    /**
     * 导入费用配置
     */
    @Log(title = "楼层费用", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('fee:floor:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<FeeFloor> util = new ExcelUtil<FeeFloor>(FeeFloor.class);
        List<FeeFloor> feeConfigList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = feeFloorService.importFeeFloor(feeConfigList, updateSupport, operName);
        return AjaxResult.success(message);
    }
}
