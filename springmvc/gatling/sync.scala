import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class ServiceSimulation extends Simulation {
    var name="async"
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

class SyncSimulation extends ServiceSimulation {
    name="sync"
	//tomcat
	url="http://192.168.99.100:8080"
}

class Sync1u extends SyncSimulation {
    users=1
    repeatTimes=100
    startup()
}

class Sync100u extends SyncSimulation {
    users=100
    repeatTimes=100
    startup()
}

class Sync500u extends SyncSimulation {
    users=500
    repeatTimes=100
    startup()
}

class Sync1000u extends SyncSimulation {
    users=1000
    repeatTimes=100
    startup()
}

class Sync2000u extends SyncSimulation {
    users=2000
    repeatTimes=100
    startup()
}
