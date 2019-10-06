package com.github.houbb.valid.core.api.constraint;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.valid.api.api.constraint.IConstraintContext;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * {@link javax.validation.constraints.Digits} 约束注解实现
 * @author binbin.hou
 * @since 0.0.3
 * @see CharSequence
 * @see BigDecimal
 * @see BigInteger
 * @see Integer
 * @see Byte
 * @see Short
 * @see Long
 */
@ThreadSafe
class DigitsConstraint extends AbstractCombineConstraint {

    /**
     * 整数部分最多多少位
     * @since 0.0.3
     */
    private final int integer;

    /**
     * 小数部分最多多少位
     * @since 0.0.3
     */
    private final int fraction;

    public DigitsConstraint(int integer, int fraction) {
        this.integer = integer;
        this.fraction = fraction;
    }

    public DigitsConstraint(int integer) {
        this(integer, 0);
    }

    @Override
    protected List<Class> getSupportClassList() {
        return SupportClassTypeUtil.getDigitsSupportClassList();
    }

    /**
     * 获取对应的约束实现
     * @param context 上下文
     * @return 约束实现
     * @since 0.0.3
     */
    @Override
    protected AbstractConstraint getConstraintInstance(final IConstraintContext context) {
        final Object value = context.value();

        if(value instanceof CharSequence) {
            return new DigitsBigDecimalConstraint(integer, fraction);
        }

        if(value instanceof BigDecimal) {
            return new DigitsBigDecimalConstraint(integer, fraction);
        }

        if(value instanceof  BigInteger) {
            return new DigitsBigIntegerConstraint(integer, fraction);
        }

        // 其他，直接使用 long 进行处理
        return new DigitsLongConstraint(integer, fraction);
    }

}
