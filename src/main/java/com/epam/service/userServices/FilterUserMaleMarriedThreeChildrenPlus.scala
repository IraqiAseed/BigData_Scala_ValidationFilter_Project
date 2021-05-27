package com.epam.service.userServices

import com.epam.model.User
import org.springframework.stereotype.Component
@Component
class FilterUserMaleMarriedThreeChildrenPlus extends Tasks {

  override def filterUser(users: List[User]): List[User] = getAllMarriedMenPlusThreeAndMoreChildren(users)

  private def getAllMarriedMenPlusThreeAndMoreChildren(user: List[User]): List[User] = {
    user
      .filter(client => client.gender.equalsIgnoreCase("male"))
      .filter(client => client.maritalStatus.equalsIgnoreCase("married"))
      .filter(client => client.numberOfChildren.getOrElse(0) > 2)
  }
}
