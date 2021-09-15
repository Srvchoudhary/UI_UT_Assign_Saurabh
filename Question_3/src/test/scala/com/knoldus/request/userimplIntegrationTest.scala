package com.knoldus.request
import com.knoldus.db.companyReadDto
import com.knoldus.models.user
import com.knoldus.validator.{emailValidator, userValidator}
import org.scalatest.flatspec.AnyFlatSpec
class userimplIntegrationTest extends AnyFlatSpec {
  val companyName = new companyReadDto
  val validateEmail = new emailValidator
  val userValidator = new userValidator(companyName,validateEmail)

  val userImpl = new userimpl(userValidator)

  "User" should "not be created as company does not exists in DB" in {
    val mohitUser: user = user("Mohit","Kumar",24,"Google","mohit.kumar@gmail.com")

    val result = userImpl.createUser(mohitUser)
    assert(result.isEmpty)
  }

  "User" should "not be created as email id is not valid" in {
    val yanshikUser: user = user("Yanshik","Rajput",23,"Knoldus","yanshik.rajput@knoldus")

    val result = userImpl.createUser(yanshikUser)
    assert(result.isEmpty)
  }

  "User" should "not be created as company does not exists in DB and email id is not valid" in {
    val sivamUser: user = user("sivam","Kumar",22,"Microsoft","sivam.kumar@microsoft")

    val result = userImpl.createUser(sivamUser)
    assert(result.isEmpty)
  }

  "User" should "be created" in {
    val saurabhUser: user = user("saurabh","Gupta",23,"Knoldus","saurabh.choudhary@knoldus.com")

    val result = userImpl.createUser(saurabhUser)
    assert(!result.isEmpty)
  }
}
