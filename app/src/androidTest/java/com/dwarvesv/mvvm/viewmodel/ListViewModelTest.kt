/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.dwarvesv.mvvm.viewmodel

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.dwarvesv.mvvm.repository.UserRepository
import com.dwarvesv.mvvm.service.UserService
import com.dwarvesv.mvvm.utils.Constant
import com.dwarvesv.mvvm.view.list.ListViewModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.locks.ReentrantLock


@RunWith(AndroidJUnit4::class)
class ListViewModelTest {

    private lateinit var listViewModel: ListViewModel
    @Before
    fun setUp() {
        listViewModel = ListViewModel(InstrumentationRegistry.getTargetContext(), UserRepository.getInstance(UserService.getInstance().api))
    }

    @Test
    fun doLogin() {
        val lock = ReentrantLock()
        val condition = lock.newCondition()

        lock.lock()
        try {

            listViewModel.getListData(Constant.LIMIT, 0, false)


            listViewModel.outputs.onResultsReceived.subscribe {
                condition.signal()
            }
            condition.await()

        } finally {
            lock.unlock()
        }


    }


}
