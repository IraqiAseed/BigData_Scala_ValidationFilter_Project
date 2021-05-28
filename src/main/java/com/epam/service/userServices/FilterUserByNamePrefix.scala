package com.epam.service.userServices

import com.epam.model.User
import com.epam.repo.{FilesRepo, RequestReader}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class FilterUserByNamePrefix extends Filtering {

  @Autowired
  var request: RequestReader = _

  override def filterUser(users: List[User]): List[User] =
    getAllPeopleWhoseNamesStartWith(users, request.readRequest._3)


  private def getAllPeopleWhoseNamesStartWith(users: List[User], prefix: String): List[User] = {
    users.filter(user => user.firstName.startsWith(prefix))
  }

}
