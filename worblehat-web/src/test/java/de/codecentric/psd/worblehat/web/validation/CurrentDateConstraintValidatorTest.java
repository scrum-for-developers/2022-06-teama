package de.codecentric.psd.worblehat.web.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintValidatorContext;

import java.time.LocalDate;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

class CurrentDateConstraintValidatorTest {

  private CurrentDateValidator currentDateValidator;

  private ConstraintValidatorContext constraintValidatorContext;

  @BeforeEach
  public void setUp() throws Exception {
    currentDateValidator = new CurrentDateValidator();
    constraintValidatorContext = mock(ConstraintValidatorContext.class);
  }

  @Test
  void initializeShouldTakeIsbn() {
    CurrentDate currentDate = mock(CurrentDate.class);
    assertDoesNotThrow(() -> currentDateValidator.initialize(currentDate));
  }

  @Test
  void shouldReturnTrueIfBlank() throws Exception {
    boolean actual = currentDateValidator.isValid("", constraintValidatorContext);
    assertTrue(actual);
  }

  @Test
  void shouldReturnTrueIfYearIsEqualThanNow() throws Exception {
    boolean actual = currentDateValidator.isValid(""+currentYear(), constraintValidatorContext);
    assertTrue(actual);
  }

  @Test
  void shouldReturnTrueIfYearIsLessThanNow() throws Exception {
    boolean actual = currentDateValidator.isValid(""+(currentYear()-1), constraintValidatorContext);
    assertTrue(actual);
  }

  @Test
  void shouldReturnFalseIfInvalidYear() throws Exception {
    boolean actual = currentDateValidator.isValid(""+(currentYear()+1), constraintValidatorContext);
    assertFalse(actual);
  }

  private int currentYear(){
    return LocalDate.now().getYear();
  }
}
