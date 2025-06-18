package com.ruoyi.web.controller.dorm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.onlivepeople.domain.DormOnlivepeople;
import com.ruoyi.onlivepeople.service.IDormOnlivepeopleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 登记入住人员Controller
 * 
 * @author qqq
 * @date 2022-04-13
 */
@RestController
@RequestMapping("/dorm/onlivepeople")
public class DormOnlivepeopleController extends BaseController
{
    @Autowired
    private IDormOnlivepeopleService dormOnlivepeopleService;

    /**
     * 查询登记入住人员列表
     */
    @PreAuthorize("@ss.hasPermi('dorm:onlivepeople:list')")
    @GetMapping("/list")
    public TableDataInfo list(DormOnlivepeople dormOnlivepeople)
    {
        startPage();
        List<DormOnlivepeople> list = dormOnlivepeopleService.selectDormOnlivepeopleList(dormOnlivepeople);
        return getDataTable(list);
    }

    /**
     * 导出登记入住人员列表
     */
    @PreAuthorize("@ss.hasPermi('dorm:onlivepeople:export')")
    @Log(title = "登记入住人员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DormOnlivepeople dormOnlivepeople)
    {
        List<DormOnlivepeople> list = dormOnlivepeopleService.selectDormOnlivepeopleList(dormOnlivepeople);
        ExcelUtil<DormOnlivepeople> util = new ExcelUtil<DormOnlivepeople>(DormOnlivepeople.class);
        util.exportExcel(response, list, "登记入住人员数据");
    }

    /**
     * 获取登记入住人员详细信息
     */
    @PreAuthorize("@ss.hasPermi('dorm:onlivepeople:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dormOnlivepeopleService.selectDormOnlivepeopleById(id));
    }

    /**
     * 新增登记入住人员
     */
    @PreAuthorize("@ss.hasPermi('dorm:onlivepeople:add')")
    @Log(title = "登记入住人员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DormOnlivepeople dormOnlivepeople)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            dormOnlivepeople.setCreatedAt(sdf.parse(sdf.format(new Date())));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return toAjax(dormOnlivepeopleService.insertDormOnlivepeople(dormOnlivepeople));
    }

    /**
     * 修改登记入住人员
     */
    @PreAuthorize("@ss.hasPermi('dorm:onlivepeople:edit')")
    @Log(title = "登记入住人员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DormOnlivepeople dormOnlivepeople)
    {
        return toAjax(dormOnlivepeopleService.updateDormOnlivepeople(dormOnlivepeople));
    }

    /**
     * 删除登记入住人员
     */
    @PreAuthorize("@ss.hasPermi('dorm:onlivepeople:remove')")
    @Log(title = "登记入住人员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dormOnlivepeopleService.deleteDormOnlivepeopleByIds(ids));
    }
}
