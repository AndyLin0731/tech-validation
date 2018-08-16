/*
 * Copyright (c)  2018. houbinbin Inc.
 * tech-validation All rights reserved.
 */

import com.github.houbb.tech.validation.reflect.interfaces.ITag;
import com.github.houbb.tech.validation.reflect.util.ClassUtil;

import org.junit.Test;

import java.util.List;

/**
 * <p> </p>
 *
 * <pre> Created: 2018/8/16 下午3:37  </pre>
 * <pre> Project: tech-validation  </pre>
 *
 * @author houbinbin
 * @version 1.0
 * @since JDK 1.7
 */
public class ClassUtilTest {

    @Test
    public void test() {
        List<Class> iTagList = ClassUtil.getAllClassByInterface(ITag.class);
        for(Class clazz : iTagList) {
            System.out.println(clazz);
        }
    }

}
