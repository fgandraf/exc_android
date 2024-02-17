

fun main() {

//    ********** GET TOKEN **********
    val token = ApiRequest().login(LoginRequest("admin@admin", "admin"))


//    ********** GET VALUE FROM ENDPOINT **********
    val result = ApiRequest().get("v1/regions", token)
    println(result.code)
    println(result.body!!.string())


//    ********** POST TO ENDPOINT **********
//    val model = CreateRegionRequest("Piratininga", users = emptyList())
//    val result = ApiRequest().post(model, "v1/regions", token)
//    println(result.code)
//    println(result.message)


//    ********** PUT TO ENDPOINT **********
//    val model = CreatePutRequest
//    val result = ApiRequest().put(model, "v1/regions", token)
//    println(result.code)
//    println(result.message)


//    ********** DELETE **********
//    val result = ApiRequest().delete("v1/regions", "3", token)
//    println(result.code)
//    println(result.body!!.string())

}