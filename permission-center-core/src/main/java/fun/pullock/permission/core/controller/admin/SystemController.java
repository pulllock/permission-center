package fun.pullock.permission.core.controller.admin;

import fun.pullock.general.model.Result;
import fun.pullock.permission.core.model.admin.SystemVO;
import fun.pullock.permission.core.service.SystemService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/system")
public class SystemController {

    @Resource
    private SystemService systemService;

    @GetMapping("/detail")
    public Result<SystemVO> detail(@RequestParam Long id) {
        return new Result<>(systemService.detail(id));
    }
}
