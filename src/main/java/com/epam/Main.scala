package com.epam

import com.epam.model.HumanToUser._
import com.epam.repo.FileRepoImpl
import com.epam.service.userServices.{Tasks, TasksAggregator}
import com.epam.service.validationServices.ValidatorAggregator
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.{AnnotationConfigApplicationContext, PropertySource}


@SpringBootApplication
@PropertySource(Array("classpath:application.properties"))
class MainApplication

object Main {

  def main(args: Array[String]): Unit = {

    val context:AnnotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.epam")
    val fileRepo = context.getBean(classOf[FileRepoImpl])
    val persons = context.getBean(classOf[ValidatorAggregator]).validateAll(fileRepo.getLinesFromPersonJsonFile)
    val clients = context.getBean(classOf[ValidatorAggregator]).validateAll(fileRepo.getLinesFromClientXlsFile)

    context.getBean(classOf[TasksAggregator]).runAllTasks(List.concat(clients, persons))

  }


}
