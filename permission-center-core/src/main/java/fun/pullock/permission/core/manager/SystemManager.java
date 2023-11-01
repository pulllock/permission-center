package fun.pullock.permission.core.manager;

import fun.pullock.permission.core.repository.SystemRepository;
import fun.pullock.permission.core.repository.model.SystemDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class SystemManager {

    @Resource
    private SystemRepository systemRepository;

    public SystemDO queryById(Long id) {
        return systemRepository.queryById(id);
    }

    public SystemDO queryByCode(String code) {
        return systemRepository.queryByCode(code);
    }

    public Boolean add(SystemDO newSystem) {
        return systemRepository.add(newSystem);
    }

    public Boolean update(SystemDO systemDO) {
        return systemRepository.update(systemDO);
    }
}
