package com.knoldus.request
import com.knoldus.models.company
import com.knoldus.validator.companyValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.flatspec.AnyFlatSpec
class companyimplUnitTest extends AnyFlatSpec {
  val mockedCompanyValidator = mock[companyValidator]
  val knoldusCompany: company = company("Knoldus", "knoldus@gmail.com", "Noida")

  "Company" should "be created" in {
    val companyImpl = new companyimpl(mockedCompanyValidator)

    when(mockedCompanyValidator.companyIsValid(knoldusCompany)) thenReturn(true)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(!result.isEmpty)
  }

  "Company" should "not be created" in {
    val companyImpl = new companyimpl(mockedCompanyValidator)

    when(mockedCompanyValidator.companyIsValid(knoldusCompany)) thenReturn(false)
    val result = companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }
}
