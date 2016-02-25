package ii_collections

fun example6() {
    val sum = listOf(1, 5, 3).sum()
}

fun Customer.getTotalOrderPrice(): Double {
    // Return the sum of prices of all products that a customer has ordered.
    // Note: a customer may order the same product for several times.

    //Lager om produkter til en map, lager en ny map(liste) ved å returnere pris
    //Tar sum av denne lista.
    return orders.flatMap { it.products }.map { it.price }.sum()
}
