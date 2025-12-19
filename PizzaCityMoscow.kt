package models.pizzaCities

import interfaces.CheckPhoto
import contracts.PizzaCity

/**
 * Пиццерия москвы
 * @param neapolitanPizzaPrice цена неаполитанской пиццы
 * @param romanPizzaPrice цена римской пиццы
 * @param sicilianPizzaPrice цена сицилианской пиццы
 * @param tyroleanPizzaPrice цена тирольской пиццы
 */
class PizzaCityMoscow(
    neapolitanPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyroleanPizzaPrice: Double
) : PizzaCity (
    neapolitanPizzaPrice,
    romanPizzaPrice,
    sicilianPizzaPrice,
    tyroleanPizzaPrice
), CheckPhoto {
    override var checkCount: Int = 0
    override var checkSold: Double = 0.0
    override var checkSale: Double = 50.0

    override fun offerCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1. Да\n2. Нет")
        if (readln() == "1") {
            println("Вам будет скидка 50 рублей с покупки")
            checkCount++
            checkSold += checkSale
            additionalPrice -= checkSale
        }
    }

    override fun neapolitanPizzaSale(): String {
        println("Спасибо за покупу неаполитанской пиццы в Москве!")
        return super.neapolitanPizzaSale()
    }

    override fun romanPizzaSale(): String {
        println("Спасибо за покупу римской пиццы в Москве!")
        return super.romanPizzaSale()
    }

    override fun sicilianPizzaSale(): String {
        println("Спасибо за покупу сицилианской пиццы в Москве!")
        return super.sicilianPizzaSale()
    }

    override fun tyroleanPizzaSale(): String {
        println("Спасибо за покупу тирольсокй пиццы в Москве!")
        return super.tyroleanPizzaSale()
    }

    override fun showSpecialStatistics() {
        println("Показано чеков $checkCount")
        println("Общая сумма скидки $checkSold")
        if (customerCount != 0) {
            println(
                "Соотношение людей, которых показывают фотографию чека к тем, которые не показывают:" +
                        " ${(checkCount.toDouble() / customerCount.toDouble()) * 100}%"
            )
        }
    }
}
