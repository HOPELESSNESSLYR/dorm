package com.ruoyi.web.controller.dorm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.room.domain.DormRoominfor;
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
import com.ruoyi.DormBed.domain.DormBed;
import com.ruoyi.DormBed.service.IDormBedService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 床位信息Controller
 * 
 * @author qqq
 * @date 2022-04-14
 */
@RestController
@RequestMapping("/DormBed/bed")
public class DormBedController extends BaseController
{
    @Autowired
    private IDormBedService dormBedService;

    /**
     * 查询床位信息列表
     */
    @PreAuthorize("@ss.hasPermi('DormBed:bed:list')")
    @GetMapping("/list")
    public TableDataInfo list(DormBed dormBed)
    {
        startPage();
        List<DormBed> list = dormBedService.selectDormBedList(dormBed);
        return getDataTable(list);
    }

    /**
     * 查询床位信息列表
     */
    @PreAuthorize("@ss.hasPermi('DormBed:bed:list')")
    @GetMapping("/listDormBed/{dormbed}")
    public TableDataInfo list2(@PathVariable("dormbed") String dormBed)
    {
        startPage();
        Map<String,String> map = new HashMap<>();
        map.put("area_number",dormBed.split(",")[0]);
        map.put("floor_number",dormBed.split(",")[1]);
        map.put("dorm_floor",dormBed.split(",")[2]);
        map.put("room_number",dormBed.split(",")[3]);
        List<DormBed> list = dormBedService.selectDormBedByMap2(map);
        return getDataTable(list);
    }

    /**
     * 导出床位信息列表
     */
    @PreAuthorize("@ss.hasPermi('DormBed:bed:export')")
    @Log(title = "床位信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DormBed dormBed)
    {
        List<DormBed> list = dormBedService.selectDormBedList(dormBed);
        ExcelUtil<DormBed> util = new ExcelUtil<DormBed>(DormBed.class);
        util.exportExcel(response, list, "床位信息数据");
    }

    /**
     * 获取床位信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('DormBed:bed:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dormBedService.selectDormBedById(id));
    }


    /**
     * 新增床位信息
     */
    @PreAuthorize("@ss.hasPermi('DormBed:bed:add')")
    @Log(title = "床位信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DormBed dormBed)
    {
        return toAjax(dormBedService.insertDormBed(dormBed));
    }

    /**
     * 修改床位信息
     */
    @PreAuthorize("@ss.hasPermi('DormBed:bed:edit')")
    @Log(title = "床位信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DormBed dormBed)
    {
        return toAjax(dormBedService.updateDormBed(dormBed));
    }

    /**
     * 删除床位信息
     */
    @PreAuthorize("@ss.hasPermi('DormBed:bed:remove')")
    @Log(title = "床位信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dormBedService.deleteDormBedByIds(ids));
    }

    @PostMapping("/importTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<DormBed> util = new ExcelUtil<DormBed>(DormBed.class);
        util.importTemplateExcel(response, "床位数据");
    }

    @Log(title = "床位信息管理", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('DormBed:bed:import')")
    @PostMapping("/importData")
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<DormBed> util = new ExcelUtil<DormBed>(DormBed.class);
        List<DormBed> dormBedList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = dormBedService.importDormBedinfor(dormBedList, updateSupport, operName);
        return AjaxResult.success(message);
    }
}
