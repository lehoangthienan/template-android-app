package {{packageName}}.support

import {{packageName}}.util.observeOnMain
import io.reactivex.ObservableTransformer

interface LoadingManager {
    fun show()

    fun hide()

    fun <T> bind(): ObservableTransformer<T, T> {
        return ObservableTransformer {
            return@ObservableTransformer it
                    .observeOnMain()
                    .doOnSubscribe { show() }
                    .doFinally { hide() }
        }
    }
}
