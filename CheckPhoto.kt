package interfaces

/**
 * Фотография чека
 */
interface CheckPhoto {
    /**
     * Предложить сфотографировать чек
     */
    fun offerCheckPhoto()

    /**
     * Количество чеков
     */
    var checkCount: Int

    /**
     * Выручка с сфотографирования чеков
     */
    var checkSold: Double

    /**
     * Скидка от чеков
     */
    var checkSale: Double
}
