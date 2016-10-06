package currying

import java.io.File

/**
  * Author: Tomasz Kawik
  * Date: 06.10.2016
  */
object FileSearcher {
  def main(args: Array[String]) {
    val path = new File("E:\\Dropbox")
    val finders = comparators.map(comp => find(comp) _).flatMap(parFun => extensionFilters.map(filter => parFun(filter))).map(finder => finder(path).take(2))
    finders.foreach(listOfFiles => {
      listOfFiles.foreach(file => println(file.getName + " " + file.length))
    })
  }

  def find (comparator: (File, File) => Boolean)(extensionCriterion: (File) => Boolean)(file: File): Array[File] = {
    def recursiveListFiles(f: File): Array[File] = {
      val these = f.listFiles()
      these.filter(file => !file.isDirectory && extensionCriterion(file)) ++ these.filter(_.isDirectory).flatMap(recursiveListFiles)
    }
    recursiveListFiles(file).sortWith(comparator)
  }

  def extensionFilter(extension: String)(file: File, name: String): Boolean = name.endsWith(extension)
  val comparators = Array (
    (fileA: File, fileB: File) => fileA.getName.length < fileB.getName.length,
    (fileA: File, fileB: File) => fileA.length < fileB.length
  )
  val extensionFilters = Array("pdf", "jpg", "png").map(extension => (file:File) => file.getName.endsWith(extension))
}
