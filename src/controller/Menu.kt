package controller

import model.AccountModel
import kotlin.system.exitProcess

class Menu {
    var account = Account()

    fun menu() {
        var choose = 0
        println("\nMenu available : ")
        println("1. Show Account")
        println("2. Add Balance")
        println("3. Add Expense Trx")
        println("4. Exit")
        print("Which menu do you choose ? ")
        choose = readLine()!!.toInt()  //!! -> tidak boleh kosong

        if (choose == 1) {
            account.showData()
            print("1. Back to Main Menu | 2. Edit Data | 3. Exit : ")
            var subMenu = readLine()!!.toInt()

            if (subMenu == 1) {
                showMenu()
            } else if (subMenu == 2) {
                account.editData()
                showMenu()
            } else if (subMenu == 3) {
                exitProcess(0)
            } else {
                println("Menu not available")
                return
            }
        } else if (choose == 2) {
            //add balance controller
            account.addBalance()
            showMenu()
        } else if (choose == 3) {
            //controller add expenses
            Expense().showTrx()
        } else if (choose == 4) {
            exitProcess(0)
        } else {
            println("Menu not available")
            return
        }
    }

    fun showMenu() {
        var answer = "N"
        do {
            if (AccountModel.name != "") {
                println("\nWELCOME BACK TO THE E-WALLET APPLICATION")
                println("Hello " + AccountModel.name)
                println("Your balance : Rp " + AccountModel.balance)
                //call menu
                menu()
                //question
                print("Back to Main Menu [Y/N] ? ")
                answer = readLine().toString()
            } else {
                account.inputData()
                answer = "Y"
            }
        } while (answer == "Y" || answer == "y")
    }
}