import React from "react";

const FrontPage = ({onViewAll, onCreateFood, onSearchByName, nameSearch, onChangeSearch, onSearchByUser, userSearch, onChangeSearchDiary
    //,onSearchByTitle,onSearchByTag, onChange,author,
    // title, text, tags, titleSearch, onChangeSearch, tagSearch, onAddQuestion
     }) => (
<div className="p-3 mb-2 bg-dark text-white form-group"> 
    <h2 className="text-light">Welcome to DailyFit!</h2>
    <br/><br/>
    <button className="btn btn-info" onClick={onViewAll}>View All Foods</button>
    <br/><br/><br/>
    <button className="btn btn-info" onClick={onCreateFood}>Add new food</button>
    <br/><br/><br/>
    <button className="btn btn-info" onClick={onSearchByName}>Search</button>
    <br/>
    <input placeholder="nameSearch" value={nameSearch}
        onChange={ e => onChangeSearch("nameSearch", e.target.value)}
    /><br/>
    <button className="btn btn-info" onClick={onSearchByUser}>Today Diary</button>
    <br/>
    <input placeholder="userSearch" value={userSearch}
        onChange={ e => onChangeSearchDiary("userSearch", e.target.value)}
    /><br/>
    {/* <button className="btn btn-info" onClick={onAddQuestion}>Add Question</button>
    <br/>
    <input placeholder="title" value={title}
        onChange={ e => onChange("title", e.target.value)}
    /><br/>
    <input placeholder="author" value={author}
        onChange={ e => onChange("author", e.target.value)}
    />
    <br/>
     <input placeholder="text" value={text}
        onChange={ e => onChange("text", e.target.value)}
    /><br/>
     <input placeholder="tags" value={tags}
        onChange={ e => onChange("tags", e.target.value)}
    />

    <br/><br/><br/>
    <button className="btn btn-info" onClick={onSearchByTitle}>Search By Title</button>
    <br/>
    <input placeholder="title search" value={titleSearch}
        onChange={ e => onChangeSearch("titleSearch", e.target.value)}
    />

    <br/><br/><br/>
    <button className="btn btn-info" onClick={onSearchByTag}>Search By Tag</button>
    <br/>
    <input placeholder="tag search" value={tagSearch}
        onChange={ e => onChangeSearch("tagSearch", e.target.value)}
    />
    <br/><br/><br/> */}
</div>
);

export default FrontPage;