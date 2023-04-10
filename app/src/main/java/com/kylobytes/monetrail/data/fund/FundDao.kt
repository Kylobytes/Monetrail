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

package com.kylobytes.monetrail.data.fund

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FundDao {
    @Query("SELECT name, amount FROM funds")
    fun all(): Flow<Fund>

    @Insert
    suspend fun insert(fund: Fund)

    @Delete
    suspend fun delete(fund: Fund)
}