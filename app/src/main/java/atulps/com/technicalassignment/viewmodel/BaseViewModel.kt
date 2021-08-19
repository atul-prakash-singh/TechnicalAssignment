package atulps.com.technicalassignment.viewmodel

import androidx.lifecycle.ViewModel
import atulps.com.technicalassignment.utility.Event
import atulps.com.technicalassignment.utility.EventIdentifier
import atulps.com.technicalassignment.utility.EventType

/**
 * [BaseViewModel]
 * @brief Base ViewModel to handle Click Events
 * @author atul.ps
 * @date 03/27/2019
 */
open class BaseViewModel : ViewModel() {

    val onEventReceived: Event<EventType> = Event()

    /**
     * [triggerEvent]
     * @brief Fuction to trigger Click Events
     * @param [type] EventIdentifier
     * @author atul.ps
     * @date 03/27/2019
     */
    fun triggerEvent(type: EventIdentifier) {
        onEventReceived(EventType(type))
    }
}
