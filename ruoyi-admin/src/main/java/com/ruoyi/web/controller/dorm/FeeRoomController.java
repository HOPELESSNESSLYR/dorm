package com.ruoyi.web.controller.dorm;

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
import com.ruoyi.feeroom.domain.FeeRoom;
import com.ruoyi.feeroom.service.IFeeRoomService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 房间费用Controller
 * 
 * @author lyr
 * @date 2025-07-01
 */
@RestController
@RequestMapping("/fee/room")
public class FeeRoomController extends BaseController
{
    @Autowired
    private IFeeRoomService feeRoomService;

    /**
     * 查询房间费用列表
     */
    @PreAuthorize("@ss.hasPermi('fee:room:list')")
    @GetMapping("/list")
    public TableDataInfo list(FeeRoom feeRoom)
    {
        startPage();
        List<FeeRoom> list = feeRoomService.selectFeeRoomList(feeRoom);
        return getDataTable(list);
    }

    /**
     * 导出房间费用列表
     */
    @PreAuthorize("@ss.hasPermi('fee:room:export')")
    @Log(title = "房间费用", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FeeRoom feeRoom)
    {
        List<FeeRoom> list = feeRoomService.selectFeeRoomList(feeRoom);
        ExcelUtil<FeeRoom> util = new ExcelUtil<FeeRoom>(FeeRoom.class);
        util.exportExcel(response, list, "房间费用数据");
    }

    /**
     * 获取房间费用详细信息
     */
    @PreAuthorize("@ss.hasPermi('fee:room:query')")
    @GetMapping(value = "/{roomfeeId}")
    public AjaxResult getInfo(@PathVariable("roomfeeId") Long roomfeeId)
    {
        return AjaxResult.success(feeRoomService.selectFeeRoomByRoomfeeId(roomfeeId));
    }

    /**
     * 新增房间费用
     */
    @PreAuthorize("@ss.hasPermi('fee:room:add')")
    @Log(title = "房间费用", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FeeRoom feeRoom)
    {
        return toAjax(feeRoomService.insertFeeRoom(feeRoom));
    }

    /**
     * 修改房间费用
     */
    @PreAuthorize("@ss.hasPermi('fee:room:edit')")
    @Log(title = "房间费用", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FeeRoom feeRoom)
    {
        return toAjax(feeRoomService.updateFeeRoom(feeRoom));
    }

    /**
     * 删除房间费用
     */
    @PreAuthorize("@ss.hasPermi('fee:room:remove')")
    @Log(title = "房间费用", businessType = BusinessType.DELETE)
	@DeleteMapping("/{roomfeeIds}")
    public AjaxResult remove(@PathVariable Long[] roomfeeIds)
    {
        return toAjax(feeRoomService.deleteFeeRoomByRoomfeeIds(roomfeeIds));
    }
}
