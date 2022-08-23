package com.fang.wxcloudrun.handler.mybaitsPlus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author Fph
 * @since 2022年8月23日16:03:05
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Object createBy = getFieldValByName("createdBy", metaObject);
        Object createDate = getFieldValByName("createdDate", metaObject);

        if (createBy == null) {
            this.strictInsertFill(metaObject, "createdBy", String.class, "system");
        }

        if (createDate == null) {
            this.strictInsertFill(metaObject, "createdDate", Instant.class, Instant.now());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateBy = getFieldValByName("lastModifiedBy", metaObject);
        Object updateDate = getFieldValByName("lastModifiedDate", metaObject);

        if (updateBy == null) {
            this.strictUpdateFill(metaObject, "lastModifiedBy", String.class,  "system");
        }

        if (updateDate == null) {
            this.strictUpdateFill(metaObject, "lastModifiedDate", Instant.class, Instant.now());
        }
    }
}
