package com.knoldus.request
import com.knoldus.models.employee
import com.knoldus.validator.employeeValidator

class employeeimpl(EmployeeValidator:employeeValidator) {
  def createEmployee(Employee: employee): Option[String] = {
    if (EmployeeValidator.employeeIsValid(Employee)) Option(Employee.emailId)
    else None
  }
}
