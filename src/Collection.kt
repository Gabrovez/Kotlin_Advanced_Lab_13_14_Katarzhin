val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
val gasPlanets = arrayOf<String>("Jupiter", "Saturn", "Uranus", "Neptune")
val solarSystems = rockPlanets + gasPlanets

val newSolarSystems = arrayOf(
    "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto")

fun main() {

    val solarSystem = mutableSetOf(
        "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"
    )
    println(solarSystem.size)
    solarSystem.add("Pluto")
    println(solarSystem.size)
    println(solarSystem.contains("Pluto"))
    println("Pluto" in solarSystem)
    solarSystem.add("Pluto")
    println(solarSystem.size)
    println(solarSystem.remove("Pluto"))
    println(solarSystem.size)
    println(solarSystem.contains("Pluto"))





//    solarSystem.add("Pluto")
//    solarSystem.add(3,"Theia")
//    solarSystem[3] = "Future Moon"
//    println(solarSystem[3])
//    println(solarSystem[9])
//    solarSystem.removeAt(9)
//    solarSystem.remove("Future Moon")
//    println(solarSystem.contains("Pluto"))
//    println("Future Moon" in solarSystem)
//    val solarSystem = listOf(
//        "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"
//    )
//    println(solarSystem.size)
//    println(solarSystem[2])
//    println(solarSystem.get(3))
//    println(solarSystem.indexOf("Earth"))
//    println(solarSystem.indexOf("Pluto"))
//    for (planet in solarSystem) {
//        println(planet)
//    }

//    println(solarSystems[0])
//    println(solarSystems[1])
//    println(solarSystems[2])
//    solarSystems[3] = "Little Earth"
//    println(solarSystems[3])
//    println(solarSystems[4])
//    println(solarSystems[5])
//    println(solarSystems[6])
//    println(solarSystems[7])
//    println(newSolarSystems[8])
}