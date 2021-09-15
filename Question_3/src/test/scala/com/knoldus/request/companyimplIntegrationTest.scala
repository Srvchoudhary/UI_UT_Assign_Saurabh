package com.knoldus.request
import com.knoldus.db.companyReadDto
import com.knoldus.models.company
import com.knoldus.validator.{companyValidator, emailValidator}

import org.scalatest.flatspec.AnyFlatSpec
class companyimplIntegrationTest extends AnyFlatSpec {
  val companyName = new companyReadDto
  val validateEmail = new emailValidator
  val companyValidator = new companyValidator(companyName,validateEmail)

  "Company" should "not be created as it already exists in DB" in {
    val knoldusCompany: company = company("Knoldus", "knoldus@gmail.com", "Noida")

    val companyImpl = new companyimpl(companyValidator)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }

  "Company" should "not be created as email id is not valid" in {
    val googleCompany: company = company("Google", "google@gmail", "Gurugram")

    val companyImpl = new companyimpl(companyValidator)
    val result = companyImpl.createCompany(googleCompany)
    assert(result.isEmpty)
  }

  "Company" should "not be created as it already exists in DB and email id is not valid" in {
    val knoldusCompany: company = company("Knoldus", "knoldus@gmailcom", "Noida")

    val companyImpl = new companyimpl(companyValidator)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }

  "Company" should "be created" in {
    val googleCompany: company = company("Google", "google@gmail.com", "Gurugram")

    val companyImpl = new companyimpl(companyValidator)
    val result = companyImpl.createCompany(googleCompany)
    assert(!result.isEmpty)
  }
}
