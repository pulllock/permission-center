package fun.pullock.permission.core.converters;

import fun.pullock.permission.core.dao.model.SystemDO;
import fun.pullock.permission.core.model.admin.SystemAddParam;
import fun.pullock.permission.core.model.admin.SystemVO;

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
}
