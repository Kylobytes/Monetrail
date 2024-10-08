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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kylobytes.monetrail.R
import com.kylobytes.monetrail.ui.budget.BudgetDialog
import com.kylobytes.monetrail.ui.expense.ExpenseDialog

@Composable
fun Home(navController: NavController) {
    val homeViewModel = hiltViewModel<HomeViewModel>()
    val expensesToday by homeViewModel.expensesToday.collectAsState(listOf())
    val expenseDialogShown by homeViewModel
        .expenseDialogShown
        .collectAsState(false)
    val budgetDialogShown by homeViewModel
        .budgetDialogShown
        .collectAsState(false)
    val categories by homeViewModel.categories.collectAsState(listOf())

    Box(Modifier.fillMaxSize()) {
        if (expensesToday.isEmpty()) {
            HomeEmptyContent(
                { homeViewModel.toggleBudgetDialog() },
                { homeViewModel.toggleExpenseDialog() }
            )
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        stringResource(R.string.expenses_today),
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                    OutlinedIconButton(
                        onClick = { homeViewModel.toggleExpenseDialog() }
                    ) {
                        Icon(
                            Icons.Default.Add,
                            stringResource(R.string.add_expense)
                        )
                    }
                }
            }
        }
    }

    if (expenseDialogShown) {
        ExpenseDialog(onCloseClick = { homeViewModel.toggleExpenseDialog() })
    }

    if (budgetDialogShown) {
        BudgetDialog(
            categories,
            { homeViewModel.toggleBudgetDialog() },
            homeViewModel::saveBudget
        )
    }
}
