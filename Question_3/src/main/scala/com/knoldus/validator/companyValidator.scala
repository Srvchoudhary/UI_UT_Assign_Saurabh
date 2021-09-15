package com.knoldus.validator
import com.knoldus.db.companyReadDto
import com.knoldus.models.company

class companyValidator(companyName: companyReadDto,validateEmail: emailValidator) {

  def companyIsValid(company: company): Boolean = {
    if(companyName.getCompanyByName(company.name).isEmpty &&
      validateEmail.emailIdIsValid(company.emailId))
      true
    else
      false
  }
}