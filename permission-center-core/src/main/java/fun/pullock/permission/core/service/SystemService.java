package fun.pullock.permission.core.service;

import fun.pullock.general.model.ServiceException;
import fun.pullock.permission.core.dao.model.SystemDO;
import fun.pullock.permission.core.manager.SystemManager;
import fun.pullock.permission.core.model.ErrorCode;
import fun.pullock.permission.core.model.admin.SystemAddParam;
import fun.pullock.permission.core.model.admin.SystemVO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import static fun.pullock.permission.core.converters.SystemConverter.newSystemDO;
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

    public Boolean add(SystemAddParam param, Long operatorId) {
        SystemDO systemDO = systemManager.queryByCode(param.getCode());
        if (systemDO != null) {
            throw new ServiceException(ErrorCode.SYSTEM_ADD_CODE_DUPLICATE);
        }

        SystemDO newSystem = newSystemDO(param, operatorId);
        return systemManager.add(newSystem);
    }
}
