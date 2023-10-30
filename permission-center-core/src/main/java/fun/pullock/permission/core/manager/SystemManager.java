package fun.pullock.permission.core.manager;

import fun.pullock.permission.core.dao.SystemDao;
import fun.pullock.permission.core.dao.model.SystemDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class SystemManager {

    @Resource
    private SystemDao systemDao;

    public SystemDO queryById(Long id) {
        return systemDao.queryById(id);
    }
}
