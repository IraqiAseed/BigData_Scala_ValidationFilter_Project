package com.epam.model

import scala.language.implicitConversions

case class ClientToUser(client: Client)

object ClientToUser {

  implicit def clientsToUsers(clients: List[Client]): List[User] = clients.map(clientToUser)

  implicit def clientToUser(client: Client): User = {

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
        company = "null")
  }
}