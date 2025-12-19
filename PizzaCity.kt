package contracts

/**
 * Базовая пиццерия, продающая следующие пиццы:
 * @param neapolitanPizzaPrice цена неаполитанской пиццы
 * @param romanPizzaPrice цена римской пиццы
 * @param sicilianPizzaPrice цена сицилианской пиццы
 * @param tyroleanPizzaPrice цена тирольской пиццы
 */
abstract class PizzaCity(
    private val neapolitanPizzaPrice: Double,
    private val romanPizzaPrice: Double,
    private val sicilianPizzaPrice: Double,
    private val tyroleanPizzaPrice: Double
) {
    var customerCount = 0
    var neapolitanPizzaCount = 0
    var romanPizzaCount = 0
    var sicilianPizzaCount = 0
    var tyroleanPizzaCount = 0
    var additionalPrice = 0.0

    open fun neapolitanPizzaSale(): String {
        customerCount++
        neapolitanPizzaCount++
        return "Неаполитанская пицца"
    }

    open fun romanPizzaSale(): String {
        customerCount++
        romanPizzaCount++
        return "Римская пицца"
    }

    open fun sicilianPizzaSale(): String {
        customerCount++
        sicilianPizzaCount++
        return "Сицилийская пицца"

    }
    open fun tyroleanPizzaSale(): String {
        customerCount++
        tyroleanPizzaCount++
        return "Тирольская пицца"
    }

    open fun showSpecialStatistics() { }

    fun showStatistics() {
        println("-----------СТАТИСТИКА-----------")

        println("Продано сицилийскокй пиццы: $sicilianPizzaCount")
        println("Продано неаполитанской пиццы: $neapolitanPizzaCount")
        println("Продано римской пиццы: $romanPizzaCount")
        println("Продано тирольской пиццы: $tyroleanPizzaCount")

        showSpecialStatistics()

        val money = neapolitanPizzaPrice * neapolitanPizzaCount +
                sicilianPizzaPrice * sicilianPizzaCount +
                romanPizzaPrice * romanPizzaCount +
                tyroleanPizzaPrice * tyroleanPizzaCount + additionalPrice

        println("\nВсего заработано денег: $money")
    }
}
