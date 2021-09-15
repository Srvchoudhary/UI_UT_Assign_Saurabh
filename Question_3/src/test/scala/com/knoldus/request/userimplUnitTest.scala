package com.knoldus.request
import com.knoldus.models.user
import com.knoldus.validator.userValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec

class userimplUnitTest extends AnyFlatSpec {
  val mockedUserValidator = mock[userValidator]
  val saurabhUser: user = user("saurabh","choudhary",23,"Knoldus","saurabh.choudhary@knoldus.com")

  "User" should "be created" in {
    val userImpl = new userimpl(mockedUserValidator)

    when(mockedUserValidator.userIsValid(saurabhUser)) thenReturn(true)
    val result = userImpl.createUser(saurabhUser)
    assert(!result.isEmpty)
  }

  "User" should "not be created" in {
    val userImpl = new userimpl(mockedUserValidator)

    when(mockedUserValidator.userIsValid(saurabhUser)) thenReturn(false)
    val result = userImpl.createUser(saurabhUser)
    assert(result.isEmpty)
  }
}
