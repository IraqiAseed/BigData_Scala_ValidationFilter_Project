package com.epam.service.userServices

import com.epam.model.User

trait UserService {

  def getAllUsersWhoseAgeFilteredByRange(users: List[User], min: Int, max: Int): List[User]

  def getAllPeopleWhoseNamesStartWith(users: List[User], prefix: String): List[User]

  def getAllMarriedMenPlusThreeAndMoreChildren(users: List[User]): List[User]
}
