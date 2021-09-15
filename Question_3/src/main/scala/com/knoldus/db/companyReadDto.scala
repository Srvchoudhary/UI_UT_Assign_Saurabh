package com.knoldus.db
import com.knoldus.models.company

import scala.collection.immutable.HashMap
class companyReadDto {
  val knoldusCompany: company = company("Knoldus","knoldus@gmail.com", "Noida")
  val samsungCompany: company = company("samsung","samsung123@gmail.com", "Noida")
  val companies: HashMap[String, company] = HashMap("Knoldus" -> knoldusCompany, "samsung" -> samsungCompany)

  def getCompanyByName(name: String): Option[company] = companies.get(name)
}
