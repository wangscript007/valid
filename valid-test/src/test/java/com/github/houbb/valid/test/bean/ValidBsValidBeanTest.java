package com.github.houbb.valid.test.bean;

import com.github.houbb.valid.api.api.result.IResult;
import com.github.houbb.valid.core.api.fail.Fails;
import com.github.houbb.valid.core.bs.ValidBs;
import com.github.houbb.valid.test.model.User;
import com.github.houbb.valid.test.model.ValidUser;
import org.junit.Assert;
import org.junit.Test;

/**
 * 核心模块-基于 bean 递归验证进行校验
 * @author binbin.hou
 * @since 0.1.2
 */
public class ValidBsValidBeanTest {

    /**
     * 对象验证失败测试
     * @since 0.1.2
     */
    @Test
    public void beanFailTest() {
        User user = new User();
        user.sex("default").password("old").password2("new")
                .failType("DEFINE");

        ValidUser validUser = new ValidUser();
        validUser.user(user);

        IResult result = ValidBs.on(validUser)
                .fail(Fails.failOver())
                .valid()
                .print();

        Assert.assertFalse(result.pass());
    }

    @Test
    public void beanPassTest() {
        User user = new User();
        user.sex("boy").password("old").password2("old")
                .failType("FAIL_OVER").name("name");

        ValidUser validUser = new ValidUser();
        validUser.user(user);

        IResult result = ValidBs.on(validUser)
                .fail(Fails.failOver())
                .valid();

        Assert.assertTrue(result.pass());
    }

}
