package com.epam.model

import scala.language.implicitConversions


case class HumanToUser(person: Person)

object HumanToUser {

  implicit def personsToUsers(persons: List[Person]): List[User] = {
    persons.map(person =>
      User(
        firstName = person.name.split(" ")(0),
        lastName = person.name.split(" ")(1),
        gender = person.gender,
        age = person.age,
        email = person.email,
        phone = person.phone,
        education = "UNKNOWN",
        occupation = "UNKNOWN",
        salary = 0,
        maritalStatus = "UNKNOWN",
        numberOfChildren = 0,
        address = person.address,
        company = person.company))
  }

  implicit def clientsToUsers(clients: List[Client]): List[User] = {
    clients.map(client =>
      User(
        firstName = client.firstName,
        lastName = client.lastName,
        gender = client.gender,
        age = client.age,
        email = client.email,
        phone = client.phone,
        education = client.education,
        occupation = client.occupation,
        salary = client.salary,
        maritalStatus = client.maritalStatus,
        numberOfChildren = client.numberOfChildren,
        address = "UNKNOWN",
        company = "UNKNOWN"))
  }

}

