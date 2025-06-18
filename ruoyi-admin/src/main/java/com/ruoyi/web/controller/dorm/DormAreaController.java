package com.ruoyi.web.controller.dorm;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.service.ISysUserService;
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
import com.ruoyi.area.domain.DormArea;
import com.ruoyi.area.service.IDormAreaService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 区域信息Controller
 * 
 * @author qqq
 * @date 2022-03-30
 */
@RestController
@RequestMapping("/dorm/area")
public class DormAreaController extends BaseController
{
    @Autowired
    private IDormAreaService dormAreaService;

    /**
     * 查询区域信息列表
     */
    @PreAuthorize("@ss.hasPermi('dorm:area:list')")
    @GetMapping("/list")
    public TableDataInfo list(DormArea dormArea)
    {
        startPage();
        List<DormArea> list = dormAreaService.selectDormAreaList(dormArea);
        return getDataTable(list);
    }

    /**
     * 导出区域信息列表
     */
    @PreAuthorize("@ss.hasPermi('dorm:area:export')")
    @Log(title = "区域信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DormArea dormArea)
    {
        List<DormArea> list = dormAreaService.selectDormAreaList(dormArea);
        ExcelUtil<DormArea> util = new ExcelUtil<DormArea>(DormArea.class);
        util.exportExcel(response, list, "区域信息数据");
    }

    /**
     * 获取区域信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:area:query')")
    @GetMapping(value = "/{areaNumber}")
    public AjaxResult getInfo(@PathVariable("areaNumber") String areaNumber)
    {
        return AjaxResult.success(dormAreaService.selectDormAreaByAreaNumber(areaNumber));
    }

    /**
     * 新增区域信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:area:add')")
    @Log(title = "区域信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DormArea dormArea)
    {
        dormArea.setAreaCdate(new Date());
        dormArea.setAreaCreateman(SecurityUtils.getUsername());
        return toAjax(dormAreaService.insertDormArea(dormArea));
    }

    /**
     * 修改区域信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:area:edit')")
    @Log(title = "区域信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DormArea dormArea)
    {
        //dormArea.setAreaCdate(new Date());
        //dormArea.setAreaCreateman(SecurityUtils.getUsername());
        return toAjax(dormAreaService.updateDormArea(dormArea));
    }

    /**
     * 删除区域信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:area:remove')")
    @Log(title = "区域信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{areaNumbers}")
    public AjaxResult remove(@PathVariable String[] areaNumbers)
    {
        return toAjax(dormAreaService.deleteDormAreaByAreaNumbers(areaNumbers));
    }
}
