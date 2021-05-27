package com.epam.service.userServices

import com.epam.model.User
import com.epam.repo.FilesRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class FilterUserByAgeRange extends Tasks {

  @Autowired
  var files: FilesRepo = _

  override def filterUser(users: List[User]): List[User] =
    getAllUsersWhoseAgeFilteredByRange(users, files.getJsonRequestData._1, files.getJsonRequestData._2)


  private def getAllUsersWhoseAgeFilteredByRange(users: List[User], min: Int, max: Int): List[User] = {

    users.filter(client => client.age >= min).filter(client => client.age <= max)

  }
}
