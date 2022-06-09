package de.codecentric.psd.worblehat.web.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

  @ParameterizedTest
  @ValueSource(strings = {"test@test.de", "x@x.com"})
  void shouldReturnTrueIfValid(String input) throws Exception {
    boolean actual =
      customEmailConstraintValidator.isValid(input, constraintValidatorContext);
    assertTrue(actual);
  }

  @ParameterizedTest
  @ValueSource(strings = {"test@test", "test@", "test@test.", "@"})
  void shouldReturnFalseIfNoDomain(String input) throws Exception {
    boolean actual =
      customEmailConstraintValidator.isValid(input, constraintValidatorContext);
    assertFalse(actual);
  }

  @ParameterizedTest
  @ValueSource(strings = {"test", "test .de", ".de"})
  void shouldReturnFalseIfNoAt(String input) throws Exception {
    boolean actual = customEmailConstraintValidator.isValid(input, constraintValidatorContext);
    assertFalse(actual);
  }
}
