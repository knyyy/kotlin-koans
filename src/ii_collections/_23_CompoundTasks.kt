package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    return customers.filter { it.orderedProducts.contains(product) }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    //Filtrer orders.
    //Lag en flatmap / map / list basert på arugmenter som blir send tinn altså produktene
    //Flatmap betyr å lage nestedlister in til en liste.
    //prodcuts = List( List(1 2 3 4), List(4 5 6)) => List( 1 2 3 4   4 5 6)
    //Flater ut map

    //find max by pris
    return orders.filter { it.isDelivered }.flatMap { it.products }.maxBy { it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    //Flater ut først produkter innen for orders.
    return customers.flatMap { it.orders.flatMap { it.products } }.count { it == product }
}
