package fun.pullock.permission.core.controller.admin;

import fun.pullock.general.model.Result;
import fun.pullock.general.model.ServiceException;
import fun.pullock.permission.core.model.ErrorCode;
import fun.pullock.permission.core.model.admin.param.SystemAddParam;
import fun.pullock.permission.core.model.admin.param.SystemUpdateParam;
import fun.pullock.permission.core.model.admin.vo.SystemVO;
import fun.pullock.permission.core.service.SystemService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/system")
public class SystemController extends AdminBaseController {

    @Resource
    private SystemService systemService;

    @GetMapping("/detail")
    public Result<SystemVO> detail(@RequestParam Long id) {
        return new Result<>(systemService.detail(id));
    }

    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SystemAddParam param) {
        if (param == null) {
            throw new ServiceException(ErrorCode.SYSTEM_ADD_PARAM_NULL);
        }

        if (StringUtils.isEmpty(param.getCode())) {
            throw new ServiceException(ErrorCode.SYSTEM_ADD_CODE_NULL);
        }

        if (StringUtils.isEmpty(param.getName())) {
            throw new ServiceException(ErrorCode.SYSTEM_ADD_NAME_NULL);
        }

        return new Result<>(systemService.add(param, operator()));
    }

    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SystemUpdateParam param) {
        if (param == null) {
            throw new ServiceException(ErrorCode.SYSTEM_UPDATE_PARAM_NULL);
        }

        if (param.getId() == null || param.getId() <= 0) {
            throw new ServiceException(ErrorCode.SYSTEM_UPDATE_INVALID_ID);
        }

        if (param.getVersion() == null || param.getVersion() <= 0) {
            throw new ServiceException(ErrorCode.SYSTEM_UPDATE_INVALID_VERSION);
        }

        if (StringUtils.isEmpty(param.getName())) {
            throw new ServiceException(ErrorCode.SYSTEM_UPDATE_NAME_NULL);
        }

        return new Result<>(systemService.update(param, operator()));
    }
}
