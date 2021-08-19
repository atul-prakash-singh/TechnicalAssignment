package atulps.com.technicalassignment.utility

/**
 * [Event]
 * @brief Class to handle Events Actions & Listeners
 * @author atul.ps
 * @date 03/27/2019
 */
class Event<T> {

    private val handlers = arrayListOf<(Event<T>.(T) -> Unit)>()

    /**
     * @brief Function to overload '+' operator to add new event.
     * @author atul.ps
     * @param [handler] Event of any generic type
     * @date 03/27/2019
     */
    operator fun plusAssign(handler: Event<T>.(T) -> Unit) {
        handlers.add(handler)
    }

    /**
     * @brief Function to overload '-' operator to remove event.
     * @author atul.ps
     * @param [handler] Event of any generic type
     * @date 03/27/2019
     */
    operator fun minusAssign(handler: Event<T>.(T) -> Unit) {
        handlers.remove(handler)
    }

    /**
     * @brief Function to overload '[]' operator to invoke any particular event.
     * @author atul.ps
     * @param [value] Any generic type
     * @date 03/27/2019
     */
    operator fun invoke(value: T) {
        for (handler in handlers) handler(value)
    }

    /**
     * @brief Function to remove all events.
     * @author atul.ps
     * @date 03/27/2019
     */
    fun removeHandlers() {
        handlers.clear()
    }
}
