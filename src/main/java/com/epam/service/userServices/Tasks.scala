package com.epam.service.userServices

import com.epam.model.User


trait Tasks {

  def filterUser(users: List[User]): List[User]

}
