package fun.pullock.permission.core.repository;

import fun.pullock.permission.core.repository.mapper.SystemMapper;
import fun.pullock.permission.core.repository.model.SystemDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class SystemRepository {

    @Resource
    private SystemMapper systemMapper;

    public SystemDO queryById(Long id) {
        return systemMapper.selectByPrimaryKey(id);
    }

    public SystemDO queryByCode(String code) {
        return systemMapper.selectByCode(code);
    }

    public Boolean add(SystemDO newSystem) {
        return systemMapper.insert(newSystem) == 1;
    }

    public Boolean update(SystemDO systemDO) {
        return systemMapper.updateByPrimaryKeyWithVersion(systemDO) == 1;
    }
}
