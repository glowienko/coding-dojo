import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract


/**
 * Executes given function block returning result and measured execution time in milliseconds.
 */
@OptIn(ExperimentalContracts::class)
inline fun <reified T : Any> executeMeasuringTimeMillis(block: () -> T): Pair<T, Long> {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val start = System.currentTimeMillis()
    val result = block()
    val end = System.currentTimeMillis()
    return Pair(result, end - start)
}