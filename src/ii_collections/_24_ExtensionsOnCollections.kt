package ii_collections

import util.TODO

fun todoTask24(): Nothing = TODO(
    """
        Task 24.
        The function should behave the same as '_24_JavaCode.doSomethingStrangeWithCollection'
        Replace all invocations of 'todoTask24()' with the appropriate code.
    """,
        references = { c: Collection<String> -> _24_JavaCode().doSomethingStrangeWithCollection(c) }
)

fun doSomethingStrangeWithCollection(collection: Collection<String>): Collection<String>? {
    val groupsByLength = collection.groupBy { s -> s.length }
    //Grupper by lengde på stringen,
    // Input: "a" "bb" "c"
    //group by = { 1 = ["a" , "b"]
    //              2 = ["bb"]

    //returner største verdi på values av størrelse -> ["a", "b"]
    return groupsByLength.values.maxBy { group -> group.size }
}

