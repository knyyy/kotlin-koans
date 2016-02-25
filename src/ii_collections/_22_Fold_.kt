package ii_collections

fun example9() {
    val result = listOf(1, 2, 3, 4).fold(1, { partResult, element -> element * partResult })
    result == 24
}

// The same as
fun whatFoldDoes(): Int {
    var result = 1
    listOf(1, 2, 3, 4).forEach { element -> result = element * result}
    return result
}

//Fold er noe harde greier...........
fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
    // Return the set of products ordered by every customer
    return customers.fold(allOrderedProducts, {
        //allorderedproducts er alle produkter som er blitt ordered
        //OrdererbyAll blir da initial verdi som er tom?
        //Tar inn  customer blir alle customers i lista
        //Gjør en intersect på customer sine bestilte produkter og initial list.
        orderedByAll, customer ->
        orderedByAll.intersect(customer.orderedProducts)
    })
}
