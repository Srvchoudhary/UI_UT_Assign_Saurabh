package com.knoldus.request
import com.knoldus.models.user
import com.knoldus.validator.userValidator

class userimpl(UserValidator:userValidator){
  def createUser(User: user): Option[String] = {
    if (UserValidator.userIsValid(User)) Option(User.emailId)
    else None
  }
}
