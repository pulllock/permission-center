package fun.pullock.permission.core.controller.admin;

import fun.pullock.permission.core.service.PermissionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/permission")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping("/list")
    public void list(@RequestParam("systemCode") String systemCode) {
        Long userId = 1L;
        permissionService.list(userId, systemCode);
    }
}
