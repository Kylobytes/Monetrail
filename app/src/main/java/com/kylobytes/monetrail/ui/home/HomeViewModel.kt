/*
 * Copyright (C) 2023 Kent Delante  <leftybournes@pm.me>.
 *
 * This file is part of Monetrail.
 *
 * Monetrail  is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Monetrail is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Monetrail. If not, see <https://www.gnu.org/licenses/>.
 */

package com.kylobytes.monetrail.ui.home

import androidx.lifecycle.ViewModel
import com.kylobytes.monetrail.data.expense.ExpenseDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (
    expenseDao: ExpenseDao
): ViewModel() {
    private val _expensesToday = expenseDao.loadExpensesToday()
    private val _showExpenseDialog = MutableStateFlow(false)
    private val _showBudgetDialog = MutableStateFlow(false)

    val expensesToday = _expensesToday
    val showExpenseDialog = _showExpenseDialog
    val showBudgetDialog = _showBudgetDialog

    fun toggleExpenseDialog() {
        _showExpenseDialog.value = !_showExpenseDialog.value
    }
    fun toggleBudgetDialog() {
        _showBudgetDialog.value = !_showBudgetDialog.value
    }
}