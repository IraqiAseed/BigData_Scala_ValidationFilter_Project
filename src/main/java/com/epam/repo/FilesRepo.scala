package com.epam.repo

import com.epam.model.User


trait FilesRepo {

  def readLines: List[User]

}
