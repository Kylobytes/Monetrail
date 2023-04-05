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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kylobytes.monetrail.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditableExpense() {
    var amount by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    Row(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            label = { Text(stringResource(R.string.name)) },
            value = name,
            onValueChange = { name = it }
        )
        Spacer(modifier = Modifier.padding(4.dp))
        OutlinedTextField(
            label = { Text(stringResource(R.string.amount)) },
            value = amount,
            onValueChange = { amount = it }
        )
    }
}
