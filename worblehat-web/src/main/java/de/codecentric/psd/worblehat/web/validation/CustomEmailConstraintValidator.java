package de.codecentric.psd.worblehat.web.validation;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomEmailConstraintValidator implements ConstraintValidator<CustomEmail, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    // Don't validate null, empty and blank strings, since these are validated by @NotNull,
    // @NotEmpty and @NotBlank
    if (StringUtils.isNotBlank(value)) {
      return EmailValidator.getInstance().isValid(value);
    }
    return true;
  }
}
