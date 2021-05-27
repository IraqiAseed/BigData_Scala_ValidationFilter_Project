package com.epam.service.userServices

import com.epam.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

import java.util
import scala.collection.JavaConverters.asScalaBufferConverter

@Component
class TasksAggregator {

  @Autowired
  var filterTasks: util.List[Tasks] = _

  def runAllTasks(users: List[User] ): Unit = {

    val filtering = filterTasks.asScala
    println(filtering(0))
    println(filtering(1))
    println(filtering(2))
    for (i <- filtering.indices)
      println(filtering(i).filterUser(users))


  }
}
