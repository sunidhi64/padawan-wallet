/*
 * Copyright 2020 thunderbiscuit and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the ./LICENSE file.
 */

package com.goldenraven.padawanwallet.utils

import android.text.format.DateFormat
import org.bitcoindevkit.bdkjni.Types.ConfirmationTime
import java.util.*

// extension function on the timestamp provided in the TransactionDetails type
fun ConfirmationTime.timestampToString(): String {
    val calendar = Calendar.getInstance(Locale.ENGLISH)
    calendar.timeInMillis = this.timestamp * 1000
    return DateFormat.format("MMMM d yyyy HH:mm", calendar).toString()
}