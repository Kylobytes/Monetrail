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
import androidx.lifecycle.viewModelScope
import com.kylobytes.monetrail.data.budget.Budget
import com.kylobytes.monetrail.data.budget.BudgetRepository
import com.kylobytes.monetrail.data.category.Category
import com.kylobytes.monetrail.data.category.CategoryRepository
import com.kylobytes.monetrail.data.expense.ExpenseDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (
    expenseDao: ExpenseDao,
    private val budgetRepository: BudgetRepository,
    private val categoryRepository: CategoryRepository
): ViewModel() {
    private val _expensesToday = expenseDao.loadExpensesToday()
    private val _expenseDialogShown = MutableStateFlow(false)
    private val _budgetDialogShown = MutableStateFlow(false)
    private val _categories = MutableStateFlow(listOf<Category>())

    init {
        viewModelScope.launch {
            categoryRepository.all.collect { _categories.value = it }
        }
    }

    val expensesToday = _expensesToday
    val expenseDialogShown = _expenseDialogShown
    val budgetDialogShown = _budgetDialogShown
    val categories = _categories

    fun toggleExpenseDialog() {
        _expenseDialogShown.value = !_expenseDialogShown.value
    }
    fun toggleBudgetDialog() {
        _budgetDialogShown.value = !_budgetDialogShown.value
    }

    suspend fun saveBudget(category: String, amount: String) {
        val match = categories.value.firstOrNull { it.name == category }
        val categoryId: Long = match?.id ?: categoryRepository.add(Category(name = category))

        budgetRepository
            .add(Budget(amount = amount.toDouble(), categoryId = categoryId))

        _budgetDialogShown.value = false
    }
}