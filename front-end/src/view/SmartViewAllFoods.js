import React, { Component } from "react";
import food from "../model/food";
import ViewAllFoods from "./ViewAllFoods";
import foodsPresenter from "../presenter/FoodsPresenter";

const mapModelStateToComponentState = modelState => ({
    foods: modelState.foods
});

export default class SmartViewAllFoods extends Component {
    constructor() {
        super();
        this.state = mapModelStateToComponentState(food.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        food.addListener("change", this.listener);
        foodsPresenter.onInit();
    }

    componentWillUnmount() {
        food.removeListener("change", this.listener);
    }

    render() {
        return (
            <ViewAllFoods 
                onBack={foodsPresenter.onBack}
                foods={this.state.foods} />               
        );
    }
}
