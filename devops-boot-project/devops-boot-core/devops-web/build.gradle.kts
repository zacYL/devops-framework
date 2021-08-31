description = "DevOps Boot Web"

dependencies {
    api(project(":devops-boot-project:devops-boot-core:devops-boot"))
    api(project(":devops-boot-project:devops-boot-core:devops-logging"))
    api(project(":devops-boot-project:devops-boot-core:devops-utils"))
    api("org.springframework.boot:spring-boot-starter-web") {
        exclude(module = "spring-boot-starter-tomcat")
    }
    api("org.springframework.boot:spring-boot-starter-undertow")
    api("org.springframework.boot:spring-boot-starter-actuator")
    api("io.springfox:springfox-boot-starter")
}
