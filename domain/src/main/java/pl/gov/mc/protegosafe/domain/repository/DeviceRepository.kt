package pl.gov.mc.protegosafe.domain.repository

import io.reactivex.rxjava3.core.Single
import pl.gov.mc.protegosafe.domain.model.ExposureNotificationStatusItem

interface DeviceRepository {
    fun getServicesStatusJson(): Single<String>
    fun getExposureNotificationStatus(): Single<ExposureNotificationStatusItem>
    fun isGooglePlayServicesForSafetyNetAvailable(): Boolean
}
