package com.example.clases_en_kotlin

import androidx.appcompat.app.AppCompatActivity
import kotlin.math.PI
import kotlin.math.sqrt
import android.os.Bundle


class MainActivity : AppCompatActivity() {
    fun main(){
        val squareCabin = SquareCabin(5 , 50.00)
        with(squareCabin){
            println("\nSquare Cabin\n============")
            println("Capacity: ${capacity}")
            println("Material: ${buildingMaterial}")
            println("Has room? ${hasRoom()}")
            getRoom()
            println("Has room? ${hasRoom()}")
            getRoom()
            println("Floor area: ${floorArea()}")
        }

        val roundHut = RoundHut(3, 10.0)
        with(roundHut){
            println("\nroundHut Cabin\n============")
            println("Capacity: ${capacity}")
            println("Material: ${buildingMaterial}")
            println("Has room? ${hasRoom()}")
            getRoom()
            println("Has room? ${hasRoom()}")
            getRoom()
            println("Floor area: ${floorArea()}")
            println("Carpet Size ${calculateMaxCarpetSize()}")
        }

        val roundTower = RoundTower(3, 15.0)
        with(roundTower){
            println("\nroundTower Cabin\n============")
            println("Capacity: ${capacity}")
            println("Material: ${buildingMaterial}")
            println("Has room? ${hasRoom()}")
            getRoom()
            println("Has room? ${hasRoom()}")
            getRoom()
            println("Floor area: ${floorArea()}")
            println("Carpet Size ${calculateMaxCarpetSize()}")
        }
    }

    /**
     * Defines properties common to all dwellings.
     * All dwellings have floorspace,
     * but its calculation is specific to the subclass.
     * Checking and getting a room are implemented here
     * because they are the same for all Dwelling subclasses.
     *
     * @param residents Current number of residents
     */

    abstract class Dwelling(private var residents: Int){
        abstract val buildingMaterial: String
        abstract val capacity: Int
        /**
         * Calculates the floor area of the dwelling.
         * Implemented by subclasses where shape is determined.
         *
         * @return floor area
         */
        fun hasRoom(): Boolean {
            return residents < capacity
        }

        /**
         * Checks whether there is room for another resident.
         *
         * @return true if room available, false otherwise
         */
        abstract fun floorArea(): Double


        /**
         * Compares the capacity to the number of residents and
         * if capacity is larger than number of residents,
         * add resident by increasing the number of residents.
         * Print the result.
         */

        fun getRoom() {
            if (capacity > residents) {
                residents++
                println("You got a room!")
            } else {
                println("Sorry, at capacity and no rooms left.")
            }
        }

    }
    /**
     * A square cabin dwelling.
     *
     *  @param residents Current number of residents
     *  @param length Length
     */

    class SquareCabin(residents: Int , val length: Double) : Dwelling(residents){
        override val buildingMaterial = "Wood"
        override val capacity = 6
        /**
         * Calculates floor area for a square dwelling.
         *
         * @return floor area
         */

        override fun floorArea():Double{
            return length * length
        }
    }
    /**
     * Dwelling with a circular floorspace
     *
     * @param residents Current number of residents
     * @param radius Radius
     */

    open class RoundHut(residents: Int , val radius: Double): Dwelling(residents){
        override val buildingMaterial = "Straw"
        override val capacity = 4
        /**
         * Calculates floor area for a round dwelling.
         *
         * @return floor area
         */

        override fun floorArea():Double{
            return PI * radius * radius
        }
        /**
         *  Calculates the max length for a square carpet
         *  that fits the circular floor.
         *
         * @return length of carpet
         */

        fun calculateMaxCarpetSize(): Double {
            val diameter = 2 * radius
            return sqrt(diameter * diameter / 2)
        }

    }
    /**
     * Round tower with multiple stories.
     *
     * @param residents Current number of residents
     * @param radius Radius
     * @param floors Number of stories
     */

    class RoundTower(residents: Int , radius: Double ,val floors: Int = 2) : RoundHut(residents, radius){
        override val buildingMaterial = "Stone"
        // Capacity depends on the number of floors.
        override val capacity = 4 * floors
        /**
         * Calculates the total floor area for a tower dwelling
         * with multiple stories.
         *
         * @return floor area
         */

        override fun floorArea(): Double {
            return super.floorArea() * floors
        }

    }

}
