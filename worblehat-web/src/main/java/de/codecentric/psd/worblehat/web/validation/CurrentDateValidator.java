package de.codecentric.psd.worblehat.web.validation;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class CurrentDateValidator implements ConstraintValidator<CurrentDate, String> {

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    // Don't validate null, empty and blank strings, since these are validated by @NotNull,
    // @NotEmpty and @NotBlank
    if (StringUtils.isNotBlank(value)) {
      var dateNumeric = Integer.parseInt(value);
      var currentYear = LocalDate.now().getYear();
      return dateNumeric <= currentYear;
    }
    return true;
  }
}
