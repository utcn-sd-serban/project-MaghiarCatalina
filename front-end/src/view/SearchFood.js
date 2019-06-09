import React from "react";


const SearchFoods = ({onBack,foundFoods}) => (
<div className="p-3 mb-2 bg-dark text-white">
    <h2>Food found:</h2>
    <br/><br/>
    <table className="table table-dark table-striped table-bordered">
            <thead>
                <tr className="bg-success">
                    <th>Name</th>
                    <th>Kcals</th>
                    <th>Proteins</th>
                    <th>Carbs</th>
                    <th>Fats</th>
            
                </tr>
            </thead>
            <tbody>
                {
                    foundFoods.map((food, index) => (
                        <tr key={index}>
                            <td>{food.name}</td>
                            <td>{food.kcals}</td>
                            <td>{food.proteins}</td>
                            <td>{food.carbs}</td>
                            <td>{food.fats}</td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
        <br/><br/>
        <button className="btn btn-warning" onClick={onBack}>Back</button>
</div>
);

export default SearchFoods;