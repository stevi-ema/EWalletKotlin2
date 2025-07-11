package controller

import model.AccountModel
import model.ExpenseModel
import kotlin.system.exitProcess

class Expense {
    var date = ""
    var catString = ""
    var amount = 0.0
    var desc = ""
    var menu = Menu()

    fun showTrx() {
        var count = 0
        println("\n\n===============================================================================")
        println("|                                EXPENSES DATA                                |")
        println("===============================================================================")
        println("No \t\t Date \t\t\t   Category \t\t  Amount \t\t    Description")
        while (count < ExpenseModel.data.size) {
            if (ExpenseModel.data.size == 1 && ExpenseModel.data.get(count).date == "") {
                println("No expense transaction data available")
                break
            } else {
                print((count + 1))
                print("\t\t" + ExpenseModel.data.get(count).date + "\t")
                print("\t" + ExpenseModel.data.get(count).category + "\t")
                print("\t" + ExpenseModel.data.get(count).amount + "\t\t")
                println("\t" + ExpenseModel.data.get(count).description)
                count++
            }
        }
        println("===============================================================================")
        print("1. Back to Main Menu | 2. Add Data | 3. Edit Data | 4. Delete Data| 5. Exit : ")
        var subMenu = readLine()!!.toInt()

        if (subMenu == 1) {
            menu.showMenu()
        } else if (subMenu == 2) {
            addTrx()
            showTrx()
        } else if (subMenu == 3) {
            editTrx()
            showTrx()
        } else if (subMenu == 4) {
            deleteTrx()
            showTrx()
        } else if (subMenu == 5) {
            exitProcess(0)
        } else {
            println("Menu not available")
            return
        }
    }

    fun input() {
        println("Your current balance : ")
        print("Date [DD-MM-YYYY] : ")
        date = readln()
        print("Category [1. Groceries| 2. Food | 3. Education | 4. Entertaiment | 5. Transportation | 6. Housing] : ")
        var catInt = readln().toInt()
        //get category string
        if (catInt == 1) {
            catString = "  Groceries   "
        } else if (catInt == 2) {
            catString = "     Food     "
        } else if (catInt == 3) {
            catString = "  Education   "
        } else if (catInt == 4) {
            catString = "Entertaiment  "
        } else if (catInt == 5) {
            catString = "Transportation"
        } else if (catInt == 6) {
            catString = "   Housing    "
        } else {
            return
        }
        do {
            print("Amount            : ")
            amount = readln().toDouble()

            if (amount > AccountModel.balance) {
                println("Sorry, your balance is insufficient !. Your current balance is Rp " + AccountModel.balance)
            }
        }while (amount > AccountModel.balance)

        print("Description       : ")
        desc = readLine().toString()
    }

    fun addTrx() {
        println("\n\n========================================================================================================")
        println("|                                          ADD EXPENSES DATA                                           |")
        println("========================================================================================================")
        input()
        //add data to List + cek data
        var noData = ExpenseModel.data.size
        if (ExpenseModel.data.get(noData-1).date == "") {
            ExpenseModel.data.set((noData-1),ExpenseModel(date, catString, amount, desc))
        } else {
            ExpenseModel.data.add(ExpenseModel(date, catString, amount, desc))
        }
        //update balance
        AccountModel.balance -= amount
    }

    fun editTrx() {
        println("\n\n========================================================================================================")
        println("|                                         EDIT EXPENSES DATA                                           |")
        println("========================================================================================================")
        print("What number data do you want to edit ? ")
        var noData = readln().toInt()
        //update balance
        AccountModel.balance += ExpenseModel.data.get(noData-1).amount
        //edit data
        input()
        //edit data from List
        ExpenseModel.data.set((noData-1),ExpenseModel(date, catString, amount, desc))
        //update balance
        AccountModel.balance -= amount
    }

    fun deleteTrx() {
        println("\n\n===============================================================================")
        println("|                           DELETE EXPENSES DATA                              |")
        println("===============================================================================")
        println("What number data do you want to delete ? ")
        var noData = readln().toInt()
        //delete data from List
        ExpenseModel.data.removeAt(noData-1)
        //update balance
        AccountModel.balance += ExpenseModel.data.get(noData-1).amount
    }
}
