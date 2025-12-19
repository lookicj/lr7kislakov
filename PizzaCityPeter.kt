package models.pizzaCities

import interfaces.DrinkSale
import contracts.PizzaCity

/**
 * Пиццерия санкт-петербурга
 * @param neapolitanPizzaPrice цена неаполитанской пиццы
 * @param romanPizzaPrice цена римской пиццы
 * @param sicilianPizzaPrice цена сицилианской пиццы
 * @param tyroleanPizzaPrice цена тирольской пиццы
 */
class PizzaCityPeter(
    neapolitanPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyroleanPizzaPrice: Double
) : PizzaCity (
    neapolitanPizzaPrice,
    romanPizzaPrice,
    sicilianPizzaPrice,
    tyroleanPizzaPrice
), DrinkSale {
    override var drinkCount: Int = 0
    override var drinkSold: Double = 0.0
    override var drinkPrice: Double = 200.0
    override var drinkPizzaMap: MutableMap<String, Int> = mutableMapOf()

    override fun offerDrink(pizza: String) {
        println("Вы будете кофе?")
        println("1. Да\n2. Нет")
        if (readln() == "1") {
            println("С вас 200 руб.")
            drinkCount++
            additionalPrice += drinkPrice
            drinkSold += drinkPrice
            incrementAmountForPizza(pizza)
        }
    }

    override fun neapolitanPizzaSale(): String {
        println("Спасибо за покупу неаполитанской пиццы в Санкт-петербурге!")
        return super.neapolitanPizzaSale()
    }

    override fun romanPizzaSale(): String {
        println("Спасибо за покупу римской пиццы в Санкт-петербурге!")
        return super.romanPizzaSale()
    }

    override fun sicilianPizzaSale(): String {
        println("Спасибо за покупу сицилианской пиццы в Санкт-петербурге!")
        return super.sicilianPizzaSale()
    }

    override fun tyroleanPizzaSale(): String {
        println("Спасибо за покупу тирольсокй пиццы в Санкт-петербурге!")
        return super.tyroleanPizzaSale()
    }

    override fun showSpecialStatistics() {
        println("Продано напитков $drinkCount")
        println("Общая сумма выручки $drinkSold")
        if (customerCount != 0) {
            println(
                "Соотношение людей, которых покупают напитков к тем, которые отказываются:" +
                        " ${(drinkCount.toDouble() / customerCount.toDouble()) * 100}%"
            )
        }

        if (drinkPizzaMap.isNotEmpty()) {
            println("Топ пицц, к которым покупают напитки: ")
            println("\nВ количественном соотношении: ")
            for ((key, value) in drinkPizzaMap) {
                println("* $key = $value")
            }

            println("\nВ процентном соотношении: ")
            for ((key, value) in drinkPizzaMap) {
                println("* $key = ${getPercentForAmount(value) * 100} %")
            }
        }
    }

    private fun incrementAmountForPizza(pizza: String) {
        if (drinkPizzaMap[pizza] == null) {
            drinkPizzaMap[pizza] = 1
        }

        drinkPizzaMap[pizza]!!.plus(1)
    }

    private fun getPercentForAmount(value: Int): Double {
        return (value.toDouble() / drinkPizzaMap.values.sum().toDouble())
    }
}
