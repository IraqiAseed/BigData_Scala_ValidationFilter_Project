package com.epam.model

import scala.language.implicitConversions

case class ClientsToUsers(client: Client)

object ClientsToUsers {
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
        numberOfChildren = Some(client.numberOfChildren),
        address = "null",
        company = "null"))
  }
}