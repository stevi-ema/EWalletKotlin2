package model

data class ExpenseModel(var date:String, var category:String, var amount:Double, var description:String) {
    companion object {
        var data = mutableListOf(ExpenseModel("","",0.0,""))
    }
}