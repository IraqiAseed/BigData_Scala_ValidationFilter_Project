package com.epam.model

case class User(firstName: String,
                lastName: String,
                gender: String,
                age: Double,
                email: String,
                phone: String,
                education: String,
                occupation: String,
                salary: Double,
                maritalStatus: String,
                numberOfChildren: Int,
                address: String,
                company: String) {

  def printName(): Unit = println(firstName)
}
