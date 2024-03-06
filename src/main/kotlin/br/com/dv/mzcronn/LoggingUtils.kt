package br.com.dv.mzcronn

import java.util.logging.Logger

fun <R : Any> R.logger(): Lazy<Logger> = lazy {
    Logger.getLogger(unwrapCompanionClass(this.javaClass).name)
}

fun <T : Any> unwrapCompanionClass(ofClass: Class<T>): Class<*> {
    return if (ofClass.enclosingClass != null && ofClass.enclosingClass.kotlin.objectInstance?.javaClass == ofClass) {
        ofClass.enclosingClass
    } else {
        ofClass
    }
}
