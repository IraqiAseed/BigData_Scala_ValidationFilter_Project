package com.epam.model

import scala.language.implicitConversions


case class PersonToUser(person: Person)

object PersonToUser {

  implicit def personsToUsers(persons: List[Person]): List[User] = persons.map(personToUser)

  implicit def personToUser(person: Person): User = {

    User(
      firstName = person.name.split(" ")(0),
      lastName = person.name.split(" ")(1),
      gender = person.gender,
      age = person.age,
      email = person.email,
      phone = person.phone,
      education = "null",
      occupation = "null",
      salary = 0,
      maritalStatus = "null",
      numberOfChildren = None,
      address = person.address,
      company = person.company)
  }


}

