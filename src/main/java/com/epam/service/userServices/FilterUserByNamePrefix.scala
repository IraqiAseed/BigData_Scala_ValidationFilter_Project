package com.epam.service.userServices

import com.epam.model.User
import com.epam.repo.FilesRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class FilterUserByNamePrefix extends Tasks {

  @Autowired
  var files: FilesRepo = _

  override def filterUser(users: List[User]): List[User] =
    getAllPeopleWhoseNamesStartWith(users, files.getJsonRequestData._3)


  private def getAllPeopleWhoseNamesStartWith(users: List[User], prefix: String): List[User] = {
    users.filter(user => user.firstName.startsWith(prefix))
  }

}
