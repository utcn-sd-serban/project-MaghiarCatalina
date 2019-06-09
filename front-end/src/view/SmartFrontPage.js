import React,{ Component } from "react";
import FrontPage from "./FrontPage";
//import FoodsPresenter from "../presenter/FoodsPresenter";
import food from "../model/food";
import foodsPresenter from "../presenter/FoodsPresenter";
import diaryPresenter from "../presenter/DiaryPresenter";

const mapModelStateToComponentState = modelState => ({
    name: modelState.newFood.name,
    kcals: modelState.newFood.kcals,
    proteins: modelState.newFood.proteins,
    carbs: modelState.newFood.carbs,
    fats: modelState.newFood.fats
});

export default class SmartFrontPage extends Component{
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
            <FrontPage
                onViewAll={foodsPresenter.onViewAll}
                onCreateFood={foodsPresenter.onCreateFood}
                onSearchByUser={diaryPresenter.onSearchByUser}
                
                onSearchByName={foodsPresenter.onSearchByName}
                onChangeSearch = {foodsPresenter.onChangeSearch}
                onChangeSearchDiary={diaryPresenter.onChangeSearch}
                // onAddQuestion={questionsPresenter.onAddQuestion}
                // onSearchByTitle={questionsPresenter.onSearchByTitle}
                // onSearchByTag={questionsPresenter.onSearchByTag}
                // onChange={questionsPresenter.onChange}
                // onChangeSearch={questionsPresenter.onChangeSearch}
                
                // author={this.state.author}
                // title={this.state.title}
                // text={this.state.text}
                // date={this.state.date}
                // tags={this.state.tags}
            />
        );
    }
}