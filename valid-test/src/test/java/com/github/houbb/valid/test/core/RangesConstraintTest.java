package com.github.houbb.valid.test.core;

import com.github.houbb.valid.api.api.result.IResult;
import com.github.houbb.valid.core.api.constraint.Constraints;
import com.github.houbb.valid.core.bs.ValidBs;
import org.junit.Assert;
import org.junit.Test;

/**
 * 值指定范围内测试
 * @author binbin.hou
 * @since 0.1.2
 */
public class RangesConstraintTest {

    @Test
    public void notPassTest() {
        IResult result = ValidBs.on("DEFINE", Constraints.rangesConstraint("FAIL_OVER",
                "FAIL_FAST"))
            .valid();

        Assert.assertFalse(result.pass());
    }

    @Test
    public void passTest(){
        IResult result = ValidBs.on("FAIL_OVER", Constraints.rangesConstraint("FAIL_OVER",
                "FAIL_FAST"))
                .valid();

        Assert.assertTrue(result.pass());
    }

}
