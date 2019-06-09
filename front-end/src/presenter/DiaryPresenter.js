import diary from "../model/diary";

class DiaryPresenter{
  
    onSearchByUser(){
        var user = diary.state.iduser;
        diary.searchByUser(user);
        window.location.assign('#/diaries/today/'+user);
    }

    onChangeSearch(property,value){
        diary.changeProperty(property,value);
    }
    
    onBack(){
        window.location.assign('#/home');
    }
}

const diaryPresenter = new DiaryPresenter();

export default diaryPresenter;