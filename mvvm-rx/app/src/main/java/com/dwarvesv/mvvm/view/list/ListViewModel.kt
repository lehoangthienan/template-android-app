package {{packageName}}.view.list

import android.content.Context
import {{packageName}}.data.model.User
import {{packageName}}.repository.UserRepository
import {{packageName}}.utils.isNetworkConnected
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

interface ListViewModelViewModelInputs {

    fun getListData(limit: Int, offset: Int, pullToRefresh: Boolean)
}

interface ListViewModelViewModelOutputs {

    val isShowRefreshing: Observable<Boolean>

    val isShowLoadMore: PublishSubject<Boolean>

    val isShowAlertDialog: PublishSubject<Boolean>

    val onResultsReceived: Observable<ArrayList<User>>

}

class ListViewModel(var context: Context?, private val userRepository: UserRepository)
    : ListViewModelViewModelInputs, ListViewModelViewModelOutputs {

    override val isShowRefreshing: PublishSubject<Boolean> = PublishSubject.create()
    override val isShowLoadMore: PublishSubject<Boolean> = PublishSubject.create()
    override val isShowAlertDialog: PublishSubject<Boolean> = PublishSubject.create()

    val inputs: ListViewModelViewModelInputs = this
    val outputs: ListViewModelViewModelOutputs = this

    private val getListDataPublishSubject: PublishSubject<ArrayList<User>> = PublishSubject.create()
    override val onResultsReceived: Observable<ArrayList<User>> = getListDataPublishSubject


    override fun getListData(limit: Int, offset: Int, pullToRefresh: Boolean) {
        if (offset == 0) {
            if (!pullToRefresh) isShowRefreshing.onNext(true)
        } else isShowLoadMore.onNext(true)

        if (!isNetworkConnected(context)) {

            if (offset == 0)
                isShowRefreshing.onNext(false)
            else
                isShowLoadMore.onNext(false)

            isShowAlertDialog.onNext(true)
            return
        }

        userRepository.getListData().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                        { userList ->
                            userList?.let { getListResults ->
                                getListDataPublishSubject.onNext(getListResults)
                            }

                            callHideIndicator(offset)
                        }
                        ,
                        {
                            callHideIndicator(offset)

                            isShowAlertDialog.onNext(true)
                        })
    }

    private fun callHideIndicator(offset: Int) {
        if (offset == 0) {
            isShowRefreshing.onNext(false)
        } else {
            isShowLoadMore.onNext(false)
        }
    }

}