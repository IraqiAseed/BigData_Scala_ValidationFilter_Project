package com.epam.repo

import com.epam.model.{Client, Person}

trait FilesRepo {

  def getLinesFromPersonJsonFile: List[Person]

  def getLinesFromClientXlsFile: List[Client]

  def getJsonRequestData: (Int, Int, String)

}
