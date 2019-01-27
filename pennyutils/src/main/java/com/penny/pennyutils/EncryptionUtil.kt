package com.penny.pennyutils

import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

 class EncryptionUtil(private val key: ByteArray) {
    @Throws(Exception::class)
    fun encrypt(plainText: ByteArray): ByteArray {
        val secretKey = SecretKeySpec(key, ALGORITHM)
        val cipher = Cipher.getInstance(ALGORITHM)
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)

        return cipher.doFinal(plainText)
    }

    @Throws(Exception::class)
    fun decrypt(cipherText: ByteArray): ByteArray {
        val secretKey = SecretKeySpec(key, ALGORITHM)
        val cipher = Cipher.getInstance(ALGORITHM)
        cipher.init(Cipher.DECRYPT_MODE, secretKey)
        return cipher.doFinal(cipherText)
    }

    companion object {
        private val ALGORITHM = "AES"
    }

}
