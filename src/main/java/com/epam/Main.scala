package com.epam

import com.epam.model.HumanToUser._
import com.epam.repo.{FileRepoImpl, FilesRepo}
import com.epam.service.validationServices.ValidatorAggregator
import com.epam.service.userServices.UserService
import com.epam.service.userServices.{UserService, UserServiceImpl}
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.context.annotation.{AnnotationConfigApplicationContext, Bean, Configuration, PropertySource}
import org.springframework.stereotype.Component


@SpringBootApplication
class MainApplication

object Main {

  def main(args: Array[String]): Unit = {

   // val ct = SpringApplication.run(classOf[MainApplication])
   // val fileRepo = ct.getBean(classOf[FileRepoImpl])

    val fileRepo = new FileRepoImpl()
    val userService: UserService = new UserServiceImpl()
    val context = new AnnotationConfigApplicationContext("com.epam")

    val personsJson = fileRepo.getLinesFromPersonJsonFile
    val clientsFromXls = fileRepo.getLinesFromClientXlsFile

    val persons = context.getBean(classOf[ValidatorAggregator]).validateAll(personsJson)
    val clients = context.getBean(classOf[ValidatorAggregator]).validateAll(clientsFromXls)

    val users = List.concat(clients, persons)

    val requestMinMaxPrefix = fileRepo.getJsonRequestData
    val usersFilteredByAge = userService
      .getAllUsersWhoseAgeFilteredByRange(users, min = requestMinMaxPrefix._1, max = requestMinMaxPrefix._2)

    val usersNamesStartsWithPrefix = userService.getAllPeopleWhoseNamesStartWith(users, prefix = requestMinMaxPrefix._3)
    val clientsMarriedMenThreeChildrenAndMore = userService.getAllMarriedMenPlusThreeAndMoreChildren(clients)

    println(usersFilteredByAge)
    println(usersNamesStartsWithPrefix)
    println(clientsMarriedMenThreeChildrenAndMore)

  }


}
