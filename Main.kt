import interfaces.CheckPhoto
import interfaces.DrinkSale
import contracts.PizzaCity
import interfaces.SauceSale
import models.pizzaCities.PizzaCityMoscow
import models.pizzaCities.PizzaCityPeter
import models.pizzaCities.PizzaCityRostov

val pizzaPeter = PizzaCityPeter(
    175.0, 241.5,
    167.5, 215.0
)

val pizzaMoscow = PizzaCityMoscow(
    215.0, 250.0,
    180.5, 240.0
)

val pizzaRostov = PizzaCityRostov(
    235.0, 150.0,
    140.5, 200.0
)

fun main() {
    while (true) {
        println("\nДобрый день! Выберите город")
        println("1. Москва" +
                " \n2. Санкт-Петербург" +
                " \n3. Ростов на дону" +
                " \n4. Выход из программы"
        )

        val currentPizzaCity: PizzaCity = when (readln()) {
            "1" -> pizzaMoscow
            "2" -> pizzaPeter
            "3" -> pizzaRostov
            "4" -> break
            else -> {
                println("Неправильный ввод данных")
                continue
            }
        }

        println("\nВыберите пиццу:")
        println("1. Неполитанская пицца" +
                " \n2. Римская пицца" +
                " \n3. Сицилийская пицца" +
                " \n4. Тирольская пицца" +
                " \n0. Показать статистику")

        selectPizza(currentPizzaCity)
    }
}

fun selectAdditionalService(currentPizzaCity: PizzaCity, selectedPizza: String) {
    if (currentPizzaCity is CheckPhoto) {
        currentPizzaCity.offerCheckPhoto()
    }

    if (currentPizzaCity is DrinkSale) {
        currentPizzaCity.offerDrink(selectedPizza)
    }

    if (currentPizzaCity is SauceSale) {
        currentPizzaCity.offerSauce()
    }
}

fun selectPizza(currentPizzaCity: PizzaCity) {
    val choice = readln()

    var chosenPizza = ""

    when (choice) {
        "1" -> chosenPizza = currentPizzaCity.neapolitanPizzaSale()
        "2" -> chosenPizza = currentPizzaCity.romanPizzaSale()
        "3" -> chosenPizza = currentPizzaCity.sicilianPizzaSale()
        "4" -> chosenPizza = currentPizzaCity.tyroleanPizzaSale()
        "0" -> currentPizzaCity.showStatistics()
        else -> {
            println("Неправильный ввод данных")
            return
        }
    }
    if (choice != "0") {
        selectAdditionalService(currentPizzaCity, chosenPizza)
    }
}
