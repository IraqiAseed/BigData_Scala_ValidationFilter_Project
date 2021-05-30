package com.epam.repo

import com.epam.model.{Person, User}
import com.fasterxml.jackson.core.`type`.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import com.epam.model.PersonToUser._

import java.io.File

@Component
case class PersonReader(@Value("${person_location}") pathPersonFile: String) extends FilesRepo {

  val mapper = new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)


  override def readLines: List[User] =
    mapper.readValue(new File(pathPersonFile), new TypeReference[List[Person]]() {})


}
