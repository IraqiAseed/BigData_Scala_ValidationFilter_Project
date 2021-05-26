package com.epam.repo

import com.epam.model.{Client, Person, Request}
import com.fasterxml.jackson.core.`type`.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.{Configuration, PropertySource}
import org.springframework.stereotype.Component

import java.io.{File, FileInputStream}
import scala.collection.convert.ImplicitConversions.`iterable AsScalaIterable`


@Component
case class FileRepoImpl(@Value("${person_location}") pathPersonFile: String,
                        @Value("${client_location}") pathClientFile: String,
                        @Value("${request_location}") pathRequestFile: String) extends FilesRepo {

  val mapper = new ObjectMapper()
  mapper.registerModule(DefaultScalaModule)


  override def getLinesFromPersonJsonFile: List[Person] = {
    mapper.readValue(new File(pathPersonFile), new TypeReference[List[Person]]() {})

  }

  override def getLinesFromClientXlsFile: List[Client] = {

    val file: FileInputStream = new FileInputStream(new File(pathClientFile))
    val workbook = WorkbookFactory.create(file)
    val clientsSheet = workbook.getSheetAt(0)
    workbook.close()

    clientsSheet.toList.tail
      .map(e => Client(
        firstName = e.getCell(0).toString,
        lastName = e.getCell(1).toString,
        gender = e.getCell(2).toString,
        age = e.getCell(3).toString.toDouble,
        email = e.getCell(4).toString,
        phone = e.getCell(5).toString,
        education = e.getCell(6).toString,
        occupation = e.getCell(7).toString,
        salary = e.getCell(8).toString.toDouble,
        maritalStatus = e.getCell(9).toString,
        numberOfChildren = e.getCell(10).toString.toDouble.toInt))
  }

  override def getJsonRequestData: (Int, Int, String) = {

    val req = mapper.readValue(new File(pathRequestFile), new TypeReference[List[Request]]() {})
    (req.head.minAge.toInt, req.head.maxAge.toInt, req.head.prefixName)
  }
}
