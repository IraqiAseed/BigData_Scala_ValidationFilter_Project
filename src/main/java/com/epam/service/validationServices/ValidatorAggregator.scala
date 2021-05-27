package com.epam.service.validationServices

import com.epam.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import java.util
import scala.collection.JavaConverters.asScalaBufferConverter


@Component
class ValidatorAggregator {

  @Autowired
  var validatorsList: util.List[Validator] = _

  def validateAll( personsToValidate: scala.collection.immutable.List[User]): List[User] = {

    val validators = validatorsList.asScala
    var persons: List[User] = personsToValidate

    for (i <- validators.indices) persons = validators(i).validate(persons)

    persons
  }




}
