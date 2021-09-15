package com.knoldus.request
import com.knoldus.models.company
import com.knoldus.validator.companyValidator
class companyimpl(CompanyValidator:companyValidator) {
  def createCompany(Company: company): Option[String] = {
    if (CompanyValidator.companyIsValid(Company)) {
      println("=>Company ='"+Company.name+"' is created successfully!")
      Option(Company.name)
    }

    else {
      println("=>Company ='"+Company.name+"' is not created due to above reason!")
      None
    }
  }
}
