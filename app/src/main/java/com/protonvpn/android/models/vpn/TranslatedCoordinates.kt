/*
 * Copyright (c) 2017 Proton Technologies AG
 *
 * This file is part of ProtonVPN.
 *
 * ProtonVPN is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * ProtonVPN is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with ProtonVPN.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.protonvpn.android.models.vpn

import com.protonvpn.android.utils.CountryTools
import com.protonvpn.android.utils.Log
import java.io.Serializable

class TranslatedCoordinates(forFlag: String) : Serializable {

    val positionX = CountryTools.locationMap[forFlag + "_x"]
    val positionY = CountryTools.locationMap[forFlag + "_y"]

    fun hasValidCoordinates(): Boolean = positionX != null && positionY != null
    fun asCoreCoordinates() = doubleArrayOf(positionX!!, positionY!!)

    operator fun compareTo(b: TranslatedCoordinates) = when {
        !hasValidCoordinates() || !b.hasValidCoordinates() -> 0
        positionY!! > b.positionY!! -> 1
        positionY < b.positionY -> -1
        else -> 0
    }

    init {
        if (positionX == null || positionY == null) {
            Log.d("Can't translate coordinates for: $forFlag")
        }
    }
}
