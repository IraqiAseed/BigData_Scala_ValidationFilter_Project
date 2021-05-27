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
                numberOfChildren: Option[Int],
                address: String,
                company: String) {

}
