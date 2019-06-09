import React, { Component } from "react";
import food from "../model/food";
import SearchFood from "./SearchFood";
import foodsPresenter from "../presenter/FoodsPresenter";

const mapModelStateToComponentState = modelState => ({
    searchedFoodsByName : modelState.searchedFoodsByName
});

export default class SmartSearchFood extends Component {
    constructor() {
        super();
        this.state = mapModelStateToComponentState(food.state);
        this.listener = modelState => this.setState(mapModelStateToComponentState(modelState));
        food.addListener("change", this.listener);
    }

    componentWillUnmount() {
        food.removeListener("change", this.listener);
    }

    render() {
        return (
            <SearchFood
                onBack={foodsPresenter.onBack}
                foundFoods={this.state.searchedFoodsByName} />               
        );
    }
}
