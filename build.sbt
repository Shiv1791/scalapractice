name := "scalapractice"

version := "0.1"

scalaVersion := "2.13.2"


val akkaHttpVersion = "10.1.6"
val akkaVersion = "2.5.19"
val akkaHttpCorsVersion = "0.2.2"


val typesafeConfig = "com.typesafe" % "config" % "1.4.0"

val akkaActor = "com.typesafe.akka" %% "akka-actor" % akkaVersion

val akkaStream = "com.typesafe.akka" %% "akka-stream" % akkaVersion

val akkaHttp = "com.typesafe.akka" %% "akka-http"  % akkaHttpVersion

val akkaSprayJson = "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion

val akkaHttpCors = "ch.megard" %% "akka-http-cors" % akkaHttpCorsVersion

val akkaHttpTestKit = "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion
val akkaTestKit = "com.typesafe.akka" %% "akka-testkit" % akkaVersion



