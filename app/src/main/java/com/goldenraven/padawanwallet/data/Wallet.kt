/*
 * Copyright 2020 thunderbiscuit and contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the ./LICENSE file.
 */

package com.goldenraven.padawanwallet.data

import android.util.Log
import com.goldenraven.padawanwallet.utils.RequiredInitialWalletData
import org.bitcoindevkit.bdkjni.Lib
import org.bitcoindevkit.bdkjni.Types.*

private const val TAG = "Wallet"

object Wallet {

    private val lib: Lib
    private lateinit var walletPtr: WalletPtr
    private const val name: String = "padawan-testnet-0"
    private lateinit var path: String
    private const val electrumURL: String = "ssl://electrum.blockstream.info:60002"
    
    init {
        // load bitcoindevkit
        Lib.load()
        lib = Lib()
    }

    // setting the path requires the application context and is done once by PadawanWalletApplication
    fun setPath(path: String) {
        Wallet.path = path
    }

    private fun initialize(
        descriptor: String,
        changeDescriptor: String,
    ): Unit {
        walletPtr = lib.constructor(
            WalletConstructor(
                name = name,
                network = Network.testnet,
                path = path,
                descriptor = descriptor,
                change_descriptor = changeDescriptor,
                electrum_url = electrumURL,
                electrum_proxy = null,
            )
        )
    }

    fun loadExistingWallet(): Unit {
        val initialWalletData: RequiredInitialWalletData = Repository.getInitialWalletData()
        Log.i(TAG, "Loading existing wallet with descriptor: ${initialWalletData.descriptor}")
        Log.i(TAG, "Loading existing wallet with change descriptor: ${initialWalletData.changeDescriptor}")
        initialize(
            descriptor = initialWalletData.descriptor,
            changeDescriptor = initialWalletData.changeDescriptor,
        )
    }

    fun recoverWallet(mnemonic: String): Unit {
        val keys: ExtendedKey = restoreExtendedKeyFromMnemonic(mnemonic)
        val descriptor: String = createDescriptor(keys)
        val changeDescriptor: String = createChangeDescriptor(keys)
        initialize(
            descriptor = descriptor,
            changeDescriptor = changeDescriptor,
        )
        Repository.saveWallet(path, descriptor, changeDescriptor)
        Repository.saveMnemonic(keys.mnemonic)
    }

    fun createWallet(): Unit {
        val keys: ExtendedKey = generateExtendedKey()
        val descriptor: String = createDescriptor(keys)
        val changeDescriptor: String = createChangeDescriptor(keys)
        initialize(
            descriptor = descriptor,
            changeDescriptor = changeDescriptor,
        )
        Repository.saveWallet(path, descriptor, changeDescriptor)
        Repository.saveMnemonic(keys.mnemonic)
    }

    private fun generateExtendedKey(): ExtendedKey {
        return lib.generate_extended_key(Network.testnet, 12, "")
    }

    private fun restoreExtendedKeyFromMnemonic(mnemonic: String): ExtendedKey {
        return lib.restore_extended_key(Network.testnet, mnemonic, "")
    }

    private fun createDescriptor(keys: ExtendedKey): String {
        Log.i(TAG,"Descriptor for receive addresses is wpkh(${keys.xprv}/84'/1'/0'/0/*)")
        return ("wpkh(" + keys.xprv + "/84'/1'/0'/0/*)")
    }

    private fun createChangeDescriptor(keys: ExtendedKey): String {
        Log.i(TAG, "Descriptor for change addresses is wpkh(${keys.xprv}/84'/1'/0'/1/*)")
        return ("wpkh(" + keys.xprv + "/84'/1'/0'/1/*)")
    }

    fun sync(max_address: Int?=null) {
        lib.sync(walletPtr, max_address)
    }

    fun getBalance(): Long {
        return lib.get_balance(walletPtr)
    }

    fun getNewAddress(): String {
        return lib.get_new_address(walletPtr)
    }

    fun createTransaction(
        fee_rate: Float,
        addressees: List<Pair<String, String>>,
        send_all: Boolean? = false,
        utxos: List<String>? = null,
        unspendable: List<String>? = null,
        policy: Map<String, List<String>>? = null,
    ): CreateTxResponse {
        return lib.create_tx(walletPtr, fee_rate, addressees, send_all, utxos, unspendable, policy)
    }

    fun listTransactions(): List<TransactionDetails> {
        return lib.list_transactions(walletPtr, false)
    }

    fun sign(psbt: String, assume_height: Int? = null): SignResponse {
        return lib.sign(walletPtr, psbt, assume_height)
    }

    fun extractPsbt(psbt: String): RawTransaction {
        return lib.extract_psbt(walletPtr, psbt)
    }

    fun broadcast(raw_tx: String): Txid {
        return lib.broadcast(walletPtr, raw_tx)
    }
}
