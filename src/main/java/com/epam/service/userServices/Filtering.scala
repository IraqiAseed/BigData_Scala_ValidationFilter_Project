package com.epam.service.userServices

import com.epam.model.User


trait Filtering {

  def filterUser(users: List[User]): List[User]

}
