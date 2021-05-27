package com.epam.service.validationServices

import com.epam.model.User

trait Validator {

  def validate(user: List[User]): List[User]

}
