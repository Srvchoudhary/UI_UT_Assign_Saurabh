package com.knoldus.validator
import com.knoldus.db.companyReadDto
import com.knoldus.models.{company, user}
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class userValidatorTest extends AnyFlatSpec {
  val amanUser: user = user("rishav","singh",22,"Google","rishav.singh@google.in")
  val knoldusCompany: company = company("Knoldus", "knoldus@gmail.com", "Noida")

  val mockedCompanyReadDto = mock[companyReadDto]
  val mockedEmailvalidator = mock[emailValidator]

  val userValidator = new userValidator(mockedCompanyReadDto,mockedEmailvalidator)

  "User" should "be valid" in {

    when(mockedCompanyReadDto.getCompanyByName(amanUser.companyName)) thenReturn(Option(knoldusCompany))
    when(mockedEmailvalidator.emailIdIsValid(amanUser.emailId)) thenReturn(true)

    val result = userValidator.userIsValid(amanUser)
    assert(result)
  }

  "User" should "be invalid because his email is not valid" in {

    when(mockedCompanyReadDto.getCompanyByName(amanUser.companyName)) thenReturn(Option(knoldusCompany))
    when(mockedEmailvalidator.emailIdIsValid(amanUser.emailId)) thenReturn(false)

    val result = userValidator.userIsValid(amanUser)
    assert(!result)
  }

  "User" should "be invalid because his company does not exists in DB" in {

    when(mockedCompanyReadDto.getCompanyByName(amanUser.companyName)) thenReturn(None)
    when(mockedEmailvalidator.emailIdIsValid(amanUser.emailId)) thenReturn(true)

    val result = userValidator.userIsValid(amanUser)
    assert(!result)
  }

  "User" should "be invalid because his email id is not valid and his company does not exists in DB" in {

    when(mockedCompanyReadDto.getCompanyByName(amanUser.companyName)) thenReturn(None)
    when(mockedEmailvalidator.emailIdIsValid(amanUser.emailId)) thenReturn(false)

    val result = userValidator.userIsValid(amanUser)
    assert(!result)
  }
}
