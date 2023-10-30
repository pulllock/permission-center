package fun.pullock.permission.core.converters;

import fun.pullock.permission.core.dao.model.SystemDO;
import fun.pullock.permission.core.model.admin.SystemVO;

public class SystemConverter {

    public static SystemVO toSystemVO(SystemDO source) {
        if (source == null) {
            return null;
        }

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
}
