package com.epam.service.validationServices

import com.epam.model.{Email, User}
import org.springframework.stereotype.Component

@Component
class EmailValidator extends Validator {


  override def validate(users: List[User]): List[User] = users.filter(person => validator(person.email))

  private def validator(mail: String): Boolean = {

    val email = mail.split("@")

    val answer = Email(email(0), email(1)) match {
      case Email(sender, domain) if (domain.isEmpty || sender.isEmpty) => false
      case Email(_, domain) if (!domain.endsWith(".com")) => false
      case _ => true

    }
    answer
  }


}