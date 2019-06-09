import food from "../model/food";

class FoodsPresenter{

    onViewAll(){
        window.location.assign("#/foods/view-all");
    }

    onInit(){
        food.loadFoods();
    }

    onCreateFood(){
        window.location.assign("#/foods/create");
    }

    onAddFood(){
        var name = food.state.newFood.name;
        var kcals = food.state.newFood.kcals;
        var proteins = food.state.newFood.proteins;
        var carbs = food.state.newFood.carbs;
        var fats = food.state.newFood.fats;
       
        food.createFood(name,kcals,proteins,carbs,fats).then(()=>{
            food.changeNewFoodProperty("name","");
            food.changeNewFoodProperty("kcals", "");
            food.changeNewFoodProperty("proteins", "");
            food.changeNewFoodProperty("carbs", "");
            food.changeNewFoodProperty("fats", "");
        window.location.assign("#/home");
        });
    }

  
    onSearchByName(){
        var name = food.state.nameSearch;
        food.searchByName(name);
        window.location.assign('#/foods/'+name);
    }

    // onSearchByTag(){
    //     var tag = question.state.tagSearch;
    //     question.searchByTag(tag);
    //     window.location.assign('#/tag-search/'+tag);
    // }

    onChange(property, value){
       food.changeNewFoodProperty(property,value);
    }

    onChangeSearch(property,value){
        food.changeProperty(property,value);
    }
    
    onBack(){
        window.location.assign('#/home');
    }
}

const foodsPresenter = new FoodsPresenter();

export default foodsPresenter;