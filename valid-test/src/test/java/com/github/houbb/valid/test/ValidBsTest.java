package com.github.houbb.valid.test;

import com.github.houbb.valid.api.api.result.IResult;
import com.github.houbb.valid.core.api.constraint.NotNullConstraint;
import com.github.houbb.valid.core.api.constraint.NullConstraint;
import com.github.houbb.valid.core.bs.ValidBs;
import org.junit.Test;

/**
 * @author binbin.hou
 * @since 0.0.2
 */
public class ValidBsTest {

    @Test
    public void notNullTest() {
        IResult result = ValidBs.failType().on(null, new NotNullConstraint()).result();
        System.out.println(result);
    }

    @Test
    public void nullTest() {
        IResult result = ValidBs.failType().on(null, new NullConstraint()).result();
        System.out.println(result);
    }

}
