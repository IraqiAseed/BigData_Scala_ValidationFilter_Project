package com.epam.service.userServices

import com.epam.model.User

class UserServiceImpl extends UserService {


  override def getAllUsersWhoseAgeFilteredByRange(users: List[User], min: Int, max: Int): List[User] = {

    users.filter(client => client.age >= min).filter(client => client.age <= max)

  }

  override def getAllPeopleWhoseNamesStartWith(users: List[User], prefix: String): List[User] = {
    users.filter(user => user.firstName.startsWith(prefix))
  }

  override def getAllMarriedMenPlusThreeAndMoreChildren(clients: List[User]): List[User] = {
      clients
      .filter(client => client.gender.equalsIgnoreCase("male"))
      .filter(client => client.maritalStatus.equalsIgnoreCase("married"))
      .filter(client => client.numberOfChildren > 2)
  }
}
