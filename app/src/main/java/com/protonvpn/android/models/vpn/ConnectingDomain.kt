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

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class ConnectingDomain(
    @param:JsonProperty(value = "EntryIP", required = true) val entryIp: String,
    @param:JsonProperty(value = "Domain", required = true) val entryDomain: String,
    @param:JsonProperty(value = "ExitIP", required = false) private val exitIp: String?,
    @param:JsonProperty(value = "Status", required = true) private val isOnline: Boolean?
) : Serializable {

    fun isOnline() = isOnline != false
    fun getExitIP() = exitIp ?: entryIp
}
