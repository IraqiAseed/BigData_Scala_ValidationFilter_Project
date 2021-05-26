package com.epam.service.validationServices

import com.epam.model.User
import org.springframework.stereotype.Component


@Component
class PhoneValidator extends Validator {

  override def validate(users: List[User]): List[User] = {

    users.filter(users => validator(users.phone))

  }

  private def validator(phoneNumber: String): Boolean = phoneNumber.exists(_.isDigit)

}
