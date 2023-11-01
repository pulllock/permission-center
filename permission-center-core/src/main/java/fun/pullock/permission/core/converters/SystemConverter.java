package fun.pullock.permission.core.converters;

import fun.pullock.permission.core.repository.model.SystemDO;
import fun.pullock.permission.core.model.admin.param.SystemAddParam;
import fun.pullock.permission.core.model.admin.param.SystemUpdateParam;
import fun.pullock.permission.core.model.admin.vo.SystemVO;

import java.time.LocalDateTime;

public class SystemConverter {

    public static SystemVO toSystemVO(SystemDO source) {
        SystemVO target = new SystemVO();
        target.setId(source.getId());
        target.setCreatorId(source.getCreatorId());
        target.setModifierId(source.getModifierId());
        target.setCreateTime(source.getCreateTime());
        target.setUpdateTime(source.getUpdateTime());
        target.setVersion(source.getVersion());
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        return target;
    }


    public static SystemDO newSystemDO(SystemAddParam source, Long operateId) {
        SystemDO target = new SystemDO();
        target.setCode(source.getCode());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        target.setCreatorId(operateId);
        target.setModifierId(operateId);
        target.setCreateTime(LocalDateTime.now());
        target.setUpdateTime(target.getCreateTime());
        target.setVersion(1);
        return target;
    }

    public static void updateSystemDO(SystemDO old, SystemUpdateParam param, Long operatorId) {
        old.setName(param.getName());
        old.setDescription(param.getDescription());
        old.setUpdateTime(LocalDateTime.now());
        old.setModifierId(operatorId);
    }
}
