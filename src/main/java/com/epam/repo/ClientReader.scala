package com.epam.repo
import com.epam.model.{Client, User}
import org.apache.poi.ss.usermodel.WorkbookFactory
import org.springframework.beans.factory.annotation.Value

import java.io.{File, FileInputStream}
import scala.collection.convert.ImplicitConversions.`iterable AsScalaIterable`
import com.epam.model.HumanToUser._
import org.springframework.stereotype.Component

@Component
case class ClientReader(@Value("${client_location}") pathClientFile: String) extends FilesRepo{


  override def readLines: List[User] = {

    val file: FileInputStream = new FileInputStream(new File(pathClientFile))
    val workbook = WorkbookFactory.create(file)
    val clientsSheet = workbook.getSheetAt(0)
    workbook.close()

    clientsSheet.toList.tail
      .map(e => Client(
        firstName = e.getCell(0).toString,
        lastName = e.getCell(1).toString,
        gender = e.getCell(2).toString.toUpperCase,
        age = e.getCell(3).toString.toDouble,
        email = e.getCell(4).toString,
        phone = e.getCell(5).toString,
        education = e.getCell(6).toString,
        occupation = e.getCell(7).toString,
        salary = e.getCell(8).toString.toDouble,
        maritalStatus = e.getCell(9).toString,
        numberOfChildren = e.getCell(10).toString.toDouble.toInt))
  }
}
