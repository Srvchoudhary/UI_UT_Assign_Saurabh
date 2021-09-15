package com.knoldus.db
import org.scalatest.flatspec.AnyFlatSpec
class companyReadDtoTest extends AnyFlatSpec {
  "Company" should "exist" in {
    val companyReadDto = new companyReadDto
    val result = companyReadDto.getCompanyByName("Knoldus")
    assert(!result.isEmpty)
  }

  "Company" should "not exist" in {
    val companyReadDto = new companyReadDto
    val result = companyReadDto.getCompanyByName("Google")
    assert(result.isEmpty)
  }
}
