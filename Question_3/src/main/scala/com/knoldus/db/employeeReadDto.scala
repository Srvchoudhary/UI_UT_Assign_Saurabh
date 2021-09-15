package com.knoldus.db
import com.knoldus.models.employee
import scala.collection.immutable.HashMap
class employeeReadDto {
  val saurabhEmployee: employee = employee("saurabh","choudhary",23,12000,"Intern","knoldus","saurabh.choudhary@knoldus.com")
  val rishavEmployee: employee = employee("rishav","singh",24,15000,"Software Engineer","samsung","rishav.singh@philips.com")

  val employees: HashMap[String, employee] = HashMap("saurabh" -> saurabhEmployee, "rishav" -> rishavEmployee)
  def getEmployeeByName(name: String): Option[employee] = employees.get(name)
}
