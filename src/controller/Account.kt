package controller

import model.AccountModel

class Account {
    fun inputData() {
        println("Your are a new member in this application")
        println("Please fill your personal data first")
        print("Name                : ")
        AccountModel.name = readLine()!!.toString()
        print("First balance       : Rp ")
        AccountModel.balance = readLine()!!.toString().toDouble()
        print("Debit card number   : ")
        AccountModel.debitCard = readLine().toString()
        print("Credit card number  : ")
        AccountModel.creditCard = readLine().toString()
    }

    fun showData() {
        println("\n\n================================================")
        println("|                ACCOUNT DATA                  |")
        println("================================================")
        println("Name               : " + AccountModel.name)
        println("Debit card number  : " + AccountModel.debitCard)
        println("Credit card number : " + AccountModel.creditCard)
    }

    fun editData() {
        println("\n\n================================================")
        println("|              EDIT ACCOUNT DATA               |")
        println("================================================")
        print("Name                : ")
        AccountModel.name = readLine().toString()
        print("Debit card number   : ")
        AccountModel.debitCard = readLine().toString()
        print("Credit card number  : ")
        AccountModel.creditCard = readLine().toString()
    }

    fun addBalance() {
        println("\n\n================================================")
        println("|                ADD BALANCE                   |")
        println("================================================")
        print("Income : Rp ")
        AccountModel.balance += readLine()!!.toDouble()
    }
}