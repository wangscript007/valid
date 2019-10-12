package com.github.houbb.valid.core.api.constraint.annotation;

import com.github.houbb.heaven.annotation.NotThreadSafe;
import com.github.houbb.valid.api.api.constraint.IConstraint;
import com.github.houbb.valid.core.annotation.constraint.Ranges;
import com.github.houbb.valid.core.api.constraint.Constraints;

/**
 * 范围注解约束实现
 * @author binbin.hou
 * @since 0.0.9
 */
@NotThreadSafe
public class AtRangesConstraint extends AbstractAnnotationConstraint<Ranges> {

    @Override
    protected IConstraint buildConstraint(Ranges annotation) {
        return Constraints.rangesConstraint(annotation.value());
    }

}
