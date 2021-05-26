package com.epam.service.validationServices

import com.epam.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import java.util
import scala.collection.JavaConverters.asScalaBufferConverter


@Component
class ValidatorAggregator {

  @Autowired
  var validators: util.List[Validator] = _

  def validateAll(implicit personsLst: scala.collection.immutable.List[User]): List[User] = {
    val scalaList = validators.asScala
    var lst = new scala.collection.mutable.MutableList[User]

    val numOfValidators = scalaList.size
    var valid = personsLst
    for (i <- 0 until numOfValidators) {
      valid = scalaList(i).validate(valid)
    }
    valid
  }
}
