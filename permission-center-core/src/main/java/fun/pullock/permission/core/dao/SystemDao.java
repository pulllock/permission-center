package fun.pullock.permission.core.dao;

import fun.pullock.permission.core.dao.mapper.SystemMapper;
import fun.pullock.permission.core.dao.model.SystemDO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class SystemDao {

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
