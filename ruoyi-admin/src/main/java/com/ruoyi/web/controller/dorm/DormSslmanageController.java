package com.ruoyi.web.controller.dorm;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.SecurityUtils;
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
import com.ruoyi.dorm.domain.DormSslmanage;
import com.ruoyi.dorm.service.IDormSslmanageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 宿舍楼信息Controller
 * 
 * @author qqq
 * @date 2022-04-07
 */
@RestController
@RequestMapping("/dorm/manage")
public class DormSslmanageController extends BaseController
{
    @Autowired
    private IDormSslmanageService dormSslmanageService;

    /**
     * 查询宿舍楼信息列表
     */
    @PreAuthorize("@ss.hasPermi('dorm:manage:list')")
    @GetMapping("/list")
    public TableDataInfo list(DormSslmanage dormSslmanage)
    {
        startPage();
        List<DormSslmanage> list = dormSslmanageService.selectDormSslmanageList(dormSslmanage);
        return getDataTable(list);
    }

    /**
     * 导出宿舍楼信息列表
     */
    @PreAuthorize("@ss.hasPermi('dorm:manage:export')")
    @Log(title = "宿舍楼信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DormSslmanage dormSslmanage)
    {
        List<DormSslmanage> list = dormSslmanageService.selectDormSslmanageList(dormSslmanage);
        ExcelUtil<DormSslmanage> util = new ExcelUtil<DormSslmanage>(DormSslmanage.class);
        util.exportExcel(response, list, "宿舍楼信息数据");
    }

    /**
     * 获取宿舍楼信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:manage:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dormSslmanageService.selectDormSslmanageById(id));
    }

    /**
     * 新增宿舍楼信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:manage:add')")
    @Log(title = "宿舍楼信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DormSslmanage dormSslmanage)
    {
        dormSslmanage.setCreateTime(new Date());
        dormSslmanage.setFloorCname(SecurityUtils.getUsername());
        return toAjax(dormSslmanageService.insertDormSslmanage(dormSslmanage));
    }

    /**
     * 修改宿舍楼信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:manage:edit')")
    @Log(title = "宿舍楼信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DormSslmanage dormSslmanage)
    {
        return toAjax(dormSslmanageService.updateDormSslmanage(dormSslmanage));
    }

    /**
     * 删除宿舍楼信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:manage:remove')")
    @Log(title = "宿舍楼信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dormSslmanageService.deleteDormSslmanageByIds(ids));
    }
}
