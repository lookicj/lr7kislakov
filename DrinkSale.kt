package interfaces

/**
 * Напиток
 */
interface DrinkSale {
    /**
     * Продажа напитков
     */
    fun offerDrink(pizza: String)

    /**
     * Количество проданных напитков
     */
    var drinkCount: Int

    /**
     * Цена напитков
     */
    var drinkPrice: Double

    /**
     * Выручка с напитков
     */
    var drinkSold: Double

    /**
     * Словарь из пицц, к которым покупают напитки
     */
    var drinkPizzaMap: MutableMap<String, Int>
}
