import sbt._

object AppDependencies {
  def apply(): Seq[ModuleID] = dependencies ++ testDependencies

  val bootstrapVersion    = "10.7.1"
  val hmrcMongoVersion    = "2.13.0"
  val appEventsVersion    = "1.2.0-SNAPSHOT" // Ensure this version of the application-events library uses the appDomainVersion below
  val appDomainVersion    = "1.6.0-SNAPSHOT"
  val commonDomainVersion = "1.0.0"

  private val dependencies = Seq(
    "uk.gov.hmrc"            %% "bootstrap-backend-play-30"       % bootstrapVersion,
    "io.github.samueleresca" %% "pekko-quartz-scheduler"          % "1.2.2-pekko-1.0.x",  // 1.0.x from play framework
    "uk.gov.hmrc.mongo"      %% "hmrc-mongo-play-30"              % hmrcMongoVersion,
    "uk.gov.hmrc"            %% "api-platform-common-domain"      % commonDomainVersion,
    "uk.gov.hmrc"            %% "api-platform-application-domain" % appDomainVersion,
    "uk.gov.hmrc"            %% "api-platform-application-events" % appEventsVersion
  )

  private val testDependencies = Seq(
    "uk.gov.hmrc"            %% "bootstrap-test-play-30"              % bootstrapVersion,
    "org.scalatestplus"      %% "mockito-5-18"                        % "3.2.19.0",
    "uk.gov.hmrc.mongo"      %% "hmrc-mongo-test-play-30"             % hmrcMongoVersion,
    "uk.gov.hmrc"            %% "api-platform-common-domain-fixtures"      % commonDomainVersion,
    "uk.gov.hmrc"            %% "api-platform-application-domain-fixtures" % appDomainVersion
  ).map(m => m % "test")
}
 