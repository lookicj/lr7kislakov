package interfaces

import models.foods.Sauce

/**
 * Соус
 */
interface SauceSale {
    /**
     * Предложить соус
     */
    fun offerSauce()

    /**
     * Количество проданных соусов
     */
    var sauceCount: Int

    /**
     * Выручка с соусов
     */
    var saucesSold: Double

    /**
     * Список доступных соусов
     */
    var availableSauces: List<Sauce>

    /**
     * Словарь из соусов, к их продажам
     */
    var sauceSaleMap: MutableMap<Sauce, Double>
}
