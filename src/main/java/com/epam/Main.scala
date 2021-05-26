package com.epam

import com.epam.model.HumanToUser._
import com.epam.repo.FileRepoImpl
import com.epam.service.userServices.{UserService, UserServiceImpl}
import com.epam.service.validationServices.ValidatorAggregator
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.{AnnotationConfigApplicationContext, PropertySource}


@SpringBootApplication
@PropertySource(Array("classpath:application.properties"))
class MainApplication

object Main {

  def main(args: Array[String]): Unit = {

    val context = new AnnotationConfigApplicationContext("com.epam")
    val userService: UserService = new UserServiceImpl()

    val fileRepo = context.getBean(classOf[FileRepoImpl])
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
