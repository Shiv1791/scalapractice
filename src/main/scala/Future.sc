import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}
/*

var count = 0

for (_ <- 1 until 100) {
  Future{count = count + 1}
}

println(count)

*/

val fortyTwo = Future { 21 + 21 }
val fortySix = Future { 23 + 23 }

val futureNums = List(fortyTwo, fortySix)
/*
val folded = Future.fold(futureNums)(0){(acc, num) =>
  acc + num
}



folded.value
*/

val future  =  Future{42}
val valid = future.filter(_>0)

valid.value

val flipped = future.transformWith { // Scala 2.12
  case Success(res) =>
    Future { throw new Exception(res.toString) }
  case Failure(ex) => Future { 21 + 21 }
}



val newFuture = future andThen {
  case Success(res) => println(res)
  case Failure(ex) => println(ex)
}

newFuture.value


val invalid = future.filter(_<0)

invalid.value

val valid1 = for (res <- future if res > 0) yield res



valid1.value

val invalid1 = for (res <- future if res < 0) yield res

invalid1.value


val a =  future.collect{case res if res>0 => res+ 46}

a.value



val future1 =  Future{41/0}

future1.failed.value

future.failed

val fallback = future1.fallbackTo(future)

val failedFallback = future1.fallbackTo(
  Future { val res = 42; require(res < 0); res }
)

failedFallback.value

val recovered = failedFallback recover {
  case ex:ArithmeticException => -1
}

recovered.failed

val first = future.transform(
  res => res * -1,
  ex => new Exception("see cause", ex)
)

val second = future1.transform(
  res => res * -1,
  ex => new Exception("see cause", ex)
)
second.value


val firstCase = future.transform { // Scala 2.12
  case Success(res) => Success(res * -1)
  case Failure(ex) =>
    Failure(new Exception("see cause", ex))
}

firstCase.value

val secondCase = future1.transform {
  case Success(res) => Success(res * -1)
  case Failure(ex) =>
    Failure(new Exception("see cause", ex))
}

secondCase.value






/*
val pro =  Promise[Int]
val fut = pro.future

fut.value

pro.success(42)
fut.value
*/

/*
val future = Future{Thread.sleep(100); 21+21}

future.isCompleted
future.isCompleted
/*

future.value

val result = future.map{x=>Thread.sleep(100);x+1}
result.isCompleted
result.isCompleted

result.value
*/

val future2 =  Future{Thread.sleep(1); 23+23}

Thread.sleep(100)
future2.isCompleted
future2.isCompleted


val res = for{x<- future
    y<- future2} yield x+y


res.value


*/
