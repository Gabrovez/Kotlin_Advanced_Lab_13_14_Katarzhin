val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
val gasPlanets = arrayOf<String>("Jupiter", "Saturn", "Uranus", "Neptune")
val solarSystems = rockPlanets + gasPlanets

val newSolarSystems = arrayOf(
    "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto")

fun main() {
    println(solarSystems[0])
    println(solarSystems[1])
    println(solarSystems[2])
    solarSystems[3] = "Little Earth"
    println(solarSystems[3])
    println(solarSystems[4])
    println(solarSystems[5])
    println(solarSystems[6])
    println(solarSystems[7])
    println(newSolarSystems[8])
}