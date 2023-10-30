package fun.pullock.permission.core.service;

import fun.pullock.permission.core.dao.model.SystemDO;
import fun.pullock.permission.core.manager.SystemManager;
import fun.pullock.permission.core.model.admin.SystemVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import static fun.pullock.permission.core.converters.SystemConverter.toSystemVO;

@Service
public class SystemService {

    @Resource
    private SystemManager systemManager;

    public SystemVO detail(Long id) {
        SystemDO systemDO = systemManager.queryById(id);
        if (systemDO == null) {
            return null;
        }
        return toSystemVO(systemDO);
    }
}
