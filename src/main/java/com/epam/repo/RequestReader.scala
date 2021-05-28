package com.epam.repo

import com.epam.model.{Request, User}
import com.fasterxml.jackson.core.`type`.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import java.io.File

@Component
case class RequestReader(@Value("${request_location}") pathRequestFile: String)  {

  val mapper = new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)

   def readRequest: (Int, Int, String) = {
    val req = mapper.readValue(new File(pathRequestFile), new TypeReference[List[Request]]() {})
    (req.head.minAge.toInt, req.head.maxAge.toInt, req.head.prefixName)

  }
}
