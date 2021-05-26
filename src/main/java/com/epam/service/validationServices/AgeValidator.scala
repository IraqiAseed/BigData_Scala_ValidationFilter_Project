package com.epam.service.validationServices

import com.epam.model.User
import org.springframework.stereotype.Component


@Component
class AgeValidator extends Validator {

  override def validate(users: List[User]): List[User] = users.filter(user => user.age > 0)

}