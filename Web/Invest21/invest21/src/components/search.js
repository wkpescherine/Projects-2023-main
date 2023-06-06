import '../App.css';

function Search(){
    return (
        <div>
            <p>
                <input type="text" placeholder="Search by symbols" ></input>
            </p>
            <p>
                <input type="text" placeholder="Search by company name"></input>
            </p>
            <button>Search</button>
        </div>
    );
}

export default Search;