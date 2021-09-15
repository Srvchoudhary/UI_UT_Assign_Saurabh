package com.knoldus.validator
import org.scalatest.flatspec.AnyFlatSpec

class emailValidatorTest extends AnyFlatSpec {
  "email" should "be invalid as it does not contains recipient name" in {
    val emailValidator = new emailValidator
    assert(!emailValidator.emailIdIsValid("@gmail.com"))
  }

  "email" should "be invalid as it does not contains @ symbol" in {
    val emailValidator = new emailValidator
    assert(emailValidator.emailIdIsValid("saurabh@gmail.com"))
  }

  "email" should "be invalid as it does not contains domain name" in {
    val emailValidator = new emailValidator
    assert(!emailValidator.emailIdIsValid("saurabh@.com"))
  }

  "email" should "be invalid as it does not contains .(com,net,org)" in {
    val emailValidator = new emailValidator
    assert(!emailValidator.emailIdIsValid("saurabh.in"))
  }

  "email" should "be valid" in {
    val emailValidator = new emailValidator
    assert(emailValidator.emailIdIsValid("saurabh@gmail.com"))
  }
}
