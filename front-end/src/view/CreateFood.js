import React from "react";

const CreateFood = ({onCreate, name, kcals, proteins, carbs, fats, onChange
    //,onSearchByTitle,onSearchByTag, onChange,author,
    // title, text, tags, titleSearch, onChangeSearch, tagSearch, onAddQuestion
     }) => (
<div className="p-3 mb-2 bg-dark text-white form-group"> 
    <h2 className="text-light">Add new food info: </h2>
    <br/><br/>
    <button className="btn btn-info" onClick={onCreate}>Create</button>
    <br/><br/><br/>
    <br/>
    <input placeholder="name" value={name}
        onChange={ e => onChange("name", e.target.value)}
    /><br/>
    <input placeholder="kcals" value={kcals}
        onChange={ e => onChange("kcals", e.target.value)}
    />
    <br/>
     <input placeholder="proteins" value={proteins}
        onChange={ e => onChange("proteins", e.target.value)}
    /><br/>
     <input placeholder="carbs" value={carbs}
        onChange={ e => onChange("carbs", e.target.value)}
    />
    <input placeholder="fats" value={fats}
        onChange={ e => onChange("fats", e.target.value)}
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

export default CreateFood;