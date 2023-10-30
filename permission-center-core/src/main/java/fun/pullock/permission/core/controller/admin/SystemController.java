package fun.pullock.permission.core.controller.admin;

import fun.pullock.general.model.Result;
import fun.pullock.general.model.ServiceException;
import fun.pullock.permission.core.model.ErrorCode;
import fun.pullock.permission.core.model.admin.SystemAddParam;
import fun.pullock.permission.core.model.admin.SystemVO;
import fun.pullock.permission.core.service.SystemService;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/system")
public class SystemController {

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

        // TODO
        return null;
    }
}
