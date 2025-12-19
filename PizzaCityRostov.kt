package models.pizzaCities

import interfaces.DrinkSale
import interfaces.CheckPhoto
import contracts.PizzaCity
import interfaces.SauceSale
import models.foods.Sauce
import kotlin.system.exitProcess

/**
 * Пиццерия ростова на дону
 * @param neapolitanPizzaPrice цена неаполитанской пиццы
 * @param romanPizzaPrice цена римской пиццы
 * @param sicilianPizzaPrice цена сицилианской пиццы
 * @param tyroleanPizzaPrice цена тирольской пиццы
 */
class PizzaCityRostov(
    neapolitanPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyroleanPizzaPrice: Double
) : PizzaCity (
    neapolitanPizzaPrice,
    romanPizzaPrice,
    sicilianPizzaPrice,
    tyroleanPizzaPrice
), DrinkSale, CheckPhoto, SauceSale {
    override var drinkCount: Int = 0
    override var drinkSold: Double = 0.0
    override var drinkPrice: Double = 200.0
    override var drinkPizzaMap: MutableMap<String, Int> = mutableMapOf()
    override var sauceSaleMap: MutableMap<Sauce, Double> = mutableMapOf()

    override var checkCount: Int = 0
    override var checkSold: Double = 0.0
    override var checkSale: Double = 50.0

    override var sauceCount: Int = 0
    override var saucesSold: Double = 0.0

    override var availableSauces: List<Sauce> = listOf(
        Sauce("Кетчуп", 60.0),
        Sauce("Майонез", 50.0)
    )

    override fun offerSauce() {
        println("Вы будете соус?")
        println("1. Да\n2. Нет")

        //TODO: сделать от списка availableSauces а не вручную
        if (readln() == "1") {
            println("Какой именно?")
            println("1. Кетчуп\n2. Майонез")

            val chosenSauce = when (readln()) {
                "1" -> availableSauces[0]
                "2" -> availableSauces[1]
                else -> {
                    println("Неправильный ввод данных")
                    exitProcess(1)
                }
            }

            sauceCount++
            additionalPrice += chosenSauce.price
            saucesSold += chosenSauce.price
            incrementSaleForSauce(chosenSauce)
        }
    }

    override fun offerCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1. Да\n2. Нет")
        if (readln() == "1") {
            println("Вам будет скидка 50 рублей с покупки")
            checkCount++
            additionalPrice -= checkSale
            checkSold += checkSale
        }
    }

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
        println("Спасибо за покупу неаполитанской пиццы в Ростове на дону!")
        return super.neapolitanPizzaSale()
    }

    override fun romanPizzaSale(): String {
        println("Спасибо за покупу римской пиццы в Ростове на дону!")
        return super.romanPizzaSale()
    }

    override fun sicilianPizzaSale(): String {
        println("Спасибо за покупу сицилианской пиццы в Ростове на дону!")
        return super.sicilianPizzaSale()
    }

    override fun tyroleanPizzaSale(): String {
        println("Спасибо за покупу тирольсокй пиццы в Ростове на дону!")
        return super.tyroleanPizzaSale()
    }

    override fun showSpecialStatistics() {
        println("Количество проданных соусов: $sauceCount")
        println("Выручка за каждый соус: ")
        if (sauceSaleMap.isNotEmpty()) {
            for ((key, value) in sauceSaleMap) {
                println("* ${key.name} = $value")
            }
        }

        println("В сумме: $saucesSold")

        println("Показано чеков: $checkCount")
        println("Общая сумма скидки $checkSold")
        if (customerCount != 0) {
            println(
                "Соотношение людей, которых показывают фотографию чека к тем, которые не показывают:" +
                        " ${(checkCount.toDouble() / customerCount.toDouble()) * 100}%"
            )
        }
        println("Продано напитков: $drinkCount")
        println("Общая сумма выручки с напитков $drinkSold")
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

    private fun incrementSaleForSauce(selectedSauce: Sauce) {
        if (sauceSaleMap[selectedSauce] == null) {
            sauceSaleMap[selectedSauce] = selectedSauce.price
        }

        sauceSaleMap[selectedSauce]!!.plus(selectedSauce.price)
    }

    private fun getPercentForAmount(value: Int): Double {
        return (value.toDouble() / drinkPizzaMap.values.sum().toDouble())
    }
}
