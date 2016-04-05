test in assembly := {}
assemblyJarName in assembly := "finagle-postgres-tests.jar"
mainClass in assembly := Some("org.junit.runner.JUnitCore")
fullClasspath in assembly := (fullClasspath in Test).value
assemblyMergeStrategy in assembly := {
case PathList(xs @ _*) if xs.exists(_.contains("hamcrest")) => MergeStrategy.first
case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}