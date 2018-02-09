package com.wujun.boot.gatling

import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration.FiniteDuration

class ApiGatlingSimulationTest extends Simulation{
  val scn = scenario("Gatling Test").repeat(1000, "n") {
    exec(
      http("GetTest-API")
        .get("http://localhost:8080/gatling/test")
        .check(status.is(200))
    )
  }

  setUp(scn.inject(atOnceUsers(30))).maxDuration(FiniteDuration.apply(10, "minutes"))
}
