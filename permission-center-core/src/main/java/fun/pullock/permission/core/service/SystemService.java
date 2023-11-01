package fun.pullock.permission.core.service;

import fun.pullock.general.model.ServiceException;
import fun.pullock.permission.core.model.ErrorCode;
import fun.pullock.permission.core.model.admin.param.SystemAddParam;
import fun.pullock.permission.core.model.admin.param.SystemUpdateParam;
import fun.pullock.permission.core.model.admin.vo.SystemVO;
import fun.pullock.permission.core.repository.SystemRepository;
import fun.pullock.permission.core.repository.model.SystemDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static fun.pullock.permission.core.converters.SystemConverter.*;

@Service
public class SystemService {

    @Resource
    private SystemRepository systemRepository;

    public SystemVO detail(Long id) {
        SystemDO systemDO = systemRepository.queryById(id);
        if (systemDO == null) {
            return null;
        }
        return toSystemVO(systemDO);
    }

    public Boolean add(SystemAddParam param, Long operatorId) {
        SystemDO systemDO = systemRepository.queryByCode(param.getCode());
        if (systemDO != null) {
            throw new ServiceException(ErrorCode.SYSTEM_ADD_CODE_DUPLICATE);
        }

        SystemDO newSystem = newSystemDO(param, operatorId);
        return systemRepository.add(newSystem);
    }

    public Boolean update(SystemUpdateParam param, Long operator) {
        SystemDO systemDO = systemRepository.queryById(param.getId());
        if (systemDO == null) {
            throw new ServiceException(ErrorCode.SYSTEM_UPDATE_INVALID_ID);
        }

        if (!Objects.equals(param.getVersion(), systemDO.getVersion())) {
            throw new ServiceException(ErrorCode.SYSTEM_UPDATE_INVALID_VERSION);
        }

        updateSystemDO(systemDO, param, operator);
        boolean updateResult = systemRepository.update(systemDO);
        if (!updateResult) {
            throw new ServiceException(ErrorCode.SYSTEM_UPDATE_FAILED);
        }
        return true;
    }
}
