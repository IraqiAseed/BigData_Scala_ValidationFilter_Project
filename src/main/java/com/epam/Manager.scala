package com.epam

import com.epam.model.User
import com.epam.repo.{FilesRepo, PersonReader, ClientReader}
import com.epam.service.userServices.FilteringAggregator
import com.epam.service.validationServices.ValidatorAggregator
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.{AnnotationConfigApplicationContext, PropertySource}

@SpringBootApplication
@PropertySource(Array("classpath:application.properties"))
class MainApplication

object Manager {

  val context: AnnotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.epam")

  def run(): Unit = {
    val users = validateFiles();
    printFilteredUsers(users)

  }

  def validateFiles(): List[User] = {
    val personReader: FilesRepo = context.getBean(classOf[PersonReader])
    val clientReader: FilesRepo = context.getBean(classOf[ClientReader])
    val persons = context.getBean(classOf[ValidatorAggregator]).validateAll(personReader.readLines)
    val clients = context.getBean(classOf[ValidatorAggregator]).validateAll(clientReader.readLines)

    List.concat(clients, persons)

  }

  def printFilteredUsers(users: List[User]): Unit = {
    context.getBean(classOf[FilteringAggregator]).runAllTasks(users)
  }
}
