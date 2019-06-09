import { EventEmitter } from "events";
import RestClient from "../rest/RestClient";

const client = new RestClient("Cata","123");

class Food extends EventEmitter{
    constructor(){
        super();
        this.state = {
            foods: [],
            newFood: {
            name : "",
            proteins: "",
            carbs: "",
            fats: "",
            kcals: ""
            },
            searchedFoodsByName:[],
            nameSearch: ""
        };
    }

    loadFoods(){
        return client.loadAllFoods().then(foods => {
            this.state = {
                ...this.state,
                foods: foods
            };
            this.emit("change", this.state);
        })
    }

    createFood(name, kcals, proteins, carbs, fats){
        return client.addFood(name, kcals, proteins, carbs, fats)
        .then(food => {
            this.state={
                ...this.state,
                foods: this.state.foods.concat([food])
            };
            this.emit("change",this.state);
        });
    }

    appendFood(food) {
        this.state = { 
            ...this.state, 
            foods: this.state.foods.concat([food]) 
        };
        this.emit("change", this.state);
    }

    changeNewFoodProperty(property, value){
        this.state = {
            ...this.state,
            newFood: {
                ...this.state.newFood,
                [property]: value
            }
        };
        this.emit("change",this.state);
    }

    changeSearchedFoodsProperty(food){
        this.state ={
            ...this.state,
            searchedFoodsByName: this.state.searchedFoodsByName.concat(food)
        };
        this.emit("change",this.state);
    }

    changeProperty(property,value){
        this.state={
            ...this.state,
            [property]: value
        };
        this.emit("change", this.state);
    }

    searchByName(searchedName){
        return client.loadFoodsByName(searchedName).then(response=>{
            this.state = {
                ...this.state,
                searchedFoodsByName: response
    
            };
            this.emit("change", this.state);
        });
    }

}

const food = new Food();

export default food;