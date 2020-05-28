import java.io.File

val filesHere = (new File(".")).listFiles()

for(file <- filesHere)
  if (file.isFile)
  if(file.getName.endsWith(".scala"))
  println(file)


def fileLines(file: File) = scala.io.Source.fromFile(file).getLines().toList

def grep(pattern: String) =
  for (file<- filesHere
       if(file.getName.endsWith(".scala"));
       line <- fileLines(file);
       trimmed = line.trim
    if(trimmed.matches(pattern))
       ) println(file + ": "+ trimmed)


grep(".snap.*")

for(file <- filesHere
  if (file.isFile)
    if(file.getName.endsWith(".scala"))) yield file

import scala.io.Source

object LongLines {
  def processFile(filename: String, width: Int) = {
    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine(filename, width, line)
  }
  private def processLine(filename: String,
                          width: Int, line: String) = {
    if (line.length > width)
      println(filename + ": " + line.trim)
  }
}

object FindLongLines {
  def main(args: Array[String]) = {
    val width = args(0).toInt
    for (arg <- args.drop(1))
      LongLines.processFile(arg, width)
  }
}