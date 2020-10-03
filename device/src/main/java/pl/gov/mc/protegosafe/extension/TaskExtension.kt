package pl.gov.mc.protegosafe.extension

import com.google.android.gms.tasks.Task
import io.reactivex.rxjava3.core.Single

fun <T> Task<T>.toSingle(): Single<T> {
    return Single.create { emitter ->
        this.addOnCompleteListener { task ->
            if (!emitter.isDisposed) {
                if (task.isSuccessful) {
                    emitter.onSuccess(task.result)
                } else {
                    emitter.onError(task.exception as Throwable)
                }
            }
        }
    }
}
