package Aquarium.generics

fun main(args: Array<String>){
    genericExample()
}

open class WaterSupply(var needsProcessed: Boolean)


class TapWater : WaterSupply(needsProcessed = true) {
    fun addChemicalCleaners() {
        needsProcessed = false
    }
}

class FishStoreWater : WaterSupply(needsProcessed = false) {}

class LakeWater : WaterSupply(needsProcessed = true) {
    fun filter() {
        needsProcessed = false
    }
}

class Aquarium<out T: WaterSupply>(val waterSupply: T) {
    fun addWater(cleaner: Cleaner<T>) {
        if(waterSupply.needsProcessed) {
            cleaner.clean(waterSupply)
        }
        println("adding water from $waterSupply")
    }


}

interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: T)
}

class TapWaterCleaner: Cleaner<TapWater> {
    override fun clean(waterSupply: TapWater) {
        waterSupply.addChemicalCleaners()
    }
}

fun addItemTo(aquarium: Aquarium<WaterSupply>) = println("item added")

inline fun <reified R: WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R

fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("aquarium water is clean: ${aquarium.waterSupply.needsProcessed}")
}
inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T
fun genericExample() {

    /*val aquarium: Aquarium<TapWater> = Aquarium(TapWater())
    aquarium.waterSupply.addChemicalCleaners()

    val aquarium4: Aquarium<LakeWater> = Aquarium(LakeWater())
    aquarium4.waterSupply.filter()
    aquarium4.addWater()*/

    /*val cleaner = TapWaterCleaner()
    val aquarium = Aquarium(TapWater())
    addItemTo(aquarium)
    aquarium.addWater(cleaner)*/

    val aquarium = Aquarium(TapWater())
    //isWaterClean<TapWater>(aquarium)
    aquarium.hasWaterSupplyOfType<TapWater>()
    aquarium.waterSupply.isOfType<LakeWater>()

}
