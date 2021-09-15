package com.knoldus.validator
import com.knoldus.db.companyReadDto
import com.knoldus.models.user
class userValidator(CompanyName: companyReadDto, ValidateEmail: emailValidator) {
  def userIsValid(user: user): Boolean = {

    if(!CompanyName.getCompanyByName(user.companyName).isEmpty && ValidateEmail.emailIdIsValid(user.emailId))
      true
    else
      false
  }
}
