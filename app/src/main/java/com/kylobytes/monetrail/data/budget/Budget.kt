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

package com.kylobytes.monetrail.data.budget

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.kylobytes.monetrail.data.category.Category

@Entity(foreignKeys = [
    ForeignKey(
        entity = Category::class,
        parentColumns = [ "id" ],
        childColumns = [ "categoryId" ],
        onDelete = ForeignKey.CASCADE
    )
])
data class Budget(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo
    val categoryId: Long,
    @ColumnInfo
    val amount: Long
)
