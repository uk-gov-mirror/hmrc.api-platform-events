import sbt._

object AppDependencies {
  def apply(): Seq[ModuleID] = dependencies ++ testDependencies

  lazy val bootstrapVersion    = "10.7.0"
  lazy val hmrcMongoVersion    = "2.12.0"
  lazy val appEventsVersion    = "1.1.0" // Ensure this version of the application-events library uses the appDomainVersion below
  lazy val appDomainVersion    = "1.1.0"

  private lazy val dependencies = Seq(
    "uk.gov.hmrc"            %% "bootstrap-backend-play-30"       % bootstrapVersion,
    "io.github.samueleresca" %% "pekko-quartz-scheduler"          % "1.2.2-pekko-1.0.x",  // 1.0.x from play framework
    "uk.gov.hmrc.mongo"      %% "hmrc-mongo-play-30"              % hmrcMongoVersion,
    "uk.gov.hmrc"            %% "api-platform-application-events" % appEventsVersion
  )

  private lazy val testDependencies = Seq(
    "uk.gov.hmrc"            %% "bootstrap-test-play-30"              % bootstrapVersion,
    "org.scalatestplus"      %% "mockito-5-18"                        % "3.2.19.0",
    "uk.gov.hmrc.mongo"      %% "hmrc-mongo-test-play-30"             % hmrcMongoVersion,
    "uk.gov.hmrc"            %% "api-platform-application-domain-fixtures" % appDomainVersion

  ).map(m => m % "test")
}
 