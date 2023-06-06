import './App.css';
import React from "react";
//import pokemon from "./pokemon4.json";
import PropTypes from "prop-types";

const PokemonRow = ({pokemon, onSelect}) =>(
  <tr>
    <td>{pokemon.name.english}</td>
    <td>{pokemon.type.join(",")}</td>
    <td>
      <button onClick={() => onSelect(pokemon)}>Select</button>
    </td>
  </tr> 
);

const PokemonInfo =({ name, base}) =>(
  <div>
    <h1>{name.english}</h1>
    <table>
      {Object.keys(base).map((key) => (
            <tr key={key}>
              <td>{key}</td>
              <td>{base[key]}</td>
            </tr>
          )
        )
      }
    </table>
  </div>
)

PokemonRow.propTypes = {
  pokemon: PropTypes.shape({
    name: PropTypes.shape({
      english:PropTypes.string,
    }),
    type:PropTypes.arrayOf(PropTypes.string)
  }),
  onSelect:PropTypes.func,
};

PokemonInfo.propTypes = {
  name:PropTypes.shape({
    english:PropTypes.string,
  }),
  base:PropTypes.shape({
    HP:PropTypes.number.isRequired,
    Atatck:PropTypes.number.isRequired,
    Defense:PropTypes.number.isRequired,
    "Sp.Attack":PropTypes.number.isRequired,
    "Sp.Defense":PropTypes.number.isRequired,
    Speed:PropTypes.number.isRequired,
  })
}

function App() {
  const[filter,setFilter] = React.useState("");
  const[selectedItem, setSelectedItem] = React.useState("")
  const[pokemon,setPokemon] = React.useState([])

  React.useEffect(()=>{
    fetch("http://localhost:3000/pokemon4.json")
    .then((resp) => resp.json())
    .then((data) => setPokemon(data));
  })

  return (
    <div 
      style={{
        margin: "auto",
        width: 800,
        paddingTop: "1rem"
      }}
    >
      <h1 className="title">Pokemon Search</h1>
      <div
        style={{
          display: "grid",
          gridTemplateColumns: "70% 30%",
          gridColumnGap: "1rem",
        }}
      >
        <div>
          <input value={filter} onChange={(evt) => setFilter(evt.target.value)}/>
          <table width="100%">
            <thead>
              <tr>
                <th>NAME</th>
                <th>ELEMENT</th>
               </tr>
            </thead>
            <tbody>
              {pokemon
                .filter((pokemon) => pokemon.name.english.toLowerCase().includes(filter.toLowerCase()))
                .slice(0,20)
                .map((pokemon) =>(
                <PokemonRow 
                  pokemon={pokemon} 
                  key={pokemon.id} 
                  onSelect={(pokemon) => setSelectedItem(pokemon)}/>
              ))}
            </tbody>
          </table>
        </div>
      </div>
      {selectedItem && <PokemonInfo {...selectedItem} />}
    </div>
  );
}

export default App;