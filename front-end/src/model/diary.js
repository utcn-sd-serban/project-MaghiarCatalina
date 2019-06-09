import { EventEmitter } from "events";
import RestClient from "../rest/RestClient";

const client = new RestClient("Cata","123");

class Diary extends EventEmitter{
    constructor(){
        super();
        this.state = {
            diaries: [],
            newDiary: {
            date : "",
            proteins: "",
            carbs: "",
            fats: "",
            kcals: ""
            },
            searchedDiary:[],
            iduser: ""
        };
    }

    changeSearchedDiaryProperty(diary){
        this.state ={
            ...this.state,
            searchedDiary: this.state.searchedDiary.concat(diary)
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

    searchByUser(iduser){
        return client.loadDiary(iduser).then(response=>{
            this.state = {
                ...this.state,
                searchedDiary: response
    
            };
            this.emit("change", this.state);
        });
    }
}

const diary = new Diary();

export default diary;