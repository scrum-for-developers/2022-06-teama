package de.codecentric.psd.worblehat.web.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintValidatorContext;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

class EmailConstraintValidatorTest {

  ConstraintValidatorContext constraintValidatorContext;
  private CustomEmailConstraintValidator customEmailConstraintValidator;

  @BeforeEach
  void setUp() throws Exception {
    customEmailConstraintValidator = new CustomEmailConstraintValidator();
    constraintValidatorContext = mock(ConstraintValidatorContext.class);
  }

  @Test
  void initializeShouldTakeEmail() {
    CustomEmail numeric = mock(CustomEmail.class);
    assertDoesNotThrow(() -> customEmailConstraintValidator.initialize(numeric));
  }

  @Test
  void shouldReturnTrueIfBlank() throws Exception {
    boolean actual = customEmailConstraintValidator.isValid("", constraintValidatorContext);
    assertTrue(actual);
  }

  @Test
  void shouldReturnTrueIfValid() throws Exception {
    boolean actual =
      customEmailConstraintValidator.isValid("test@test.de", constraintValidatorContext);
    assertTrue(actual);
  }

  @Test
  void shouldReturnFalseIfNoDomain() throws Exception {
    boolean actual =
      customEmailConstraintValidator.isValid("test@test", constraintValidatorContext);
    assertFalse(actual);
  }

  @Test
  void shouldReturnFalseIfNoAt() throws Exception {
    boolean actual = customEmailConstraintValidator.isValid("test", constraintValidatorContext);
    assertFalse(actual);
  }
}
