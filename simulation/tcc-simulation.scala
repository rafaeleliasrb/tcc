import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class ServiceSimulation extends Simulation {
    var name="Reactive"
    var users=1
    var rampupTime=30 seconds
    var repeatTimes=1
	var url="http://localhost:8080"
    
    def startup(){
        val httpProtocol = http.baseURL(url)
        
        val page = repeat(repeatTimes, "n") {
            exec(http(name).get("/users/"))
        }

        val scn = scenario("page").exec(page)
        
        setUp(scn.inject(rampUsers(users).over(rampupTime))).protocols(httpProtocol)
    }
}

class ReactiveSimulation extends ServiceSimulation {
    name="reactive"
	//netty
	url="http://192.168.99.100:8080"
}

class TraditionalSimulation extends ServiceSimulation {
    name="traditional"
    //tomcat
    url="http://192.168.99.100:8080"
}

class Reactive100u extends ReactiveSimulation {
    users=100
    repeatTimes=100
    startup()
}

class Reactive1000u extends ReactiveSimulation {
    users=1000
    repeatTimes=100
    startup()
}


class Reactive2000u extends ReactiveSimulation {
    users=2000
    repeatTimes=100
    startup()
}

class Traditional100u extends TraditionalSimulation {
    users=100
    repeatTimes=100
    startup()
}

class Traditional1000u extends TraditionalSimulation {
    users=1000
    repeatTimes=100
    startup()
}


class Traditional2000u extends TraditionalSimulation {
    users=2000
    repeatTimes=100
    startup()
}