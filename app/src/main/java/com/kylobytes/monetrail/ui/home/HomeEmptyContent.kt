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

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kylobytes.monetrail.R

@Composable
fun HomeEmptyContent(
    onAddBudgetClick: () -> Unit,
    onAddExpenseClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(stringResource(R.string.home_empty_message))
        Spacer(Modifier.size(8.dp))
        OutlinedButton(onClick = onAddBudgetClick) {
            Icon(
                Icons.Outlined.Add,
                stringResource(R.string.add_budget)
            )
            Spacer(Modifier.size(4.dp))
            Text(stringResource(R.string.add_budget))
        }
        Button(onClick = onAddExpenseClick) {
            Icon(
                Icons.Outlined.Add,
                stringResource(R.string.add_expense)
            )
            Spacer(Modifier.size(4.dp))
            Text(stringResource(R.string.add_expense))
        }
    }
}