package com.epam

import com.epam.model.HumanToUser._
import com.epam.model.User
import com.epam.repo.FileRepoImpl
import com.epam.service.userServices.TasksAggregator
import com.epam.service.validationServices.ValidatorAggregator
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.{AnnotationConfigApplicationContext, PropertySource}

@SpringBootApplication
@PropertySource(Array("classpath:application.properties"))
class MainApplication

object Manager {

  val context: AnnotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.epam")
  val fileRepo: FileRepoImpl = context.getBean(classOf[FileRepoImpl])

  def run(): Unit = {
    val users = validateFiles();
    printFilteredUsers(users)

  }

  def validateFiles(): List[User] = {
    val persons = context.getBean(classOf[ValidatorAggregator]).validateAll(fileRepo.getLinesFromPersonJsonFile)
    val clients = context.getBean(classOf[ValidatorAggregator]).validateAll(fileRepo.getLinesFromClientXlsFile)
    List.concat(clients, persons)
  }

  def printFilteredUsers(users: List[User]): Unit = {
    context.getBean(classOf[TasksAggregator]).runAllTasks(users)
  }
}
