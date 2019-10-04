/*
 * Hibernate Validator, declare and validate application constraints
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.hibernate.validator.constraints.br;

import org.hibernate.validator.constraints.Mod11Check;
import org.hibernate.validator.constraints.Mod11Check.List;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Validates a <a href="http://ghiorzi.org/cgcancpf.htm">T\u00edtulo Eleitoral</a> (Brazilian Voter ID card number).
 *
 * @author George Gastaldi
 */
@Pattern(regexp = "[0-9]{12}")
@List({
		@Mod11Check(threshold = 9,
				endIndex = 7,
				checkDigitIndex = 10),
		@Mod11Check(threshold = 9,
				startIndex = 8,
				endIndex = 10,
				checkDigitIndex = 11)
})
@ReportAsSingleViolation
@Documented
@Constraint(validatedBy = { })
@SupportedValidationTarget(ValidationTarget.ANNOTATED_ELEMENT)
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
public @interface TituloEleitoral {
	String message() default "{org.hibernate.validator.constraints.br.TituloEleitoral.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}