import React,{ Component } from "react";
import CreateFood from "./CreateFood";
import food from "../model/food";
import foodsPresenter from "../presenter/FoodsPresenter";

const mapModelStateToComponentState = modelState => ({
    name: modelState.newFood.name,
    kcals: modelState.newFood.kcals,
    proteins: modelState.newFood.proteins,
    carbs: modelState.newFood.carbs,
    fats: modelState.newFood.fats
});

export default class SmartCreateFood extends Component{
    constructor(){
        super();
        this.state = mapModelStateToComponentState(food.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        food.addListener("change", this.listener);
    
    }

    componentWillUnmount() {
        food.removeListener("change", this.listener);
    }

    render(){
        return(
            <CreateFood
                onCreate={foodsPresenter.onAddFood}
                onChange={foodsPresenter.onChange}
                // onAddQuestion={questionsPresenter.onAddQuestion}
                // onSearchByTitle={questionsPresenter.onSearchByTitle}
                // onSearchByTag={questionsPresenter.onSearchByTag}
                // onChange={questionsPresenter.onChange}
                // onChangeSearch={questionsPresenter.onChangeSearch}
                
                name={this.state.name}
                kcals={this.state.kcals}
                proteins={this.state.proteins}
                carbs={this.state.carbs}
                fats={this.state.fats}
            />
        );
    }
}