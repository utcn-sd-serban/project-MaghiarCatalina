const BASE_URL = "http://localhost:8080";

export default class RestClient {
    constructor(username, password) {
        this.authorization = "Basic " + btoa(username + ":" + password);
    }

    login(){
        return fetch(BASE_URL+"/",{
            method: "POST",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }

    loadAllFoods(){
        return fetch(BASE_URL+"/foods/view-all", {
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }

    loadFoodsByName(searchedName){
        return fetch(BASE_URL+"/foods/"+searchedName, {
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }

    addFood(name,kcals,proteins,carbs,fats){
        return fetch(BASE_URL+"/foods/create",{
            method: "POST",
            body: JSON.stringify({
                name: name,
                kcals: kcals,
                proteins: proteins,
                carbs: carbs,
                fats: fats
            }),
            headers: {
                "Authorization": this.authorization,
                "Content-Type": "application/json"
            }
        }).then(response => response.json());
    }

    loadDiary(iduser){
        return fetch(BASE_URL+"/diaries/today/"+iduser, {
            method: "GET",
            headers: {
                "Authorization": this.authorization
            }
        }).then(response => response.json());
    }
}