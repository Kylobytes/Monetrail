/*
 * Copyright (C) 2024 Kent Delante  <leftybournes@pm.me>.
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

package com.kylobytes.monetrail.ui.budget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kylobytes.monetrail.R

@Composable
fun BudgetDialog(onCloseClick: () -> Unit) {
    var name by rememberSaveable { mutableStateOf("") }
    var amount by rememberSaveable { mutableStateOf("") }
    var category by rememberSaveable { mutableStateOf("") }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.padding(
                horizontal = 8.dp,
                vertical = 8.dp
            )
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = onCloseClick) {
                        Icon(
                            Icons.Default.Close,
                            stringResource(R.string.close)
                        )
                    }
                    Spacer(Modifier.padding(4.dp))
                    Text(stringResource(R.string.add_budget))
                }

                TextButton(onClick = onCloseClick) {
                    Text(stringResource(R.string.done))
                }
            }
            
            Spacer(Modifier.padding(8.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    label = { Text(stringResource(R.string.name)) },
                    value = name,
                    onValueChange = { name = it }
                )
            }

            Spacer(Modifier.padding(4.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    label = { Text(stringResource(R.string.amount)) },
                    value = amount,
                    onValueChange = { amount = it }
                )
            }

            Spacer(Modifier.padding(4.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                TextField(
                    label = { Text(stringResource(R.string.category)) },
                    value = category,
                    onValueChange = { category = it }
                )
            }
        }
    }
}